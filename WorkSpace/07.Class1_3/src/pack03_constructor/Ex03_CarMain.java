package pack03_constructor;

public class Ex03_CarMain {
	public static void main(String[] args) {
		Ex03_Car ec = new Ex03_Car("쌍용" , "티볼리", "흰색");//제조사 , 모델 , 색상 = => null
		System.out.println(ec.company);
		System.out.println(ec.model);
		System.out.println(ec.color);
	}
}
