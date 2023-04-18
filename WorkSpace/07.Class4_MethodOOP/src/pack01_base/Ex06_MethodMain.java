package pack01_base;

public class Ex06_MethodMain {
	public static void main(String[] args) {
		Ex06_Method em = new Ex06_Method();
		em.method1();//void
		em.method2("testData");//void
		em.isMethod3();//boolean
		em.isMethod4(10);//boolean
		//메소드에 리턴타입이 주어지면 해당하는 타입의 변수라고 봐도 됨.
		//메소드에 리턴타입이 없으면 아무타입도 아님.(실행후없어지는 코드 블럭)
		boolean isMethod = em.isMethod3();
		System.out.println(isMethod);
		//System.out.println(em.method1());//void
		System.out.println(em.isMethod3());//boolean
		
		//조건식 핵심 : true or false 일것
		boolean isBoolean = 1 < 2 ;
		if(em.isMethod3()) {//메소드 결과가 true일때 또는 false일때에 따라서 if와 else 블럭 실행여부가 바뀜
			
		}else {
			
		}
		System.out.println(em.dMethod()+3.2);
		System.out.println(em.aMethod()[0]);// 0번 인덱스에 있는 0을 출력하고싶음.
		System.out.println(em.sMethod());
		
		em.method2(null);
		
		
	}
}
