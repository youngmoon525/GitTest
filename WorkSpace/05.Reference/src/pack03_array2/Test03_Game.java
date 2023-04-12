package pack03_array2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Test03_Game {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("랜덤한 숫자 맞추기 게임!");
		System.out.println("난이도를 선택해주세요");
		int level = Integer.parseInt(sc.nextLine());// <= 오류가 나는 코드인지 알고있음.(A=>예외)
		int[] gameArray = new int[level];// 3=> [0] [0] [0]
		String[] gameResults = new String[level];// [?] [?] ...[?]
		for (int i = 0; i < gameResults.length; i++) {
			gameResults[i] = "?";
		}
	

		int random = new Random().nextInt(level);// 0~2
		System.out.println(random);

		gameArray[random] = 112312;// 배열의 랜덤한 공간에 0이 아닌 숫자를 넣어서 맞추게 유도
		System.out.println(Arrays.toString(gameArray));
		while (true) {
			System.out.println("1부터 " + gameArray.length + " 까지의 값을 입력 !");

			for (int i = 0; i < gameResults.length; i++) {
				System.out.print(i + 1 + " [" + gameResults[i] + "] , ");
			}
			System.out.println();
			int userNum = Integer.parseInt(sc.nextLine()) - 1;
			if (gameArray[userNum] != 0) {
				System.out.println("정답!!!!");
				break;
			} else {
				gameResults[userNum] = "X";
				System.out.println("땡~");

			}
		}

	}
}
