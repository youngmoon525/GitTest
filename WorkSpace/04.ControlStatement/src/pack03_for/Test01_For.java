package pack03_for;

import java.util.Scanner;

public class Test01_For {
	public static void main(String[] args) {
		System.out.println("A");
		System.out.print("B");
		System.out.println("C");
		System.out.println("D");
		// print , println 을 잘 활용해보기.
		// 다중 for문을 이용해서 별찍기
		// for ( int i = 1 ; i<= 5 ; i ++ ) {
		// for ( int j = 1 ; 조건식이 바뀌려면 여기는 바뀌는값 (변수?) ; j ++ )
		// }
		// ★ 1 j<=1
		// ★★ 12 j<=2
		// ★★★ 123 j<=3
		// ★★★★ 1234 j<=4
		// ★★★★★ 12345 j<=5
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) { // 1 <= 5 , 2<= 5 ,....
				System.out.print("★");
			}
			System.out.println();
		}
		// 2~9 반복 <= 사용자가 입력한 횟수
		// 1~9 반복
		// 응용문제 Scanner를 이용해서 숫자를 입력 받는다.
		// 입력 받은 숫자까지의 구구단을 출력하는 for문을 만들어보기
		// 2미만의 숫자를 입력하면 구구단을 출력x => 잘못된숫자 라고 콘솔창에 출력만함.
		// 2이상의 숫자가 입력 되면 해당하는 단까지의 구구단을 출력하기.
		Scanner sc = new Scanner(System.in);
		int userNum = Integer.parseInt(sc.nextLine());// 사용자가 숫자를입력하고 enter
		System.out.println(userNum);

		if (userNum < 2) {
			System.out.println("잘못된숫자");
		} else {
			// 기존 구구단 로직을 그대로 사용
			// 2~9 => 사용자가 입력한 단까지.
			// 초기변수는 2 조건 : 2와같거나 작을동안
			for (int i = 2; i <= userNum; i++) {
				System.out.println("i 값 " + i);
				if (i % 2 == 1) {
					for (int j = 1; j <= 9; j++) {
						System.out.print(i + " * " + j + " = " + (i * j) + " ");
					}
				}
				System.out.println();
			}
		}

	}
}
