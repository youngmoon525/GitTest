package pack05_etc;

import java.util.Scanner;

public class Ex01_Break {
	public static void main(String[] args) {
		// break 문은 제어문을 종료하고 빠져나가는 기능 
		// 무한루프하는 반복문 밑에 코드가 있으면 에러.(영원히 실행x 코드 )
//		while(true) {
//			while(true) {
//				break;	// 하나의 제어문에 해당함.		
//			}
//			break;
//		}
		// 무한루프를 만들고 내가 종료를 원할때만 종료되게 만든다.
		// 스캐너로 -1을 입력하면 무한루프가 종료되게 만들어보기.
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("루프중");
			int userNum = Integer.parseInt(sc.nextLine());
			if(userNum == - 1) {
				System.out.println("종료");
				break;
			}else if(userNum == 1) {
				System.out.println("1번 메뉴에 대한 코딩");
			}else {
				System.out.println(" 잘못된입력");
			}
		}//while
		
		System.out.println("출력");
	}
}
