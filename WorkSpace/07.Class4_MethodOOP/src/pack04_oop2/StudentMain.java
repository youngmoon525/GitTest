package pack04_oop2;

public class StudentMain {
	// private <> public
	
	public static void main(String[] args) {
		//Student stu1 = new Student(1 ,"김영문" , 100 , 100 , 51 );
		//stu1.display();
			//DTO 상태정보
		    //DAO 기능 
		StudentDTO dto1 = new StudentDTO(1 ,"김영문" , 50 , 50 , 50 );
		StudentDAO dao = new StudentDAO();
		dao.display(dto1);
		System.out.println("====");
		dto1.setScore1(80);
		dao.display(dto1);
	}
}
