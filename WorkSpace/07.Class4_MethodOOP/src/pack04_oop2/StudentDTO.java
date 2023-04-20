package pack04_oop2;

public class StudentDTO {
	// 메소드나 변수 앞에 접근제한자라는것을 사용하면 , 외부에서의 접근을 제한할수있다.
	// public , protected , default , private

	// 지금 사용할것 : public(공공,공개된) , private(공개되지않은 , 사적인)
	// public : 같은 프로젝트 내에서 접근 가능
	// default : 같은 패키지 내에서 접근 가능
	// private : 같은 클래스 내부에서만 접근 가능

	private int num;
	private String name;
	// score1~3 => sum , avg ( 총합 , 평균 )
	// 외부에서 score1을 변수에 접근해서 변경한경우 데이터의 신뢰가 없어짐(정합성)

	// getter & setter
	// 변수이름앞에 get을 붙이고 뒤에 변수이름 첫번째 글자를 대문자로 바꾼형태로,
	// 외부에서의 접근이 막혀있는 변수를 메소드를 통해서 접근 가능하게 만드는 구조.
	// score1=> getScore1()메소드 => score1에 들어있는 값을 리턴해줌
	// setScore1(int score1) => score1에 값을 변경해줌
	private int score1, score2, score3, sum;
	private double avg;

	// 전체 필드는 외부에서 접근이 불가능한 변수(완)
	// 방금 했던 코드 자동완성 기능으로 getter & setter 만들어보기.
	// StudentMain 과 StudentDAO에서 발생하는 오류를 해결해보기.(빨간줄)

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore1() {
		return score1;
	}

	public void setScore1(int score1) {
		this.score1 = score1;
		
		this.sum = this.score1 + this.score2 + this.score3;
		this.avg = (double) this.sum / 3;
	}

	public int getScore2() {
		return score2;
	}

	public void setScore2(int score2) {
		this.score2 = score2;
		
		this.sum = this.score1 + this.score2 + this.score3;
		this.avg = (double) this.sum / 3;
	}

	public int getScore3() {
		return score3;
	}

	public void setScore3(int score3) {
		this.score3 = score3;
		
		this.sum = this.score1 + this.score2 + this.score3;
		this.avg = (double) this.sum / 3;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public StudentDTO(int num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	public StudentDTO(int num, String name, int score1, int score2, int score3) {
		this.num = num;
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
		this.sum = this.score1 + this.score2 + this.score3;
		this.avg = (double) (this.score1 + this.score2 + this.score3) / 3;
	}
}
