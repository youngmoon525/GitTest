package pack04_while;

public class Ex01_While {
	public static void main(String[] args) {
		// for ( ① 반복에 사용 할 변수 초기화 식 (i) ② 조건식(TRUE일때 동작) ④ 증감식){
		// ③ 실제 반복할 코드 ( 구간 )
		// }

		// ① 변수 초기화식
		// while ( ② 조건식 ){
		// 반복하는 구간
		// ③ 증감식 or break를 이용한 반복문 종료
		// }
		int i = 0;
		while (i < 10) {
			System.out.println(i);// i~>
			i++;
		}
		int j = 0;
		// while문을 이용해서 홀수만 출력해보기. <= 1~50까지의 수중
		// for문 : 반복 횟수를 정확하게 알때 수에 의해서 반복시키는 경우
		// while문 : 반복 횟수를 정확하게 모를때 조건에 의해서 반복시키는 경우
		while (j < 50) {
			if (j % 2 == 1) {
				System.out.println(j);// i~>
			}
			j++;
		}

	}
}
