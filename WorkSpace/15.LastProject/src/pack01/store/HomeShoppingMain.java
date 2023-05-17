package pack01.store;

import java.util.Scanner;

public class HomeShoppingMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		HomeShoppingDAO dao = new HomeShoppingDAO();
		
		
		while(true) {
			System.out.println("================");
			System.out.println("홈쇼핑에 오신것을\n 환영합니다!!");
			System.out.println("================");
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.아이디찾기");
			System.out.println("4.비밀번호찾기");
			System.out.println("0.종료");
			System.out.println("================");
			
			int selectNum=dao.selectNum();
			
			if(selectNum==1) {
				dao.membership();
			}
			else if(selectNum==2) {
				dao.intoHomeShopping();
			}
			else if(selectNum==3) {
				dao.findID();
			}
			else if(selectNum==4) {
				dao.findPW();
			}
			else if(selectNum==0) {
				System.out.println("종료합니다");
				break;
			}
			else {
				System.out.println("다시 입력해주세요");
			}
		}
		
			
			
			
			
		
	}
	
	
}
