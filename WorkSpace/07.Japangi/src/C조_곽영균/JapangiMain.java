import java.util.Scanner;

public class JapangiMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JapangiDTO[] dtoArr = new JapangiDTO[3];
		dtoArr[0] = new JapangiDTO("��  ��", 800, 5);
		dtoArr[1] = new JapangiDTO("���̴�",1000, 4);
		dtoArr[2] = new JapangiDTO("ȯ  Ÿ", 900, 1);
		JapangiDAO dao = new JapangiDAO();
		
		dao.display(dtoArr);
		
	}
}
