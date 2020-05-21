package project02.gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class Ding extends JFrame{

	public Ding() {
		setTitle("부산은행 체크카드 추천");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		JLabel lbname = new JLabel("Ding Ding 체크카드");
		lbname.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
		lbname.setBounds(0, 0, 984, 75);
		lbname.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().add(lbname);
		
		ImageIcon cardIcon = new ImageIcon("img/딩딩카드.png");
		JLabel lbbenefit = new JLabel(cardIcon);
		lbbenefit.setBounds(76, 59, 831, 863);
		getContentPane().add(lbbenefit);
		
		JButton btnBack = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btnBack.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btnBack.setBounds(824, 24, 121, 38);
		getContentPane().add(btnBack);
		
		setSize(1000,1000);
		setVisible(true);
		
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new AllCard();
				dispose();
			}
		});
	}

}
