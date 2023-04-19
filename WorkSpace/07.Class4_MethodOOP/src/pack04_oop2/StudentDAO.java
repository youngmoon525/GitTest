package pack04_oop2;

public class StudentDAO {
	void display(StudentDTO dto) {                
		System.out.println(dto.getNum());              
		System.out.println(dto.getName());             
		System.out.println(dto.getScore1());           
		System.out.println(dto.getScore2());           
		System.out.println(dto.getScore3());           
		System.out.println(dto.getSum());           
		System.out.println(dto.getAvg());        
	}                                             
}
