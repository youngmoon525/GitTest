package Test;

public class japangiDTO {
	private int num;
	private String menu;
	private int price;
	private int quntity;
	
	public japangiDTO(int num, String menu, int price, int quntity) {
		this.num = num;
		this.menu = menu;
		this.price = price;
		this.quntity = quntity;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuntity() {
		return quntity;
	}
	public void setQuntity(int quntity) {
		this.quntity = quntity;
	}
	
}
