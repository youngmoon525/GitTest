package pack07_oop3;

import java.util.Scanner;

public class DrinkDAO {
	//반드시 숫자를 입력해야 반복이 종료됨.
	//숫자를 입력받아야하는 경우 사용하면 됨.
	public int rtnInt() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			try {
				return Integer.parseInt(sc.nextLine());
			}catch (Exception e) {
				System.out.println("숫자만 입력해주세요");
			}
		}
	}
}
