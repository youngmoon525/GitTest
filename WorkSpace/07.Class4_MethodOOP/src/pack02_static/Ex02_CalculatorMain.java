package pack02_static;

public class Ex02_CalculatorMain {
	public static void main(String[] args) {
		// 인스턴스 멤버 : 인스턴스화 한 객체에 .찍으면 나옴
		// 스태틱 멤버 : 클래스에 . 찍으면 나옴
		System.out.println(Ex02_Calculator.div(10, 20));
		System.out.println(Ex02_Calculator.plus(10, 20));
		System.out.println(Ex02_Calculator.minus(10, 20));
		System.out.println(Ex02_Calculator.mul(10, 20));
		System.out.println(Ex02_CalculatorMain.div(10, 20));
		
		String str = new String("a");
	}
	static int div(int x , int y) {
		return x / y ;
	}
	
}
