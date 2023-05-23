package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어떤글자.js <-로 끝나는 모든것들을 요청받게. => *.js
@WebServlet("*.js")
public class JstlController extends HttpServlet {
	// doGet , doPost <= Spring에서는 default로 두가지가 합쳐진 버전의 메소드를 활용을 한다.
	// service ( get , post 의 모든 요청을 받는 메소드 )
	RequestDispatcher rd ;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		//RequestDispatcher <= req객체가 요청을 받고나서 다시 새로운 페이지로 요청을 넘겨야할때.(Forward)사용
		//페이지를 보여줄지말지를 요청온 Mapping기준으로 분기 => list.js
		if(req.getServletPath().equals("/list.js")) {
			req.setAttribute("key1", "값1");//forward로 요청을 넘길때는 setAttribute를 통해 데이터 전달.
			req.setAttribute("key2", "값2");//forward로 요청을 넘길때는 setAttribute를 통해 데이터 전달.
			req.setAttribute("key3", "값3");//forward로 요청을 넘길때는 setAttribute를 통해 데이터 전달.
			req.setAttribute("v1", "val1");
			req.setAttribute("v2", "val2");
			req.setAttribute("v3", "val3");
			rd = req.getRequestDispatcher("jstl/list.jsp");//jsp,html페이지 경로를 써주는것
			//Model(MVC M ) : DAO DTO를 다음페이지로 넘겨주고 요청을 맡긴다.
		}else if(req.getServletPath().equals("/listdetail.js")){
			//form태그와 url로 넘어온 파라메터 => req.getParameter ( set x )
			//Controller에서 => jsp페이지로 넘어갈때 => req.getAttribute
			//paramter로 q_bbsCode라는 이름으로 값 1013이필요함.
			//listdetail.js는 글의 상세목록을 보여줄 예정이기때문. 이때 어떻게해야할까?
			System.out.println("리퀘스트로부터 요청받은 파라메터" + req.getParameter("q_bbsCode"));
			System.out.println("조회를 할때 , list.jsp=>listdetail로 갈때 ");
			System.out.println("게시글 번호 => select를 하기위해서 ");
			req.setAttribute("selectOne", "글의 상세 정보"+req.getParameter("q_bbsCode"));
			// 문자열을 저장할수있는 ArrayList를 만들고 데이터를 10건 넣어보기.
			ArrayList<String> list = new ArrayList<>();
			for(int i = 0 ; i < 10 ; i ++) {				
				list.add("A"+i);
			}
			req.setAttribute("strList", list);
			
			rd = req.getRequestDispatcher("jstl/listdetail.jsp");
		}else {
			rd = req.getRequestDispatcher("error/list.jsp");//나중에 추가예정KYM(20230523)->20230526
		}
		
		
		rd.forward(req, resp);//jsp페이지로 모든 정보를 넘기고 처리를 떠맡긴다.
		
	}
	

}
