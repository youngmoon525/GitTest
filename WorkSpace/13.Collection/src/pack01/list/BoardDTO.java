package pack01.list;

import java.util.ArrayList;

//3
public class BoardDTO { // 데이터베이스의 한행 
	private int boardNum ;
	private String boardTitle , boardCotent;
	
	
	
	public BoardDTO(int boardNum, String boardTitle, String boardCotent) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardCotent = boardCotent;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardCotent() {
		return boardCotent;
	}
	public void setBoardCotent(String boardCotent) {
		this.boardCotent = boardCotent;
	}
	
	
	
}
