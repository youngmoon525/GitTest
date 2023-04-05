package pack01_if;

public class Ex01_If {
	public static void main(String[] args) {// { <= 프로그램의 시작점
		//if문 : 제어문 중에 조건문이다. 
		//어떤 조건을 주고 해당 조건이 TRUE일때의 지역(블럭킹{})을 만들고 그 지역의 코드를 실행한다.
		//이항연산자부분은 값만 결과로 사용가능.=>if문은 별도의 코딩을 결과로써 사용이가능하다.
		// if (  조건식※TRUE와FALSE의 결과를 얻을수있는것※  ) {
			   //조건식이 TRUE일때 실행하는 부분.
		// }
		int score = 80 ;// 웹에서 입력받아온 ID와 PW를 비교할때 사용함.
		if( score >= 90 ) {
			//조건식이 TRUE일때만 실행이 가능하다.
			System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A등급 입니다.");
		}
		System.out.println("여기까지 왔을까요?");
		// score % 2 <== 어떤수를 나누고나서 나머지가나옴. 숫자값 != boolean
		// score라는 변수에 있는 값을 2로 나누고 나서 나머지가 1과 같습니까? TRUE / FALSE
		if(score % 2 == 0) {
			System.out.println("score는 짝수");
		}
		if(score % 2 == 1) {
			System.out.println("score는 홀수");
		}
		//score의 숫자가 홀수인지 짝수인지를 판단해서 ( if문) 결과를 출력하게 코딩해보기.
		
	}// 프로그램의 끝점
}
