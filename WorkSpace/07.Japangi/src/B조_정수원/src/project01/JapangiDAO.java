package project01;

import java.util.Scanner;

public class JapangiDAO {
	private JapangiDTO[] jpArr;
	boolean input = true;
	int money = 0; //������
	int choice; // ���� ����
	int num; // ���� ����
	int adLogin; // ������ �α���
	int adChoice; // ������ �ɼ� ����
	int c1000, c500, c100, c50, c10;
	int index;
	int inPrice, inNum, inCount;
	String inDrink;
	String remove;
	String update;
	String updateDrink;
	Scanner sc = new Scanner(System.in);
	
	
	//�ݾ� �Է¹ޱ�
	public void moneyScanner() {
	System.out.println("�������� �Է����ּ���");
	while(true) {
		if(input) {
		try{
			money = Integer.parseInt(sc.nextLine());
			if(money%10==0 || money%50==0 || money%100==0 || money%500==0 || money%1000==0) {
				input=false;
				System.out.println("���� �������� " + money +"�� �Դϴ�.");
				break;
			}else if(money<0){
				System.out.println("0�̻��� ���� �Է����ּ���.");
			}else {
				System.out.println("10, 50, 100, 500, 1000���� ������ �������� ���� �Է����ּ���");
			}
		}catch(Exception e) {
			System.out.println("���ڿܿ� ���� �ԷµǾ����ϴ�.");
		}
		}
	}
	//������ : ���� ������ ���� �Է����� ��
	}

//���?2,3 ���� �̱� /���Ǳ� ���� 
	public void drink(JapangiDTO[] jpArr) {
		while(true) {
			System.out.println("<<<<���� ���Ǳ�>>>>");
			System.out.println("��ȣ|����|����|���?");
			System.out.println("================");
			System.out.println(jpArr[0].getNum()+ ". " +jpArr[0].getDrink()+ "  " + jpArr[0].getPrice()+"��  "+jpArr[0].getCount()+"��");
			System.out.println(jpArr[1].getNum()+ ". " +jpArr[1].getDrink()+ "  " + jpArr[1].getPrice()+"��  "+jpArr[1].getCount()+"��");
			System.out.println(jpArr[2].getNum()+ ". " +jpArr[2].getDrink()+ "  " + jpArr[2].getPrice()+"��  "+jpArr[2].getCount()+"��");
//			for(int i=0; i<jpArr.length; i++) {
//				System.out.println(jpArr[i].getNum()+".  "+jpArr[i].getDrink()+"   "+jpArr[i].getPrice()+"��  "+jpArr[i].getCount()+"��");
//			}  ->�迭 ũ�⶧���� nullexception �Ͼ!
			System.out.println("�����Ÿ� �����Ͻ÷��� 0����");
			System.out.println("�ֹ��Ͻ� ���� ��ȣ�� �������ּ���");
			choice = Integer.parseInt(sc.nextLine());
				if(choice==1 && jpArr[0].getCount() ==0) {
					System.out.println("�ݶ� ���? �����մϴ�. �ٸ� �������? ����ּ���?.");
				}else if(choice==1 && money>=jpArr[0].getPrice()) {
					System.out.println("�� �� �����Ͻðڽ��ϱ�?");
					num=Integer.parseInt(sc.nextLine());
					if(money>=jpArr[0].getPrice()*num) {
						money -= jpArr[0].getPrice()*num;
						System.out.println("�ݶ� " + num + "�� �����ϼ̽��ϴ�.");
						System.out.println("�ܾ��� " + money + "�Դϴ�."); 
						jpArr[0].setCount(num);
					}else {
						System.out.println("�������� �����մϴ�.");
					}
				}else if(choice==2 && jpArr[1].getCount() ==0) {
					System.out.println("���̴� ���? �����մϴ�. �ٸ� �������? ����ּ���?.");	
					
				}else if(choice==2 && money>=jpArr[1].getPrice()) {
					System.out.println("�� �� �����Ͻðڽ��ϱ�?");
					num=Integer.parseInt(sc.nextLine());
					if(money>=jpArr[1].getPrice()*num) {
						money -= jpArr[1].getPrice()*num;
						System.out.println("���̴ٸ� " + num + "�� �����ϼ̽��ϴ�.");
						System.out.println("�ܾ��� " + money + "�Դϴ�."); 
						jpArr[1].setCount(num);
					}else {
						System.out.println("�������� �����մϴ�.");
					}
				}else if(choice==3 && jpArr[2].getCount() ==0) {
					System.out.println("ȯŸ ���? �����մϴ�. �ٸ� �������? ����ּ���?.");
				}else if(choice==3 && money>=jpArr[2].getPrice()) {
					System.out.println("�� �� �����Ͻðڽ��ϱ�?");
					num=Integer.parseInt(sc.nextLine());
					if(money>=jpArr[2].getPrice()*num) {
						money -= jpArr[2].getPrice()*num;
						System.out.println("ȯŸ�� " + num + "�� �����ϼ̽��ϴ�.");
						System.out.println("�ܾ��� " + money + "�Դϴ�."); 
						jpArr[2].setCount(num);
					}else {
						System.out.println("������ �����մϴ�.");
					}
				}else if(choice>3){
					System.out.println("��ȣ�� �߸��Է��߽��ϴ�. �ٽ� �Է����ּ���.");
				}else {
					System.out.println("----�ȳ���������.----");
					// ������ ������ �ܵ� ��ȯ�ؾ���
					c1000=money/1000;
					c500=money%1000/500;
					c100=money%1000%500/100;
					c50=money%1000%500%100/50;
					c10=money%1000%500%100%50/10;
					if(money>=1000) {
						System.out.println("�ܵ��� ��ȯ�մϴ� -> ");
						System.out.println("1000��: " + c1000 +"�� /" + "500��: " + c500 + "�� /" 
											+ "100��: " + c100 +"�� /" + "50��: " + c50 + "�� /" + "10��: "+c10+"��" );
					}else if(money>=500) {
						System.out.println("�ܵ��� ��ȯ�մϴ� -> ");
						System.out.println("500��: " + c500 + "�� /" + "100��: " + c100 +"�� /" 
											+ "50��: " + c50 + "�� /" + "10��: "+c10+"��" );	
								
					}else if(money>=100) {
						System.out.println("�ܵ��� ��ȯ�մϴ� -> ");
						System.out.println("100��: " + c100 +"�� /" + "50��: " + c50 + "�� /" + "10��: "+c10+"��" );
					}else if(money>=50) {
						System.out.println("�ܵ��� ��ȯ�մϴ� -> "); 
						System.out.println("50��: " + c50 + "�� /" + "10��: "+c10+"��" );
						}else {
						System.out.println("�ܵ��� ��ȯ�մϴ� -> ");
						System.out.println("10��: "+c10+"��" );
					}
					break;
				}
				
		}
	}

