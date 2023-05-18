package pack.url;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03_GetPost")
public class Ex03_GetPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	// public String method(String txt1){
	
	//}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqTxt = request.getParameter("txt1");
		System.out.println(reqTxt);
		response.getWriter().append(" GET KYM ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqTxt = request.getParameter("txt1");
		System.out.println(reqTxt);
		response.getWriter().append(" POST KYM ").append(request.getContextPath());
	}

}
