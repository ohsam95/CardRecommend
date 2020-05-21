package project02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;

import project02.gui.Check;
import project02.gui.Login;

public class LogChk {

	public class logC {
		int checkIDPW(String id, String pw) {
			int result = 1;
			try {
				String SQL3 = "select pwd from joinlist where id =?";
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection conn3 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "myproject",
						"myproject");
				PreparedStatement pstmt2 = conn3.prepareStatement(SQL3);
				pstmt2.setString(1, id);
				ResultSet rs = pstmt2.executeQuery();
				boolean a;
				if (( a =rs.next()) == false) { // id가 존재x
					result = 1;
				} else {
						System.out.println(a);
						if (rs.getString(1).equals(pw)) { // pw와 같은지 비교
							result = 0; // 같으면 로그인 성공
						} else { // 아이디는같고 pw가 다른경우
							result = 1;
						}
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return result;
		}
	}

	public void loginCheck(JFrame jf, String id, String pw) {
		MsgeBox mb = new MsgeBox();
		logC lc = new logC();
//            Login l2= new Login();
		int result = lc.checkIDPW(id, pw);
		if (result == 0) {
			mb.messageBox(jf.getContentPane(), "로그인 되었습니다.");
			new Check();
		} else {
			mb.messageBox(jf.getContentPane(), "로그인 실패");
			new Login();
		}

	}

}
