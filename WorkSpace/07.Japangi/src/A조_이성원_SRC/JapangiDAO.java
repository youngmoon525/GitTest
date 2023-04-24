package japangi;

import java.util.Scanner;

public class JapangiDAO {
	public void display(JapangiDTO dto) {
		System.out.print(dto.getNum()+".");
		System.out.print(dto.getName());
		System.out.print(" 금액: " +dto.getPrice());
		System.out.println(" 수량: " +dto.getCnt());
	}
	
public int inputCoin() {int coin;	
		while(true) {
			try {
		System.out.println("돈을 넣어 주세요.");
		Scanner sc = new Scanner(System.in);
		
		String user = sc.nextLine();
		coin = Integer.parseInt(user);
		
		if (coin < 0 || coin%10!=0) {
			System.out.println("돈을 다시 넣어 주세요.");
		} else {
			System.out.println(coin+"원을 넣었습니다.");
			break; }
			} catch (Exception e) {
				System.out.println("입력 오류");
			
			}
			
		}
		return coin;
	}
	public void buydrink () {
		while(true) {
			System.out.println("음료를 골라 주세요.");
			
			Scanner sc = new Scanner(System.in);
			String choose = sc.nextLine();
			
			
		}
	}
	















}
