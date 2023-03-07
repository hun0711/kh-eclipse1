package com.pojo.step3;

import org.apache.log4j.Logger;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	Logger logger = Logger.getLogger(ViewResolver.class);
   public ViewResolver() {}
   public ViewResolver(HttpServletRequest req, HttpServletResponse res, String[] pageMove) //요청받은걸 응답할때 pageMove 필요함
   throws ServletException, IOException
   {
	   String path = pageMove[1];
		//webapp 바라본다.
		if ("redirect".equals(pageMove[0])) {
			res.sendRedirect(path);
		} else if ("forward".equals(pageMove[0])) {
			RequestDispatcher view = req.getRequestDispatcher("/" + path + ".jsp");
			view.forward(req, res);
	    //setViewName(~~~);
		//WEB-INF/view/~~~.jsp
		} else {
			logger.info("else");
			path = pageMove[0] + "/" + pageMove[1];
			RequestDispatcher view = req.getRequestDispatcher("/WEB-INF/view/" + path + ".jsp");
			view.forward(req, res);
		}
   }
}
