package pack03.inter;

public class AndroidActivity {
	// Activity는 화면이 동작하게 하는 클래스
	public static void main(String[] args) {
		
		//익명의 메소드
		AndroidOnclick ao = new AndroidOnclick() {
			@Override
			public void onClick() {
				System.out.println("구현함");
			}
		};
		ao.onClick();
	}
	
	void test(AndroidOnclick ao) {
		ao.onClick();
	}
	
	
}
