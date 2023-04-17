package pack01_base;

public class Ex02_CalculatorMain {
	public static void main(String[] args) {
		// 멤버 : 클래스를 인스턴스화 하고 .<-찍으면 나오는 모든것들
		Ex02_Calculator ec = new Ex02_Calculator();
		ec.powerOn(0);
		//ec.powerOff();//<=해당 코드가 오류가 없게 실행되게끔 처리해보기.
		int result = ec.test()+10;// int타입을 무조건 return함. ==> int형 변수랑 같이 취급
		System.out.println(result);
		System.out.println(1+ec.test());
		result = ec.plus(5, 10);
		// String inputData = sc.nextLine();//<= nextLine()== String을 return하는 메소드
		System.out.println(ec.plus3(1, 2 , 3));
		System.out.println(ec.plus3(1, 2 , 3 )/3);
	}
}
