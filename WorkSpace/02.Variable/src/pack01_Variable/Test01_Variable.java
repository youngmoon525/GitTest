package pack01_Variable;

public class Test01_Variable {
// int num1 , int num2
//������ �������� ���� 1�� 2�� ���������.
//���� ���Ҵ� x , �ΰ��� ���ڸ� �ٲ㺸��.
//���ܰ� ����� �� ��밡���ϳ�, num1=2<= X ���Ҵ� �Ұ�
// �ʱ� : num1(1) , num2(2)
// ��� : num1(2) , num2(1)
	public static void main(String[] args) {
		int num1 = 1;
		int num2 = 2;
		int temp = 0;
		// temp�� �̿��ؼ� num1�� num2�� �ٲ㺸��.
		//SWAP
		temp = num1;//temp(1)
		num1 = num2 ;//num1(2)
		num2 = temp ;
		System.out.println(num1);
		System.out.println(num2);
	}
	
}