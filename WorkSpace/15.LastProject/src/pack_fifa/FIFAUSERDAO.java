package pack_fifa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class FIFAUSERDAO {
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

String id;
Scanner sc = new Scanner(System.in);	

	public boolean login() {
		
		int count = 0;
		while(count<3) {
			System.out.print("���̵� : ");
			id = sc.nextLine();
			System.out.print("��й�ȣ : ");
			String pw = sc.nextLine();
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("select * from FIFAMEMBER "
							+ "where MEMBER_ID = '"+id+"' "
							+ "AND MEMBER_PASSWORD = '"+pw+"'");
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println("�α��� ����");
				return true;
			}else {
				System.out.println("�α��� ���� ���̵� �Ǵ� ��й�ȣ�� Ȯ�����ּ���.");
			}
		} catch (SQLException e) {
			System.out.println("sbnSqlplus Exception : "+e.getMessage());
		}
		count++;
		}
		System.out.println("�õ� Ƚ�� 3ȸ �ʰ�");
		return false;
	}
	

	
	
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
	
	public void searchMyPlayer() {
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("SELECT m.PLAYER_NUM, k.player_name, k.player_age, k.height, k.main_foot, k.position, k.price  from FIFAMYMEMBER m , korea k WHERE k.player_num = m.player_num and MEMBER_ID = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				displayInfo();
			}
			if(!rs.next()) {
				System.out.println("�����ϰ� �ִ� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void formation() {
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("SELECT FORMATION from FIFAMEMBER WHERE MEMBER_ID = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
		System.out.println("���� �� �����̼� : "+rs.getString("FORMATION"));
			}
		System.out.println("�����̼��� �������ּ���");
		System.out.println("1�� 4-2-3-1\t2�� 4-2-2-1-1\t3�� 4-2-2-2\t4�� 5-2-3");
		System.out.println("     ��    \t      ��    \t   ��   ��  \t��   ��   ��");
		System.out.println("  ��  ��  �� \t      ��    \t ��       ��\t  ��   ��  ");
		System.out.println("   ��   ��  \t  ��       ��\t   ��   ��  \t�� �� �� �� ��");
		System.out.println(" ��  �� ��  ��\t    ��   ��  \t ��  �� ��  ��\t    ��    ");
		System.out.println("     ��    \t  ��  �� ��  ��\t     ��    ");
		System.out.println("          \t      ��    ");
		String[] formation = {"4-2-3-1", "4-2-2-1-1", "4-2-2-2", "5-2-3"};
		while(true) {
			int num = inputInt();
			if(num==1||num==2||num==3||num==4) {
				System.out.println(num+"�� �����̼��� ���õǾ����ϴ�.");
				conn = getConn(); 
				ps = conn.prepareStatement("UPDATE FIFAMEMBER SET FORMATION = ? WHERE MEMBER_ID = ?");
				ps.setString(1, formation[num-1]);
				ps.setString(2, id);
				rs = ps.executeQuery();
				break;
			}else {
				System.out.println("�Է¿��� 1~4������ ���� �Է��ϼ���.");
			}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void candidate() {
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("SELECT PLAYER_NUM FROM FIFAMYMEMBER WHERE MEMBER_ID = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
			conn = getConn(); 
			ps = conn.prepareStatement("SELECT m.PLAYER_NUM, k.player_name, k.player_age, k.height, k.main_foot, k.position, k.price  from FIFAMYMEMBER m , korea k WHERE k.player_num = m.player_num and MEMBER_ID = ? AND m.main = 'MAIN' ORDER BY PLAYER_NUM");
			ps.setString(1, id);
			rs = ps.executeQuery();
			System.out.println("=====���� ����=====");
			while(rs.next()) {
				displayInfo();
			}
			conn = getConn();
			ps = conn.prepareStatement("select count(*) AS CNT\r\n"
					+ "from    fifamymember\r\n"
					+ "where   member_id = '1'\r\n"
					+ "and     main = 'MAIN'");
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getInt("CNT")<11) {
					conn = getConn(); 
					ps = conn.prepareStatement("SELECT m.PLAYER_NUM, k.player_name, k.player_age, k.height, k.main_foot, k.position, k.price  from FIFAMYMEMBER m , korea k WHERE k.player_num = m.player_num and MEMBER_ID = ? AND m.main = 'SERVE' ORDER BY PLAYER_NUM");
					ps.setString(1, id);
					rs = ps.executeQuery();
					System.out.println("=====�ĺ� ����=====");
					while(rs.next()) {
						displayInfo();
					}
					System.out.println("�������� �߰��� ������ ��ȣ�� �Է����ּ���");
					while(true) {
					int num = inputInt();
					conn = getConn(); 
					ps = conn.prepareStatement("SELECT PLAYER_NUM FROM FIFAMYMEMBER WHERE PLAYER_NUM = ? AND MAIN = 'SERVE'");
					ps.setInt(1, num);
					rs = ps.executeQuery();
					if(rs.next()) {
						System.out.println("�߰��� �Ϸ�Ǿ����ϴ�.");
						conn = getConn(); 
						ps = conn.prepareStatement("UPDATE FIFAMYMEMBER SET MAIN = 'MAIN' WHERE PLAYER_NUM = ?");
						ps.setInt(1, num);
						rs = ps.executeQuery();
						conn = getConn(); 
						ps = conn.prepareStatement("SELECT m.PLAYER_NUM, k.player_name, k.player_age, k.height, k.main_foot, k.position, k.price  from FIFAMYMEMBER m , korea k WHERE k.player_num = m.player_num and MEMBER_ID = ? AND m.main = 'MAIN' ORDER BY PLAYER_NUM");
						ps.setString(1, id);
						rs = ps.executeQuery();
						System.out.println("=====���� ����=====");
						while(rs.next()) {
							displayInfo();
						}
						break;
					}else {
						System.out.println("�Է� ���� ���� �����ϰ� �ִ� �ĺ� ������ ��ȣ�� �Է����ּ���.");
					}
					}
				}else {
					
				}
			}
			}else {
				System.out.println("���� �����ϰ� �ִ� ������ �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	public void checkBP() {
		try {
			conn = getConn(); //DB ���ᰴü �ʱ�ȭ ��Ű��
			ps = conn.prepareStatement("SELECT MEMBER_BP FROM FIFAMEMBER WHERE MEMBER_ID = ?" );
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("MEMBER_BP") +" BP");
			}
		} catch (SQLException e) {
			System.out.println(" Exception : " + e.getMessage());
		} 
	}
	

	
public void sell() {
        try {	
        		conn = getConn();
        		ps = conn.prepareStatement("SELECT PLAYER_NAME FROM FIFAMYMEMBER WHERE MEMBER_ID = ?");
    			ps.setString(1, id);
	        	rs = ps.executeQuery();
	        	while(rs.next()) {
	        		System.out.println(rs.getString("PLAYER_NAME"));
	        	}
        		System.out.println("�Ǹ��� ������ �̸��� �Է����ּ���.");
 	        	String player = sc.nextLine();
        	 	conn = getConn();
 	        	String sql1 = "SELECT PLAYER_NAME FROM FIFAMYMEMBER WHERE PLAYER_NAME = ?";
 	        	ps = conn.prepareStatement(sql1);
 	        	ps.setString(1, player);
 	        	rs = ps.executeQuery();
				
	          if(rs.next()) {
		           	
	        	  String query1 = "SELECT * FROM KOREA WHERE PLAYER_NAME = ?";
	        	  	ps = conn.prepareStatement(query1);
					ps.setString(1, player);
					rs = ps.executeQuery();
					
					if(rs.next()) {
						  int price = rs.getInt("PRICE");
		        		  String updateQuery = "UPDATE FIFAMEMBER SET MEMBER_BP = MEMBER_BP + ? WHERE MEMBER_ID = ?";
			               ps = conn.prepareStatement(updateQuery);
			               ps.setInt(1, price);
			               ps.setString(2, id);
			               ps.executeUpdate();		            	   
			               
			               System.out.println(price + "���� �߰��Ǿ����ϴ�.");
	            
			               String query2 = "DELETE  FROM FIFAMYMEMBER WHERE MEMBER_ID= ? ";
			               ps = conn.prepareStatement(query2);
			               ps.setString(1, id);
			               ps.executeQuery();
			               System.out.println(player + "�� �����Ͽ����ϴ�.");
					}
	          }else {
	        	  System.out.println("������ �������� �ʽ��ϴ�.");
	          }
        } catch (SQLException e) {
            // ���� ó��
        } finally {
        	dbClose();
        }
	    }

	public void purchase() {

	    String sql2 = "UPDATE FIFAMEMBER SET MEMBER_BP = MEMBER_BP - ? WHERE MEMBER_ID = ?";
	    String sql3 = "INSERT INTO FIFAMYMEMBER (MEMBER_ID, PLAYER_NAME) VALUES (?, ?)";

	    try {
	        conn = getConn();
	        displayList();
	        System.out.println("������ ������ �̸��� �Է����ּ���.");
	        String sql1 = "SELECT PLAYER_NAME FROM FIFAMYMEMBER WHERE PLAYER_NAME = ?";
	        ps = conn.prepareStatement(sql1);
	        String player = sc.nextLine();
	        ps.setString(1, player);
	        rs = ps.executeQuery();
	        
	        if (!rs.next()) {
	            String getPriceQuery = "SELECT PRICE FROM KOREA WHERE PLAYER_NAME = ?";
	            ps = conn.prepareStatement(getPriceQuery);
	            ps.setString(1, player);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                int price = rs.getInt("PRICE");

	                ps = conn.prepareStatement(sql2);
	                ps.setInt(1, price);
	                ps.setString(2, id);
	                ps.executeUpdate();
	                System.out.println(price + "���� �����Ǿ����ϴ�.");

	                ps = conn.prepareStatement(sql3);
	                ps.setString(1, id);
	                ps.setString(2, player);
	                ps.executeUpdate();
	                System.out.println(player + "�� �����Ͽ����ϴ�.");
	            }
        }else{
        	System.out.println("�ߺ��Ǵ� ������ �־� ������ �Ұ��մϴ�.");
        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        dbClose();
	    }
	}

	public void chargeBP() {
		conn=getConn();
		String sql = "UPDATE FIFAMEMBER SET MEMBER_BP = MEMBER_BP + ? WHERE MEMBER_ID = ? ";
         try {
        	ps = conn.prepareStatement(sql);
        	System.out.println("������ Bp�� �Է����ּ���");
        	int bp = inputInt();
			ps.setInt(1, bp);
			ps.setString(2, id);
			ps.executeUpdate();	
			System.out.println(bp + " : ���� �����Ǿ����ϴ�.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void signout() {
		System.out.println("��й�ȣ : ");
		
		try {
			conn = getConn(); 
			ps = conn.prepareStatement("select * from FIFAMEMBER where MEMBER_ID = '"+id+"' "
							+ "AND MEMBER_PASSWORD = '"+sc.nextLine()+"'");
			rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println("ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
			conn = getConn(); 
			ps = conn.prepareStatement("DELETE FROM FIFAMEMBER WHERE MEMBER_ID = '"+id+"'");
			rs = ps.executeQuery();
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
