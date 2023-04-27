package pack04.db;

import java.util.Scanner;

public class HtmlMain {
	public static void main(String[] args) {
		//DataAccessObject dao = new MysqlDAO();
		//dbWork( new MysqlDAO());
		//dbWork(  new OracleDAO());
		//   \n
		Scanner sc = new Scanner(System.in);
		if(sc.nextLine().equals("1")) {
			dbWork( new MysqlDAO());
		}else {
			dbWork(  new OracleDAO());
		}
		
	}
	
	// Oracle또는 Mysql을 입력받아 select~delete 하는 메소드
	public static void dbWork(DataAccessObject dao) {
		//mysql을 select....delete
		//oracle을 select....delete
		dao.select();
		dao.insert();
		dao.delete();
		dao.update();
	}
	
}
