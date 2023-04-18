package pack02_static;

public class Ex02_Calculator {
	// Ex02_CalculatorMain을 만들고 Ex02_Calculator에 있는 메소드를 전부 호출하는것
	// Main클래스에서는 인스턴스화 과정이 없습니다.
	
	//메소드(기능)은 다음과 같습니다.
	// plus <- 두수를 입력받아 합을 return하는 static메소드
	// minus(차)을 return하는 static메소드
	// mul (곱)을 return하는 static메소드
	// div(나)을 return하는 static메소드
	
	static int plus(int x , int y) {
		return  x + y ;
	}
	static int minus(int x , int y) {
		return  x - y ;
	}
	static int mul(int x , int y) {
		return  x * y ;
	}
	static int div(int x , int y) {
		return  x / y ;
	}
	
}
