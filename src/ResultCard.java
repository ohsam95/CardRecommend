package project02;

import java.rmi.server.RMIClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultCard {
	public static void cardname() {
		try {
			String SQL3 = "select cardname from (select c.cardname, count(c.num) r from checkcard c , cardbenefit b , usercheck u where u.benefit = b.benefit and u.id = '"+ PollSession.id + "' and c.num = b.checkcardnum group by c.cardname order by r DESC) where rownum = 1" ;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn3 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "myproject", "myproject");
			PreparedStatement pstmt2 = conn3.prepareStatement(SQL3);
		//	pstmt2.setString(1, PollSession.id);
			ResultSet rs = pstmt2.executeQuery();
			
			List<ResultModle> resultModle = new ArrayList<>();
			while (rs.next()) {
				ResultModle rm = new ResultModle(
						rs.getString("cardname")
						);
				resultModle.add(rm);
				CardM.CName = rm.getCardname(); 
			}
				 
//				for (ResultModle rm : resultModle) {
//					System.out.println(rm.getCardname());
//				}
//				System.out.println("¿Ï·á");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
	
		
	
	

