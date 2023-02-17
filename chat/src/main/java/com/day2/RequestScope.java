package com.day2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
// http://localhost:9000/day2/a로 요청을 하면 RequestScope 서블릿 클래스의 doGet 메소드가 호출되고
// doGet 메소드 안에서 27번의 sendRedirect대신에
// forward 메소드가 호출되므로 주소는 그대로 http://localhost:9000/day2/a를 가리키고 있는데
// 실제 출력 페이지는 http://localhost:9000/day2/b.jsp를 찾고 있다.
// 이것이 sendRedirect("b.jsp")로 이동할 때와 forward로 이동할 때 차이점이다.
// sendRedirect로 페이지 이동시에는 값을 유지하려면 쿠키나 세션을 사용해야 하지만
// forward로 이동시에는 forward메소드 호출시 첫번째 파라미터인 request 객체에 담아서
// 넘길(유지시킬) 수 있다.
@WebServlet("/day2/a")
public class RequestScope extends HttpServlet {
 Logger logger = Logger.getLogger(RequestScope.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    logger.info("doGet 호출");
	    Map<String,Object> rmap = new HashMap<>();
	    rmap.put("mem_id", "tomato");
	    req.setAttribute("rmap",rmap);
		RequestDispatcher view = req.getRequestDispatcher("b.jsp");
	 view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

}
