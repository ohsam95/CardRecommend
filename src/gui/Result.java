package project02.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

import project02.CardM;
import project02.CardM2;
import project02.MsgeBox;
import project02.PollSession;
import project02.ResultCard;

import javax.swing.Icon;


public class Result extends JFrame{
	
	Result resultframe = this;

	
	public Result() {
		setTitle("�λ����� üũī�� ��õ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JLabel lbmain = new JLabel("\uB2F9\uC2E0\uC5D0\uAC8C \uB9DE\uB294 \uCCB4\uD06C\uCE74\uB4DC");
		lbmain.setHorizontalAlignment(JLabel.CENTER);
		lbmain.setFont(new Font("���� ���", Font.PLAIN, 25));
		lbmain.setBounds(0, 0, 1484, 94);
		getContentPane().add(lbmain);
		
	
		JLabel lbname = new JLabel("1. "+CardM.CName);
		lbname.setFont(new Font("���� ���", Font.PLAIN, 16));
		lbname.setHorizontalAlignment(JLabel.CENTER);
		lbname.setBounds(0, 121, 730, 37);
		getContentPane().add(lbname);

		
		String imgPath = selectCard();
		ImageIcon cardIcon = new ImageIcon(imgPath);
		Image cardimg = cardIcon.getImage();
		Image cardimg2 = cardimg.getScaledInstance(500,500, Image.SCALE_SMOOTH);
		ImageIcon Icon = new ImageIcon(cardimg2);
		
		JLabel lbimg = new JLabel(Icon);
		lbimg.setHorizontalAlignment(JLabel.CENTER);
		lbimg.setBounds(37, 183, 650, 670);
		getContentPane().add(lbimg);
		
		JLabel lbnu = new JLabel("\u203B \uC6D0\uD558\uB294 \uD61C\uD0DD\uC774 \uAC00\uC7A5 \uB9CE\uC740 \uCCB4\uD06C\uCE74\uB4DC\uB97C \uC54C\uB824\uC8FC\uAE30 \uB54C\uBB38\uC5D0, \uB204\uB77D\uB41C \uD61C\uD0DD\uC774 \uC788\uC744 \uC218\uB3C4 \uC788\uC2B5\uB2C8\uB2E4.");
		lbnu.setFont(new Font("���� ���", Font.PLAIN, 11));
		lbnu.setHorizontalAlignment(JLabel.CENTER);
		lbnu.setBounds(0, 96, 1484, 15);
		getContentPane().add(lbnu);
		
		JButton btnout = new JButton("\uB098\uAC00\uAE30");
		btnout.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnout.setBounds(1323, 34, 132, 37);
		getContentPane().add(btnout);
		
		JButton btnsung = new JButton("\uBAA8\uB4E0\uC0C1\uD488 \uBCF4\uAE30");
		btnsung.setFont(new Font("���� ���", Font.PLAIN, 14));
		btnsung.setBounds(1179, 34, 142, 37);
		getContentPane().add(btnsung);
		
		

//		JPanel jp = new JPanel();
//		JScrollPane scroll = new JScrollPane(jp);
//		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scroll.setPreferredSize(new Dimension(700, 735));
//		wpanel1.add(area);
		
		JLabel lbname2 = new JLabel("2. "+ CardM2.CName2);
		lbname2.setHorizontalAlignment(SwingConstants.CENTER);
		lbname2.setFont(new Font("���� ���", Font.PLAIN, 16));
		lbname2.setBounds(754, 121, 730, 37);
		getContentPane().add(lbname2);
		
		String imgPath2 = selectCard2();
		ImageIcon cardIcon2 = new ImageIcon(imgPath2);
		Image cardimg3 = cardIcon2.getImage();
		Image cardimg4 = cardimg3.getScaledInstance(500,500, Image.SCALE_SMOOTH);
		ImageIcon Icon2 = new ImageIcon(cardimg4);
		
		
		JLabel lbimg_1 = new JLabel(Icon2);
		lbimg_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbimg_1.setBounds(797, 183, 650, 670);
		getContentPane().add(lbimg_1);
		
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
					
					mb.messageBox(resultframe.getContentPane(), "�̿����ּż� �����մϴ�!");
					ResultCard.cardname();
					
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		
		
		
		setSize(1500,1050);
		setVisible(true);
		
		btnsung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AllCard();
//				System.out.println(CardM.CName);
//				System.out.println(CardM2.CName2);
			}
		});
	}
	public String selectCard() {
		String Url;
		if (CardM.CName.equals("û����� 369 üũī��")) {
			Url = "img/û�����.png";
		}else if(CardM.CName.equals("YO üũī��")) {
			Url = "img/yoī��.png";
		}else if(CardM.CName.equals("DingDing üũī��")) {
			Url = "img/����ī��.png";
		}else if(CardM.CName.equals("���ũ ī��")) {
			Url = "img/���ũī��.png";
		}else if(CardM.CName.equals("BNK���ڵǼ��� �� ���ϸ��� üũī��")) {
			Url = "img/���ڵǼ���.png";
		}else if(CardM.CName.equals("�����ູüũī��")) {
			Url = "img/�����ູī��.png";
		}else {
			Url = "img/������ī��.png";
		}
		return Url;
	}
	public String selectCard2() {
		String Url2;
		if (CardM2.CName2.equals("û����� 369 üũī��")) {
			Url2 = "img/û�����.png";
		}else if(CardM2.CName2.equals("YO üũī��")) {
			Url2 = "img/yoī��.png";
		}else if(CardM2.CName2.equals("DingDing üũī��")) {
			Url2 = "img/����ī��.png";
		}else if(CardM2.CName2.equals("���ũ ī��")) {
			Url2 = "img/���ũī��.png";
		}else if(CardM2.CName2.equals("BNK���ڵǼ��� �� ���ϸ��� üũī��")) {
			Url2 = "img/���ڵǼ���.png";
		}else if(CardM2.CName2.equals("�����ູüũī��")) {
			Url2 = "img/�����ູī��.png";
		}else {
			Url2 = "img/������ī��.png";
		}
		return Url2;
	}
	}

