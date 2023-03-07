package com.pojo.step3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pojo.step2.Board2Controller;

public class ActionSupport extends HttpServlet {
	 Logger logger = Logger.getLogger(ActionSupport.class);
		protected void doService(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

			logger.info("doService호출");
			String uri = req.getRequestURI(); // 주소창에 입력된 값 중 도메인과 포트번호가 제외된 값만 담음
			logger.info(uri); //
			String context = req.getContextPath(); // /*/* -> server.xml
			logger.info(context); //
			String command = uri.substring(context.length() + 1); // context 정보만 제외된 나머지 경로 정보 담음
			int end = command.lastIndexOf("."); // 16 - st1 잘라내기 위해 사용
			command = command.substring(0, end); // dept/getDeptList
			String upmu[] = null; // upmu[0] = 업무명|폴더명 , upmu[1] = 요청기능이름
			upmu = command.split("/"); //
			logger.info(upmu[0] + "," + upmu[1]);
			req.setAttribute("upmu", upmu);
			Object obj = "";
			try {
				obj = HandlerMapping.getController(upmu,req,res);
			}catch(Exception e){
				logger.info("Exception : " + e.toString());
			}
			if (obj != null) { // redirect:XXX.jsp or forward:XXX.jsp
				String pageMove[] = null;
				ModelAndView mav = null;
				if (obj instanceof String) {
					if (((String) obj).contains(":")) {
						logger.info(":포함O");
						pageMove = obj.toString().split(":");
					} else {
						logger.info(":포함X");
						pageMove = obj.toString().split("/");
					}
				}else if(obj instanceof ModelAndView){
					mav = (ModelAndView)obj;
					pageMove = new String[2];
					pageMove[0] = ""; //forward -> ViewResolver else if() 타게됨 ->  webapp
					pageMove[1] = mav.getViewName();
				}
				if (pageMove != null) {
					// pageMove[0] = redirect or forward
					// pageMove[1] = xxx.jsp
					new ViewResolver(req, res, pageMove);
					
				}
			} // end of 페이지 이동처리에 대한 공통 코드 부분

		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("doGet 호출"); // 브라우저의 주소창을 통해 요청하는 건 모두 get방식이다 - doGet() 호출
			doService(req, res);

		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("doPost 호출");
			doService(req, res);
		}
		}
	


