package poly;

public class TryCatch {
	public static void main(String[] args) {
		String str = null;
		try {//오류를 직접 처리
			System.out.println(str.length()); 
		} catch (Exception e) {
			// TODO: handle exception
		}
		testMethod();//try{}catch를안해주면 오류발생함
		
		try {
			testMethod();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void testMethod() throws Exception{//오류를 나를 사용하는 장소에서 처리
		String str = null;
		System.out.println(str.length());
	}
	
}
