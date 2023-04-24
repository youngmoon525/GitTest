package japangi;

import java.util.Scanner;

public class japangiMain {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		japangiDTO dto = new japangiDTO();
		
		
		dto.setDri(0, "콜라");
		dto.setDri(1, "사이다");
		dto.setDri(2, "환타");
		dto.setDriCost(0, 800);
		dto.setDriCost(1, 1000);
		dto.setDriCost(2, 900);
		dto.setDriCount(0, 8);
		dto.setDriCount(1, 5);
		dto.setDriCount(2, 1);
		
		japangiDAO dao = new japangiDAO();
		
		int seven = 7;
		String id;
		String pw;
		String inputNum;
		String manNum1;
		String addDri;
		int manSelNum1;
		int manSelNum2;
		int corNum1;
		int manAddNum1;
		int selNum1;
		int inputMoney;
		int totalMoney = 0;
		int chanMoney10, chanMoney50, chanMoney100, chanMoney500, chanMoney1000 = 0;
		int[] changeMoney = new int[5];
		
		while(true) {
			System.out.println("1.관리자기능");
			System.out.println("2.음료 구매");
			System.out.println("3.자판기 종료");
			inputNum=sc.nextLine();
			
			if(inputNum.equals("1")) {
				System.out.println("관리자 가능에 접속했습니다");
				while(true) {
			System.out.println("id를 입력해주세요" + "초기 메뉴로 돌아가시려면 0번을 입력해주세요"); 
			id = sc.nextLine();
			if(inputNum.equals("0")) {
				break;
			}
			
		System.out.println("비밀번호를 입력하세여");
		pw = sc.nextLine();
		if(id.equals("ad")&&pw.equals("adpw")) {
			System.out.println("관리자 기능에 접속하였습니다.");
		dao.display(dto);
			while(true) {
			System.out.println("1. 음료 추가");	
			System.out.println("2. 음료 수정");	
			System.out.println("3. 음료 삭제");	
			System.out.println("0. 초기 화면 설정");	
			
			manNum1 = sc.nextLine();
			if(manNum1.equals("1")) {
				
				
				
				
				}
				
			}
				
				
				
				
			}
			
			
			
			
		}
		
				}
				}
	}
}
