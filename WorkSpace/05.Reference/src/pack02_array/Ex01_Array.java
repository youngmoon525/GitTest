package pack02_array;

public class Ex01_Array {
	public static void main(String[] args) {
		// 배열이란 ?
		// 자료형 변수를 생성하고 사용할때 주로 쓰임.
		// 규칙 : "동일한" 데이터 타입을 묶어서 사용하게 하며 정해진 수만큼 저장 처리하는
		// "객체"=> 한번 만든 크기는 다시 바꾸는게 불편하다.
		//형태:  dataType[] name = new dataType[size] ;
		//          데이터타입[] 배열이름 = new 데이터타입[크기] ;
		
		//아직 스캐너나 별도의 처리로 점수를 입력하지 않은 변수 5개를 준비만 해둠.
		int score1=0, score2=0, score3=0,score4=0,score5=0;//..100
		// score1~5까지의 합 : score1 + 2 + 3 .. + score5 = 합
		int[] scoreArray = new int[5];// 0[0] 1[0] 2[0] 3[0] 4[0] : 
		// 배열의 인덱스 규칙 : n의 크기가 주어진 배열은 0부터 n-1까지의 주소를 가진다.
		System.out.println("scoreArray[0] 값 : " + scoreArray[0]);
		System.out.println(scoreArray);//[I@515f550a=>힙영역의 주소(메모리) 값 x
		scoreArray[0] = 10;//배열에 데이터 타입이 주어졌으면 해당하는 타입의 변수라고 생각
		System.out.println("scoreArray[0] 값 : " + scoreArray[0]);
		scoreArray[1] = 20;
		scoreArray[2] = 30;
		scoreArray[3] = 40;
		scoreArray[4] = 50;
		System.out.println(scoreArray[0]);
		System.out.println(scoreArray[1]);
		System.out.println(scoreArray[2]);
		System.out.println(scoreArray[3]);
		System.out.println(scoreArray[4]);
		//배열의 모든 인덱스에 10~50까지를 할당하고 출력해보기. [ 10 ] [ 0 ][ 0 ][ 0 ][ 0 ]
		//																						   [ 10 ] [20 ][ 30 ][ 40 ][ 50 ]
		
		//다풀고 생각해보기 : 배열의 크기가 100이였다면?=> 반복문 ( 반복되는일은 컴퓨터가 잘함==>반복)
		//반복문으로 scoreArray에 값을 모두 출력해보기
		for(int i = 0 ; i <= 5-1 ; i++) {
			System.out.println(scoreArray[i]);
		}
		
		// for문으로 1~5까지 출력해보기 <=
		
		
		
		
	}
}
