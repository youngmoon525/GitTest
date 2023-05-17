package pack_fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FIFASIGNUPDAO {
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
	

	public void signup() {
		String id, password, name;
		int age;
		try {
		System.out.println("ȸ�����Կ� �ʿ��� ������ ���ʴ�� �Է����ּ���.");
		while(true) {
		System.out.print("���̵� : ");
		id = sc.nextLine();
		conn = getConn(); 
		ps = conn.prepareStatement("SELECT * FROM FIFAMEMBER WHERE MEMBER_ID = '"+id+"'");
		rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("�̹� �����ϴ� ���̵��Դϴ�. �ٸ� ���̵� �Է����ּ���.");
		}else {
			System.out.println("��밡���� ���̵��Դϴ�.");
			break;
		}
		}
		System.out.print("��й�ȣ : ");
		password = sc.nextLine();
		System.out.print("�̸� : ");
		name = sc.nextLine();
		System.out.print("���� : ");
		age = inputInt();
		conn = getConn(); 
		ps = conn.prepareStatement("INSERT INTO FIFAMEMBER (MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_AGE) VALUES (?, ?, ?, ?)");
		ps.setString(1, id);
		ps.setString(2, password);
		ps.setString(3, name);
		ps.setInt(4, age);
		rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}else {
			System.out.println("ȸ�������� �����Ͽ����ϴ�.");
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
