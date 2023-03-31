package pack03_Decimal;

public class Ex01_Decimal {
	public static void main(String[] args) {
		int i = 1234567890;
		System.out.println(i);
		//int 이상의 값을 담을 수 있는 정수형 데이터타입이 존재함.
		//long형 l1이라는 변수를 선언하기.
		//long형 l2라는 변수를 초기화 시키기.12345678901
		long l1 ;
		long l2 = 1234567890123456789L;//숫자+long타입이라는 구분자
		System.out.println(l2);
		
		//실수형 데이터 타입 : float , double
		//실수형은 소숫점이 있는것을 표현하기 위해 존재
		//float는 long과 마찬가지로 구분자 F를 붙여줘야만함.
		//문제1)데이터타입 float를 사용하여 변수 선언 , 할당 , 초기화
		//문제2)데이터타입 double을 이용하여 ↑
		//문제를 풀 때 소숫점이 있는 값을 담기(할당)
		float f1 ;
		f1 = 1.1F;
		float f2 = 3.14F;
		double d1 = 1.1;
		double d2 = 3.14;
		// 뒤에 구분자가 붙는 long , float 편하다 ??
		// 대표적 :※ int , doulbe ※
		
	}
}
