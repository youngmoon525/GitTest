package pack06_game;

import java.util.Scanner;

public class Test02_ScorePg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int kor = -1 , eng = -1 , mat = -1;//-1이면 입력x 상태
		System.out.println("국어 점수를 입력해주세요.");
		while ( kor == -1) {// 초기에 -1로 값을 초기화 해놨기때문에 초기화만 된상태에서는 계속해서 반복
			kor = Integer.parseInt(sc.nextLine());//0~100까지만 입력이 가능하게 해야함
			if(kor > 0 && kor <= 100) {
				System.out.println("국어 성적입력완료");
			}else {
				System.out.println("잘못입력 1~100까지만 가능!!!");
				kor = -1;
			}
		}//while Kor
		
		System.out.println("영어 성적 입력해주세요.");
		while ( eng == -1) {// 초기에 -1로 값을 초기화 해놨기때문에 초기화만 된상태에서는 계속해서 반복
			eng = Integer.parseInt(sc.nextLine());//0~100까지만 입력이 가능하게 해야함
			if(eng > 0 && eng <= 100) {
				System.out.println("영어 성적입력완료");
			}else {
				System.out.println("잘못입력 1~100까지만 가능!!!");
				eng = -1;
			}
		}//while eng
		
		System.out.println("수학 성적 입력해주세요.");
		while ( mat == -1) {// 초기에 -1로 값을 초기화 해놨기때문에 초기화만 된상태에서는 계속해서 반복
			mat = Integer.parseInt(sc.nextLine());//0~100까지만 입력이 가능하게 해야함
			if(mat > 0 && mat <= 100) {
				System.out.println("수학 성적입력완료");
			}else {
				System.out.println("잘못입력 1~100까지만 가능!!!");
				mat = -1;
			}
		}//while eng
		
		System.out.println("국어 점수 : " + kor );
		System.out.println("영어 점수 : " + eng );
		System.out.println("수학 점수 : " + mat );
	}
}
