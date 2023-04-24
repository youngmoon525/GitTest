package japangi;

import java.util.Scanner;

public class JapangiMain {
	public static void main(String[] args) {
		
		System.out.println("자판기");
		System.out.println("=========================");
		JapangiDTO[] dtoArr = new JapangiDTO[3];
		JapangiDAO dao = new JapangiDAO();
		dtoArr[0] = new JapangiDTO(1, "콜라", 800, 8);
		dtoArr[1] = new JapangiDTO(2, "사이다", 1000, 5);
		dtoArr[2] = new JapangiDTO(3, "환타", 900, 1);
		for(int i = 0; i < dtoArr.length; i++) {
			dao.display(dtoArr[i]);
		}
		System.out.println("=========================");
		
		dao.inputCoin();
	
		dao.buydrink();
		
		


	}
		
	
	
	

}