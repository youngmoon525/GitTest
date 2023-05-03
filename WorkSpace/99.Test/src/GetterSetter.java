
public class GetterSetter {
	private int age ; // GetterSetterMain이라는 클래스와 메인메소드를 만들고, 해당 클래스에서 , -값과 0이 입력안되게 
							// 처리해보기.
							// Scanner sc = new Scanner(System.in);
							// 

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 1) {
			System.out.println(" 잘못됨");
		}else {
			this.age = age;			
		}
	}
	
	
	
	//1.개발자끼리 봤을때 정확한 메소드의 기능을 판단하기
	//어려움(빠른 판단 불가)
	//==> getter & setter라는 메소드 이름규칙을정함.
	//getMethod : 필드의 값을 받아올때씀
	//setMethod : 필드의 값을 넣을때씀
	
	//2. 다른개발자는 메소드의 존재여부를 모르고
	//변수에 바로접근해서 -값을 넣을수가있음.
	//==> private
	
//	public void method(int num) {
//		if(num < 1) {
//			System.out.println("잘못된입력");
//		}else {
//			System.out.println("잘된입력");
//			age = num;
//			System.out.println(age + " gs.age의 값");
//		}
//	}
}
