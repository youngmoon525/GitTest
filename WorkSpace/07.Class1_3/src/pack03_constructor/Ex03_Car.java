package pack03_constructor;

public class Ex03_Car {
	//필드 (멤버)
	String company ;//제조사
	String model;//모델
	String color;//색상
	int maxSpeed;
	int speed;
	
	//this<- 나자신. ( 중괄호 기준으로 나자신)
	public Ex03_Car(String companya, String model, String color) {
		this.company = companya;
		this.model = model;
		this.color = color;
	}
	
	
	//Ex03_CarMain에서 Ex03_Car를 생성을합니다.
	//Ex03_Car클래스에 규칙을 하나 만들기.
	//제조사와 모델 그리고 색상은 필수로 입력이 되었을때만 생성이 가능한 규칙을 만든다.
	
	
	
}
