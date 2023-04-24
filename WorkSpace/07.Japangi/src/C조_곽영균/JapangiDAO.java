import java.util.Scanner;

public class JapangiDAO {
	Scanner sc = new Scanner(System.in);
	
	public void display(JapangiDTO[] dtoArr){
		int coin = 0;
		int select = 0;
		int retry=0;
		for(int i=0; i<dtoArr.length; i++) {
			System.out.println((i+1)+"." +dtoArr[i].menu +"  "+dtoArr[i].price+"원 "+" 재고:"+dtoArr[i].count+"개");
		}System.out.println();
		
			System.out.println("========금액 입력=========");
			coin = Integer.parseInt(sc.nextLine());
			if(coin%10==0 && coin>0) {
				System.out.println("현재 머니 : "+ coin+ "원");
				System.out.println();
			}else {
				System.out.println("오류!");
				return;
			}	
			System.out.println("음료숫자 입력바람");
			select = Integer.parseInt(sc.nextLine())-1;
			try {
				System.out.println(dtoArr[select].menu +" "+ dtoArr[select].price+"원");		
			}catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("돌아가세요.");
				return;
			}
			
			if(coin>dtoArr[select].price) {
				System.out.println(dtoArr[select].menu+" 나왔음");
				System.out.println(dtoArr[select].menu+" 남은 재고:"+--dtoArr[select].count);
				
			}else {
				System.out.println(-(coin-dtoArr[select].price)+"원 부족함");
				return;
			}
			System.out.println("계속 구매하기 1, 금액 추가하기 2, 잔돈 반환하기 3");
			retry = Integer.parseInt(sc.nextLine()); 
			if(retry == 1) {
				continue;	
			}else if (retry==2) {
				System.out.println("추가할 금액 입력");
				int money = Integer.parseInt(sc.nextLine());
				coin += money;
				System.out.println("금액이 추가되었습니다 : "+coin);
		
			}else if (retry==3) {
				System.out.println("종료");
				System.out.println("잔돈 : "+(coin-dtoArr[select].price)+"원");
				return;	
	}
	}

	}

	
	
	
	

