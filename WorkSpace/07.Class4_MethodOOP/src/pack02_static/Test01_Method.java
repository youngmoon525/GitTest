package pack02_static;

public class Test01_Method {
	// 리턴타입이 잘 구분이 안될때. void(반환없음)
	boolean login(String id , String pw) {
		//Test01_MethodMain이라는 외부 클래스에서 입력받은 id와 pw가 내가 원하는 값과 일치하는지 여부를
		//판단
		if(id.equals("master") && pw.equals("master1234")) {
			System.out.println(" 정보 일치");
			return true;
		}else {
			System.out.println(" 정보 불일치");
			return false;
		}
	}
	
	
	
	
	
}
