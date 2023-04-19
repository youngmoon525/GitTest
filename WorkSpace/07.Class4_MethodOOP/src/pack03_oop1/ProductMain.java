package pack03_oop1;

import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {
		// 상품 두개를 생성하기.
		// 1.컴퓨터 , 2.노트북
		// display()메소드를 이용해서 내용 출력해보기.
//		Product p1 = new Product(1,"컴퓨터");
//		p1.display();
//		Product p2 = new Product(2,"노트북");
//		p2.display();

		ProductDTO dto = new ProductDTO();
		dto.num = 1;
		dto.name = "컴퓨터";
		ProductDTO dto2 = new ProductDTO();
		dto2.name = "노트북";
		dto2.num = 2;
		
		
		ProductDAO dao = new ProductDAO();
		dao.display(dto);
		dao.display(dto);
		
		
		
	}
}
