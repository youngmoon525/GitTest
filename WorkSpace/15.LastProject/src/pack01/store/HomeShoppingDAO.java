package pack01.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HomeShoppingDAO {
	Scanner sc = new Scanner (System.in);
	StoreDAO daoS = new StoreDAO();
	HumanDAO daoH = new HumanDAO();
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	boolean islogin = false;
	String user_id=null;
	
	
	int selectNum() {
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
	
	public Connection getConn() {
		
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
			if(!conn.isClosed()) {
				return conn;
			}
		} catch (ClassNotFoundException e) {
			System.out.println("홈쇼핑이 망했습니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("홈쇼핑이 망했습니다.");
		}
		
		return conn;
		
	}
	
	
	
	void membership() {//회원가입
		
		conn = getConn();
		
		System.out.println("====회원가입====");
		
		System.out.print("아이디:");
		String id= sc.nextLine();
		while(id.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			id= sc.nextLine();
		}
		try {
			ps=conn.prepareStatement("SELECT id from member2 where id=?" );
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
			while(id.equals(rs.getString("id"))) {
				System.out.println("이미 사용중인 아이디입니다.");
				System.out.println("다시 입력해주세요");
				System.out.print("아이디:");
				id= sc.nextLine();
				while(id.length()>30) {
					System.out.println("30자 이내로");
					System.out.println("다시입력해주세요");
					id= sc.nextLine();
				}
			}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		System.out.print("비밀번호:");
		String pw= sc.nextLine();
		while(pw.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			pw= sc.nextLine();
		}
		
		
		System.out.print("이름:");
		String name= sc.nextLine();
		while(name.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			name= sc.nextLine();
		}
		
		
		System.out.print("생일:");
		int birth= selectNum();
		int length = (int)(Math.log10(birth)+1);
		while(length!=8 ) {
			System.out.println("8자로 입력해주세요");
			birth= selectNum();
			length = (int)(Math.log10(birth)+1);
		}
		
		try {
			ps = conn.prepareStatement("INSERT INTO member2 (ID, PW, NAME, BIRTH,cash) "
					+ "VALUES (?, ?, ?, ?,0)");
			ps.setString(1, id);
			ps.setString(2, pw);
			ps.setString(3, name);
			ps.setInt(4, birth);
			rs = ps.executeQuery();
			
			ps=conn.prepareStatement("SELECT name from member2 where id=?" );
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
			System.out.print(rs.getString("name"));
			System.out.println("님 어서오세요!!");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
	}
	
	void login() {
		
		conn = getConn();
		
		System.out.println("====로그인====");
		
		System.out.print("아이디:");
		String id = sc.nextLine();
		System.out.print("비밀번호:");
		String pw = sc.nextLine();
		
		try {
			ps=conn.prepareStatement("SELECT id,pw from member2 where id=? and pw=?" );
			ps.setString(1, id);
			ps.setString(2, pw);
			rs=ps.executeQuery();
			if(rs.next()) {
					if(id.equals(rs.getString("id"))&&pw.equals(rs.getString("pw"))) {
						System.out.print(rs.getString("id"));
						System.out.println("님 어서오세요!!");
						islogin=true;
						user_id=id;
					}
					
				}else {
					System.out.println("아이디 또는 비밀번호가 틀립니다.");
					islogin=false;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbClose();
		}
		
		
	}
	
	
	void findID() {
		
		conn = getConn();
		
		System.out.println("당신의 이름은?");
		String name= sc.nextLine();
		while(name.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			name= sc.nextLine();
		}
		
		System.out.println("당신의 생일은?");
		int birth= selectNum();
		int length = (int)(Math.log10(birth)+1);
		while(length!=8 ) {
			System.out.println("8자로 입력해주세요");
			birth= selectNum();
			length = (int)(Math.log10(birth)+1);
		}
		
		
		try {
			ps = conn.prepareStatement("select name,birth,id from member2 where name=? and birth=?");
			ps.setString(1, name);
			ps.setInt(2, birth);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("당신의 아이디는");
				System.out.println(rs.getString("id"));
			}
			else {
				System.out.println("회원정보가 없습니다");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		
	}
	
	
	void findPW() {
		conn = getConn();
		
		System.out.println("당신의 아이디는?");
		String id= sc.nextLine();
		
		while(id.length()>30 ) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			id= sc.nextLine();
		}

		System.out.println("당신의 이름은?");
		String name= sc.nextLine();
		while(name.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			name= sc.nextLine();
		}
		
		System.out.println("당신의 생일은?");
		int birth= selectNum();
		int length = (int)(Math.log10(birth)+1);
		while(length!=8 ) {
			System.out.println("8자로 입력해주세요");
			birth= selectNum();
			length = (int)(Math.log10(birth)+1);
		}
		
		
		try {
			ps = conn.prepareStatement("select id,name,birth,pw from member2 where id=? and name=? and birth=?");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3,birth);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println("당신의 비밀번호는");
				System.out.println(rs.getString("pw"));
			}
			else {
				System.out.println("회원정보가 없습니다");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	
	void intoHomeShopping() { //홈쇼핑 로그인 성공
		login();
		while(islogin==true) {
			System.out.println("============");
			System.out.println("1.물품보기");
			System.out.println("2.물건구매");
			System.out.println("3.캐시충전");
			System.out.println("4.비밀번호수정");
			System.out.println("5.회원탈퇴");
			System.out.println("0.로그아웃");
			System.out.println("============");
			displayMoney();
			int selectNum=selectNum();
			if(selectNum==1) {
				daoS.displayList();
			}
			else if(selectNum==2) {
				buy();
			}
			else if(selectNum==3) {
				chargeCash();
			}
			else if(selectNum==4) {
				correction();
			}
			else if(selectNum==5) {
				delete();
			}
			else if(selectNum==0){
				System.out.println("로그아웃합니다");
				islogin=false;
			}
			else {
				System.out.println("다시입력해주세요");
			}
		}
	}
	
	void buy() {
	
		daoS.displayList();
		getConn();
		System.out.println("구매할 제품의 코드번호를 입력해주세요");
		int code=selectNum();
		int rs0=0;
		int rs1=0;
		int rs2=0;
		
		try {
			ps=conn.prepareStatement("SELECT cnt from convenience where code=?" );
			ps.setInt(1, code);
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
			ps.setInt(1, code);
			rs=ps.executeQuery();
			if(rs.next()) {
				rs1=rs.getInt("price");
			}
			
			ps=conn.prepareStatement("SELECT cash from member2 where id=?" );
			ps.setString(1, user_id);
			rs=ps.executeQuery();
			if(rs.next()) {
				rs2=rs.getInt("cash");
			}
			
			if(rs2>=rs1) {
				ps=conn.prepareStatement("UPDATE CONVENIENCE SET cnt=cnt-1 where code=?" );
				ps.setInt(1, code);
				ps.executeUpdate();
				ps=conn.prepareStatement("SELECT product from convenience where code=?" );
				ps.setInt(1, code);
				rs=ps.executeQuery();
				if(rs.next()) {
				System.out.print(rs.getString("product"));
				System.out.println("를 구입하셧습니다!");
				}
				ps = conn.prepareStatement("UPDATE member2 SET cash = cash-(select convenience.price from convenience where code=?) where id=?");
				ps.setInt(1, code);
				ps.setString(2, user_id);
				ps.executeUpdate();
				ps=conn.prepareStatement("SELECT cash from member2 where id=?" );
				ps.setString(1, user_id);
				rs=ps.executeQuery();
				if(rs.next()) {
				System.out.print("현재금액 : ");
				System.out.println(rs.getInt("cash"));
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
		getConn();
		try {
			ps = conn.prepareStatement("select cash from member2 where id=?");
			ps.setString(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("현재잔액 : "+rs.getInt("cash"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	void chargeCash() {
		displayMoney();
		
		System.out.println("얼마를 충전하시겠습니까?");
		int chargeCash=selectNum();
		try {
			getConn();
			ps = conn.prepareStatement("UPDATE member2 SET cash=cash+? where id=?");
			ps.setInt(1, chargeCash);
			ps.setString(2, user_id);
			ps.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			dbClose();
		}
		displayMoney();

	}
	
	void correction() {
		getConn();
		System.out.println("변경할 비밀번호를 입력하세요");
		System.out.print("비밀번호:");
		String pw= sc.nextLine();
		while(pw.length()>30) {
			System.out.println("30자 이내로");
			System.out.println("다시입력해주세요");
			pw= sc.nextLine();
		}
		
		
		
		try {
			ps=conn.prepareStatement("UPDATE member2 SET pw=? where id=?" );
			ps.setString(1, pw);
			ps.setString(2, user_id);
			ps.executeUpdate();
			System.out.println("수정됨");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			dbClose();
		}
		
		
		
		
	}
	
	void delete() {
		System.out.println("회원 탈퇴 하시겠습니까?????");
		System.out.println("1.탈퇴안한다");
		System.out.println("2.탈퇴한다");
		int select = selectNum();
		if(select==1) {
			System.out.println("회원탈퇴가 취소 되었습니다.");
		}
		if(select==2) {
			try {
				getConn();
				ps=conn.prepareStatement("delete FROM member2 where id=?" );
				ps.setString(1,user_id);
				ps.executeUpdate();
				System.out.println("탈퇴되었습니다.");
				islogin=false;
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			}finally {
				dbClose();
			}
		}
		
		
	}
}
