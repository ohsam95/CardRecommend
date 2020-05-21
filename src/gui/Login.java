package project02.gui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import project02.LogChk;
import project02.PollSession;
import project02.Test;

public class Login extends JFrame {
	
	private JFrame jf;
	private JTextField tfid;
	private JTextField tfpwd;
	
	public Login() {
		
		jf = this;
		setTitle("부산은행 체크카드 추천_로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		Container c = getContentPane();
		
		JLabel lbtitle = new JLabel("\uCCB4\uD06C\uCE74\uB4DC \uCD94\uCC9C \uC571");
		lbtitle.setHorizontalAlignment(JLabel.CENTER);
		lbtitle.setBounds(0, 10, 334, 41);
		lbtitle.setVerticalAlignment(SwingConstants.TOP);
		lbtitle.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		getContentPane().add(lbtitle);
		
		JLabel lbid = new JLabel("ID");
		lbid.setBounds(58, 123, 36, 36);
		getContentPane().add(lbid);
		
		JLabel lbpwd = new JLabel("PWD");
		lbpwd.setBounds(58, 185, 36, 36);
		getContentPane().add(lbpwd);
		
		tfid = new JTextField();
		tfid.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD558\uC138\uC694");
		tfid.setColumns(10);
		tfid.setBounds(126, 131, 138, 21);
		getContentPane().add(tfid);
		
		tfpwd = new JTextField();
		tfpwd.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694");
		tfpwd.setColumns(10);
		tfpwd.setBounds(126, 193, 138, 21);
		getContentPane().add(tfpwd);
		
		JButton btnjoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnjoin.setBounds(70, 295, 97, 30);
		getContentPane().add(btnjoin);
		
		JButton btnenter = new JButton("\uB85C\uADF8\uC778");
		btnenter.setBounds(167, 295, 97, 30);
		getContentPane().add(btnenter);
		
		c.setFocusable(true);
		
		tfid.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfid.setText("");
			}
		});
		tfpwd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				tfpwd.setText("");
			}
		});
		
		btnjoin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new Join();
			}
		});
		
		
		btnenter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogChk LC = new LogChk();
				pp(); 
				LC.loginCheck(jf, tfid.getText(), tfpwd.getText());
				//Test.named = tfid.getText();
				
				dispose();
				} 
		});
		
		
		setSize(350,400);
		setVisible(true);
				
		
	}
	public void pp() {
	PollSession.id = tfid.getText();
	}
	
	
	
	}

