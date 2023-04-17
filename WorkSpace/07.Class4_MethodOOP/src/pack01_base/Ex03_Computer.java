package pack01_base;

public class Ex03_Computer {
	// Ex03_Computer에 메소드를 구현해보기.
	// sum1이라는 메소드를 만듬.
	//1.[해당하는 메소드는 숫자형을 묶어놓은 배열을 입력받아 ] <= 파라메터부 배열로 만들어라.
	//2.[배열의 총합을 구하는 메소드이다.]
	//3.[총합을 구하고 나서 결과를 메소드 호출부로 반환(return)하는 기능을 구현해보기.]

	int sum1(int[] arr) {
		int sum = 0 ;
		for (int i = 0; i < arr.length; i++) {// 10 > 10-1 , 9 > 9-1
			sum += arr[i];
		}
		return sum;
	}
	
	//많이 안쓰는 형태의 메소드 파라메터
	int sum2(int ... values) {
		int sum = 0 ;
		for (int i = 0; i < values.length; i++) {
			sum += i ;
		}
		
		return sum;
	}
	
	
	//Ex03_ComputerMain에서 호출해서 사용해보기.◀
}
