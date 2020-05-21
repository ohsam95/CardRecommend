package project02.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.ws.Holder;

import project02.MsgeBox;
import project02.PollSession;
import project02.ResultCard;
import project02.ResultCard2;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Check extends JFrame implements ItemListener{
	
	List<String> checkArr;
	Check checkFrame = this;
	JLabel hihi;
	
	public Check() {
		
		setTitle("ºÎ»êÀºÇà Ã¼Å©Ä«µå ÃßÃµ");
		Container c = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	
		
		JLabel home = new JLabel("\uBD80\uC0B0\uC740\uD589 \uCCB4\uD06C\uCE74\uB4DC \uD61C\uD0DD");
		home.setHorizontalAlignment(JLabel.CENTER);
		home.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		home.setBounds(0, 0, 472, 54);
		getContentPane().add(home);
		
		JLabel smalltitle = new JLabel("\uC6D0\uD558\uB294 \uD61C\uD0DD\uC744 \uC120\uD0DD\uD558\uC138\uC694!");
		smalltitle.setHorizontalAlignment(JLabel.CENTER);
		smalltitle.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		smalltitle.setBounds(0, 117, 472, 41);
		getContentPane().add(smalltitle);
		
		JCheckBox cbgyo = new JCheckBox("\uAD50\uD1B5\uBE44 \uD61C\uD0DD");
		cbgyo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbgyo.setBounds(39, 199, 150, 41);
		getContentPane().add(cbgyo);
		
		
		JCheckBox cbdo = new JCheckBox("\uB3C4\uC11C \uD61C\uD0DD");
		cbdo.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbdo.setBounds(237, 328, 132, 41);
		getContentPane().add(cbdo);
		
		JCheckBox cbtong = new JCheckBox("\uD1B5\uC2E0\uBE44 \uD61C\uD0DD");
		cbtong.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbtong.setBounds(39, 285, 150, 41);
		getContentPane().add(cbtong);
		
		JCheckBox cbco = new JCheckBox("\uCEE4\uD53C \uD61C\uD0DD");
		cbco.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbco.setBounds(39, 328, 150, 41);
		getContentPane().add(cbco);
		
		JCheckBox cbshon = new JCheckBox("\uC628\uB77C\uC778 \uBAB0 \uD560\uC778 \uD61C\uD0DD");
		cbshon.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbshon.setBounds(39, 371, 150, 41);
		getContentPane().add(cbshon);
		
		JCheckBox cbsi = new JCheckBox("\uC2DC\uD5D8\uC751\uC2DC\uB8CC \uD61C\uD0DD");
		cbsi.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbsi.setBounds(237, 371, 132, 41);
		getContentPane().add(cbsi);
		
		JCheckBox cble = new JCheckBox("\uB808\uC2A4\uD1A0\uB791 \uD61C\uD0DD");
		cble.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cble.setBounds(237, 199, 150, 41);
		getContentPane().add(cble);
		
		JCheckBox cbyoung = new JCheckBox("\uC601\uD654\uAD00 \uD61C\uD0DD");
		cbyoung.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbyoung.setBounds(39, 242, 150, 41);
		getContentPane().add(cbyoung);
		
		JCheckBox cbole = new JCheckBox("\uC62C\uB9AC\uBE0C\uC601 \uBC0F \uB2E4\uC774\uC18C \uD61C\uD0DD");
		cbole.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbole.setBounds(237, 285, 189, 41);
		getContentPane().add(cbole);
		
		JCheckBox cbfa = new JCheckBox("\uD328\uC2A4\uD2B8\uD478\uB4DC \uBC0F \uBCA0\uC774\uCEE4\uB9AC \uD61C\uD0DD");
		cbfa.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbfa.setBounds(237, 242, 210, 41);
		getContentPane().add(cbfa);
		
		JCheckBox cbyuk = new JCheckBox("\uC721\uC544/\uAD50\uC721 \uD61C\uD0DD");
		cbyuk.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbyuk.setBounds(39, 414, 132, 41);
		getContentPane().add(cbyuk);
		
		JCheckBox cbhang = new JCheckBox("\uD56D\uACF5\uB9C8\uC77C\uB9AC\uC9C0\uC801\uB9BD \uD61C\uD0DD");
		cbhang.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbhang.setBounds(237, 414, 162, 41);
		getContentPane().add(cbhang);
		
		JCheckBox cbcash = new JCheckBox("\uAD6D\uB0B4/\uD574\uC678 \uCE90\uC2DC\uBC31 \uD61C\uD0DD");
		cbcash.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbcash.setBounds(39, 459, 162, 41);
		getContentPane().add(cbcash);
		
		JCheckBox cbgan = new JCheckBox("\uAC04\uD3B8\uACB0\uC81C \uD560\uC778 \uD61C\uD0DD");
		cbgan.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 12));
		cbgan.setBounds(237, 457, 150, 41);
		getContentPane().add(cbgan);
		
		cbgyo.addItemListener(this);
		cbdo.addItemListener(this);
		cbtong.addItemListener(this);
		cbco.addItemListener(this);
		cbshon.addItemListener(this);
		cbsi.addItemListener(this);
		cble.addItemListener(this);
		cbyoung.addItemListener(this);
		cbole.addItemListener(this);
		cbfa.addItemListener(this);
		cbyuk.addItemListener(this);
		cbhang.addItemListener(this);
		cbcash.addItemListener(this);
		cbgan.addItemListener(this);
		
		JButton btnnext = new JButton("\uACB0\uACFC \uBCF4\uAE30");
		btnnext.setBounds(174, 538, 125, 41);
		getContentPane().add(btnnext);
		
		
		hihi = new JLabel("¾È³çÇÏ¼¼¿ä! " + PollSession.id + "´Ô");
		hihi.setHorizontalAlignment(JLabel.CENTER);
		hihi.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 16));
		hihi.setBounds(12, 74, 460, 33);
		getContentPane().add(hihi);
		
		JLabel smalltitle_1 = new JLabel("\u203B \uCD5C\uC18C 2\uAC1C \uC774\uC0C1 \uC120\uD0DD\uD574\uC8FC\uC138\uC694!");
		smalltitle_1.setForeground(Color.RED);
		smalltitle_1.setHorizontalAlignment(SwingConstants.CENTER);
		smalltitle_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 10));
		smalltitle_1.setBounds(0, 507, 472, 21);
		getContentPane().add(smalltitle_1);
		
		
	
		
		btnnext.addMouseListener(new next());
		
		setSize(488,640);
		setVisible(true);
		checkArr = new ArrayList<>();
	}
	
	
	
	JCheckBox temp;
	@Override
	
	public void itemStateChanged(ItemEvent e) {
		temp = (JCheckBox) e.getItem();
		
		if(e.getStateChange()==1) {
		checkArr.add(temp.getText());
		}else {
		checkArr.remove(temp.getText());
		}
//		System.out.println(temp.getText());
//		System.out.println(e.getStateChange());
//		System.out.println(checkArr);
	}
		
	class next implements MouseListener{
			@Override
			public void mouseClicked(MouseEvent e) { 
				MsgeBox mb = new MsgeBox();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
					for (int i = 0; i < checkArr.size(); i++) {
						final String SQL = "insert into usercheck(num, benefit, id) values (usercheck_seq.nextval, ?, ?)";
						PreparedStatement pstmt = conn.prepareStatement(SQL);
						pstmt.setString(1, checkArr.get(i));
						pstmt.setString(2, PollSession.id);
						pstmt.executeUpdate();
					}
					mb.messageBox(checkFrame.getContentPane(), "Àá½Ã¸¸ ±â´Ù·ÁÁÖ¼¼¿ä!");
					ResultCard.cardname();
					ResultCard2.cardname2();
					new Result();
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
			@Override
			public void mouseEntered(MouseEvent e) {		
			}
			@Override
			public void mouseExited(MouseEvent e) {	
			}
	}
}
