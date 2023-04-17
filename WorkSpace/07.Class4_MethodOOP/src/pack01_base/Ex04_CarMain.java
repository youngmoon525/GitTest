package pack01_base;

import java.util.Random;
import java.util.Scanner;

public class Ex04_CarMain {
	public static void main(String[] args) {
		Random rd = new Random();
		rd.nextInt(10);
		
		Scanner sc = new Scanner(System.in);
		String inputData = sc.nextLine();
		
		
		Ex04_Car ec = new Ex04_Car(10);//<= 오답 ( gas라는 것 입력 안했는데 생성이 됨.)
		System.out.println(ec.isLeftGas());
		
		if(ec.isLeftGas()) {
			while(ec.isLeftGas()) {
				System.out.println("자동차 달립니다 . 가스 잔량 : " + ec.gas + "L");
				ec.gas--;
			}
		}else {
			
		}
		
	}
}
