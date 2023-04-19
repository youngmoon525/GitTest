package pack03_constructor;

public class Test01 {
	// 1.이름 , 아이디 , 패스워드 , 나이를 필드로 사용하는 Member 클래스를 생성 후 Member클래스 필드값에
	//값을 할당하고 출력해보기.
	
	// 2.이름 , 아이디 , 패스워드 , 나이를 필드로 사용하는 MemberDTO 클래스를 생성 한다.
	// 필수로 입력이 되어야 할것같은 필드는 생성자를 통해서 입력을 받게 만들고.
	// 해당 내용을 출력한다.
	public static void main(String[] args) {
		Test01_Member member = new Test01_Member();//<=별도로 생성자 메소드 안만들어서 기본으로 생성가능
		member.id = "youngmoon525";
		member.pw = "123";
		member.name = "김영문";
		member.age = 99;
		System.out.println(member.id);
		System.out.println(member.pw);
		System.out.println(member.name);
		System.out.println(member.age);
		
		Test01_MemberDTO dto = new Test01_MemberDTO("youngmoon525", "123", "김영문");
		System.out.println(dto.id);
		System.out.println(dto.pw);
		System.out.println(dto.name);
		
	}
	
	
	
}
