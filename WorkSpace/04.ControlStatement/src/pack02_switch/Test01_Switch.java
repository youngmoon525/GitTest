package pack02_switch;

public class Test01_Switch {
	public static void main(String[] args) {
		int score = 90;
		// switch문을 이용해서 다중 if문으로 해결했던 문제를 해결해보기.
		// 100 ~109: A ?
		// 90~99 : / 10 : => 9
		// 80~89 : / 10 : => 8
		// 70~79 : C ? case ? : C
		// 60~69 : C ? case ? : D
		// 그외에 ( 60미만 : E )
		//
		switch (score / 10 ) {
		case 10:
			System.out.println("A학점");
			break;
			
		case 9:
			System.out.println("A학점");
			break;
			
		case 8:
			System.out.println("B학점");
			break;
			
		case 7:
			System.out.println("C학점");
			break;
			
		case 6:
			System.out.println("D학점");
			break;
			
		default:
			System.out.println("E학점");
			break;
		}
		
		
		
	}
}
