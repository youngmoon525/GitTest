package japangi;

public class JapangiDTO {
	private int num; //상품 고유번호
	private String name; //상품 이름
	private int price; //상품 가격
	private int cnt; //상품 재고
	private int coin; 
	public JapangiDTO(int num, String name, int price, int cnt) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	

	
	
}