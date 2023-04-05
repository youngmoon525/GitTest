package pack01_if;

public class Ex05_IfElseIf {
	public static void main(String[] args) {
		// if else 문으로는 어떤 조건을 줄때 true 인지와 false인지 두가지 경우만 만들수가있음.ex)짝수? Y(TRUE) else N(FALSE)
		// if (조건식 A ) {
			// 조건식A가 TRUE일때 실행할 코드를 넣어줌..
		//} else if ( 조건식 B ) { 
		   // 조건식A가 TRUE가 아니고 조건식 B일때 실행할 코드를 넣어줌.
		// }else if ( 조건식 C ) { 
		   // 조건식A와B가 TRUE가 아니고   조건식 C일때 실행할 코드를 넣어줌.
		// }else {
		    //if와 elseif의 모든 조건이 TRUE가 아닐때 실행부. ( 규칙 : if문 블럭킹 끝에 붙여서 사용한다 )
		//}
		int score = 80; // 기존방식으로 score가 90점 이상이면 A , 80점이상이면 B , 70점 이상이면 C 그외에는 D가 나오게처리..
		// if else만 이용해서 ↑ (생각보다 어려움)  A~D가 출력되면 정답 ( hint : && , || )
		// 90~100 : A
		// 80~89 : B
		// 70~79 : C
		// 그외에 ( 70미만 : D )
		if( score >= 90 ) { // 90점 이상이면 ==TRUE
			System.out.println("A");
		}
		if( score >= 80 && score < 90 ) {// 80점 이상이고 90보다 작으면 ==TRUE , &&<=AND(곱) , ||<=OR(합)
			System.out.println("B");
		}
		if( score >= 70 && score < 80 ) {// 80점 이상이고 90보다 작으면 ==TRUE , &&<=AND(곱) , ||<=OR(합)
			System.out.println("C");
		}
		if(  score < 70 ) {// 80점 이상이고 90보다 작으면 ==TRUE , &&<=AND(곱) , ||<=OR(합)
			System.out.println("D");
		}
		
		// 90~100 : A
		// 80~89 : B
		// 70~79 : C
		// 그외에 ( 70미만 : D )
		// if else if문으로 마무리 해보기.
		if ( score >= 90 ) { // 조건식이 TRUE가 나오는 조건식을 실행하는 순간 해당 블럭킹을 실행하고 나머지 else if ,else는 무시함.(skip)
			System.out.println("A");
		}else if ( score >= 80) {
			System.out.println("B");
		}else {
			System.out.println("E");
		}
		
		
		
	}
}
