package japangi;

import java.util.Scanner;

public class JapangiDAO {
	void display(JapangiDTO dto) {
		Scanner sc = new Scanner(System.in);
//������ ���
		System.out.println("1.������ 2.�����");

		for(;;) {
		int admin = Integer.parseInt(sc.nextLine());
		if (admin == 1) {
			System.out.println("�α����� �ʿ��մϴ�. id�� �Է��ϼ���.");
			String id = (sc.nextLine());
			if (id.equals("master")) {
				System.out.println("�н����带 �Է��ϼ���.");
				String pw = (sc.nextLine());
				if (pw.equals("admin")) {
					System.out.println("���� ����: "+dto.bev[0]+"/"+dto.bev[1]+"/"+dto.bev[2]);
					System.out.println("1.�����߰� 2.������� 3.�������");
					int add = Integer.parseInt(sc.nextLine());
					if(add==1) {
						System.out.println("[�����߰�]");
						System.out.println("�߰��� ���Ḧ �Է��ϼ���.");
						String addBev = (sc.nextLine());
						addBev=dto.bev[3];
						System.out.println("���Ḧ �߰��Ͽ����ϴ�.");
					}else if(add==2) {
						System.out.println("[�������]");
						System.out.println("������ ���Ḧ �����ϼ���.");
						String adtBev = (sc.nextLine());
						if(adtBev.equals(dto.bev[0])|adtBev.equals(dto.bev[1])|adtBev.equals(dto.bev[2])) {
							System.out.println("������ ������ �Է��ϼ���.");
							int adt = Integer.parseInt(sc.nextLine());
							System.out.println("������ ����Ǿ����ϴ�.");
						}else {System.out.println("�߸��� �Է��Դϴ�.");}
					}else if(add==3) {
						System.out.println("[�������]");
						System.out.println("������ ���Ḧ �����ϼ���.");
						String delBev = (sc.nextLine());
						if(delBev.equals(dto.bev[0])|delBev.equals(dto.bev[1])|delBev.equals(dto.bev[2])) {
							System.out.println("���ᰡ �����Ǿ����ϴ�.");
						}else {System.out.println("�߸��� �Է��Դϴ�.");}
					}
					}else{System.out.println("���ӺҰ�. ����ڷ� ��ȯ�˴ϴ�.");}
			} else {
				System.out.println("���ӺҰ�. ����ڷ� ��ȯ�˴ϴ�.");
			}
			

//����� ���			
		} else if(admin == 2) {
			System.out.println("���� ��������");
		}else {
			System.out.println("�߸��� �����Դϴ�.");
			break;
		}
		
		for (;;) {
			try {
				int coin = Integer.parseInt(sc.nextLine());
				if ((coin % 10 == 0) & (coin < dto.Price[0])) {
					System.out.println("�ܾ��� �����մϴ�.");
				} else if (coin % 10 != 0) {
					System.out.println("���� �Ǵ� ���� �־��ּ���");
				} else {
					System.out.println("���ἱ��(�ݶ�,���̴�,ȯŸ)");
					String bev = sc.nextLine();

					if (bev.equals(dto.bev[0]) & coin >= dto.Price[0] & dto.cnt[0] > 0) {
						System.out.println(dto.bev[0] + " �Ž����� " + (coin - dto.Price[0]) + "��");
						System.out.println("1000�� ¥�� "+(coin - dto.Price[0])/1000 + "��");
						System.out.println("100�� ¥�� "+((coin - dto.Price[0])%1000)/100 + "��");
						System.out.println("10�� ¥�� "+(((coin - dto.Price[0])%1000%100))/10 + "�� ��ȯ�մϴ�");
					} else if (bev.equals(dto.bev[1]) & coin >= dto.Price[1] & dto.cnt[1] > 0) {
						System.out.println(dto.bev[1] + " �Ž����� " + (coin - dto.Price[1]) + "��");
						System.out.println("1000�� ¥�� "+(coin - dto.Price[1])/1000 + "��");
						System.out.println("100�� ¥�� "+((coin - dto.Price[1])%1000)/100 + "��");
						System.out.println("10�� ¥�� "+(((coin - dto.Price[1])%1000%100))/10 + "�� ��ȯ�մϴ�");
					} else if (bev.equals(dto.bev[2]) & coin >= dto.Price[2] & dto.cnt[2] > 0) {
						System.out.println(dto.bev[2] + " �Ž����� " + (coin - dto.Price[2]) + "��");
						System.out.println("1000�� ¥�� "+(coin - dto.Price[2])/1000 + "��");
						System.out.println("100�� ¥�� "+((coin - dto.Price[2])%1000)/100 + "��");
						System.out.println("10�� ¥�� "+(((coin - dto.Price[2])%1000%100))/10 + "�� ��ȯ�մϴ�");
					} else {
						System.out.println("�ܾ� �Ǵ� ��� �����մϴ�.");
					}
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("���� ��������");
			}
		}
	}
	}
}