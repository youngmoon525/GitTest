package pack01.list;

import java.util.ArrayList;
import java.util.List;

public class Ex01_List {
	public static void main(String[] args) {
		//Collection Framework
		//Collection : 자료를 수집해서 가지고 있을수있는 기능을가진 자료구조( 클래스 , 배열 )
		//FrameWork : 어떤 목적이나 기능을 미리 쉽게 사용하게 만들어놓은것(복잡)ex)밥짓기vs햇반
		//List<Extends Object> list = new ...<>();
		//List는 Object를 상속받은 객체 타입만 데이터를 수집하게 해놓음.( 클래스 )
		//List< 묶을 데이터타입 (DTO) > list = new 자료구조타입(...);
		//List<E> 에서 E는 요소 ( Element ) : 어떤 내용이 내부에 묶여서 저장 될지
		String[] arrStr = new String[1];
		arrStr[0] = "aa";
		arrStr[0] = new String("aa");
		
		
		String listInner = "java1";
		arrStr[0] = listInner ;
		List<String> list = new ArrayList<String>();//ArrayList는 Ex03~04사용예정
		list.add(listInner);//List가 String타입을 묶어놓기로 약속이 되어있기때문에 String만 요소로 넣을수있음.
		list.add(new String("abcd"));
		list.add("Java3");
		list.add("Java4");
		list.add("Java5");
		list.add("Java6");
		list.add(3, "끼워넣기");//결과 예측 :  용어 : 메소드가 파라메터나 타입다르고 똑같은 이름가진것
										  //잘 사용안함 ( DB에서 정렬해온 정보가 정합성을 가지고있기때문)
	//	System.out.println(list.size());//배열은 arr.length라는 변수로 크기를 받아올수있음.
	//	System.out.println(list.get(0));//list도 배열과 마찬가지로 0부터시작해서 크기-1까지의 index를가짐
	//	System.out.println(list.get(1));//list도 배열과 마찬가지로 0부터시작해서 크기-1까지의 index를가짐
		
		for(int i = 0 ; i < list.size() ; i ++ ) {
			System.out.println(list.get(i));
		}
		
		//list의 내용을 for문을 이용해서 전부 출력해보기. ( ex 1차원 배열 내용 출력 : ? )
		
		
		
	}
}
