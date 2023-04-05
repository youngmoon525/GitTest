package pack03_for;

public class Ex02_For {
	public static void main(String[] args) {
		// 제어문은 무한하게 중첩이 가능하다.
		//1.0~9까지 10번 반복하는 반복문 안보고 만들어보기.
		//2.1부터10까지 반복하는 반복문으로 수정해보기.↑
		
		//1. 1부터 10까지의 누적합을 구하시오.(반복문 이용) 
		// 1 + 2 + 3 + 4 + 5 .... + 10 = ?
		int sum = 0 ;
		for ( int i = 1 ; i <= 10 ; i++) {
			sum += i;
			// 짝수 , 홀수도 "홀수" + 숫자<=출력되게 해보기
//			if(i%2 == 0 ) {
//				System.out.println("짝수" +  i);
//			}else {
//				System.out.println("홀수" +  i);
//			}
		}
		System.out.println(sum);
		
		
		
	}
}
