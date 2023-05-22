package contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.MemberDAO;


@WebServlet("/jdbclogin") // mapping
public class Ex03_Request extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao이용해서 JDBC를 이용하여 로그인 처리
		MemberDAO dao = new MemberDAO();
		//dao.isLogin(request.getParameter("id"), request.getParameter("pw"));
		
		System.out.println(dao.isLogin(request.getParameter("id"), request.getParameter("pw")));
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
