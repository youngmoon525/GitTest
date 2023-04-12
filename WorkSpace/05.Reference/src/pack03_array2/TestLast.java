package pack03_array2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class TestLast {
	public static void main(String[] args) {
		//2차원 배열을 만듬.
		//2차원 배열의 크기와 타입은 자유롭게 하면됨.
		//2차원 배열에 구구단2~9단의 답을 저장하고 2차원배열을 통해 출력까지 해보기.
		// { { 2 , 4 , 6 , 8 ....18 } , { 9 , 18 ....81 } }
		//※for문을 이용해서 풀것※
		int[][] gugudan =  new int[8][9];
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				// 한줄 어떤 코드가 들어가면 끝
				gugudan[i-2][j-1] =   ( i * j ) ;
				System.out.print( i  +  " * " + j + " = "  +  gugudan[i-2][j-1]  + "   ");
			}
			System.out.println();
		}
		
		int [] arr= new int[3];
		System.out.println(Arrays.toString(arr));
		//1차원 배열이 2개가 있음. ( Arrays.toString( 1차원배열 ) );
		// arrA = { 1 , 2 , 3 , 4 } 
		// arrB = { 4 , 5 , 6 , 8 } 
		// arrA에 들어있는 내용과 arrB에 들어있는 내용을 바꾸세요.
		// 변경 후 ↓
		// arrB = { 1 , 2 , 3 , 4 } 
		// arrA = { 4 , 5 , 6 , 8 } 
		int[] arrA = { 1 , 2 , 3 , 4 };
		int[] arrB = { 4 , 5 , 6 , 8 };
		int[] tempArr = arrA;
		arrA = arrB;
		arrB = tempArr;
		System.out.println(Arrays.toString(arrA));
		System.out.println(Arrays.toString(arrB));
		
		//심화 ) int[] arr = { 3 , 4 , 6 , 7 , 8 , 9 , 1 , 2 , 5 }
		//해당 내용을 오름차순 또는 내림차순으로 정렬해서 보여주기.
		//작업후 => arr => { 1 ,~~~9 } { 9~~1 }
		//선택 정렬 
		int[] arrSort = { 1 , 2 , 6 , 7 , 8 , 9 , 4 , 3 , 5 };
		Arrays.sort(arrSort);
		System.out.println(Arrays.toString(arrSort));
		
//		for(int i = 0 ; i < arrSort.length; i ++) {
//			for(int j = i+1; j < arrSort.length; j++) {
//				if(arrSort[i] < arrSort[j]) {//arrSort[i]3 > arrSort[j]1
//					int temp = arrSort[i];//3
//					arrSort[i] = arrSort[j];
//					arrSort[j] = temp;
//				}
//			}
//			System.out.println(Arrays.toString(arrSort));
//		}
	
		
	}
}
