package pack03_array2;

public class Ex03_Array {
	public static void main(String[] args) {
		// 2차원 배열을 두가지 방법으로 두개 만들어보기.
		//1. 2차원 배열을 초기화할때 행과열의 크기를 주고 만들기.(정방형==모든 1차원배열의 크기가 같음)
		int[][] array1 = new int[2][3];
		
		//2. 2차원 배열을 초기화할때 값이 있는 1차원 배열을 바로 넣고 만들기.(비정방형==1차원배열의 크기 다름)
		int[] arr = new int[3];
		int[][] array2 = {
				arr , { 7 , 8 , 9 } , { 10 } , { 11 , 12 }
		};
		
		//3. 2차원 배열은 1차원 배열을 요소로 가진다.(== 1차원배열을 여러개 그룹화해놓은것) 
		// 1차원배열의 개수만 정확하게 주어졌을때 사용하는 방법.
		int[][] array3 = new int[5][];
		array3[0] = new int[3];// int[] arr = { 1, 2 } ; <=중괄호 초기화식은 최초 한번만 가능함.
		System.out.println(array3[1].length);
		
		
	}
}
