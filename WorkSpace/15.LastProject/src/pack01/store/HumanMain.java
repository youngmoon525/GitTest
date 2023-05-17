package pack01.store;

import java.util.Scanner;

public class HumanMain {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		HumanDAO dao = new HumanDAO();
		
		while(true) {
			System.out.println("=============");
			System.out.println("1.편의점가기");
			System.out.println("2.카드충전하기");
			System.out.println("3.집에가기");
			System.out.println("=============");
			int select = dao.selectNum();
			if(select==1) {
				dao.intoStore();
			}
			else if(select==2) {
				dao.chargeMoney();
			}
			else if(select==3) {
				System.out.println("집에 갑니다");
				break;
			}
		}
		
		
		
	}

}
