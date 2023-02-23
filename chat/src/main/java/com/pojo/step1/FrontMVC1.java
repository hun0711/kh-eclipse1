package com.pojo.step1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FrontMVC1 extends HttpServlet {
	Logger logger = Logger.getLogger(FrontMVC1.class);
	
	protected void doService(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		logger.info("doService호출");
		String uri = req.getRequestURI();
		logger.info(uri); // /dept/getDeptList.st1
		String context = req.getContextPath(); // /*/* -> server.xml
		logger.info(context);
		String command = uri.substring(context.length()+1);
		System.out.println(command); // dept/getDeptList.st1
		int end = command.lastIndexOf("."); //16
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
		req.setAttribute("upmu", upmu);
		if("dept".equals(upmu[0])) {
			//인스턴스화 -> execute() 호출하려구 -> 안하면 널포인트익셉션 -> 500번
			deptController = new DeptController(); 
            af = deptController.execute(req,res); 
            //deptController는 서블릿이 아니라서 req와 res를 톰캣으로부터 주입받을 수 없다.
            //왜냐하면 httpservlet을 상속받지않아서
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
		doService(req,res);
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doService(req,res);
	
	}

}
