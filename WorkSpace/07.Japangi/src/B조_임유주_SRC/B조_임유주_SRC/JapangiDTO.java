package japangi;

public class JapangiDTO {
	int[] Price = { 800, 1000, 900 }, cnt = { 8, 5, 1 };
	String[] bev = { "�ݶ�", "���̴�", "ȯŸ","null" };


	public void MenuDTO(int[] price, int[] cnt, String[] bev) {
		Price = price;
		this.cnt = cnt;
		this.bev = bev;
	}
}