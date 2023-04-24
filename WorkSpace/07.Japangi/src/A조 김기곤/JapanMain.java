package project1;

import java.util.Scanner;

public class JapanMain {
	public static void main(String[] args) {
		JapanDAO dao = new JapanDAO();
		JapanDTO dto = new JapanDTO();
		Scanner sc = new Scanner(System.in);

		JapanDTO[] dtoArr = new JapanDTO[3];
		dtoArr[0] = new JapanDTO("콜라", 800, 8);
		dtoArr[1] = new JapanDTO("사이다", 1000, 5);
		dtoArr[2] = new JapanDTO("환타", 900, 1);

		

		while (true) {
			
			int modeSelect = 0;
			
			try {
				
				System.out.println("1. 관리자모드 2. 사용자모드 3.종료");
				modeSelect = Integer.parseInt(sc.nextLine());
			}
			catch (Exception e) {
				
			}
			
			if (modeSelect == 1) {
				
				dao.login(dto);
				
				if(dto.login==1) {
					
					while(true) {
						
						System.out.println();
						System.out.println("1.목록보기");
						System.out.println("2.음료추가하기");
						System.out.println("3.음료삭제하기");
						System.out.println("4.음료수정하기");
						System.out.println("5.종료");
						
						int adminSelect=0;
						
						try {
							adminSelect = Integer.parseInt(sc.nextLine());
						}
						catch (Exception e) {
							System.out.println("1~5를 입력해주세요");
						}
						
						
						if (adminSelect == 1) {
							for (int i = 0; i < dtoArr.length; i++) {
								System.out
										.println((i + 1) + ". " + dtoArr[i].name + " " + dtoArr[i].price + "원 " + dtoArr[i].count + "개 남음");

							}
							System.out.println("자판기 안에 "+dto.japanMoney+"원 들어있습니다");

						} else if (adminSelect == 2) {
							dao.addDrink(dtoArr, dto);
						} else if (adminSelect==3) {
							dao.deleteDrink(dtoArr, dto);
						} else if (adminSelect==4) {
							dao.change(dtoArr, dto);
						} else if (adminSelect==5) {
							System.out.println("종료합니다");
							break;
						}
					}
					
				}
				
				
				
				
				
				
				
			} else if (modeSelect == 2) {
				
				dao.display(dtoArr, dto);

				dao.inputMoney(dtoArr, dto);
				
				while (true) {
					
					

					System.out.println();
					dao.display(dtoArr, dto);

					System.out.println();
					System.out.println("번호를 선택하세요");
					System.out.println("1. 음료 선택");
					System.out.println("2. 돈 더 넣기");
					System.out.println("3. 종료(잔돈반환)");

					int selectNum = Integer.parseInt(sc.nextLine());

					if (selectNum == 1) {
						dao.selectdrink(dtoArr, dto);

					} else if (selectNum == 2) {
						dao.inputMoney(dtoArr, dto);
					}

					else if (selectNum == 3) {
						dao.coin(dtoArr, dto);
						break;
					} else {
						System.out.println("1~3번 숫자를 입력해주세요");
					}
				}

			}else if(modeSelect==3) {
				System.out.println("종료");
				break;
			}else {
				System.out.println("1~3숫자를 입력해주세요");
			}
		}

	}
}
