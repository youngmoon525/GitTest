package pack07_oop3;

public class ProductDAO {
	public  void display(ProductDTO dto) {
		System.out.print("번호: " + dto.getNum() + " , ");
		System.out.print("이름: " + dto.getName() + " , ");
		System.out.print("가격: " + dto.getPrice() + " , ");
		System.out.println("수량: " + dto.getCnt() );
	}
	
	public void display(ProductDTO[] dtoArr) {
		for(int i = 0 ; i < dtoArr.length ; i ++) {
			//상품의 번호만 1~5까지 나오게 코드 ( display메소드 사용 x)
			// dao.display(dtoArr[i]);// <- 코드 작동 정상? 
			System.out.println(dtoArr[i].getNum());
		}
	}
}
