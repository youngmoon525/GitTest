package pack02_static;

public class Ex01_Static {
	// static 의 여부에 따라서 멤버를 구분한다.
	// static 의 여부에 따라서 메모리에 올라가는 순서가 다르다.
	// 멤버 : 클래스의 멤버=> 클래스의 중괄호 사이에 있는 모든것들
	
	static void sMethod() {
		System.out.println(" 스태틱 멤버 입니다.");
		//Ex01_Static es = new Ex01_Static();
		//es.iMethod();//접근 불가
	}
	
	//인스턴스 멤버 (메소드)
	void iMethod2() {
		iMethod();//↓인스턴스 (접근가능)
		sMethod();//스태틱 (접근가능)
	}
	//(instance)인스턴스 멤버
	void iMethod() {
		System.out.println(" 인스턴스 멤버 입니다.");
	}
	//static : 프로그램 시작전에 먼저 메모리에 할당 , 프로그램 종료 시 소멸
	//instance : 인스턴스화 과정 후에 메모리에 할당 , 프로그램 종료 시 소멸
	
	// static 멤버 
	public static void main(String[] args) {
		//메인 메소드에서 iMethod 호출해보기.
		//Ex01_Static es = new Ex01_Static();
		//es.iMethod();
		sMethod();
		if(true) {
			Ex01_Static es = new Ex01_Static();
			es.iMethod();
		}
	}
	
	
}
