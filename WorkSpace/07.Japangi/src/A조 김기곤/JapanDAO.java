package project1;

import java.util.Scanner;

public class JapanDAO {
	void display(JapanDTO[] dtoArr, JapanDTO dto) {// 남은 음료 보여주기
		for (int i = 0; i < dtoArr.length; i++) {
			System.out
					.println((i + 1) + ". " + dtoArr[i].name + " " + dtoArr[i].price + "원 " + dtoArr[i].count + "개 남음");

		}
		System.out.println("현재잔액: " + dto.money);
	}

	// ------------------------//

	void inputMoney(JapanDTO[] dtoArr, JapanDTO dto) {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("돈을 넣어주세요");

		while (true) {

			try {
				int inputMoney = Integer.parseInt(sc.nextLine());
				if (inputMoney < 0 || inputMoney % 10 != 0) {
					System.out.println("현금을 넣어주세요");
				} else {
					dto.money = dto.money + inputMoney;
					System.out.println(inputMoney + "원을 넣으셨습니다!");
					break;
				}
			} catch (Exception e) {
				System.out.println("현금을 넣으세요");
			}

		}

	}

	// ---------------------//

	void selectdrink(JapanDTO[] dtoArr, JapanDTO dto) {
		Scanner sc = new Scanner(System.in);

		display(dtoArr, dto);
		System.out.println();
		System.out.println("음료를 선택하세요");
		int selectDrink = Integer.parseInt(sc.nextLine());

		boolean isExit = false;

		while (dto.money < dtoArr[selectDrink - 1].price) {
			System.out.println("잔액("+ (dtoArr[selectDrink-1].price-dto.money)+"원)"+"이 부족합니다");
			System.out.println("돈 넣겠습니까?");
			System.out.println("1.O 2.X");
			int select = Integer.parseInt(sc.nextLine());
			if (select == 1) {
				inputMoney(dtoArr, dto);
				display(dtoArr, dto);
				System.out.println("음료를 고르세요");
				selectDrink = Integer.parseInt(sc.nextLine());
				continue;
			} else if (select == 2) {

				isExit = true;
				break;
			}
		}

		if (dtoArr[0].count == 0 && dtoArr[1].count == 0 && dtoArr[2].count == 0) {
			System.out.println("자판기에 물건이 다 떨어졌어요");
			isExit = true;
		}

		if (isExit) {

		} else {

			dtoArr[selectDrink - 1].count = dtoArr[selectDrink - 1].count - 1;

			while (dtoArr[selectDrink - 1].count == -1) {
				System.out.println("재고가 떨어졌어요");
				System.out.println(dtoArr[selectDrink - 1].name + " 말고 다른거 고르세요");
				dtoArr[selectDrink - 1].count = dtoArr[selectDrink - 1].count + 1;
				selectDrink = Integer.parseInt(sc.nextLine());
				dtoArr[selectDrink - 1].count = dtoArr[selectDrink - 1].count - 1;
			}

			System.out.println(dtoArr[selectDrink - 1].name + "가 나왔어요!");
			dto.japanMoney=dto.japanMoney+dtoArr[selectDrink-1].price;
			dto.money = dto.money - dtoArr[selectDrink - 1].price;

		}

	}

	// ---------------------//

	void coin(JapanDTO[] dtoArr, JapanDTO dto) {

		int[] coin = { 10, 50, 100, 500, 1000 };
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0;

		while (true) {
			if (dto.money >= 1000) {
				dto.money = dto.money - coin[4];
				count1 = count1 + 1;
			} else if (dto.money >= 500) {
				dto.money = dto.money - coin[3];
				count2 = count2 + 1;
			} else if (dto.money >= 100) {
				dto.money = dto.money - coin[2];
				count3 = count3 + 1;
			} else if (dto.money >= 50) {
				dto.money = dto.money - coin[1];
				count4 = count4 + 1;
			} else if (dto.money >= 10) {
				dto.money = dto.money - coin[0];
				count5 = count5 + 1;
			} else if (dto.money == 0) {
				break;
			}
		}
		System.out.println("1000원을 " + count1 + "장 반환합니다");
		System.out.println("500원을 " + count2 + "개 반환합니다");
		System.out.println("100원을 " + count3 + "개 반환합니다");
		System.out.println("50원을 " + count4 + "개 반환합니다");
		System.out.println("10원을 " + count5 + "개 반환합니다");
	}
	
	
	//------------------------관리자모드-------------------//
	
	
	void login(JapanDTO dto) {
		Scanner sc = new Scanner(System.in);
		while (true) {

			System.out.println("1. 로그인하기 2. 종료");
			
			int logSelect=0;
			try {
				logSelect = Integer.parseInt(sc.nextLine());
			}
			 catch (Exception e) {
				
			}

			if (logSelect == 1) {
				System.out.println("아이디를 입력하시오");
				String id = sc.nextLine();
				System.out.println("비밀번호를 입력하시오");
				String pw = sc.nextLine();

				if (id.equals("master") && pw.equals("admin")) {
					System.out.println("로그인에 성공하였습니다");
					dto.login=1;
					break;
				} else {
					System.out.println("아이디와 비밀번호가 일치하지 않습니다");
				}
			} else if (logSelect == 2) {
				System.out.println("관리자 모드 종료");
				break;
			}
			else {
				System.out.println("1~2를 입력해주세요");
			}

		}
	}
	
	
	//----------------------------------------//
	
	
	
	
	
