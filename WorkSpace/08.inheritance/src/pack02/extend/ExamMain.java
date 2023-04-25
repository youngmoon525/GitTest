package pack02.extend;

public class ExamMain {
	// 1. 상속 방법 : class 클래스(자식) extends 클래스(부모)
	// 2. 자식 클래스는 부모 클래스로부터 메소드와 필드를 물려받아 사용한다.
	// 3. 부모 클래스는 자식 클래스에서 정의한 메소드나 필드를 사용 하지 못한다.
	// ( 자식 = 자신 + 부모 / 부모 = 자신 )
	// 4. extends로 클래스의 상속은 한가지만가능하다 ( 단일 상속 )
	// 5. 부모 클래스는 여러 자식 클래스가 있을수있다. 
	// 6. 자식 클래스가 당연하게도 더 많은 기능을 가지고 있기 때문에 특별한 경우가 아니면
	//자식클래스를 인스턴스화 하는게 더 효율적이고 생산적이다.
	public static void main(String[] args) {
		// 사칙연산 + 나머지구하기
		//SuperClass sc = new SuperClass();
		//sc.sum(1, 2); 
		//sc.minus(1, 2);
		// Sub클래스에 모든 기능이 있기때문에 각각을 인스턴스화 하는것은 효율적이지 않음.
		SubClass sub = new SubClass();
		sub.sum(1, 2);
		sub.div(1, 2);
	}
}
