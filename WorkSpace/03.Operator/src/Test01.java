
public class Test01 {
	public static void main(String[] args) {
		// int , double , String
		int num ; //선언 ( 어떤 이름을 사용 하겠다고 ..) 후 값을 안넣어주면 사용x
		num = 100; //할당 ( 값을 넣어줌 값==리터럴)
		double dNum1 = 3.14;//초기화 ( 선언과 동시에 할당 )
		double dNum2 , dNum3 ;//..나열 (선언을 여러개를 동시에 함 ,초기화 가능)
		
		String str = "문자열";
		
		//-- 캐스팅 --
		String numStr = "123"; // 123이라는 문자열을 숫자로 바꾸고 +10한 결과를 얻어보기.
		System.out.println(numStr + 10);// 133 x , 12310 == String에 어떤 값을 더하면String임.
		int numInt = Integer.parseInt(numStr);//"123"=>123
		System.out.println( numInt + 10 );
		String numStr2 = ""+ numInt;//133=>"133" ??
		System.out.println(numStr2);
		
	}
}
