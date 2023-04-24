package Test;

import java.util.Scanner;

public class japangiDAO {

	
	public static void display(japangiDTO dto) {
		System.out.print(" 제품번호 : " + dto.getNum());
		System.out.print(" 메뉴 : " + dto.getMenu());
		System.out.print(" 가격 : " + dto.getPrice());
		System.out.println(" 수량 :" + dto.getQuntity());
	}
	
	int coin;
	int num;
	String id;
	String pw;
	int adminNum;

	
	Scanner sc = new Scanner(System.in);
	 void inputCoin(japangiDTO dtoArr) {
		while (true) {
			System.out.println("====금액을 넣어주세요====");
			coin = Integer.parseInt(sc.nextLine());
			try {
				if (coin % 10 == 0) {
					System.out.println(coin + "원을 넣으셨습니다.");
					if(coin < dtoArr.getPrice()) {
						System.out.println("금액이 부족합니다.");
						continue;
					}
					break;
				}
				else{
					System.out.println("동전단위로 넣어주세요");
					continue;
					
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자로 다시 입력해주세요");
			}
		}
	 }
	 void choiceCan(japangiDTO dtoArr ,japangiDTO dtoArr1 , japangiDTO dtoArr2) {
		while(true) {
		 System.out.println("무엇을 선택하시겠습니까?");
		 num = Integer.parseInt(sc.nextLine());
		 if(num == dtoArr.getNum()) {
			 System.out.println("콜라를 선택하셨습니다.");
			 if(dtoArr.getQuntity() == 0) {
				 System.out.println("품절");
				 continue;
			 }
			 break;
		 }else if(num == dtoArr1.getNum()) {
			 System.out.println("사이다를 선택하셨습니다.");
			 if(dtoArr1.getQuntity() == 0) {
				 System.out.println("품절");
				 continue;
			 }
			 break;
		 }else if(num == dtoArr2.getNum()){
			 System.out.println("환타를 선택하셨습니다.");
			 if(dtoArr1.getQuntity() == 0) {
				 System.out.println("품절");
				 continue;
			 }
			 break;
		 }
	 }
	 }
	 void changes(japangiDTO dtoArr ,japangiDTO dtoArr1 , japangiDTO dtoArr2) {
		 int[] coinUnit = { 500, 100, 50, 10 };
		 int changes1 = coin-dtoArr.getPrice();
		 int changes2 = coin-dtoArr1.getPrice();
		 int changes3 = coin-dtoArr2.getPrice();
		 if(num == dtoArr.getNum()) { 
			 System.out.println("잔돈 : " + changes1 + "원");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"원: "+	changes1 / coinUnit[i]);
				 changes1 %= coinUnit[i];
			 }
		 }else if(num == dtoArr1.getNum()) {
			 System.out.println("잔돈 : " + changes2 + "원");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"원: "+	changes2 / coinUnit[i]);
				 changes2 %= coinUnit[i];
				 }
		 }else if(num == dtoArr2.getNum()){
			 System.out.println("잔돈 : " + changes3 + "원");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"원: "+	changes3 / coinUnit[i]);
				 changes3 %= coinUnit[i];
			 }
		 }
	 }
	 
	void admin() {
		while(true){
		System.out.println("아이디를 입력해주세요.");
		id = sc.nextLine();
		System.out.println("패스워드를 입력해주세요.");
		pw = sc.nextLine();
		if(id.equals("master") && pw.equals("admin")) {
			System.out.println("관리자 모드가 실행되었습니다.");
			break;
		}else {
			System.out.println("아이디혹은 비밀번호가 틀렸습니다.");
			continue;
			}
		}
	}
	
	void adminSetting(japangiDTO[] dtoArr, japangiDTO dto , japangiDTO dto1 , japangiDTO dto2, japangiDTO dto3, japangiDTO dto4 ) {
		System.out.println("0. 제품 목록 1. 음료추가 2. 음료 수정 3. 음료 삭제");
		System.out.println("번호를 입력하세요.");
		adminNum = sc.nextInt();
		//제품 목록
		if(adminNum == 0) {
			for(int i = 0; i < dtoArr.length; i++) {			
				japangiDAO.display(dtoArr[i]);				
			}
		}else if(adminNum == 1) { 
			System.out.print("추가하실 메뉴의 번호를 입력하세요 : ");
            int v = sc.nextInt();
            System.out.print("추가하실 메뉴의 이름을 입력하세요 : ");
            String name = sc.next();
			System.out.print("추가하실 메뉴의 가격을 입력하세요 : ");
             int j = sc.nextInt();
             System.out.print(name + "의 재고는 몇 개 입니까? : ");
             int k = sc.nextInt();
             System.out.println("메뉴 추가가 완료되었습니다!");
			}else if(adminNum == 2) {
				System.out.print("수정하실 메뉴의 번호를 입력하세요 : ");
	            int v = sc.nextInt();
	            System.out.print("어떤 이름으로 수정하시겠습니까? : ");
	            String name = sc.next();
				System.out.print("수정하실 메뉴의 가격을 입력하세요 : ");
	             int j = sc.nextInt();
	             System.out.print(name + "의 재고는 몇 개 입니까? : ");
	             int k = sc.nextInt();
	             System.out.println("메뉴 수정이 완료되었습니다!");
			}else if(adminNum == 3) {
				System.out.print("삭제하실 메뉴의 번호를 입력하세요 : ");
	            int v = sc.nextInt();
	            System.out.println(v + "번 삭제가 완료되었습니다.");
			}
		}
	}




	
	

	
	
	 

