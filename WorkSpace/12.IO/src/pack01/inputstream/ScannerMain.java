package pack01.inputstream;

import java.util.Scanner;

public class ScannerMain {
	public static void main(String[] args) {
		//KymScanner를 인스턴스화 하여 문자열을 입력받아 출력해보기.
		KymScanner ks = new KymScanner(System.in);
		
		String inputData = ks.nextLine();
		System.out.println(inputData);
		int inputInt = ks.nextInt();
		System.out.println(inputInt);
	}
}
