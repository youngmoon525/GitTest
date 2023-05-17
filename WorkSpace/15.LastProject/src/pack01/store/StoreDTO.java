package pack01.store;

public class StoreDTO {
	
//	CODE, PRODUCT, PRICE, CNT
	
	private int code;
	private String product;
	private int price;
	private int cnt;
	
	
	
	
	public StoreDTO(int code, String product, int price, int cnt) {
		super();
		this.code = code;
		this.product = product;
		this.price = price;
		this.cnt = cnt;
	}




	public int getCode() {
		return code;
	}




	public void setCode(int code) {
		this.code = code;
	}




	public String getProduct() {
		return product;
	}




	public void setProduct(String product) {
		this.product = product;
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
	
	
	
	
	
	
	
	
	
}
