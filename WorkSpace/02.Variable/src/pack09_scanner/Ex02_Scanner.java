package pack09_scanner;

import java.util.Scanner;

public class Ex02_Scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);//����� �ȳ��� ����
		String data1 = sc.nextLine();//���� ����Ű ġ���������� ���ڿ��� ������
		String data2 =sc.nextLine();//���� ����Ű ġ���������� ���ڿ��� ������
		// ���ڸ� �ΰ� �޾ƿͼ� �� ���� ���� ���ϱ�. ���̵� ߾
		System.out.println(data1);
		System.out.println(data2);
		int num1 = Integer.parseInt(data1); // String�� �ϳ��� ���ڷ� �ٲٴ� ó��
		int num2 = Integer.parseInt(data2);
		//1.int sum = Integer.parseInt(data1) + Integer.parseInt(data2);//String�� �ѹ��� �ٲٴ¹��
		System.out.println(Integer.parseInt(data1) + Integer.parseInt(data2));
		//������ ���ϰ� �ٷ� ���� ���ϴ� ���
	
	}
}
