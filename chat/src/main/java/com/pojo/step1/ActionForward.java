package com.pojo.step1;

public class ActionForward {
	//페이지 이동 방법
	//1.res.sendRedirect("XXX.jsp") - 표준서블릿 - mvc 패턴이 아님!!
	//or res.sendRedirect("dept/getDeptList.kh") - 서블릿이 요청을 받음 - mvc패턴인가?
	//jsp가 요청을 받는 것이 왜 문제인가? - WAS마다 명명규칙이 다르다. 그래서 인스턴스화를 할 수 없다.
	//또한 인스턴스화를 한다 하더라도 request와 response 객체를 주입받지 못하는 문제가 있다. -> mime type을 못 정한다!!
	//*mime type을 결정하는건 응답객체 response이다 (doGet이나 doPost 메소드의 파라미터로 주입된다)
	
  private String path = null; //응답페이지 이름 또는 서블릿의 이름
  //sendRedirect로 페이지를 이동할 것인지 아니면
  //forward로 페이지를 이동할 것인지 여부를 결정함
  private boolean isRedirect = false; //true:redirect(insert | update | delete) , false:forward(select)
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public boolean isRedirect() {
	return isRedirect;
}
public void setRedirect(boolean isRedirect) {
	this.isRedirect = isRedirect;
}
}

/*
ActionForward 클래스를 왜 만드나?
웹 서비스에서는 main메소드 대신에 URL로 요청을 보낸다
누가? 클라이언트가
누구에게? Tomcat 서버에게 요청한다.
요청을 할 때 URL을 사용한다.
*/