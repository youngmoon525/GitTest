package pack01.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StoreDAO {
	Scanner sc = new Scanner(System.in);
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public int selectNum() {
		while(true) {
			try {
				int selectNum=Integer.parseInt(sc.nextLine());
				if(selectNum<0) {
					System.out.println("다시입력해주세요");
					continue;
				}
				return selectNum;
			}catch (Exception e) {
				System.out.println("숫자를 입력해주세요");
			}
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
	
	public Boolean getConn() {
		
		System.out.print("아이디:");
		String id=sc.nextLine();
		System.out.print("비밀번호:");
		String pw=sc.nextLine();
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			if(!conn.isClosed()) {
				System.out.println("다음에 접속됨"+conn.getMetaData().getDatabaseProductVersion());
				return true;
			}
		} catch (ClassNotFoundException e) {
			System.out.println(" 오라클 드라이버가 준비가 안되어서 사용이 불가능한 PC입니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(" 알수없는 오류발생! 개발자에게 문의하세요 ");
		}
		
		return false;
		
	
	
}
	
	
	public void displayList() {
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@211.223.59.99:1521:xe", "hanul", "0000");
			ps=conn.prepareStatement("select * from CONVENIENCE ORDER BY code");
			rs=ps.executeQuery();
			System.out.println("코드번호   상품명    가격   수량");
			while(rs.next()) {
				
				System.out.println(" "+rs.getInt("code")+"        "+rs.getString("product")+"   "+rs.getInt("price")+"   "+rs.getInt("cnt"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
		dbClose();	
			
		}
		
	}
	
	
	
	
	public void addList() {
		
		try {
			displayList();
			System.out.println("제품의 이름을 입력해주세요");
			String product = sc.nextLine();
			System.out.println("제품의 가격을 입력해주세요");
			int price = Integer.parseInt(sc.nextLine());
			System.out.println("제품의 수량을 입력해주세요");
			int cnt = Integer.parseInt(sc.nextLine());
			conn = DriverManager.getConnection("jdbc:oracle:thin:@211.223.59.99:1521:xe", "hanul", "0000");
			ps=conn.prepareStatement("INSERT INTO CONVENIENCE (CODE, PRODUCT, PRICE, CNT)VALUES ((SELECT NVL(MAX(code), 0) + 1 FROM convenience),?,?,?)");
			ps.setString(1, product);
			ps.setInt(2, price);
			ps.setInt(3, cnt);
			ps.executeUpdate();
			System.out.println(product+" 품목 추가됨");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
	}
	
	
	public void updateList() {
		
		try {
			displayList();
			System.out.println("제품의 코드번호를 입력해주세요");
			int code = selectNum();
			System.out.println("제품의 가격을 입력해주세요");
			int price = selectNum();
			System.out.println("제품의 수량을 입력해주세요");
			int cnt = selectNum();
			conn = DriverManager.getConnection("jdbc:oracle:thin:@211.223.59.99:1521:xe", "hanul", "0000");
			ps=conn.prepareStatement("UPDATE CONVENIENCE SET price=?,cnt=? where code=?" );
			ps.setInt(1, price);
			ps.setInt(2, cnt);
			ps.setInt(3, code);
			ps.executeUpdate();
			System.out.println("수정됨");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		finally {
			dbClose();
		}
	}
	
	
	
	public void delete() {
		
		displayList();
		System.out.println("추가할 제품의 코드번호를 입력해주세요");
		int code = selectNum();
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@211.223.59.99:1521:xe", "hanul", "0000");
			ps=conn.prepareStatement("delete FROM CONVENIENCE where code=?" );
			ps.setInt(1, code);
			ps.executeUpdate();
			System.out.println("삭제됨");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			dbClose();
		}
		
		
		
		
	}
	
}

	
