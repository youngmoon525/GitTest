package japangi;

import java.util.Scanner;

public class JapangiDAO {
	void display(JapangiDTO dto) {
		Scanner sc = new Scanner(System.in);
//관리자 기능
		System.out.println("1.관리자 2.사용자");

		for(;;) {
		int admin = Integer.parseInt(sc.nextLine());
		if (admin == 1) {
			System.out.println("로그인이 필요합니다. id를 입력하세요.");
			String id = (sc.nextLine());
			if (id.equals("master")) {
				System.out.println("패스워드를 입력하세요.");
				String pw = (sc.nextLine());
				if (pw.equals("admin")) {
					System.out.println("현재 음료: "+dto.bev[0]+"/"+dto.bev[1]+"/"+dto.bev[2]);
					System.out.println("1.음료추가 2.음료수정 3.음료삭제");
					int add = Integer.parseInt(sc.nextLine());
					if(add==1) {
						System.out.println("[음료추가]");
						System.out.println("추가할 음료를 입력하세요.");
						String addBev = (sc.nextLine());
						addBev=dto.bev[3];
						System.out.println("음료를 추가하였습니다.");
					}else if(add==2) {
						System.out.println("[음료수정]");
						System.out.println("수정할 음료를 선택하세요.");
						String adtBev = (sc.nextLine());
						if(adtBev.equals(dto.bev[0])|adtBev.equals(dto.bev[1])|adtBev.equals(dto.bev[2])) {
							System.out.println("수정할 수량을 입력하세요.");
							int adt = Integer.parseInt(sc.nextLine());
							System.out.println("수량이 변경되었습니다.");
						}else {System.out.println("잘못된 입력입니다.");}
					}else if(add==3) {
						System.out.println("[음료삭제]");
						System.out.println("삭제할 음료를 선택하세요.");
						String delBev = (sc.nextLine());
						if(delBev.equals(dto.bev[0])|delBev.equals(dto.bev[1])|delBev.equals(dto.bev[2])) {
							System.out.println("음료가 삭제되었습니다.");
						}else {System.out.println("잘못된 입력입니다.");}
					}
					}else{System.out.println("접속불가. 사용자로 전환됩니다.");}
			} else {
				System.out.println("접속불가. 사용자로 전환됩니다.");
			}
			

//사용자 기능			
		} else if(admin == 2) {
			System.out.println("돈을 넣으세요");
		}else {
			System.out.println("잘못된 접근입니다.");
			break;
		}
		
		for (;;) {
			try {
				int coin = Integer.parseInt(sc.nextLine());
				if ((coin % 10 == 0) & (coin < dto.Price[0])) {
					System.out.println("잔액이 부족합니다.");
				} else if (coin % 10 != 0) {
					System.out.println("동전 또는 지폐만 넣어주세요");
				} else {
					System.out.println("음료선택(콜라,사이다,환타)");
					String bev = sc.nextLine();

					if (bev.equals(dto.bev[0]) & coin >= dto.Price[0] & dto.cnt[0] > 0) {
						System.out.println(dto.bev[0] + " 거스름돈 " + (coin - dto.Price[0]) + "원");
						System.out.println("1000원 짜리 "+(coin - dto.Price[0])/1000 + "장");
						System.out.println("100원 짜리 "+((coin - dto.Price[0])%1000)/100 + "개");
						System.out.println("10원 짜리 "+(((coin - dto.Price[0])%1000%100))/10 + "개 반환합니다");
					} else if (bev.equals(dto.bev[1]) & coin >= dto.Price[1] & dto.cnt[1] > 0) {
						System.out.println(dto.bev[1] + " 거스름돈 " + (coin - dto.Price[1]) + "원");
						System.out.println("1000원 짜리 "+(coin - dto.Price[1])/1000 + "장");
						System.out.println("100원 짜리 "+((coin - dto.Price[1])%1000)/100 + "개");
						System.out.println("10원 짜리 "+(((coin - dto.Price[1])%1000%100))/10 + "개 반환합니다");
					} else if (bev.equals(dto.bev[2]) & coin >= dto.Price[2] & dto.cnt[2] > 0) {
						System.out.println(dto.bev[2] + " 거스름돈 " + (coin - dto.Price[2]) + "원");
						System.out.println("1000원 짜리 "+(coin - dto.Price[2])/1000 + "장");
						System.out.println("100원 짜리 "+((coin - dto.Price[2])%1000)/100 + "개");
						System.out.println("10원 짜리 "+(((coin - dto.Price[2])%1000%100))/10 + "개 반환합니다");
					} else {
						System.out.println("잔액 또는 재고가 부족합니다.");
					}
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("돈만 넣으세요");
			}
		}
	}
	}
}