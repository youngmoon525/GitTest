package pack06_japangi;

import java.util.Scanner;

public class JapangiDAO {
	
	public void display(JapangiDTO[] menu) {
		for(int i =0;i<menu.length;i++) {
			System.out.print(menu[i].getNum()+". ");
			System.out.print(menu[i].getName()+" ");
			System.out.print(menu[i].getPrice()+"�� ");
			System.out.println("��� : "+menu[i].getCount()+" ");
		}
	}
		
	public Scanner sc() {
		return new Scanner(System.in);
	}
	int i=0;
	int ad=0;
	public int inputCoin(JapangiDTO dto) {	//���� �ݾ� �Է�
		while(true) {
			System.out.println("���� �־��ּ���");
			try {
				dto.setUserMoney(Integer.parseInt(sc().nextLine()));
				if(dto.getUserMoney()<=0||dto.getUserMoney()%10!=0) {
					System.out.println("�Է� ����, ���� �� ������ �־��ּ���.");
				}else {
					System.out.println(dto.getUserMoney()+"���� �־����ϴ�.");
					break;
				}
			}catch (Exception e) {
				System.out.println("�Է� ����, ���� �� ������ �־��ּ���.");
			}
		}
		return dto.getUserMoney();
	}
	String id, pw;
	int select;
	public int drinkSelect(JapangiDTO dto, JapangiDTO menu[]) {	//����� ����
		while(true) {
			try {
				System.out.println("������� �������ּ���");
				display(menu);
				select=Integer.parseInt(sc().nextLine());
				if(select<=menu.length&&select>=1) {
					break;
				}else {
					System.out.println("�Է� ���� 1~"+menu.length+"������ ���� �Է��ϼ���.");
				}
			}catch (Exception e) {
				System.out.println("�Է� ���� 1~"+menu.length+"������ ���� �Է��ϼ���.");
			}
		}
		return select;
	}
	int selectMoney;
	public int lack(JapangiDTO dto, JapangiDTO menu[]) {	//�ܾ� �߰� �Է�
		while(dto.getUserMoney()<menu[select-1].getPrice()) {
			try {
				System.out.println("�ܾ��� �����մϴ�(���� �ܾ� : "+dto.getUserMoney()+"��)");
				System.out.println(menu[select-1].getName()+"�� ���� : "+menu[select-1].getPrice()+"��");
				System.out.println("���� �� �����ðڽ��ϱ�?");
				System.out.println("1. O 2. X");
				selectMoney=Integer.parseInt(sc().nextLine());
				if(selectMoney==1) {
					try {
						System.out.println("�ݾ��� �־��ּ���");
						dto.setInputMoney(Integer.parseInt(sc().nextLine()));
						System.out.println("���� �ܾ� : "+dto.getUserMoney()+"��");
						
					}catch (Exception e) {
						System.out.println("�Է� ����, ���� �� ������ �־��ּ���.");
					}
				}else if(selectMoney==2) {
					System.out.println("�ܵ��� ��ȯ�մϴ�");
					changes(dto, menu);
					i=1;
					break;
					
				}else {
					System.out.println("1 �Ǵ� 2�� �Է����ּ���");
				}
				
			}catch (Exception e) {
				System.out.println("1 �Ǵ� 2�� �Է����ּ���");
			}
		}return dto.getUserMoney();
	}
	public void changes(JapangiDTO dto, JapangiDTO menu[]) {	//�ܵ� ��ȯ
		System.out.println("�ܵ� : " + dto.getUserMoney()+"��");
		int i10=10000;
		int i5=50000;
		while(i10>=10) {
			if(dto.getUserMoney()/i5==0) {
			}else {
			System.out.print(i5+"�� : "+dto.getUserMoney()/i5+"�� ");
			}
			dto.setUserMoney(dto.getUserMoney()-((dto.getUserMoney()/i5)*i5));
			i5/=10;
			if(dto.getUserMoney()/i10==0) {
			}else {
			System.out.print(i10+"�� : "+dto.getUserMoney()/i10+"�� ");
			}
			dto.setUserMoney(dto.getUserMoney()-((dto.getUserMoney()/i10)*i10));
			i10/=10;
		}System.out.println();
	}
	boolean isExit;
	public int exit(JapangiDTO dto, JapangiDTO menu[]) {	//����� ���
		System.out.println(menu[select - 1].getName() + "�� ���õǾ����ϴ�.");
			if (menu[select - 1].getCount() > 0) { // ����� ����
				isExit = true;
			} else {
				isExit = false;
			}
			if (isExit) {
				menu[select - 1].setCount(menu[select - 1].getCount() - 1); // ����� ���� -1
				System.out.println(menu[select - 1].getName() + "�� ���Խ��ϴ�.");
				dto.setUserMoney(dto.getUserMoney() - menu[select - 1].getPrice());
				changes(dto, menu);
			}
		else {
			while (menu[select-1].getCount() <1) {
				System.out.println("��� �����ϴ�.");
				System.out.println(menu[select - 1].getName() + "�� �ƴ� �ٸ� ������� �������ּ���.");
				final2(dto, menu);
				break;
			}
	}
	return menu[select-1].getCount();		
	}
	
	
	public void start1(JapangiDTO dto, JapangiDTO menu[]) {		//��� ���� �� ������ �α���
		while(true) {
			i=0;
			try {
		System.out.println("��ȣ�� �Է��ϼ���");
		System.out.print("1. ������ ��� ");
		System.out.print("2. ���Ǳ� ���� ");
		System.out.println("3. ���Ǳ� ����");
		int number = Integer.parseInt(sc().nextLine());
		if(number==1) {
			System.out.println("�����ڸ�尡 ����Ǿ����ϴ�.");
			while(true) {
			System.out.println("���̵�� ��й�ȣ�� �Է����ּ���");
			System.out.print("ID : ");
			id = sc().nextLine();
			System.out.print("password : ");
			pw = sc().nextLine();
				if(id.equals("master")&&pw.equals("admin")) {
					System.out.println("�α��� ����");
					start2(dto, menu);
					break;
				}else {
					System.out.println("�α��� ���� ���̵�� ��й�ȣ�� �ٽ� Ȯ���ϼ���.");
				}
			}
		}else if(number==2) {
			System.out.println("���Ǳ⸦ �����մϴ�.");
			break;
		}else if(number==3){
			System.out.println("���Ǳ⸦ �����մϴ�.");
			final1(dto, menu);
		}
		else {
			System.out.println("�Է� ���� 1~3������ ���� �Է��ϼ���.");
		}
			}catch (Exception e) {
				System.out.println("�Է� ���� 1~3������ ���� �Է��ϼ���.");
			}
		}
	}
	int adSelect;
	public void start2(JapangiDTO dto, JapangiDTO menu[]) {	//������ ���
		while(true) {
			System.out.println("1. ���� �߰�" + "\t" +"2. ���� ����" + "\t" +"3. ���� ����" + "\t");
			try {
			adSelect=Integer.parseInt(sc().nextLine());
			if(adSelect==1) {
				System.out.println("====���� �߰�====");
				ad1(dto, menu);
				break;
			}else if(adSelect==2) {
				System.out.println("====���� ����====");
				ad2(dto, menu);
				break;
			}else if(adSelect==3) {
				System.out.println("====���� ����====");
				ad3(dto, menu);
				break;
			}else {
				System.out.println("�Է¿���, 1~3������ ���� �Է��ϼ���");
			}
		}catch (Exception e) {
			System.out.println("�Է¿���, 1~3������ ���� �Է��ϼ���");
		}
		}
			}
	public void ad1(JapangiDTO dto, JapangiDTO menu[]) {	//���� �߰�
		display(menu);
		int price;
		int count;
		System.out.println("�߰��� ������� �̸�, ����, ��� ���ʷ� �Է����ּ���.");
		JapangiDTO[] menu1 = new JapangiDTO[menu.length+1];
		for(int i=0;i<menu.length;i++) {
			menu1[i] = new JapangiDTO(menu[i].getNum(), menu[i].getName(), menu[i].getPrice(), menu[i].getCount());
		}
		System.out.print("�̸� : ");
		String name = sc().nextLine();
		while(true) {
			try {
		System.out.print("���� : ");
		price = Integer.parseInt(sc().nextLine());
		if(price>=0&&price%10==0) {
		break;
		}else {
			System.out.println("�Է� ���� �����̳� ����� ����� �� �ִ� ������ �����ּ���.");
		}
			}catch (Exception e) {
				System.out.println("�Է� ���� �����̳� ����� ����� �� �ִ� ������ �����ּ���.");
			}
		}
		while(true) {
			try {
		System.out.print("��� : ");
		count = Integer.parseInt(sc().nextLine());
		if(count>=0) {
		break;
		}else {
			System.out.println("�Է� ���� 0�̻��� �ڿ����� �Է��ϼ���.");
		}
			}catch (Exception e) {
				System.out.println("�Է� ���� 0�̻��� �ڿ����� �Է��ϼ���.");
			}
		}
		System.out.println("����� ���Ǳ� �޴� : ");
		menu1[menu1.length-1] = new JapangiDTO(menu[menu.length-1].getNum()+1, name, price, count);
		menu = new JapangiDTO[menu.length+1];
		for(int i=0;i<menu.length;i++) {
			menu[i] = new JapangiDTO(menu1[i].getNum(), menu1[i].getName(), menu1[i].getPrice(), menu1[i].getCount());
		}
		display(menu);
	}
	
