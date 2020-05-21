package project02;

import java.rmi.server.RMIClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResultCard2 {
	public static void cardname2() {
		try {
			String SQL4 = "select cardname from	(select rownum m,cardname from (select c.cardname, count(c.num) r from checkcard c , cardbenefit b , usercheck u where u.benefit = b.benefit and c.num = b.checkcardnum and u.id = '"+PollSession.id+"' group by c.cardname order by r DESC)) where m =2";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn4 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "myproject", "myproject");
			PreparedStatement pstmt4 = conn4.prepareStatement(SQL4);
		//	pstmt2.setString(1, PollSession.id);
			ResultSet rs = pstmt4.executeQuery();
			
			List<ResultModle2> resultModle2 = new ArrayList<>();
			while (rs.next()) {
				ResultModle2 rm2 = new ResultModle2(
						rs.getString("cardname")
						);
				resultModle2.add(rm2);
				CardM2.CName2 = rm2.getCardname2(); 
			}
				 
//				for (ResultModle2 rm2 : resultModle2) {
//					System.out.println(rm.getCardname());
//			}
//				System.out.println("¿Ï·á");
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
	
		
	
	