	//-------------음료추가---------------------//
	
	void addDrink(JapanDTO[] dtoArr,JapanDTO dto) {
		Scanner sc = new Scanner(System.in);
		
		boolean isEixt=true;
		
		
		if(dtoArr[0].name.equals("X")&&dtoArr[1].name.equals("X")&&dtoArr[2].name.equals("X")) {
			System.out.println("채울 음료가 없습니다");
			isEixt=false;
		}
		
		if(isEixt) {
			
			System.out.println("몇번 음료를 채우시겠습니까?");
			System.out.println("1."+dtoArr[0].name+"2."+dtoArr[1].name+"3."+dtoArr[2].name);
			
		
	
			int addSelect= Integer.parseInt(sc.nextLine());
			
			while(dtoArr[addSelect-1].name.equals("X")) {
				System.out.println("빈 슬롯입니다. 다시 선택해주세요");
				
				for(int i=0;i<dtoArr.length;i++) {
					System.out.println(i+1+". "+dtoArr[i].name+" "+dtoArr[i].price+"원 "+dtoArr[i].count+"개 남음");
				}
				
				addSelect= Integer.parseInt(sc.nextLine());
			}
			
			while(addSelect<0||addSelect>3) {
				System.out.println("1~3을 입력해주세요");
				try {
					addSelect= Integer.parseInt(sc.nextLine());
				}
				catch (Exception e) {
					
				}
			}
				
				System.out.println("몇개 채우시겠습니까??");
				int addCount=Integer.parseInt(sc.nextLine());
				
				dtoArr[addSelect-1].count=dtoArr[addSelect-1].count+addCount;
				
				for(int i=0;i<dtoArr.length;i++) {
					System.out.println(i+1+". "+dtoArr[i].name+" "+dtoArr[i].price+"원 "+dtoArr[i].count+"개 남음");
				}
				
			
		}
		
		
	}
	
	
	///-----------------------음료 삭제------------------///
	
	void deleteDrink(JapanDTO[] dtoArr,JapanDTO dto) {
		Scanner sc = new Scanner(System.in);
		
		boolean isEixt=true;
		
		if(dtoArr[0].name.equals("X")&&dtoArr[1].name.equals("X")&&dtoArr[2].name.equals("X")) {
			System.out.println("삭제할 음료가 없습니다");
			isEixt=false;
		}
		
		if(isEixt) {
			
			System.out.println("삭제할 음료의 번호를 선택하세요");
			System.out.println("1."+dtoArr[0].name+"2."+dtoArr[1].name+"3."+dtoArr[2].name);
			
			int delete=Integer.parseInt(sc.nextLine());
			while(delete<1||delete>3){
				if(delete<1||delete>3) {
					System.out.println("1~3숫자를 입력해주세요");
					delete=Integer.parseInt(sc.nextLine());
				}
			}
			
			
			dtoArr[delete-1].name="X";
			dtoArr[delete-1].price=0;
			dtoArr[delete-1].count=0;
			
			for(int i=0;i<dtoArr.length;i++) {
				System.out.println(i+1+". "+dtoArr[i].name+" "+dtoArr[i].price+"원 "+dtoArr[i].count+"개 남음");
			}
		}
		}
		
		//------------------------음료 수정----------------------//
	
		void change(JapanDTO[] dtoArr, JapanDTO dto) {
			Scanner sc=new Scanner(System.in);
			
			
			System.out.println("몇번 음료를 수정하시겠습니까?");
			System.out.println("1."+dtoArr[0].name+"2."+dtoArr[1].name+"3."+dtoArr[2].name);
			
			int addSelect2 = Integer.parseInt(sc.nextLine());
			
			while(addSelect2<1||addSelect2>3) {
				System.out.println("1~3번을 고르세요");
				addSelect2 = Integer.parseInt(sc.nextLine());
			}

			System.out.println("무슨 음료로 바꾸시겠습니까?");
			String addDrink2 = sc.nextLine();
			System.out.println("가격은 얼마로 하시겠습니까?");
			int addPrice2 = Integer.parseInt(sc.nextLine());
			while(addPrice2<0||addPrice2%10!=0) {
				System.out.println("가격을 다시 설정해주세요");
				addPrice2=Integer.parseInt(sc.nextLine());
			}
			System.out.println("갯수는 몇개로 하시겠습니까?");
			int addCount2 = Integer.parseInt(sc.nextLine());

			dtoArr[addSelect2 - 1].name = addDrink2;
			dtoArr[addSelect2 - 1].price = addPrice2;
			dtoArr[addSelect2 - 1].count = addCount2;

			for (int i = 0; i < dtoArr.length; i++) {
				System.out.println(
						i + 1 + ". " + dtoArr[i].name + " " + dtoArr[i].price + "원 " + dtoArr[i].count + "개 남음");
			}
	}
	
	
	

}