	public void ad2(JapangiDTO dto, JapangiDTO menu[]) { // ���� ����
		display(menu);
			System.out.println("������ ������� ��ȣ�� �Է����ּ���.");
			while(true){
				try {
			int number = Integer.parseInt(sc().nextLine())-1;
			if (number >= 0&&number<menu.length) {
				System.out.print("�̸� : "+menu[number].getName()+ "->" );
				menu[number].setName(sc().nextLine());
				while(true) {
					try {
				System.out.print("���� : "+menu[number].getPrice()+ "->");
				int price = Integer.parseInt(sc().nextLine());
				if(price>=0&&price%10==0) {
				menu[number].setPrice(price);
				break;
					}else {
						System.out.println("�Է� ���� �����̳� ����� ����� �� �ִ� ������ �����ּ���.");
					}
					}catch (Exception e) {
						System.out.println("�Է� ���� �����̳� ����� ����� �� �ִ� ������ �����ּ���.");
					}
				}
				while(true) {
					try {
				System.out.print("��� : "+menu[number].getCount()+ "->");
				int count = Integer.parseInt(sc().nextLine());
				if(count>=0) {
				menu[number].setCount(count);
				break;
					}else {
						System.out.println("�Է� ���� 0�̻��� �ڿ����� �Է��ϼ���.");
					}
					}catch (Exception e) {
						System.out.println("�Է� ���� 0�̻��� �ڿ����� �Է��ϼ���.");
					}
				}
				display(menu);
				break;
				}
			else {
				System.out.println("�Է� ����, 1~"+menu.length+"������ ���� �Է��ϼ���.");
			}
	}catch (Exception e) {
				System.out.println("�Է� ����, 1~"+menu.length+"������ ���� �Է��ϼ���.");
			}
			}
	}
	public void ad3(JapangiDTO dto, JapangiDTO menu[]) {//����� ����
		display(menu);
		System.out.println("������ ������� ��ȣ�� �Է����ּ���");
		while(true) {
			try {
		int number=Integer.parseInt(sc().nextLine())-1;
		if(number>=0&&number<menu.length) {
			JapangiDTO[] menu1 = new JapangiDTO[menu.length-1];
			for(int i=number+1;i<menu.length;i++) {
				menu1[i-1] = new JapangiDTO(menu[i].getNum()-1, menu[i].getName(),menu[i].getPrice(),menu[i].getCount());
			}
			if(number+1==menu.length) {
				for(int i =0;i<menu.length-1;i++) {
					menu1[i]= menu[i];
				}menu = new JapangiDTO[menu1.length];
				for(int i =0;i<menu.length;i++) {
					menu[i]=menu1[i];
				}
			}else {
			menu = new JapangiDTO[menu1.length];
			for(int i=0;i<menu.length;i++) {
				menu[i] = new JapangiDTO(menu1[i].getNum(), menu1[i].getName(),menu1[i].getPrice(),menu1[i].getCount());
			}
			}
			display(menu);
			break;
		}else {
			System.out.println("�Է� ���� 1~"+menu.length+"������ ���� �Է��ϼ���.");
		}
			}catch (Exception e) {
				System.out.println("�Է� ���� 1~"+menu.length+"������ ���� �Է��ϼ���.");
			}
		}
		
	}
	public void final1(JapangiDTO dto, JapangiDTO menu[]) {
		display(menu);
		inputCoin(dto);
		drinkSelect(dto, menu);
		lack(dto, menu);
		if(i==0) {
			exit(dto, menu);
		}
	}
	public void final2(JapangiDTO dto, JapangiDTO menu[]) {
		drinkSelect(dto, menu);
		lack(dto, menu);
		if(i==0) {
			exit(dto, menu);
		}
	}
}