package Test;

import java.util.Scanner;

public class japangiDAO {

	
	public static void display(japangiDTO dto) {
		System.out.print(" ��ǰ��ȣ : " + dto.getNum());
		System.out.print(" �޴� : " + dto.getMenu());
		System.out.print(" ���� : " + dto.getPrice());
		System.out.println(" ���� :" + dto.getQuntity());
	}
	
	int coin;
	int num;
	String id;
	String pw;
	int adminNum;

	
	Scanner sc = new Scanner(System.in);
	 void inputCoin(japangiDTO dtoArr) {
		while (true) {
			System.out.println("====�ݾ��� �־��ּ���====");
			coin = Integer.parseInt(sc.nextLine());
			try {
				if (coin % 10 == 0) {
					System.out.println(coin + "���� �����̽��ϴ�.");
					if(coin < dtoArr.getPrice()) {
						System.out.println("�ݾ��� �����մϴ�.");
						continue;
					}
					break;
				}
				else{
					System.out.println("���������� �־��ּ���");
					continue;
					
				}
			} catch (NumberFormatException e) {
				System.out.println("���ڷ� �ٽ� �Է����ּ���");
			}
		}
	 }
	 void choiceCan(japangiDTO dtoArr ,japangiDTO dtoArr1 , japangiDTO dtoArr2) {
		while(true) {
		 System.out.println("������ �����Ͻðڽ��ϱ�?");
		 num = Integer.parseInt(sc.nextLine());
		 if(num == dtoArr.getNum()) {
			 System.out.println("�ݶ� �����ϼ̽��ϴ�.");
			 if(dtoArr.getQuntity() == 0) {
				 System.out.println("ǰ��");
				 continue;
			 }
			 break;
		 }else if(num == dtoArr1.getNum()) {
			 System.out.println("���̴ٸ� �����ϼ̽��ϴ�.");
			 if(dtoArr1.getQuntity() == 0) {
				 System.out.println("ǰ��");
				 continue;
			 }
			 break;
		 }else if(num == dtoArr2.getNum()){
			 System.out.println("ȯŸ�� �����ϼ̽��ϴ�.");
			 if(dtoArr1.getQuntity() == 0) {
				 System.out.println("ǰ��");
				 continue;
			 }
			 break;
		 }
	 }
	 }
	 void changes(japangiDTO dtoArr ,japangiDTO dtoArr1 , japangiDTO dtoArr2) {
		 int[] coinUnit = { 500, 100, 50, 10 };
		 int changes1 = coin-dtoArr.getPrice();
		 int changes2 = coin-dtoArr1.getPrice();
		 int changes3 = coin-dtoArr2.getPrice();
		 if(num == dtoArr.getNum()) { 
			 System.out.println("�ܵ� : " + changes1 + "��");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"��: "+	changes1 / coinUnit[i]);
				 changes1 %= coinUnit[i];
			 }
		 }else if(num == dtoArr1.getNum()) {
			 System.out.println("�ܵ� : " + changes2 + "��");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"��: "+	changes2 / coinUnit[i]);
				 changes2 %= coinUnit[i];
				 }
		 }else if(num == dtoArr2.getNum()){
			 System.out.println("�ܵ� : " + changes3 + "��");
			 for (int i = 0; i < coinUnit.length; i++) {
				 System.out.println(coinUnit[i]+"��: "+	changes3 / coinUnit[i]);
				 changes3 %= coinUnit[i];
			 }
		 }
	 }
	 
	void admin() {
		while(true){
		System.out.println("���̵� �Է����ּ���.");
		id = sc.nextLine();
		System.out.println("�н����带 �Է����ּ���.");
		pw = sc.nextLine();
		if(id.equals("master") && pw.equals("admin")) {
			System.out.println("������ ��尡 ����Ǿ����ϴ�.");
			break;
		}else {
			System.out.println("���̵�Ȥ�� ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			continue;
			}
		}
	}
	
	void adminSetting(japangiDTO[] dtoArr, japangiDTO dto , japangiDTO dto1 , japangiDTO dto2, japangiDTO dto3, japangiDTO dto4 ) {
		System.out.println("0. ��ǰ ��� 1. �����߰� 2. ���� ���� 3. ���� ����");
		System.out.println("��ȣ�� �Է��ϼ���.");
		adminNum = sc.nextInt();
		//��ǰ ���
		if(adminNum == 0) {
			for(int i = 0; i < dtoArr.length; i++) {			
				japangiDAO.display(dtoArr[i]);				
			}
		}else if(adminNum == 1) { 
			System.out.print("�߰��Ͻ� �޴��� ��ȣ�� �Է��ϼ��� : ");
            int v = sc.nextInt();
            System.out.print("�߰��Ͻ� �޴��� �̸��� �Է��ϼ��� : ");
            String name = sc.next();
			System.out.print("�߰��Ͻ� �޴��� ������ �Է��ϼ��� : ");
             int j = sc.nextInt();
             System.out.print(name + "�� ���� �� �� �Դϱ�? : ");
             int k = sc.nextInt();
             System.out.println("�޴� �߰��� �Ϸ�Ǿ����ϴ�!");
			}else if(adminNum == 2) {
				System.out.print("�����Ͻ� �޴��� ��ȣ�� �Է��ϼ��� : ");
	            int v = sc.nextInt();
	            System.out.print("� �̸����� �����Ͻðڽ��ϱ�? : ");
	            String name = sc.next();
				System.out.print("�����Ͻ� �޴��� ������ �Է��ϼ��� : ");
	             int j = sc.nextInt();
	             System.out.print(name + "�� ���� �� �� �Դϱ�? : ");
	             int k = sc.nextInt();
	             System.out.println("�޴� ������ �Ϸ�Ǿ����ϴ�!");
			}else if(adminNum == 3) {
				System.out.print("�����Ͻ� �޴��� ��ȣ�� �Է��ϼ��� : ");
	            int v = sc.nextInt();
	            System.out.println(v + "�� ������ �Ϸ�Ǿ����ϴ�.");
			}
		}
	}




	
	

	
	
	 

