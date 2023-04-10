package pack02_array;

import java.util.Scanner;

public class Ex03_Array {
	public static void main(String[] args) { 
		//arguments ( 인수 , 파라미터 ) : main메소드 실행전 필요한것
		// 예 ) 버전 정보
		// args[0]을 출력하면 오류가 발생한다.
		// 0.String배열을 만드는데 String[0]만 사용가능한 배열을 만들어보기.String[1]부터는 사용불가
		
		//String[] sArr = new String[1];
		//System.out.println(sArr[0]);
		//System.out.println(sArr[1]);
		// 1.내가 만든 배열로 똑같은 오류를 만들어보기.ex) 10개짜리 배열을 만듬, 10번인덱스에감.오류
		//String[] sArr = new String[0];
		//System.out.println(sArr[0]);
		//args = new String[1];//코드로 푸는 방법
		System.out.println(args[0]);
		
		
		// 데이터타입[] 배열이름 = new 데이터타입[크기];
		// 내가 알고있는 모든것들 <=
		// String 타입을 가지는 배열 크기는 10으로 만들어보기.
		
		// int[0] 에 무슨값이 초기에 있었는지 ? 초기값 :  0 <- 숫자형태의 변수타입은 전부 0
		// String[0] <= 어떤 값이 들어있을까 ?  null ( 참조형 변수들의 초기값 )
		//String[] animals = new String[3];
		String[] animals = { "강아지" , "고양이" , "비둘기"    } ; 
		// 출력문을 이용해서 배열에 들어있는값을 전부 출력해보기 
		//String dog = "강아지" , cat ="고양이" , bird = "비둘기";
		System.out.println(animals[0] + animals[1] + animals[2]);
		
		int[] intArray = {  0 , 1 , 2 , 3 , 4 , 5 , 6, 7 , 8 , 9} ; 
		// { } <= 배열을 초기화하는 방법중에 값의 갯수에 따라서 배열의 크기를 가변적으로 사용가능한
		//방법이 있다. 이방법은 많이 사용이 안됨. 이유가 뭘
		
		
		
	}
}
