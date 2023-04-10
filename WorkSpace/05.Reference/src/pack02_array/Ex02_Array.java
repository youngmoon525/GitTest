package pack02_array;

public class Ex02_Array {
	public static void main(String[] args) {
		// 1. 10의 크기를 가진 int형 배열을 만들고 값을 10~100까지 할당하고 출력해보기.
		// 출력 결과 : 배열이름[인덱스] : 10 ...100
		int[] array = new int[10];//10의 크기를 가진 int형 배열을 만들고 ( 0 ~ 10-1 )==> ( 0~9 )
//		array[0] = 10;//==10~100까지 할당하고 시작
//		array[1] = 20;
//		array[2] = 30;
//		array[3] = 40;
//		array[4] = 50;
//		array[5] = 60;
//		array[6] = 70;
//		array[7] = 80;
//		array[8] = 90;
//		array[9] = 100;//10~100까지 할당하고 끝==
//		System.out.println(array[0]);
//		System.out.println(array[1]);
//		System.out.println(array[2]);
//		System.out.println(array[3]);
//		System.out.println(array[4]);
//		System.out.println(array[5]);
//		System.out.println(array[6]);
//		System.out.println(array[7]);
//		System.out.println(array[8]);
//		System.out.println(array[9]);
		
		for(int i = 0 ; i<10 ; i++ ) {
			//값 할당도 for문에서 처리해보기.
			array[i] = (i+1)*10;
			System.out.println("array[" +  i  + "] :" + array[i]);
		}
		// 현재 배열에는 10~100까지의 수가 담아져있음.
		// => 배열의 누적합을 구해보기. 10~100까지 더한값 (누적합) 과 평균 
		System.out.println(10+20+30+40+50+60+70+80+90+100);
		System.out.println(array[0] + array[1] + array[2] + array[3] + array[4] + array[5] + array[6]
				+ array[7] + array[8] + array[9] + "<=정답 아님");
		int result = 0 ;
		for(int i = 0 ; i < 10 ;  i ++ ) {
			//result = result + array[0]; x => i //0~09
			result = result + array[i];
			//result += array[i];
		}
		System.out.println("누적합 : " + result);
		
		

	}
}
