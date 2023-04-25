package pack04.extend;

public class ChangeTypeMain {
	public static void main(String[] args) {
		// CellPhone => DmbPhone => SmartPhone
		// CellPhone은 부모클래스이기때문에 자식클래스의 일부가 그대로 존재함. 
		//자식클래스를 부모클래스에 담게되면 그 기능을 그대로 사용이 가능하다.
		//CellPhone cp = new DmbPhone(1 , "색상" , "모델");
		//CellPhone cp2 = new SmartPhone(1, "색상", "모델", 5);
		CellPhone[] cpArr = new CellPhone[2];
		cpArr[0] = new DmbPhone(1 , "색상" , "모델");
		cpArr[1] = new SmartPhone(1 , "색상" , "모델" , 5);
		
		DmbPhone dp = new SmartPhone(1,  "색상" , "모델", 0);
		
		for(int i = 0 ; i < cpArr.length; i ++) {
			cpArr[i].powerOn();
		}
		// 변수타입변환중에 자동과강제가 있었음. 무슨차이가 있을까?
		// ex) int <=> double
		// int변수 intNum , double dNum 두개를 서로 바꿔서 담아보기.
		int intNum = 5;
		double dNum = 3.14;
		dNum = intNum;// 자동 : 
		intNum =(int) dNum;//강제 : 대부분의 타입변환의 의미 casting
		
		
		SmartPhone sp = (SmartPhone) new DmbPhone(1, "색상", "모델");//자식 = 부모 ; 강제로 캐스팅을 해줘야한다.
		sp.powerOn();
		
	}
}
