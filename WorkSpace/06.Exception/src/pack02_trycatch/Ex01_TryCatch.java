package pack02_trycatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex01_TryCatch {
	public static void main(String[] args) {
		// try{
			//예외(오류)가 발생할 가능성이 있는 코드(코드 자체는 정상);
		    //a <= x(코드가 비정상)
		    //Integer.parseInt( sc.nextLIne() ) ;  <= 사용자의 입력을 숫자로 바꾸는 기능.
		//}catch(Exception e) {
			//예외가 발생할 시 처리할 코드(대안코드)
		//}선택 finally{
			//무조건 한번 실행되어야 하는 코드가 있다면 넣어줌.
		   //데이터베이스의 연결을 해제하거나 , 세션을 끊는다.(큐넷)
		//}
		
		// 정상코드이지만 실행했을때 오류가 발생하게 코딩해보기.
		try {
			System.out.println(10/0);
		}catch (Exception e) {
			System.out.println("오류가 발생함");
		}
		System.out.println("여기까지 실행이되나요??");
		
		//[에러의 종류]
		//①하드웨어적인 에러 : 치명적인 에러 ▶ 프로그램이 실행이 안됨(그래픽카드,메모리등등의 물리적)
		//②소프트웨어적인 에러 : 가벼운 에러 ▶ 예외 (Exception)
		//			- Oracle회사에서는 모든 예외들을 클래스로 만들어서 제공을 한다.
		//			- 예) NullPointerException : null인 상태에서 기능 사용(참조x)
		
		//[예외의 종류]
		// ①미확인 예외(실행 예외)
		//		- 프로그램을 실행 해봐야만 예외가 발생하는지 알 수 있다.
		//		- 프로그래머의 실수,경험에 의해서 발생 : 디버깅(오류 수정) 작업이 쉽다.(현실 쉽지않음)
		
		//②확인 예외(일반 예외)<- 추후
		//		- 프로그램 작성중(코딩)에 반드시 예외처리를 해줘야만 사용이 가능한 것들이있음.(파일o)
		//		- try { } catch{}해주면 해결 됨. ↑
		
		
				try {
					FileInputStream fis = new FileInputStream("‪D:\\abc.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		
		
		
		
	}
}
