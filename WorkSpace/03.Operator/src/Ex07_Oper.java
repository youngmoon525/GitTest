
public class Ex07_Oper {
	public static void main(String[] args) {
		// = ( 대입 , 값 할당)
		// 비교 연산자 ( == , < , > , <= , >= )
		// 초과 , 미만 : 0 < 4 : <<== 해당 식을 이용해서 0이상의 숫자만 쓰면 몇부터 몇일까?
		// 조건식에 포함된숫자를 뺀다.==> 1~3
		// 이상 , 이하 : 0 <=4 : <<= 해당 식을 이용해서 0이상의 숫자만 쓰면 몇부터 몇일까?
		// 조건식에 포함된숫자를 포함.==> 1~4
		// 숫자가 10이면 1을 그리고 아니라면 2를 담는 이항연산자 써보기.		
		int num = 9;
		String result = num == 10 ? "맞다" : "틀리다" ;
		int resultInt = num == 10 ? 1 : 2; 
		System.out.println(result + resultInt);
		
		boolean resultB =  num <= 9 ? true : false ;  
		System.out.println(!resultB); // <= true가 결과로 나오는데 false로 출력을 하고싶다. 어떻게해야할까?
		// Not ture == false , Not false == true
		// num에 있는 수가 9이하라면 true 그외에는 false를 담을수있는 식을 완성해보기
		
		if ( num <= 9) {
			
		}else {
			
		}
		
		
	}
}
