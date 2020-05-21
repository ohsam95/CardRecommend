package project02.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;

import oracle.jdbc.driver.Message;
import project02.MsgeBox;

import javax.management.Query;
import javax.swing.JButton;

	
public class Join extends JFrame{
	private JTextField tfid;
	private JTextField tfpwd;
	private JTextField tfpwd2;
	private JTextField tfname;
	private JTextField tfbirth;
	
	Join joinframe = this;
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("부산은행 체크카드 추천_회원가입");
		Container c = getContentPane();
		setTitle("\uCCB4\uD06C\uCE74\uB4DC \uCD94\uCC9C \uD68C\uC6D0\uAC00\uC785");
		getContentPane().setLayout(null);

		
		JLabel lbjoin = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbjoin.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbjoin.setBounds(0, 0, 284, 55);
		getContentPane().add(lbjoin);
		
		JLabel cont1 = new JLabel("ID");
		cont1.setBounds(36, 90, 76, 27);
		getContentPane().add(cont1);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setBounds(36, 156, 76, 27); 	
		getContentPane().add(lblPwd);
		
		JLabel cont2 = new JLabel("PWD \uD655\uC778");
		cont2.setBounds(36, 193, 76, 27);
		getContentPane().add(cont2);
		
		JLabel cont3 = new JLabel("\uC774\uB984");
		cont3.setBounds(36, 230, 76, 27);
		getContentPane().add(cont3);
		
		JLabel cont4 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		cont4.setBounds(36, 267, 76, 27);
		getContentPane().add(cont4);
		
		tfid = new JTextField();
		tfid.setBounds(124, 93, 140, 21);
		getContentPane().add(tfid);
		tfid.setColumns(10);
		
		tfpwd = new JTextField();
		tfpwd.setColumns(10);
		tfpwd.setBounds(124, 159, 140, 21);
		getContentPane().add(tfpwd);
		
		tfpwd2 = new JTextField();
		tfpwd2.setColumns(10);
		tfpwd2.setBounds(124, 196, 140, 21);
		getContentPane().add(tfpwd2);
		
		tfname = new JTextField();
		tfname.setColumns(10);
		tfname.setBounds(124, 233, 140, 21);
		getContentPane().add(tfname);
		
		tfbirth = new JTextField();
		tfbirth.setColumns(10);
		tfbirth.setBounds(124, 270, 140, 21);
		getContentPane().add(tfbirth);
		
		JButton btnj = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnj.setBounds(82, 339, 125, 37);
		getContentPane().add(btnj);
		
		JButton btnid = new JButton("\uC911\uBCF5\uD655\uC778");
		btnid.setBounds(124, 124, 95, 21);
		getContentPane().add(btnid);
		
		setSize(300,450);
		setVisible(true);
		
		btnj.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					final String SQL = "insert into joinlist(id,name,pwd,birth) values (?,?,?,?)";
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
					
					PreparedStatement pstmt = conn.prepareStatement(SQL);
					pstmt.setString(1, tfid.getText());
					pstmt.setString(2, tfname.getText());
					pstmt.setString(3, tfpwd.getText());
					pstmt.setString(4, tfbirth.getText());
					
					pstmt.executeUpdate();
					MsgeBox mb = new MsgeBox();
					mb.messageBox(c, "가입이 완료되었습니다.");
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		
		
		
		btnid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					try {
						final String SQL2 = "select * from joinlist where id='" + tfid.getText() + "'";
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection conn2 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","myproject","myproject");
						
						PreparedStatement pstmt2 = conn2.prepareStatement(SQL2);
						
						pstmt2=conn2.prepareStatement(SQL2);
						ResultSet rs= pstmt2.executeQuery();
						MsgeBox mb = new MsgeBox();
						if (rs.next() == true || (tfid.getText().isEmpty()) == true) { // 이미 id가 존재한다면
		                    mb.messageBox(c, "해당 ID는 사용이 불가능합니다. 다시 작성해주세요.");
		                } else {
		                    mb.messageBox(c, "사용 가능한 ID 입니다.");
		                }

						
					}catch (Exception e1) {
						e1.printStackTrace();
					}


			}
		});
		
	}
}
