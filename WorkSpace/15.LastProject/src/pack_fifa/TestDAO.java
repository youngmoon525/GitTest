package pack_fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pack_fifa.FIFAUSERDAO;

public class TestDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
		} catch (Exception e) {
			System.out.println(" 알 수 없는 오류 발생! 개발자에게 문의하세요. ");
		}
		return conn;
	}
	
	public void test() {
		conn = getConn();

		try {
			ps = conn.prepareStatement("SELECT E.* , D.* "
					+ " FROM EMPLOYEES E LEFT OUTER JOIN DEPARTMENTS D ON  E.DEPARTMENT_ID = D.DEPARTMENT_ID");
			rs = ps.executeQuery();
			while(rs.next()) {
				//ArrayList
			}
			//================================================================//
			
			
			ps = conn.prepareStatement("select * from departments  ");
			rs = ps.executeQuery();
			while(rs.next()) {
				//ArrayList
			}
			
			// for(int i = 0 ; i < emplist.size(); i ++ ) {
				// for( j = 0 ; j < departmentList.size(); j++) {
					// if ( emplist.get(i).getDepartmentId != null &&  emplist.get(i).getDepartmentId() == departmentList.get(i).getDepartmentId()){
						//empList.get(i).setDepartmentName =  
					//}
				//}
			//}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void dbClose() {
		try {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(conn!=null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
		
		
	

