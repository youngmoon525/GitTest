package pack03_array2;

import java.util.Scanner;

public class Ex04_Mbti {
	public static void main(String[] args) {
		String[][] mbti = {{"I","E"},{"N","S"},{"F","T"},{"P","J"}};

		String a1;

		String a2;

		String a3;

		String a4;

		System.out.println("내성적이다 1.o 2.x");

		Scanner sc=new Scanner(System.in);

		int select1=Integer.parseInt(sc.nextLine());

		if(select1==1) {

			System.out.println(mbti[0][0]);

			a1=mbti[0][0];

		}

		else {

			System.out.println(mbti[0][1]);

			a1=mbti[0][1];

		}

		System.out.println("생각이 많다 1.o 2.x");

		int select2=Integer.parseInt(sc.nextLine());

		if(select2==1) {

			System.out.println(mbti[1][0]);

			a2=mbti[1][0];

		}

		else {

			System.out.println(mbti[1][1]);

			a2=mbti[1][1];

		}

		System.out.println("감성적이다 1.o 2.x");

		int select3=Integer.parseInt(sc.nextLine());

		if(select3==1) {

			System.out.println(mbti[2][0]);

			a3=mbti[2][0];

		}

		else {

			System.out.println(mbti[2][1]);

			a3=mbti[2][1];

		}

		

		System.out.println("계획이 없다 1.o 2.x");

		int select4=Integer.parseInt(sc.nextLine());

		if(select4==1) {

			System.out.println(mbti[3][0]);

			a4=mbti[3][0];

		}

		else {

			System.out.println(mbti[3][1]);

			a4=mbti[3][1];

		}

		System.out.println("너는 "+a1+a2+a3+a4);
	
	}
}
