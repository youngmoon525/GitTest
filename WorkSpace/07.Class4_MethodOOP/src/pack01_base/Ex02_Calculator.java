package pack01_base;

import java.util.Scanner;

public class Ex02_Calculator {
	// static 키워드가 있는지 없는지의 판단.( 멤버 구분의 매우 중요함!!)
	// 메소드의 구조.
	// 생성자 메소드 (Constructor) : 객체를 생성할때 필요한 메소드
	
	// 메소드 구조:
	// 리턴타입 메소드이름 ( 파라메터부 ) {
	//		메소드 내용(코드)
	//}
	// 파라메터부 :'어떤것이든' 메소드가 실행 될 때 필요한 (변수,클래스 등) 정보가 있다면 받아오게끔 처리하는 부분
	void powerOn(int power) { // 숫자
		if(power < 1 ) {
			System.out.println("배터리 부족으로 실행불가");
			powerOff();
		}else {
			System.out.println(" 전원을 켭니다. ");			
		}
	}
	//powerOff에서 main에 접근이 되는 이유:?
	//static멤버여서 '메모리'에 먼저 있기 때문.!
	
	//main에서 powerOff에 접근이 안되는 이유:?
	//인스턴스화 과정을 안거치면 메모리에 없음.
	//'메모리'에 없기 때문.
	void powerOff() {
		System.out.println(" 전원을 끕니다. ");
		//main(null);
	}
	
	
	//void인지 void가 아닌지에 따라 리턴타입이 결정된다.
	//내가 알고있는 모든 타입.=> 리턴타입으로 사용이 가능.
	//void<=(공허,비어있는) : 리턴이 없는 ( 작업 후 결과가 필요가 없는 )
	
	//return 타입이 void가 아니게 주어지면 해당하는 타입을 반환하는 return 키워드가 반드시 필요하다.
	int test() {
		return 0;
	}
	
	int plus(int num1 , int num2) { //1. 파라메터부에 숫자를 두개 입력받게 만들기.
														// 2. 입력받은 파라메터 두 숫자의 합을 return하게 코딩해보기.
														// 3. main에서 호출해보기
		//int sum = num1 + num2 ;
		return num1 + num2;
		//System.out.println("aa"); return이 되게 되면 메소드 자체가 메모리에서 사라짐
	}
	
	int plus3 (int num1 , int num2 , int num3) {
		return num1 + num2 + num3 ;//?왜오류?
	}
	
	
	// 숫자 세개를 입력받아서 3개의 합을 구하는 메소드 plus3이라는 것을 만들어보기.
	// 메인 메소드를 가진 Main클래스에서는 plus3메소드를 호출해서 합을 출력하고 , 평균도 출력해보기.
	
	
	
	
	public static void main(String[] args) {
		//powerOff();
	}
	
	
}
