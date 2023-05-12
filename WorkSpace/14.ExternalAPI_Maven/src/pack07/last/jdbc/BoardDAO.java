package pack07.last.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs; 
	
	//사용후닫기처리를 할 예정
	public Connection getConn() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
		} catch (Exception e) {
			System.out.println(" 알수없는 오류발생! 개발자에게 문의하세요 ");
		}
		return conn;
	}

	public void dbClose() {
		try {
			if(rs != null ) { rs.close() ; }
			if(ps != null ) {ps.close();}
			if(conn != null ) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public void selectList() {
		try {
			conn = getConn();//DB 연결객체 초기화 시키기
			ps = conn.prepareStatement(" select * from board ");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("BOARD_NO"));
			}
			
		} catch (SQLException e) {
			System.out.println("kymSqlplus Exception : " + e.getMessage());
		} finally {
			// conn , ps , rs 세가지 객체 전부 null로 비워줘야함.(DB Close)
			dbClose();
		}
	}
	
	public void selectList(String keyword) {
		try {
			conn = getConn();//DB 연결객체 초기화 시키기
//			ps = conn.prepareStatement(" SELECT * FROM BOARD WHERE BOARD_TITLE = '"+ keyword +"'" + 
//			"AND " +  keyword ); // <= 파라메터를 String형태에 연결시켜서 사용하려니 가독성이 떨어짐.
			ps = conn.prepareStatement(" SELECT * FROM BOARD WHERE BOARD_TITLE = ? " );
			ps.setString(1, keyword);//?로 되어있는 파라메터부에 데이터를 넣는것 . ( 왼쪽기준으로 쭉보면서 ?의 순서를 보면된다)
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("BOARD_NO"));
			}
			
		} catch (SQLException e) {
			System.out.println("kymSqlplus Exception : " + e.getMessage());
		} finally {
			// conn , ps , rs 세가지 객체 전부 null로 비워줘야함.(DB Close)
			dbClose();
		}
	}
	
	public void insertBoard() {
		try {
			conn = getConn();//DB 연결객체 초기화 시키기
			ps = conn.prepareStatement(" INSERT INTO BOARD (BOARD_NO, BOARD_TITLE, BOARD_CONTENT) "
					+ " VALUES (12,  ? , ? ) ");//사용자가 글의 식별자가 되는 글번호를 직접 입력을 할까?
															 // 한다 vs 안한다 방법 ?
			ps.setString(1, "java?title");
			ps.setString(2, "java?content");
			//rs = ps.executeQuery();
			int result = ps.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			System.out.println("kymSqlplus Exception : " + e.getMessage());
		} finally {
			// conn , ps , rs 세가지 객체 전부 null로 비워줘야함.(DB Close)
			dbClose();
		}
	}
	

}
