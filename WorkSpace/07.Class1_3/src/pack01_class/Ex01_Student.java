package pack01_class;

// 학생(물리적,추상적)을 자바코드로 표현한것.
// 기능 x
// 속성 x
public class Ex01_Student {
	//멤버 영역 ( 필드 ) : 변수를 만들면 해당하는 객체의 속성으로 사용이 가능하다.
	//속성(변수) : 이름, 성별 , 나이 등으로 값을 가지고 한번 할당되고 안바뀌는것 또는 바꿔서 사용하는것
	//기능(메소드) : 속성을 가지고 , 속성과 별개로 어떤 동작을 하는것
	String 이름  , 성별 , 나이;
	public static void main(String[] args) {
		//System.out.println(이름); static?
		String str = "";
	}
	public void study() {
		
		System.out.println(이름 + " 공부를 합니다.");
	}

}
