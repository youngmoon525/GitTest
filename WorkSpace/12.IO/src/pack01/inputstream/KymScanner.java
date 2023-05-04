package pack01.inputstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KymScanner {
	// BufferReader를 사용해서 스캐너와 비슷한구조를 만들어보기.
	// Scanner sc = new Scanner(System.in);
	// private InputStream in ;
	private BufferedReader br;

	public KymScanner(InputStream in) {
		// this.in = in;
		br = new BufferedReader(new InputStreamReader(in));
	}

	public String nextLine() {
		String inputData;
		try {
			inputData = br.readLine();
			return inputData;// 오류없으면 입력된것
		} catch (IOException e) {
			e.printStackTrace();
			return null;// 오류발생시 return
		}
	}
	
	public int nextInt() {
		
		int inputInt = -1 ;
		try {
			inputInt =Integer.parseInt( br.readLine() );
		} catch (Exception e) {
			e.printStackTrace();//오류 출력이 필요할시
		} 
		
		
		return inputInt ;
	}
	
	
	//기존 스캐너 nextInt는 숫자 외에값을 입력하면
	//오류가 발생했음. 우리가 만들 nextInt는
	//숫자 외에값이 입력되면 -1을 return하는 메소드를 만드세요.
	
	
	

}
