package pack03_oop1;

import java.util.Scanner;

public class ProductDAO {
	//기능만있음. 
	//필요에 따라서는 필드에 변수 (DAO에 필요한것) 만들기도함
	
	//display라는 메소드는 필요한게 뭘까?

	
	void display(ProductDTO dto) {
		System.out.println("번호: " + dto.num);
		System.out.println("상품명: " + dto.name);
	}
	
	void input() {
		System.out.println("상품 추가하기");
	}
	
	
	
}
