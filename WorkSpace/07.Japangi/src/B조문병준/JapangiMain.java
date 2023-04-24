package test;

import java.util.Scanner;

public class JapangiMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		JapangiDAO dao = new JapangiDAO();
		String[] nameArr = { "콜라", "사이다", "환타", null, null, null };
		int[] priceArr = { 800, 1100, 500, 0, 0, 0 };
		int[] cntArr = { 5, 6, 7, 0, 0, 0 };
		JapangiDTO dto = dao.initDTO(nameArr, priceArr, cntArr);

		String id;
		String pw;
		String inputNum;
		String manNum1;
		int totalMoney = 0;
		while (true) {
			System.out.println("1 : 관리자기능 ");
			System.out.println("2 : 음료수구매 ");
			System.out.println("3 : 종료 ");
			inputNum = sc.nextLine();

			if (inputNum.equals("1")) {
				System.out.println("관리자 기능에 접속하셨습니다.");
				while (true) {
					System.out.println("id를 입력해주세요" + " 초기메뉴로 돌아가시려면 0번을 입력해주세요.");
					id = sc.nextLine();
					if (id.equals("0")) {
						break;
					}
					System.out.println("pw를 입력해주세요");
					pw = sc.nextLine();
					if (id.equals("master") && pw.equals("admin")) {
						System.out.println("관리자 기능에 접속합니다.");
						dao.display(dto);
						while (true) {
							System.out.println("원하는 기능을 선택해주세요");
							System.out.println("1번 음료추가");
							System.out.println("2번 음료수정");
							System.out.println("3번 음료삭제");
							System.out.println("0번 초기화면으로 돌아가기");
							manNum1 = sc.nextLine();
							if (manNum1.equals("1")) {
								dao.addBev(dao, dto);
							} else if (manNum1.equals("2")) {
								dao.corBev(dao, dto);
							} else if (manNum1.equals("3")) {
								dao.delBev(dao, dto);
							} else if (manNum1.equals("0")) {
								break;
							} else {
								System.out.println("정상적인 숫자만 입력해주세요.");
								continue;
							}
						}
						break;
					} else {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
				}
			} else if (inputNum.equals("2")) {
				System.out.println("음료수 구매를 선택하셨습니다");
				dao.display(dto);
				System.out.println("9번을 입력시 음료수 구매로 넘어갑니다.");
				System.out.println("0번을 입력시 투입하신 금액을 반환하고 초기화면으로 돌아갑니다.");
				totalMoney = dao.buyBev();
				if (totalMoney == -1) {
					continue;
				}

				System.out.println("원하시는 음료수를 선택해주세요");
				System.out.println("0번을 입력시 잔돈을 반환 후 초기화면으로 돌아갑니다.");
				totalMoney = dao.changeMoney(dto, totalMoney);
			}

			else if (inputNum.equals("3")) {
				System.out.println("종료합니다.");
				break;
			} else {
				System.out.println("잘못입력하셨습니다. 다시입력해주세요.");
			}
		}

	}
}
