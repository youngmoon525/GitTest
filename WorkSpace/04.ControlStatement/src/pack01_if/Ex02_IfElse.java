package pack01_if;

public class Ex02_IfElse {
	public static void main(String[] args) {
		// if문 : 단순 if (조건식을 주고 해당하는 조건식이 TRUE인경우의 블럭킹(지역{})을 만들어서 코드실행)
		
		// if-else문: 단순 if문은 조건식이 TRUE일때만 실행이되는 번거러움이 있음.
		// if의 조건식이 TRUE가 아닌 FALSE라면 else라는 키워드를 if문 뒤에 붙여서 FALSE실행부를 만드는것.
		int score = 85 ;
		
		if(score %2  == 0) {
			//TRUE
			System.out.println("짝수");
		}else { // 문법 자체가 if문이 true가 안나왔을때 사용하기때문에 if문이 반드시 있을때만 사용가능
			//FALSE
			System.out.println("홀수");
		}
		int num1 = 30 , num2 = 20;
		if(num1 < num2) {
			System.out.println("num2 큼");
		}else {
			System.out.println("num1 큼");
		}
		// 1.int형 변수 num1과 num2를 나열을 통해서 초기화 하기 값은 자유롭게 할당.
		// 2.if-else문을 통해서 두 수를 비교하고 어떤 수가 큰지 콘솔창에 출력하게 코딩해보기.
		
		
		
//		if(score %2 == 1) {
//			System.out.println("홀수");
//		}
		
	}//main
}//class
