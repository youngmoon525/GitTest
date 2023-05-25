package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.CustomerDAO;
import customer.CustomerVO;


@WebServlet("*.cu")//하나의 요청씩처리 /list.cu 
				   // 특정 규칙을 가진 구분자의 모든 처리 (cu) : '/'(x) , *.cu
				   //Servlet파일 추가 시 꼭 해야할것=> server restart
				  //페이지의 요청:RequestDispatcher<-
	
public class CustomerController extends HttpServlet {
	
	//rd==?
	RequestDispatcher rd;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mapping = req.getServletPath();
		CustomerDAO dao = new CustomerDAO();
		System.out.println(mapping);
		//detail.cu로 요청이 오면 detail.jsp로 페이지를 요청을 해보기.
		
		if(mapping.equals("/list.cu")) {
			List<CustomerVO> list = dao.listSelect();
			req.setAttribute("list", list);//jsp페이지에 조회 된 결과를 보내줌.
			rd = req.getRequestDispatcher("customer/list.jsp");
			System.out.println("list.jsp여는 처리를 넣어줌");
		}else if(mapping.equals("/detail.cu")) {
			// url또는 get post방식으로 servlet으로 오는 모든 데이터는 paramter(String)
			// req ( 요청 ) , response( 응답 ) 
			// req객체의 set&getAttribute , getParamter
			// getParameter : jsp또는html페이지에서 servlet(back)요청 ( a태그form url)
			// setAttribute,get : servlet 동작을 하고 데이터를 전송=>
			int id = Integer.parseInt(  req.getParameter("id") );
			//CustomerVO vo = dao.selectDetail(id);
			req.setAttribute("vo", dao.selectDetail(id));
			rd = req.getRequestDispatcher("customer/detail.jsp");
		}else if(mapping.equals("/update.cu")) {
			String id = req.getParameter("id");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			
			dao.update(id , email , phone);
		}else if(mapping.equals("/insert.cu")) {
			rd = req.getRequestDispatcher("customer/insert.jsp");
		}else if( mapping.equals("/new.cu")) {
			System.out.println(req.getParameter("id"));//<= 테스트 진행 시 key값이 중복안되게 입력하고 테스트
			CustomerVO vo = new CustomerVO();
			vo.setId(Integer.parseInt(req.getParameter("id")));
			vo.setName(req.getParameter("name"));
			vo.setEmail(req.getParameter("email"));
			vo.setPhone(req.getParameter("phone"));
			
			dao.insert(vo);
			
		}
		else {
			System.out.println("잘못된요청이기때문에 어떤 처리를 할지 생각해야함.");
		}
		
		rd.forward(req, resp);//실제로 페이지 요청 처리.
	}

}
