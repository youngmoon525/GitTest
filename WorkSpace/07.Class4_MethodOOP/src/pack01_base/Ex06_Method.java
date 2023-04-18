package pack01_base;

import java.util.Scanner;

public class Ex06_Method {
	// return 이 없는 메소드 2개 ( 파라메터가 있음 , 없음 )
	
	void method1() {
		System.out.println(" method1 ");
	}
	
	void method2(String data) {
		if(data == null) {
			return;//메소드를 중지시키고 블럭킹 끝으로 이동.
		}
		System.out.println( " method2 " + data);
	}
	
	// return 이 있는 메소드 2개 ( 파라메터가 있음 , 없음 )
	boolean isMethod3() {
		//boolean temp = true;
		System.out.println( " method3 ");
		return true;
	}
	
	boolean isMethod4(int data) {
		if(data % 2 == 1) {
			return true;
		}
		System.out.println( " method4 ");
		return false;
	}
	
	// 이름 타입 형태 전부 자유.
	// 리턴타입 메소드명 ( 파라메터부) {
	
	//}
	
	String sMethod() {
		//String temp = "abc";
		return "abc";
	}
	
	double dMethod() {
		//double temp = 3.14;
		return 3.14;
	}
	
	int[] aMethod() {
		//int[] arr = new int[0];
		return new int[1];
	}
	Scanner scanMethod() {
		//Scanner sc = new Scanner(System.in);
		return  null;//해당 메소드를 이용해서 스캐너 기능 사용시 NullPointerException발생
	}
	
	
}
