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

public class FIFAADMINDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	

	public Connection getConn() {
		String url = "jdbc:oracle:thin:@211.223.59.99:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "hanul", "0000");
		} catch (Exception e) {
			System.out.println(" �� �� ���� ���� �߻�! �����ڿ��� �����ϼ���. ");
		}
		return conn;
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

Scanner sc = new Scanner(System.in);	

	public int inputInt() {
	Scanner sc = new Scanner(System.in);
	while(true) {
		try {
			int rtnInt = Integer.parseInt(sc.nextLine());
			return rtnInt;
		}catch (Exception e) {
			System.out.println("���� ���� �Է����ּ���.");
		}
	}
}
	public List<FIFADTO> displayList() {
		List<FIFADTO> list = new ArrayList<>();
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("SELECT * from korea order by 1");
			rs = ps.executeQuery();
			while(rs.next()) {
				FIFADTO dto = new FIFADTO(rs.getInt("PLAYER_NUM"), rs.getString("PLAYER_NAME"), rs.getInt("PLAYER_AGE"), rs.getString("HEIGHT"), rs.getString("MAIN_FOOT"), rs.getString("POSITION"), rs.getInt("PRICE"));
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println("sbnSqlplus Exception : "+e.getMessage());
		}
		for(FIFADTO dto1 : list) {
			System.out.print(dto1.getPlayer_num()+"\t");
			System.out.print(dto1.getPlayer_name()+"\t");
			System.out.print(dto1.getPlayer_age()+"\t");
			System.out.print(dto1.getHeight()+"\t");
			System.out.print(dto1.getMain_foot()+"\t");
			System.out.print(dto1.getPosition()+"\t");
			System.out.println(dto1.getPrice());
		}
		return list;
	}
