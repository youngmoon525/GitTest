package pack04_while;

public class Ex02_While {
	public static void main(String[] args) {
		// 1~10까지의 누적합을 while문을 통해서 구하고 출력해보기.
		// while <= 어려우면 for문으로 해결해도됨
		// 누적합 : 1+2+3+4...+10 = 55 
		int i = 1;
		int result = 0;
		while(i <= 10) {
			System.out.println(i);
			result += i;
			i++;
			//System.out.println(i); //<=
		}
		
		for(int j = 0 ; j <=10 ; j ++) {
			result += j;
		}
		
		System.out.println(result);
		
	}
	
}
