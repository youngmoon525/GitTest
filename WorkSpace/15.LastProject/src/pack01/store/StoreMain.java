package pack01.store;

public class StoreMain {
	public static void main(String[] args) {
		StoreDAO dao = new StoreDAO();
		boolean isTrue = dao.getConn();
		while(isTrue==true) {
			System.out.println("=====재고관리시스템=====");
			System.out.println("1.물품확인");
			System.out.println("2.제품추가");
			System.out.println("3.물품정보수정");
			System.out.println("4.물품삭제");
			System.out.println("0.종료");
			System.out.println("=======================");
			int selectNum = dao.selectNum();
			if(selectNum==1) {
				dao.displayList();
			}
			else if(selectNum==2) {
				dao.addList();
			}
			else if(selectNum==3) {
				dao.updateList();
			}
			else if(selectNum==4) {
				dao.delete();
			}
			else if(selectNum==0) {
				break;
			}
			else {
				System.out.println("다시입력해주세요");
			}
		}
		
	}
	
	
	
}
