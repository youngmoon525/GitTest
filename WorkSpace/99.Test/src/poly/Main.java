package poly;

public class Main {
	public static void main(String[] args) {
		//김영문 kym = new 김영문();
		//전지현 jjh = new 전지현();
		
		// 모든 사람들이 일괄적으로 호흡하게 만들고싶음. <= 모든 사람 인터페이스를 상속받은 객체들은 반드시
		// 호흡과 생사여부라는 메소드가 구현되어있음 (abstract) 
		// 따라서 사람을 상속받은 모든 객체는 == 사람과 같다.
		사람[] 사람들 = new 사람[2];
		사람들[0] = new 김영문();
		사람들[1] = new 전지현();
		for (int i = 0; i < 사람들.length; i++) {
			사람들[i].호흡();
			사람들[i].생사여부();
		}
	}
}