public boolean adminLogin() {
	int count =0;
	while(count<3) {
	System.out.print("���̵� : ");
	String id = sc.nextLine();
	System.out.print("��й�ȣ : ");
	String pw = sc.nextLine();
	if(id.equals("admin")&&pw.equals("adminpw")) {
		System.out.println("������ ���� �α��� �Ǿ����ϴ�.");
		return true;
	}else {
		System.out.println("�α��� ���� ���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
	}
	count++;
}System.out.println("�õ� Ƚ�� 3ȸ�� �ʰ��߽��ϴ�.");
	return false;
	}

public void addPlayer() {
	System.out.println("�߰��� ������ ������ ���ʴ�� �Է����ּ���.");
	try {
		conn = getConn(); 
		ps = conn.prepareStatement("INSERT INTO KOREA SELECT MAX(PLAYER_NUM)+1, ?, ?, ?, ?, ?, ? FROM KOREA"); 
		System.out.print("�̸� : ");
		ps.setString(1, sc.nextLine());
		System.out.print("���� : ");
		ps.setInt(2, inputInt());
		System.out.print("Ű : ");
		ps.setString(3, sc.nextLine());
		System.out.print("�ֹ�(right, left, both) : ");
		ps.setString(4, sc.nextLine());
		System.out.print("������(MF, FW, DF, GK) : ");
		ps.setString(5, sc.nextLine());
		System.out.print("���� : ");
		ps.setInt(6, inputInt());
		int i= ps.executeUpdate();
		if(i==1) {
			System.out.println("������ �߰��߽��ϴ�.");
			displayList();
		}else {
			System.out.println("���� �߰� ����");
		}
	} catch (SQLException e) {
		System.out.println("sbnSqlplus Exception : "+e.getMessage());
	} finally {
		dbClose();
	}
}

public void displayNum() {
	try {
	System.out.print("1. �̸� : "+rs.getString("player_name")+" ");
	System.out.print("2. ���� : "+rs.getInt("player_age")+" ");
	System.out.print("3. Ű : "+rs.getString("height")+" ");
	System.out.print("4. �ֹ� : "+rs.getString("main_foot")+" ");
	System.out.print("5. ������ : "+rs.getString("position")+" ");
	System.out.println("6. ����  :"+rs.getInt("price"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void updatePlayer() {

	displayList();
	System.out.println("������ ������ ��ȣ�� �Է����ּ���.");
	
	while(true) {
		int num = inputInt();
	try {
		conn = getConn(); 
		ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
		rs = ps.executeQuery();
		if(rs.next()) {
			displayNum();
		while(true) {
			System.out.println("������ ������ �κ��� ��ȣ�� �Է����ּ���");
		int selectNum = inputInt();
		if(selectNum==1) {
			conn = getConn();
			System.out.print(rs.getString("player_name")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET PLAYER_NAME = '"+sc.nextLine()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
			}
				break;
			}
		}else if(selectNum==2) {
			conn = getConn();
			System.out.print(rs.getString("PLAYER_AGE")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET PLAYER_AGE = '"+inputInt()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
				}
				
			}break;
		}else if(selectNum==3) {
			conn = getConn();
			System.out.print(rs.getString("HEIGHT")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET HEIGHT = '"+sc.nextLine()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
				}
			}
			break;
		}else if(selectNum==4) {
			conn = getConn();
			System.out.print(rs.getString("MAIN_FOOT")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET MAIN_FOOT = '"+sc.nextLine()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
				}
			}
			break;
		}else if(selectNum==5) {
			conn = getConn();
			System.out.print(rs.getString("POSITION")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET POSITION = '"+sc.nextLine()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
				}
			}
			break;
		}else if(selectNum==6){
			conn = getConn();
			System.out.print(rs.getString("PRICE")+" -> ");
			ps = conn.prepareStatement("UPDATE KOREA SET PRICE = '"+inputInt()+"' WHERE PLAYER_NUM = "+num); 
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("SELECT * FROM KOREA WHERE PLAYER_NUM = '"+num+"'"); 
				rs = ps.executeQuery();
				while(rs.next()) {
					displayNum();
				}
			}
			break;
		}else {
			System.out.println("�Է� ���� 1~6������ ���� �Է��ϼ���");
		}
		
		}break;
		}else {
			System.out.println("�ش��ϴ� ��ȣ�� ������ �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		}
	} catch (SQLException e) {
		System.out.println("sbnSqlplus Exception : "+e.getMessage());
	} finally {
		dbClose();
	}
	}
}

public void deletePlayer() {
	displayList();
	System.out.println("������ ������ ��ȣ�� �Է����ּ���.");
	while(true) {
	int num = inputInt();
	try {
		conn = getConn(); 
		ps = conn.prepareStatement("DELETE FROM KOREA WHERE PLAYER_NUM = ?"); 
		ps.setInt(1, num);
		int i= ps.executeUpdate();
		if(i==1) {
			System.out.println("������ �����߽��ϴ�.");
			displayList();
			break;
		}else {
			System.out.println("�ش��ϴ� ��ȣ�� ������ �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
		}
	} catch (SQLException e) {
		System.out.println("sbnSqlplus Exception : "+e.getMessage());
	} finally {
		dbClose();
	}
	}
}

public void displayInfo() {
	try {
		System.out.print(rs.getInt("player_num")+" ");
	System.out.print(rs.getString("player_name")+" ");
	System.out.print(rs.getInt("player_age")+" ");
	System.out.print(rs.getString("height")+" ");
	System.out.print(rs.getString("main_foot")+" ");
	System.out.print(rs.getString("position")+" ");
	System.out.println(rs.getInt("price"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

public void search() {
	try {
	System.out.println("1. �̸����� �˻�  2. �ֹ߷� �˻�  3. ���������� �˻�");
	while(true) {
	int num = inputInt();
	if(num==1) {
			System.out.println("ã����� ������ �̸��� �Է��ϼ���.");
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where player_name = '"+sc.nextLine()+"'");
			rs = ps.executeQuery();
		if(rs.next()) {
			displayInfo();
		}else {
			System.out.println("�Է��Ͻ� ������ ������ �����ϴ�.");
		}
		
		break;
	}else if(num==2) {
		System.out.println("1. right 2. left 3. both");
		while(true) {
		num = inputInt();
		if(num==1) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where main_foot = 'RIGHT'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else if(num==2) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where main_foot = 'LEFT'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else if(num==3) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where main_foot = 'BOTH'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else {
			System.out.println("�Է� ���� 1~3������ ���� �Է��ϼ���.");
		}
		}
		break;
	}else if(num==3) {
		System.out.println("1. MF 2. FW 3. DF 4. GK");
		while(true) {
		num = inputInt();
		if(num==1) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where POSITION = 'MF'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else if(num==2) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where POSITION = 'MF'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else if(num==3) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where POSITION = 'DF'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else if(num==4) {
			conn = getConn();
			ps = conn.prepareStatement("select * from korea where POSITION = 'GK'");
			rs = ps.executeQuery();
		while(rs.next()) {
			displayInfo();
		}
		break;
		}else {
			System.out.println("�Է� ���� 1~3������ ���� �Է��ϼ���.");
		}
		}
		break;
	}else {
		System.out.println("�Է� ���� 1~3������ ���� �Է��ϼ���.");
	}
	}
	}catch (SQLException e) {
			e.printStackTrace();
	}finally {
			dbClose();
	
	}
	}
}
		
		
	

