package pack01.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HumanDAO {
	
	Scanner sc = new Scanner(System.in);
	StoreDAO daoS = new StoreDAO();
	
	
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
	
	public Connection getConn() {
		
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
			if(!conn.isClosed()) {
				return conn;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("편의점이 망했습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("편의점이 망했습니다.");
		}
		
		return conn;
		
	}
	
	void intoStore() {
		conn = getConn();
		try {
			ps = conn.prepareStatement("select name from human");
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("name")+"님 어서 오세요!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			daoS.dbClose();
		}
		while(true) {
			System.out.println("===========");
			System.out.println("1.물품보기");
			System.out.println("2.물건사기");
			System.out.println("3.잔액확인하기");
			System.out.println("4.나가기");
			System.out.println("===========");
			int select=selectNum();
			if(select==1) {
				daoS.displayList();
			}
			else if(select==2) {
				buy();
			}
			else if(select==3) {
				displayMoney();
			}
			else if(select==4) {
				return;
			}
			else {
				System.out.println("다시입력해주세요");
			}
		}
		
	}
	

	void buy() {
		daoS.displayList();
		System.out.println("구매할 제품의 코드번호를 입력해주세요");
		int select=selectNum();
		int rs0=0;
		int rs1=0;
		int rs2=0;
		
		try {
			ps=conn.prepareStatement("SELECT cnt from convenience where code=?" );
			ps.setInt(1, select);
			rs=ps.executeQuery();
			if(rs.next()) {
				rs0=rs.getInt("cnt");
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(rs0==0) {
			System.out.println("재고가 다 떨어졌습니다");
			return;
		}
		
		try {
			ps=conn.prepareStatement("SELECT price from convenience where code=?" );
			ps.setInt(1, select);
			rs=ps.executeQuery();
			if(rs.next()) {
				rs1=rs.getInt("price");
			}
			
			ps=conn.prepareStatement("SELECT money from human where name='김기곤'" );
			rs=ps.executeQuery();
			if(rs.next()) {
				rs2=rs.getInt("money");
			}
			
			if(rs2>=rs1) {
				ps=conn.prepareStatement("UPDATE CONVENIENCE SET cnt=cnt-1 where code=?" );
				ps.setInt(1, select);
				ps.executeUpdate();
				ps=conn.prepareStatement("SELECT product from convenience where code=?" );
				ps.setInt(1, select);
				rs=ps.executeQuery();
				if(rs.next()) {
				System.out.print(rs.getString("product"));
				System.out.println("를 구입하셧습니다!");
				}
				ps = conn.prepareStatement("UPDATE human SET money = money-(select convenience.price from convenience where code=?) where name='김기곤'");
				ps.setInt(1, select);
				ps.executeUpdate();
				ps=conn.prepareStatement("SELECT money from human" );
				rs=ps.executeQuery();
				if(rs.next()) {
				System.out.print("현재금액 : ");
				System.out.println(rs.getInt("money"));
				}
			}
			else if(rs1>rs2) {
				System.out.println("잔액이 부족합니다");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			daoS.dbClose();
		}
		
		
	}
	
	
	void displayMoney() {
		conn = getConn();
		try {
			ps = conn.prepareStatement("select money from human");
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("현재잔액 : "+rs.getInt("money"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			daoS.dbClose();
		}
	}
	
	
	void chargeMoney() {
		displayMoney();
		System.out.println("얼마를 충전하시겠습니까?");
		int chargeMoney=selectNum();
		try {
			ps = conn.prepareStatement("UPDATE human SET money=money+? where name='김기곤'");
			ps.setInt(1, chargeMoney);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			daoS.dbClose();
		}
		displayMoney();
		
	}

}
