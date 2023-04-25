package pack02.extend;

public class SubClass extends SuperClass{
	// 두수의 곱하기 return , 나누기 return , 나누고 나머지 return 하는 메소드 3개를 구현해보기.
	public int mul(int num1 , int num2) {
		return num1 * num2 ;
	}
	public int div(int num1 , int num2) {
		return num1 / num2 ;
	}
	public int dir_re(int num1 , int num2) {
		return num1 % num2 ;
	}
	
}
