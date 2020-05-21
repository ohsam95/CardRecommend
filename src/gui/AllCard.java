package project02.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import project02.MsgeBox;
import project02.PollSession;
import project02.ResultCard;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;

public class AllCard extends JFrame{
	
	AllCard allCardframe = this;
	public AllCard() {
		setTitle("부산은행 체크카드 추천");
		getContentPane().setLayout(null);
		
		JLabel lbmain = new JLabel("\uBAA8\uB4E0 \uC0C1\uD488 \uBCF4\uAE30");
		lbmain.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbmain.setBounds(0, 0, 984, 71);
		lbmain.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(lbmain);
		
		JButton btnchug = new JButton("\uCCAD\uCD98\uBD88\uD328 356 \uCE74\uB4DC");
		btnchug.setBounds(50, 159, 879, 66);
		getContentPane().add(btnchug);
		
		JButton btnDingDing = new JButton("Ding Ding \uCCB4\uD06C\uCE74\uB4DC");
		btnDingDing.setBounds(50, 274, 879, 66);
		getContentPane().add(btnDingDing);
		
		JButton btnYo = new JButton("YO \uCCB4\uD06C\uCE74\uB4DC");
		btnYo.setBounds(50, 384, 879, 66);
		getContentPane().add(btnYo);
		
		JButton btnSum = new JButton("\uC378\uBC45\uD06C \uCE74\uB4DC");
		btnSum.setBounds(50, 495, 879, 66);
		getContentPane().add(btnSum);
		
		JButton btnBnk = new JButton("BNK \uBD80\uC790\uB418\uC138\uC694 \uB354 \uB9C8\uC77C\uB9AC\uC9C0 \uCCB4\uD06C\uCE74\uB4DC");
		btnBnk.setBounds(50, 602, 879, 66);
		getContentPane().add(btnBnk);
		
		JButton btnFriend = new JButton("BNK \uD504\uB80C\uC988 \uCCB4\uD06C\uCE74\uB4DC");
		btnFriend.setBounds(50, 705, 879, 66);
		getContentPane().add(btnFriend);
		
		JButton btI2 = new JButton("\uC544\uC774\uD589\uBCF5\uCCB4\uD06C\uCE74\uB4DC");
		btI2.setBounds(50, 814, 879, 66);
		getContentPane().add(btI2);
		
		JButton btnout = new JButton("\uB098\uAC00\uAE30");
		btnout.setBounds(770, 18, 130, 43);
		getContentPane().add(btnout);
	
		setSize(1000,1000);
		setVisible(true);
		
		btnchug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Chug();
				dispose();
			}
		});
		btnDingDing.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Ding();
				dispose();
			}
		});
		btnFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Friends();
				dispose();
			}
		});
		btnYo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Yo();
				dispose();
			}
		});
		btnSum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Sum();
				dispose();
			}
		});
		btI2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new I2();
				dispose();
			}
		});
		btnBnk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Bnk();
				dispose();
			}
		});
		btnout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MsgeBox mb = new MsgeBox();
				try {
					final String SQL = "delete usercheck where id = ?";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
						PreparedStatement pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, PollSession.id);

						pstmt.executeUpdate();
					
					mb.messageBox(allCardframe.getContentPane(), "감사합니다!");
					ResultCard.cardname();
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
	}
}
