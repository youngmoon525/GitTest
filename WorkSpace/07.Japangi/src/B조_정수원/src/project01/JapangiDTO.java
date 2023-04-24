package project01;

public class JapangiDTO {

	
	//num(��ȣ) , drink(����), price(����), count(����)	
	private int num;
	private String drink;
	private int price, count;
	
	//�⺻ ������
	public JapangiDTO() {
	}

	//������ �ʱ�ȭ
	public JapangiDTO(int num, String drink, int price, int count) {
		this.num = num;
		this.drink = drink;
		this.price = price;
		this.count = count;
	}
	
	//getter & setter �޼ҵ�

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num += num;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count -= count;
	
	
	}
}
