package pack01_base;

public class Ex07_OverLoading {
	// 메소드 오버로딩 : 메소드의 '이름이 같고 파라메터 타입과개수'를 다르게 해서 선택해서 사용할수있게한것
	void method() {
		
	}
	void method(int param1) {
		
	}
	void method(int param1 , int param2) {
		
	}
	void method(String param1) {
		
	}
	
	public static void main(String[] args) {
		Ex07_OverLoading eo = new Ex07_OverLoading();
		// 대표적으로 메소드 오버로딩이 되어있는것은 println임.
		//어떤 타입을 넣어도 일단 출력이 되게끔 만들어뒀음.
		System.out.println("");
		eo.method(0, 0);
	}
}
