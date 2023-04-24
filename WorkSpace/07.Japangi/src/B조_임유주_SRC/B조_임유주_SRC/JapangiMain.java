package japangi;

public class JapangiMain {
	public static void main(String[] args) {
		JapangiDTO dto = new JapangiDTO();
		JapangiDAO dao = new JapangiDAO();
		dao.display(dto);

	}
}