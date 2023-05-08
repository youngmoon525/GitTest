package pack01.list;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	//1
	public List<BoardDTO> getList() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		list.add( new BoardDTO(1, "제목1", "내용1"));
		list.add( new BoardDTO(2, "제목2", "내용2"));
		list.add( new BoardDTO(3, "제목3", "내용3"));
		
		return list ;
	}
	//2
	public void getDisplay(List<BoardDTO> list) {
		for( BoardDTO dto : list) {
			System.out.print(dto.getBoardNum());
			System.out.print(dto.getBoardTitle());
			System.out.println(dto.getBoardCotent());
		}
	}
	public void intMethod(int x) {
		System.out.println(x);
	}
	
	
}
