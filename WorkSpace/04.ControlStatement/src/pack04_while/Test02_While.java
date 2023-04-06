package pack04_while;

import java.util.Scanner;

public class Test02_While {
	public static void main(String[] args) {
		// 1. 별찍기 
		// ★              <=1
		// ★★           <=2
		// ★★★         <=3
		// ★★★★
		// ★★★★★ syso x 5
		int i = 1 ;
		while(i<=5) {
			int j = 1;
			while(j<=i) {
				System.out.print("★");
				j++;
			}
			System.out.println();
			i++;
		}
		
		
		
		// 2. 사용자가 입력한 수 만큼의 구구단 출력
		// 2미만의 숫자는 오류 라고 출력 , 그외에는 해당하는 숫자만큼 구구단 출력
		Scanner sc = new Scanner(System.in);
		int userNum = Integer.parseInt(sc.nextLine());
		if(userNum<2) {
			System.out.println("오류");
		}
		
	}
}
