
public class Ex09_Oper {
	public static void main(String[] args) {
		// 변수타입 변수명 = 값 비교식 ? "반환값1" : "반환값2" 
		// int result = num < 10 ? 1  : 식2 ? 식3.... : 모든식이 참이아닐때.
		// score라는 변수가있음. 해당 변수의 값이 90보다 크다면 A등급. 80보다 크다면 B등급..D등급.
		int score = 51;
		// 70보다 크다면 C등급
		// 60보다 크다면 D등급이 나오게 조건을 추가해보기
		// 그외에는 E등급이 나오게 처리.↓
		//String grade2 = score > 90 ? "" : ""; <=요고는 많이사용 ↓형태를 이용해서 응용해보기.
		
		String grade = score > 90 ? "A" : score > 80 ? "B" : score > 70 ? "C": score > 60 ? "D"   : "E";
		System.out.println(grade);
	}
}
