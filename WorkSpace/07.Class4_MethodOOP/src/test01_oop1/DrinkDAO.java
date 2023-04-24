package test01_oop1;

import java.util.Scanner;

import pack01_base.Const;

public class DrinkDAO {
	DrinkDTO[] drinkArr ;
	public DrinkDAO() {
		drinkArr = initDrinks();
	}
	
	// 음료목록을 가진 DrinkDTO[] 배열을 초기화 하는 메소드를 작성해보기.
	public DrinkDTO[] initDrinks() {
		DrinkDTO[] drinkArr = new DrinkDTO[3];
		drinkArr[0] = new DrinkDTO("콜라", 800, 7);
		drinkArr[1] = new DrinkDTO("사이다", 1000, 5);
		drinkArr[2] = new DrinkDTO("환타", 900, 1);
		return drinkArr;
	}

	public void display() {
		System.out.println("음료명\t가격\t개수");
		for (int i = 0; i < drinkArr.length; i++) {
			System.out.print((i + 1) + "." + drinkArr[i].getName() + "\t");// dto.
			System.out.print(drinkArr[i].getPrice() + "\t");// dto.
			System.out.print(drinkArr[i].getCnt());// dto.
			System.out.println();
		}
	}

	// 사용자가 숫자를 입력하게 하는 메소드.
	// 1.사용자는 숫자외에 값을 입력할수있음.=> 오류
	//
	public int inputInt() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				int rtnInt = Integer.parseInt(sc.nextLine());
				return rtnInt;
			} catch (Exception e) {
				System.out.println("숫자 값만 입력해주세요.");
			}
		}
	}

	// intputInt라는 메소드를 활용하면 int형 데이터만 입력을 받을수있음.
	// 이를 활용해서 2번 금액으로 인정되는 단위 입력만 되게 수정가능.
	// 2.금액으로 인정되는 단위만 입력해야함. 10,50,100,500,1000
	int[] coinArr = { 1000, 500, 100, 50, 10 };

	public int inputMoney() {
		while (true) {
			int money = inputInt();// 사용자는 무조건 숫자입력을함.
			int tempMoney = money;
			int charge = money;
			for (int i = 0; i < coinArr.length; i++) {
				tempMoney = charge / coinArr[i];
				charge = charge % coinArr[i];
				// System.out.println(coinArr[i] + "개수" + tempMoney + " " + charge);
				if (charge == 0) {
					break;
				}
			}
			if (charge != 0) {
				System.out.println(money + " 반환됨 금액입력을 다시해주세요.");
			} else {
				return money;
			}
		}
	}

	public int choiceMenu() {
		while (true) {
			int choice = inputInt();
			if (choice > 0 && choice <= drinkArr.length) {
				if(drinkArr[choice-1].getCnt() < 1) {
					System.out.println("음료의 재고가 없습니다. 다른 음료를 선택해주세요.");
					continue;
				}
				System.out.println(drinkArr[choice - 1].getName() + "주문됨");
				return choice;
			} else {
				System.out.println("잘못입력됨 1~ " + drinkArr.length + "까지만 선택 가능");
			}
		}
	}
	// money (입력된금액을 알아야함)
	// 얼마를 차감해야하는지 메뉴에 대한 정보가 있어야함
	// DTO한건을 받아와서 처리 => 
	// index를 받아와서 처리 
	// index , Arr을 받아와서 처리
	public int orderMenu(int choice , int money) {
		// 금액이 부족한 경우에는 ? 리턴 해줘야할까.
		if(money >= drinkArr[choice-1].getPrice()) {
			drinkArr[choice-1].setCnt( 
					drinkArr[choice-1].getCnt()-1
					);
			System.out.println(drinkArr[choice-1].getName() + " 주문완료");
			return money - drinkArr[choice-1].getPrice();
		}else {
			System.out.println(money + " 반환됨 금액부족 다시이용하세요");
			return -1;
		}
	}

}
