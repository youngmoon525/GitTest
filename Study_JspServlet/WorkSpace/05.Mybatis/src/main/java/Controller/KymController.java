package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kym.KymVO;

@WebServlet("*.kym")
public class KymController extends HttpServlet {
	RequestDispatcher rd;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getServletPath());
		if (req.getServletPath().equals("/list.kym")) {
			ArrayList<KymVO> list = new ArrayList<>();
			// <><- Object를 상속받은 Class타입만 넣을수있음.
			for (int i = 0; i < 10; i++) {
				KymVO vo = new KymVO();
				vo.setField1("필드1" + i);
				vo.setField2(10 + i);
				list.add(vo);
			}
			req.setAttribute("list", list);
			rd = req.getRequestDispatcher("kym/list.jsp");

		} else {
			System.out.println("잘못된요청!");
		}
		rd.forward(req, resp);
	}
//	public boolean add(String e) {
//		return false;
//	}

//	public boolean add(KymVO e) {
//		return false;
//	}

}
