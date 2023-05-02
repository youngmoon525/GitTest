package pack01.thread;

public class Ex06_ThreadTest {
	//Ex06_YoutubeThread라는 작업을 하나 별도로 만듬. => 1초에 한번씩 동영상을 재생중입니다.(콘솔)
	//	- Runnable을 상속받아 run메소드를 구현하고 Thread에 넣어서 생성해서 사용하는방법
	// - Thread를 상속받아 run메소드를 구현하고 생성하여 사용하는방법
	// - Inner Class로 구현하는 방법
	// - Thread를 new로 생성할때 Runnable(Interface)를 파라메터로 넘겨서하는방법.
	// ..
	
	//Ex06_MelonThread라는 작업을 하나 별도로 만듬. => 3초에 한번씩 음악을 재생중입니다. (콘솔)
	
	
	//ThreadTest에서는 YoutubeThred와 , MelonThred를 각각 실행함.
	
	//두개의 기능이 각각 실행되게 처리.
	public static void main(String[] args) {
		Ex06_YoutubeThread yt = new Ex06_YoutubeThread();
		Ex06_MeloneThread mt = new Ex06_MeloneThread();
		yt.start();
		mt.start();
	}
}
