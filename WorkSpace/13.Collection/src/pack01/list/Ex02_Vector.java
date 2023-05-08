package pack01.list;

import java.util.List;
import java.util.Vector;

public class Ex02_Vector {
	public static void main(String[] args) {
		//사용 빈도가 없거나 매우 낮기때문에 이론만 살펴보고 넘어감.
		//List라는 Interface를 상속받았기때문에 기본 구조는 ArrayList, LinkedList , Vector전부 비슷함.
		// ? TestDTO라는 클래스를 묶어서 저장하고싶다. ?에는 뭘 넣을까.
		//1. List 생성해보기
		//2. List에 요소 추가해보기. ※ ( TestDTO )  ※
		//3. List에 있는 요소 내용 출력해보기 ( 예시 : FirstName : 성 , LastName : 이름 ) 
		List<TestDTO> list = new Vector<TestDTO>();//크기 ? 
		//TestDTO dto = null;
		//TestDTO dto1 = new TestDTO("FirstName", "LastName");
		//System.out.println(dto1.getFirstName());
		//list.add(dto);
		//list.add(dto1);
		list.add( new TestDTO("FirstName", "LastName") );
		list.add( new TestDTO("FirstName1", "LastName1") );
		System.out.println(list.get(0).getFirstName());
		
		TestDTO[] arrDTOs = new TestDTO[2];
		arrDTOs[0] = new TestDTO("FirstName", "LastName");
		arrDTOs[1] = new TestDTO("FirstName1", "LastName1");//오류발생 배열의 크기가 1이기때문에 불가능
		TestDTO[] temps = new TestDTO[3];
		temps[0] = arrDTOs[0];
		temps[1] = arrDTOs[1];
		temps[2] = new TestDTO("FirstName1", "LastName1");
		
		arrDTOs = temps;
		//arrDTOs[2] = new TestDTO("FirstName1", "LastName1");//오류발생 배열의 크기가 1이기때문에 불가능
		
		//System.out.println(arrDTOs[0].getFirstName());
		//list.add
		
	}
}
