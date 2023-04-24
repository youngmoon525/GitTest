package miniproject;

import java.util.Scanner;

public class JapangiMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JapangiDAO dao = new JapangiDAO();
		JapangiDTO dto = new JapangiDTO();
		
		JapangiDTO [] dtoArr = new JapangiDTO[3];
		dtoArr[0] = new JapangiDTO(1, "콜라", 800, 8);
		dtoArr[1] = new JapangiDTO(2, "사이다", 1000, 5);
		dtoArr[2] = new JapangiDTO(3, "환타", 900, 1);
		
		for (int i = 0; i < dtoArr.length; i++) {
			System.out.print(dtoArr[i].num+". ");
			System.out.print(dtoArr[i].name);
			System.out.print(" 금액:"+dtoArr[i].price);
			System.out.println(" 수량:"+dtoArr[i].cnt);
		}
		System.out.println("돈 넣어주세요");
		int money = Integer.parseInt(sc.nextLine());
		System.out.println(money+"원을 넣었습니다");
		
		System.out.println("음료를 골라주세요");
		
		for (int i = 0; i < dtoArr.length; i++) {
			System.out.print(dtoArr[i].num+". ");
			System.out.print(dtoArr[i].name);
			System.out.print(" 금액:"+dtoArr[i].price);
			System.out.println(" 수량:"+dtoArr[i].cnt);
		}
		int select = Integer.parseInt(sc.nextLine());
		
		try {
			
		} catch (Exception e) {
			
		}finally {
		while(true) {
		if(select==1||select==2||select==3) {
			System.out.println(dtoArr[select-1].name+" 나왔습니다");
			money=(money-dtoArr[select-1].price);
			System.out.println("잔돈:"+money);
			break;
		}else {
			System.out.println("1,2,3 중에 골라주세요");
			select = Integer.parseInt(sc.nextLine());
		}
		}
		}
	}
}
