package pack07_oop3;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductMain {
	public static void main(String[] args) {
		
		String[] strArr = new String[5];//1~2번 같음 , 3번은 문자열 길이 출력
		// 0 ~ (5-1) , 0String , 1String , 2String , 3String , 4String

		strArr[0] = new String("1"); //"1";//String A; A.length
		strArr[1] = 22+"";//String B; B.length
		strArr[2] = "333";//String C;
		strArr[3] = "4444";//.
		strArr[4] = "55555"; //.
		
		for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i].length());
		}
		
		ProductDTO[] dtoArr = new ProductDTO[5];
		
		ProductDAO dao = new ProductDAO();
		//1.처음보는 타입을 배열로 묶을때 어려움이 있으면 해당하는 타입을 먼저 객체로 생성해보기.
		//2.생성한 객체를 배열의 임의의 인덱스에 넣어보기.
		//3.객체 생성시 사용한 생성자 또는 값을 배열의 인덱스에 넣게 수정.
		
//		ProductDTO dto1 = new ProductDTO(1, "컴퓨터", 10000, 5);
//		dtoArr[0] = dto1;				↓
//		dtoArr[0] = new ProductDTO(1, "컴퓨터", 10000, 5);
		//Scanner sc =
		dtoArr[0] = new ProductDTO(1, "컴퓨터", 10000, 5);
		dtoArr[1] = new ProductDTO(2, "노트북", 20000, 4);  
		dtoArr[2] = new ProductDTO(3, "라면", 1000, 10);   
		dtoArr[3] = new ProductDTO(4, "커피", 2000, 5);    
		dtoArr[4] = new ProductDTO(5, "마우스", 5000, 6); 
		dao.display(dtoArr);
		//ProductDTO dto1 = new ProductDTO(1, "컴퓨터", 10000, 5);
		//ProductDTO dto2 = new ProductDTO(2, "노트북", 20000, 4);
		//ProductDTO dto3 = new ProductDTO(3, "라면", 1000, 10);
		//ProductDTO dto4 = new ProductDTO(4, "커피", 2000, 5);
		//ProductDTO dto5 = new ProductDTO(5, "마우스", 5000, 6);
		
		
		// for ↓ 를 ProductDAO로 옮겨서 기능이 똑같이 되게 만들기
	
		// 0ProductDTO dto , 1ProductDTO dto , ....
		//1. dtoArr : 1.0~4까지는 어떤 데이터가 들어있을까?
		// null ( 객체를 선언만하고 사용이 가능한 상태가 아님 )
		//2. dtoArr[0] = ? 값 대입을 뭘 해야줘야할까?
		// 해당하는 타입을 생성할수있는 값(생성자 메소드 , 값 )
		//3. dtoArr를 이용해서 상품 번호 출력해보기
		

		//ProductDAO dao = new ProductDAO();
		//dao.display(dto1);
		//dao.display(dto2);
		//dao.display(dto3);
		//dao.display(dto4);
		//dao.display(dto5);
		//ProductDAO.display(dto1);
		//ProductDAO.display(dto2);

		//System.out.println(dto.cnt); <=private 접근제한자로 변수의 바로접근을 막아놓음
		//System.out.println(dto.getNum());
		//매번 dto의 내용을 하나씩 getter로 불러오는게 아니라 display()라는 메소드를 DAO구현하고
		//해당하는 메소드 호출 시 dto의 내용을 보여줄수있게 해보기.
		//번호: 1 , 이름:컴퓨터 , 가격:10000 , 수량:5
		
	}
}
