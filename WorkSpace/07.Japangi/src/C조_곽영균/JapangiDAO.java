import java.util.Scanner;

public class JapangiDAO {
	Scanner sc = new Scanner(System.in);
	
	public void display(JapangiDTO[] dtoArr){
		int coin = 0;
		int select = 0;
		int retry=0;
		for(int i=0; i<dtoArr.length; i++) {
			System.out.println((i+1)+"." +dtoArr[i].menu +"  "+dtoArr[i].price+"�� "+" ���:"+dtoArr[i].count+"��");
		}System.out.println();
		
			System.out.println("========�ݾ� �Է�=========");
			coin = Integer.parseInt(sc.nextLine());
			if(coin%10==0 && coin>0) {
				System.out.println("���� �Ӵ� : "+ coin+ "��");
				System.out.println();
			}else {
				System.out.println("����!");
				return;
			}	
			System.out.println("������� �Է¹ٶ�");
			select = Integer.parseInt(sc.nextLine())-1;
			try {
				System.out.println(dtoArr[select].menu +" "+ dtoArr[select].price+"��");		
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("���ư�����.");
				return;
			}
			
			if(coin>dtoArr[select].price) {
				System.out.println(dtoArr[select].menu+" ������");
				System.out.println(dtoArr[select].menu+" ���� ���:"+--dtoArr[select].count);
				
			}else {
				System.out.println(-(coin-dtoArr[select].price)+"�� ������");
				return;
			}
			System.out.println("��� �����ϱ� 1, �ݾ� �߰��ϱ� 2, �ܵ� ��ȯ�ϱ� 3");
			retry = Integer.parseInt(sc.nextLine()); 
			if(retry == 1) {
				continue;	
			}else if (retry==2) {
				System.out.println("�߰��� �ݾ� �Է�");
				int money = Integer.parseInt(sc.nextLine());
				coin += money;
				System.out.println("�ݾ��� �߰��Ǿ����ϴ� : "+coin);
		
			}else if (retry==3) {
				System.out.println("����");
				System.out.println("�ܵ� : "+(coin-dtoArr[select].price)+"��");
				return;	
	}
	}

	}

	
	
	
	

