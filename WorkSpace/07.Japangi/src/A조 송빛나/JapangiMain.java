package pack06_japangi;

public class JapangiMain {
	public static void main(String[] args) {
		JapangiDTO[] menu = new JapangiDTO[3];
		menu[0] = new JapangiDTO(1, "�ݶ�", 800, 8);
		menu[1] = new JapangiDTO(2, "���̴�", 1000, 5);
		menu[2] = new JapangiDTO(3, "ȯŸ", 900, 1);
		JapangiDAO dao = new JapangiDAO();
		JapangiDTO dto = new JapangiDTO();
		dao.start1(dto, menu);
	}
}