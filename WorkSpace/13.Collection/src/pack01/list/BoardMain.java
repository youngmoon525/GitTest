package pack01.list;

import java.util.List;

//4
public class BoardMain {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.getList();
		dao.getDisplay(list);
		
		dao.intMethod(10);
	}
}