	public void admin(JapangiDTO[] jpArr) {
		System.out.println("������ ������ �α����Ͻðڽ��ϱ�?");
		System.out.println("1. yes / 2. no");
		adLogin=Integer.parseInt(sc.nextLine());
		if(adLogin==1) {
			System.out.println("���̵��? ��й�ȣ��? �Է��ϼ���.");
			System.out.print("���̵�: ");
			String adminId = sc.nextLine();
			System.out.print("��й��?: ");
			String adminPw = sc.nextLine();
			
			if(adminId.equals("master")&&adminPw.equals("admin")) {
				while(true) {
					System.out.println("0�� � ����̵�? ������ ��ü �����? �����ش�.");
					System.out.println("1�� ���� �߰� - ������ ��Ͽ�? ���ο� ���Ḧ �߰��Ѵ�.");
					System.out.println("2�� ���� ���� - ������ ��Ͽ�? �ִ� ������ �����Ѵ�.");
					System.out.println("3�� ���� ���� - ������ ��Ͽ�? �ִ� ������ �����Ѵ�.");
					System.out.println("4�� ������ ���? ����!");
					adChoice = Integer.parseInt(sc.nextLine());
					if(adChoice==0) {
						index=jpArr.length;
						for(int i=0; i<index-1; i++) {
							System.out.println(jpArr[i].getNum()+".  "+jpArr[i].getDrink()+"   "+jpArr[i].getPrice()+"��  "+jpArr[i].getCount()+"��");
						}	
						
					}else if(adChoice==1) {
						index=jpArr.length;
						for(int i=0; i<index; i++) {
							System.out.println(jpArr[index-2].getDrink());
							if(jpArr[index-1].getDrink().equals(null)) {
							inDrink=sc.nextLine();
								jpArr[index-1] = new JapangiDTO(4, "�����ݶ�", 700, 3);
								break;
							}
//							jpArr[3] = new JapangiDTO(4, "�����ݶ�", 700, 3);
//							System.out.println(jpArr[i].getNum()+".  "+jpArr[i].getDrink()+"   "+jpArr[i].getPrice()+"��  "+jpArr[i].getCount()+"��");
							
						}
					}else if(adChoice==2) {
						index=jpArr.length;
							System.out.println("�����Ͻ� �������? �����ΰ���?");
							update=sc.nextLine();
							for(int i=0; i<index; i++) {
							if(update.equals(jpArr[i].getDrink())) {
								update=jpArr[i].getDrink();
								System.out.println("���� ���� �����? :");
								updateDrink=sc.nextLine();
									 break;  
							}	
						}
							for(int i=0; i<index; i++) {
								System.out.println(jpArr[i].getNum()+".  "+jpArr[i].getDrink()+"   "+jpArr[i].getPrice()+"��  "+jpArr[i].getCount()+"��");
							}
					}else if(adChoice==3) {
						index=jpArr.length;
						System.out.println("� ���Ḧ �����Ͻðڽ��ϱ�?");
						remove=sc.nextLine();
						for(int i=0; i<index; i++) {
							if(remove.equals(jpArr[i].getDrink())) {
								System.out.println(remove + "�� �����մϴ�.");
								for(int j=i; j<index; j++) {
//									jpArr[j]=jpArr[j+1];
								}		
								index--; 
							}	
						}
						for(int i=0; i<index; i++) {
							System.out.println(jpArr[i].getNum()+".  "+jpArr[i].getDrink()+"   "+jpArr[i].getPrice()+"��  "+jpArr[i].getCount()+"��");
						}
					}else if(adChoice==4) {
						System.out.println("�������� ��ȯ�˴ϴ�..");
						System.out.println("(�������?)");
						break;
					}
				}
			}else  {
				System.out.println("���̵� �Ǵ� ��й�ȣ��? Ʋ�Ƚ��ϴ�.");
			
			}
		}else if(adLogin==2) {
			System.out.println("����!");
		}
		}
	}
	


