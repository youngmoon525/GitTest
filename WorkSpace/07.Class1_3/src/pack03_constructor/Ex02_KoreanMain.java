package pack03_constructor;

public class Ex02_KoreanMain {
	public static void main(String[] args) {
		Ex02_Korean ek = new Ex02_Korean("김한국","123456-123456");
		//강제로 데이터의 정합성 : 이름과 주민등록번호가 없는 데이터(객체)하나는 실제 하면 안됨.
		System.out.println(ek.nation);
		System.out.println(ek.name);
		System.out.println(ek.ssn);
	}
}
