package pack03_array2;

import java.util.Random;

public class Ex02_Array {
	public static void main(String[] args) {
		//Test01_Game이라는 클래스를 만듬.
		// Scanner를 이용하여 숫자를 입력받는다.
		//숫자는 게임의 난이도가 된다.
		//ex)10입력 => 난이도10임.
		//난이도의 크기를 가진 배열을 만들고 배열의 랜덤한 인덱스에 특정한 다른 값을 숨김.
		//사용자는 어느칸에 특정한 값이 숨어있는지 맞추는 게임
		//new Random().nextInt(바운더리);//0~바운더리 내에서 랜덤한수생성
		
		//예시 ) 사용자가 10입력
		// 난이도는 10임.
		// 배열을 만듬 [] [] [] [] [] [] [] [] [] []
		// 배열의 특정한 인덱스에 랜덤하게 다른값을 숨김 [] [] [] [x ][ ][ ][ ][ ][ ] []
		//사용자가 답을 입력함 . 3=> 오답
		// 사용자가 답을 입력함 . 4=> 정답                                    ↑
		
		
		int[] array1 = { 1 , 2 , 3 } ;
		int[] array2 = { 4 , 5  } ;
		int[][] arrayA2 = {
			array1 ,
			array2 , 
			{ 6 , 7 , 8},
			{ 9 , 10 , 11 , 12 }
		};
		// 구조 설명을 코드리뷰해보기.
		for(int i = 0 ; i < arrayA2.length ; i  ++ ) {
			for(int j= 0; j < arrayA2[i].length ; j ++ ) {
				System.out.println(arrayA2[i][j]);
			}
		}
		
		
	}
}
