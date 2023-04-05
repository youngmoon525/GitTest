package pack03_for;

public class Ex01_For {
	public static void main(String[] args) {
		// 반복문 : for문 ( loop문 , looping , 순환)
		// 사용 이유 : 기계는 사람보다 반복적인 작업을 잘함.( 정확 , 일정 )
		// for(반복에 사용할변수 초기화; 조건식; 증감식 ){
				// 반복구간 ( 코드 넣으면 됨)
		//}
		//      
		//for(① int i = 0; ②i<10 ; ④i++){
			//③i가 0에서 시작해서 9까지 총 10번 동작하는 반복문
		//
		for( int i = 0 ;  i < 10 ; ) { //무한 루프 : 잘못된 반복문의 예시 
			System.out.println("for문 변수 i의 값 : " +  i );
			break;
		}
		// 0부터 시작해서 9사이의 수중 짝수만 콘솔창에 출력되게 반복문을 변형해보기.(많은 수정이 필요 x)
		// 3줄. 
		// for(){ 0 , 2 , 4 , 6 , 8 
			//출력문
		//}
		
		int result = 0 ;
		for ( int i = 0 ; i < 18951 ; i+=2) {
			//System.out.println("for문 변수 i의 값 : " + i);
			result = i ;
		}
		System.out.println("i의 최종값 : " + result); //?
		// i의 최종값은 8이나옴. for문 외부에서 8의값을 쓰고싶음.
		// 어떻게 해야 할까???
	}
}
