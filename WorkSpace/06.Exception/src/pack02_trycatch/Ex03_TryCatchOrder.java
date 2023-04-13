package pack02_trycatch;

import java.util.Scanner;

public class Ex03_TryCatchOrder {
	public static void main(String[] args) {
		int data2 = 1;
		try {
			int data1 = 10;
			int result = data1 / data2 ;//ArithmeticException
			Scanner sc = new Scanner(System.in); // 스캐너<= 오류 안나게 바꾸는 작업을하기.
			sc.nextLine();
			// catch블럭을 내가 알고있는 예외종류로 하나더 연결하고 catch블럭이 실행되게 해보기.
			args[10] = "1";
		} catch (ArithmeticException e) { // 연산오류 0으로 어떤수나누기하면발생
			int data3 = 100;
			System.out.println("data2의 변수 ( 값 : " + data2 + ") 때문에 오류" + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException" + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 오류 !!" + e.getMessage());
		}
	}//main Data2!
}
