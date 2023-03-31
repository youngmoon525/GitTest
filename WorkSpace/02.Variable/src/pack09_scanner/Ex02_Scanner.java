package pack09_scanner;

import java.util.Scanner;

public class Ex02_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//기억이 안나면 복붙
		String data1 = sc.nextLine();//내가 엔터키 치기전까지의 문자열을 가져옴
		String data2 =sc.nextLine();//내가 엔터키 치기전까지의 문자열을 가져옴
		// 숫자를 두개 받아와서 두 수의 합을 구하기. 난이도 上
		System.out.println(data1);
		System.out.println(data2);
		int num1 = Integer.parseInt(data1); // String을 하나씩 숫자로 바꾸는 처리
		int num2 = Integer.parseInt(data2);
		//1.int sum = Integer.parseInt(data1) + Integer.parseInt(data2);//String을 한번에 바꾸는방식
		System.out.println(Integer.parseInt(data1) + Integer.parseInt(data2));
		//저장을 안하고 바로 합을 구하는 방식
	
	}
}
