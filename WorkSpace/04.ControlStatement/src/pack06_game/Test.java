package pack06_game;

import java.util.Random;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true){

			System.out.println("국어점수를 입력하세요 : ");

			int i = Integer.parseInt(sc.nextLine());

			if(i<=100) {

				System.out.println("영어점수를 입력하세요 : ");	

				int u = Integer.parseInt(sc.nextLine());

				if(u<=100) {

					System.out.println("수학점수를 입력하세요 : ");

					int m = Integer.parseInt(sc.nextLine());

					if(m<=100) {

						

					}

					int sum = (i+u+m);

					double avg = (double)sum/3;

					System.out.println("총점 :"+ (i+u+m));

					System.out.println("평균 :"+ avg);

				}

				

		}break;

	}

	}
}
