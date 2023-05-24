package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kym.KymDAO;

@WebServlet("*.bat") // 어떤이름문자열아무거나 상관없음 뒤에가 .bat로 끝나는 문자열이면 이클래스의 메소드를 실행함
public class MybatisController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("아무글자");
		KymDAO dao = new KymDAO();
		dao.test();
	}
}
