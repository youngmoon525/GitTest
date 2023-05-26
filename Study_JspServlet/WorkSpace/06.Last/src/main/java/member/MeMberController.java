package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.mem")
public class MeMberController extends HttpServlet {
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		
		if(req.getServletPath().equals("/member/loginpage.mem")) {//
			rd = req.getRequestDispatcher("login.jsp");
		}else if (req.getServletPath().equals("/member/login.mem")) {
			System.out.println(req.getParameter("id"));
			System.out.println(req.getParameter("pw"));
			String id = req.getParameter("id");
			String pw = req.getParameter("pw");
			if(id.equals("kym") && pw.equals("1234")) {
				resp.getWriter().print("A");
			}else {
				resp.getWriter().print("");
			}
			
			return;
		}else {//에러페이지 넣기.
			
		}
		rd.forward(req, resp);
	}
}
