package pack03_for;

public class Ex04_ForFor {
	public static void main(String[] args) {
		// 제어문은 무한하게 중첩이 가능하다. (순서 x )
		// 1~10까지 반복하게 for문 만들어보기.
		for(int i = 1 ;  i <=10 ; i ++) {
			System.out.println("i" +i);
			for(int j = 1 ; j <=10 ; j ++) {
				System.out.println("j" + j);
			}
		}
		
		// 구구단을 출력해보기. print와 println을 적절히 사용하여.
		// 2x1 = 2
		// 2x2 = 4
		// .
		// .
		// 9x9 = 81
		System.out.println("==========================");
		for(int i = 2 ; i <= 9 ; i ++) {
			System.out.println();
			for(int j = 1 ; j <= 9 ; j++ ) {
				System.out.print(  i + " x " + j  + " = " + (i*j) +"  " );
			}
			System.out.println();
		}
		
		
		
		// 출력예시 . 2 x 1 = 2 , 2x 2 = 4 .............
		//                 3 x 1 = 3 , 3x 2 = 6...............
		//
		
		
		
	}
}
