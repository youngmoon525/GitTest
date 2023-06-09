package pack02.horsegame;

public class Player extends Thread{
	//쓰레드를 여러개 Player라는 클래스를 이용하여 만들고, 
	//어떤 쓰레드가 먼저 끝나는지에 따라서 등수를 내는 경마게임.
	int num; //선수의 번호,n번 선수
	int speed;//말의 속도 ( Random ) 
	
	public Player(int num, int speed) {
		this.num = num;
		this.speed = speed;
	}
	
	//thread.start(); ↓ 작업은 반드시 run메소드에 구현한다. ( Interface의 경우에도 run) 
	@Override
	public void run() {
		int hereLocation = 0 ; // 0에서부터 출발한다고 변수로만듬.
		while ( hereLocation < 100) {
			hereLocation += speed;//
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//■■■■■■■□□□
		
		PlayMain.rank++;
		if(PlayMain.rank == 1 && PlayMain.user_input == num) {
			System.out.println("정답 입니다.");
		}else if ( PlayMain.rank == 1 && PlayMain.user_input != num) {
			System.out.println("오답");
		}
		System.out.println(PlayMain.rank + " 등. " + num + "번 말 ");
		
	}
	
	
	
	
	
}
