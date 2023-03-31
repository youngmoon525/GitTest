package pack08_casting;

public class Ex01_Casting {
	public static void main(String[] args) {
		int iNum = 10 ; //정수형 변수 a를 초기화 하고 10을 담아둠
		double dNum = iNum;//더 큰타입에 작은 타입을 담으면 자동
						   //변환이 일어남 ( 자동 형변환 )
		System.out.println(iNum);
		System.out.println(dNum);
		//자동형변환이 발생함 작은 타입(int) => 큰 타입 (double)
		//묵시적 형변환 , Upcasting
		double dNum2 = 30.5;
		//int iNum2 = dNum2; 큰 타입 => 작은 데이터 타입
		//명시적 형변환 , DownCasting ==> Casting의 일반적인 의미
		int iNum2 = (int) dNum2;
		System.out.println(dNum2);
		System.out.println(iNum2);
		//DownCasting은 문제가 발생함. 표현할수없는 데이터를 버려버림.
		//데이터의 신뢰성 , 정합성이 떨어질 가능성이 크기때문에 주의
		
		// long => int , int => float 
		// 같은 숫자를 표현하는 데이터 타입끼리는 가능함.
		// byte < int
		// int 변수를 초기화해서 하나 만들고(변수명 자유) 값 담기.(자유)
		// byte형 변수에 담아보기 
		// 1. DownCasting일까?
		// 2. 실제 코드 작성
		int iNumA = 50; 
		byte bNum = (byte) iNumA; // DownCasting
		
	}
}
