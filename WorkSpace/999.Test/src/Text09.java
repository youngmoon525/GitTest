import java.util.Scanner;

public class Text09 {
	public static void main(String[] args) {
		// double���·� �ٲ㺸�� , int���·� �ٲ㺸��.
		String str = "3.14";
		// int , double ==> �ٲٱ� ���� ��������� Class
		// Integer , Double
		// .parse<= String���ڿ� Ÿ���� �ش��ϴ� ������ �ٲ��ִ°�
		double dValue = Double.parseDouble(str);//���ڿ� <> �Ҽ����ִ� ���� ������Ÿ��
		
		System.out.println("3.14");
	}
}