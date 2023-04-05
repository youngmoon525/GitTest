package pack02_switch;

public class Ex01_Switch {
	public static void main(String[] args) {
		// 제어문 : 선택문(조건문 종류 , 값 ) switch 문 : 다중 if문을 간략하게 표현한 것
		// 기준값 , 비교값을 두고 해당하는 값과 일치할때 실행할 case라는 블럭(지역)을 만들고 사용.
		// switch( 기준값 ex)score ){
				//case 값 90 (ex)score == 90 ):
				// 실행
		 		// break; <= ※제어문을 종료하고 제어문의 블럭킹 지역을 빠져나감.※
		//}
		int num = 2; // 비교에 사용 될 기준값이 되는 변수
		switch ( num-1 ) {// 2 - 1 = 1
			case 1: // if ( num == 1 )
				System.out.println("숫자 1 ");
				break;//※
			case 2:// else if ( num == 2 )
				System.out.println("숫자 2");
				break;
			default:
				System.out.println("1과2가 아님 else와 같음");
				break;
		}
		
		
	}
}
