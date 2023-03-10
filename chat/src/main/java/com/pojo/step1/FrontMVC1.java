package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
//개발자가 정의한 서블릿 - 표준 서블릿이 아니다
//doService 메소드는 요청처리에 대한 창구를 일원화 하기 위해 개발자 정의한 메소드
//따라서 request 객체와 response 객체를 톰캣 서버로부터 주입 받을 수 없다
//이 문제 해결을 위해서 메소드 파라미터 자리를 이용하여 doGet이나 doPost 메소드에서 주입받은
//요청객체와 응답객체를 넘겨 받아서 사용함
public class FrontMVC1 extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC1.class);
	/*
	 * 이 메소드는 톰캣 서버로부터 직접 요청객체와 응답객체를 주입받을 수 없다
	 * 따라서 doGet메소드와 doPost메소드 안에서 doService메소드 호출 할 때 파라미터로 넘겨받음 
	 */
	protected void doService(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("doService호출");
		String uri = req.getRequestURI(); //주소창에 입력된 값 중 도메인과 포트번호가 제외된 값만 담음
 		logger.info(uri); // /dept/getDeptList.st1
		String context = req.getContextPath(); // /*/* -> server.xml
		logger.info(context);
		//http://localhost:9000/board/getBoardList.st1
		//http://localhost:9000/board/boardInsert.st1
		//http://localhost:9000/board/boardUpdate.st1
		//http://localhost:9000/board/boardDelete.st1
		String command = uri.substring(context.length()+1); //context 정보만 제외된 나머지 경로 정보 담음
		System.out.println(command); // dept/getDeptList.st1
		int end = command.lastIndexOf("."); //16 - st1 잘라내기 위해 사용
		System.out.println(end);//16출력
		command = command.substring(0,end); //dept/getDeptList
		System.out.println(command);
		String upmu[] = null; //upmu[0] = 업무명|폴더명 , upmu[1] = 요청기능이름
		upmu = command.split("/"); //dept,getDeptList
		for(String imsi:upmu) {
			System.out.println(imsi);
		}
		ActionForward af = null;
		//게으른 인스턴스화 
		//아직 결정되지 않음 - 업무명이 Controller클래스의 접두어이다
		DeptController deptController = null;
		EmpController empController = null;
		//request 객체는 저장소이다. - setAttribute , getAttribute
		//아래 코드는 request저장소에 upmu 배열의 주소번지 원본을 저장하는 구문
		req.setAttribute("upmu", upmu);
		if("dept".equals(upmu[0])) {
			//인스턴스화 -> execute() 호출하려구 -> 안하면 널포인트익셉션 -> 500번
			deptController = new DeptController(); 
			//deptController는 서블릿이 아니라서 req와 res를 톰캣으로부터 주입받을 수 없다.
			//왜냐하면 httpservlet을 상속받지않아서
			//그래서 파라미터로 doGet메소드가 주입받은 req와 res 주소번지 원본을 넘겨줌
            //이렇게 넘기지 않으면 DeptController에서는 req와 res 누릴 수 없다.
			//이런 이유로 메소드를 하나만 가질 수 있다. - 장애
			//다른 메소드를 정의하는 것은 자유이지만 req와 res는 주입받을 수 없다
			//입력,수정,삭제,조회 4가지 메소드가 필요함
            //DeptLogic 메소드 4가지를 호출해야 하는데 upmu[1]방에 정보가 필요하다
			af = deptController.execute(req,res); 
		}
		else if ("emp".equals(upmu[0])) {
			empController = new EmpController();
			af = empController.execute(req, res);
		}
		//페이지 이동 처리 공통코드 만듦
		//1.res.sendRedirect("/dept/getDeptList.jsp"); // jsp->서블릿->jsp
		//  res.sendRedirect("/dept/getDeptList.st1"); //jsp->서블릿->서블릿->jsp
		if (af != null) {
			if(af.isRedirect()) {
				res.sendRedirect(af.getPath());
			}else {
				RequestDispatcher view = req.getRequestDispatcher(af.getPath());
				view.forward(req, res);
				
			}
		}// end of 페이지 이동처리에 대한 공통 코드 부분
	}//end of doService
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("doGet 호출"); //브라우저의 주소창을 통해 요청하는 건 모두 get방식이다 - doGet() 호출
		doService(req,res);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("doPost 호출");
		doService(req,res);
	
	}

}
