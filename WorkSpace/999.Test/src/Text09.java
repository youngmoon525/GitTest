import java.util.Scanner;

public class Text09 {
	public static void main(String[] args) {
		// double형태로 바꿔보기 , int형태로 바꿔보기.
		String str = "3.14";
		// int , double ==> 바꾸기 위한 기능을가진 Class
		// Integer , Double
		// .parse<= String문자열 타입을 해당하는 것으로 바꿔주는것
		double dValue = Double.parseDouble(str);//문자열 <> 소숫점있는 숫자 데이터타입
		
		System.out.println("3.14");
	}
}
