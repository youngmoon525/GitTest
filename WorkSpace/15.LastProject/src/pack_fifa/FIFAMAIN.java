package pack_fifa;

import java.util.Scanner;

public class FIFAMAIN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		FIFAUSERDAO dao = new FIFAUSERDAO();
		FIFAADMINDAO dao1 = new FIFAADMINDAO();
		FIFASIGNUPDAO dao2 = new FIFASIGNUPDAO();
		while(true) {
			System.out.println("�޴��� ����ּ���.");
			System.out.println("1. �α��� 2. ȸ������ 3. ����");
			int menu = dao.inputInt();
			if(menu==1) {
				while(true) {
				System.out.println("1. ������ ��� 2. ����� ��� 3. ����ȭ������ ����");
				menu = dao.inputInt();
				if(menu==1) {
					if(dao1.adminLogin()) {
						while(true) {
						System.out.println("1. ���� ���");
						System.out.println("2. ����");
						System.out.println("3. ����");
						System.out.println("4. ���� �˻�");
						System.out.println("5. �α׾ƿ�");
						menu = dao.inputInt();
						if(menu==1) {
							dao1.addPlayer();
						}else if(menu==2) {
							dao1.updatePlayer();
						}else if(menu==3) {
							dao1.deletePlayer();
						}else if(menu==4) {
							dao1.search();
						}else if(menu==5) {
							System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
							break;
						}else {
							System.out.println("�Է� ���� 1~5 ������ ���� �Է��ϼ���.");
						}
						
					}
					}
				}else if(menu==2) {
					if(dao.login()) {
						while(true) {
						System.out.println("1. �� ���� �˻�");
						System.out.println("2. ������");
						System.out.println("3. ����");
						System.out.println("4. Ż��");
						System.out.println("5. �α׾ƿ�");
						menu = dao.inputInt();
						if(menu==1) {
							dao.searchMyPlayer();
						}else if(menu==2) {
							System.out.println("1. �����̼�");
							System.out.println("2. �ĺ�");
							while(true) {
							menu = dao.inputInt();
							if(menu==1) {
								dao.formation();
								break;
							}else if(menu==2) {
								dao.candidate();
								break;
							}else {
								System.out.println("�Է� ���� 1 �Ǵ� 2�� �Է����ּ���.");
							}
							}
						}else if(menu==3) {
							System.out.println("1. ���� �����ϱ�");
							System.out.println("2. ���� �Ǹ��ϱ�");
							System.out.println("3. Bp �����ϱ�");
							System.out.println("4. ���� ���� Bp Ȯ���ϱ�");
							menu = dao.inputInt();
							if(menu==1) {
								dao.purchase();
							}else if(menu==2) {
								dao.sell();
							}else if(menu==3) {
								dao.chargeBP();
							}else if(menu==4) {
								dao.checkBP();
							}else {
								System.out.println("�Է¿��� 1 �Ǵ� 2�� �Է����ּ���");
							}
						}else if(menu==4) {
							dao.signout();
							break;
						}else if(menu==5) {
							System.out.println("�α׾ƿ� �Ǿ����ϴ�");
							break;
						}else {
							System.out.println("�Է¿��� 1~5 ������ ���� �Է��ϼ���");
						}
						}
					}
				}else if(menu==3) {
					System.out.println("����ȭ������ ���ư��ϴ�.");
					break;
				}else {
					System.out.println("�Է¿��� 1 �Ǵ� 2�� �Է����ּ���.");
				}
				}
			}else if(menu==2) {
				dao2.signup();
			}else if(menu==3) {
				System.out.println("FIFA�� �����մϴ�.");
				break;
			}
		}
	}
}
