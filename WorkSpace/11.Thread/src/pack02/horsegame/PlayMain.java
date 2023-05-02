package pack02.horsegame;

import java.util.Random;
import java.util.Scanner;

public class PlayMain {
	public static int rank = 0;
	public static int user_input = 0;
	public static void main(String[] args) {
		System.out.println("잠시후 경기가 시작됩니다.");
		// 5개의 말이 있음.
		// 사용자로 부터 몇번말이 1등을 할건지를 입력하게 만들고, 
		// 맞는지 틀린지를 출력하는 로직을 넣어보기.
		Scanner sc = new Scanner(System.in);
		user_input = Integer.parseInt(sc.nextLine());//테스트할때 1부터 ~5까지 입력을하기.
		
		Player p1 = new Player(1, new Random().nextInt(10)+1);
		Player p2 = new Player(2, new Random().nextInt(10)+1);
		Player p3 = new Player(3, new Random().nextInt(10)+1);
		Player p4 = new Player(4, new Random().nextInt(10)+1);
		Player p5 = new Player(5, new Random().nextInt(10)+1);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		System.out.println("아직 등수안나옴");
		
	}
}
