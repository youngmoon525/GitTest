package japangi;

import java.util.Scanner;

public class japangiDAO {

	void display(japangiDTO dto) {
		for (int i = 0; i < dto.getDri().length; i++) {
			if (dto.getDri()[i] == null) {

				System.out.println(i + 1 + "비어있음" + dto.driCost[i] + "원" + dto.driCount[i] + "개");
			} else {

				System.out.println(i + 1 + "번" + dto.dri[i] + "" + dto.driCost + "원" + dto.driCount[i] + "개");

			}
		}

	}

	japangiDTO initDTO(String[] nameArr, int[] priceArr, int[] cntArr) {
		japangiDTO dto = new japangiDTO();
		for (int i = 0; i < nameArr.length; i++) {
			dto.setDri(i, nameArr[i]);
		}
		for (int i = 0; i < priceArr.length; i++) {
			dto.setDriCost(i, priceArr[i]);
		}
		for (int i = 0; i < cntArr.length; i++) {
			dto.setDriCount(i, cntArr[i]);
		}
		return dto;

	}

	void addDri(japangiDAO dao, japangiDTO dto) {
		Scanner sc = new Scanner(System.in);
		int manAddNum1;
		int manSelNum1;
		int manSelNum2;
		String addDri;
		System.out.println("1번 음료추가 선택");
		System.out.println("최대 6종류의 음료를 보관할 수 있음.");
		dao.display(dto);

		while (true) {
			System.out.println("추가하려는 음료칸의 번호를 적어라");
			System.out.println("0번을 입력하면 이전 화면으로 돌아간다");
			try {
				manAddNum1 = Integer.parseInt(sc.nextLine());
				if (manAddNum1 == 0) {
					break;
				}

				if (manAddNum1 < 0 || manAddNum1 > 6) {
					System.out.println("음료추가가 불가능합니다. 정상적인 슬롯을 골라주세요.");
					continue;
				}
				if (dto.getDri()[manAddNum1 - 1] == null) {
					System.out.println("음료 추가 기능");
					System.out.println("추가하실 음료의 이름을 입력해주세여");
					addDri = sc.nextLine();
					dto.setDri(manAddNum1 - 1, addDri);
					System.out.println("추가하신 음료의 개수를 입력하세여");
					manSelNum1 = Integer.parseInt(sc.nextLine());
					dto.setDriCount(manAddNum1 - 1, manSelNum1);
					System.out.println("추가하신 음료의 가격을 입력하세요");
					manSelNum2 = Integer.parseInt(sc.nextLine());
					dto.setDriCost(manAddNum1, manSelNum2);
					System.out.println("음료 추가가 완료되었습니다.");
					dao.display(dto);
					continue;
				} else {
					System.out.println("음료 추가가 불가능합니다. 다른 번호를 골라주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력하소");
			}
		}
	}

	void corDri(japangiDAO dao, japangiDTO dto) {
		Scanner sc = new Scanner(System.in);
		int corNum1;
		int manSelNum1;
		int manSelNum2;
		String addDri;
		System.out.println("2번 음료 수정");
		dao.display(dto);
		while (true) {
			System.out.println("수정할 음료의 번호를 골라라");
			System.out.println("0번 입력시 이전 화면으로 돌아감");
			try {
				corNum1 = Integer.parseInt(sc.nextLine());
				if (corNum1 == 0) {
					break;
				}
				if (corNum1 < 0 || corNum1 > 6) {
					System.out.println("음료 추가 불가능 재입력");
					continue;
				}
				if (dto.getDri()[corNum1 - 1] != null) {

					System.out.println("음료 수정 가능");
					System.out.println("수정할 음료의 이름을 입력해라");
					addDri = sc.nextLine();
					dto.setDri(corNum1 - 1, addDri);
					System.out.println("수정할 음료의 수량을 입력해라");
					manSelNum1 = Integer.parseInt(sc.nextLine());
					dto.setDriCount(corNum1, manSelNum1);
					System.out.println("수정할 음료의 가격을 입력해라");
					manSelNum2 = Integer.parseInt(sc.nextLine());
					dto.setDriCost(corNum1, manSelNum2);
					System.out.println("음료 수정 완료");
					dao.display(dto);
					continue;
				} else {
					System.out.println("음료 수정이 불가능합니다. 다른 슬롯을 골라주세요");
					continue;
				}
			} catch (Exception e) {
				System.out.println("숫자만 입력해라");
			}

		}
	}
	


	void delDri(japangiDAO dao, japangiDTO dto, Scanner sc) {
		Scanner scanner = new Scanner(System.in);
		int delNum1;
		System.out.println("3. 음료 삭제 선택");
		dao.display(dto);
		while(true) {
			System.out.println("삭제할 음료수의 번호를 눌러주세요.");
			System.out.println("0번을 입력시 이전화면으로 돌아갑니다.");
			try {
				delNum1 = Integer.parseInt(sc.nextLine());
				if (delNum1 == 0) {
					break;
				}
				if (delNum1 < 0 || delNum1 > 6) {
					System.out.println("음료삭제가 불가능합니다. 정상적인 슬롯을 골라주세요.");
				}if(dto.getDri()[delNum1 -1] !=null) {
					dto.setDri(delNum1-1, null);
					dto.setDriCount(delNum1 -1 , null);
					dto.setDri(delNum1 - 1, null);
					System.out.println("음료 삭제가 완료되었습니다.");
					dao.display(dto);
					continue;
				}else {
					System.out.println("음료 삭제가 불가능합니다. 다시 확인하세요");
				}
			}catch(Exception e) {
				System.out.println("숫자만 입력해라");
			} 
		
	
	
	
	
	
	
	
	
	
	
	
			
	
	
			}
	
	
	
			}
			}
	
}
