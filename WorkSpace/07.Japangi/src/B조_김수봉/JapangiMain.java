package Test;

import java.util.Scanner;
public class JapangiMain {

	public static void main(String[] args) {
		japangiDAO dao = new japangiDAO();
		Scanner sc = new Scanner(System.in);
		japangiDTO[] dtoArr = new japangiDTO[5];
		dtoArr[0] = new japangiDTO(1 , "콜라" , 800 , 1);
		dtoArr[1] = new japangiDTO(2 , "사이다" , 1000 ,  3);
		dtoArr[2] = new japangiDTO(3 , "환타" , 900 , 4);
		dtoArr[3] = new japangiDTO(0 , null , 0 , 0);
		dtoArr[4] = new japangiDTO(0 , null , 0 , 0);
	
		japangiDAO.display(dtoArr[0]);
		japangiDAO.display(dtoArr[1]);
		japangiDAO.display(dtoArr[2]);
		
		dao.inputCoin(dtoArr[0]);
		dao.choiceCan(dtoArr[0], dtoArr[1], dtoArr[2]);
		dao.changes(dtoArr[0], dtoArr[1], dtoArr[2]);
		dao.admin();
		dao.adminSetting(dtoArr, dtoArr[0], dtoArr[1], dtoArr[2] , dtoArr[3] ,dtoArr[4] );
	}
}
