<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Map" %>
<%
//테스트 시나리오
//서블릿을 경유하여 forward메소드 호출의 결과 페이지로 b.jsp가 출력될 때
// rmap이 null이 아니므로 주의할 것
//즉 b.jsp페이지를 직접 호출하면 출력값은 null이 될 것이다.
 Map<String,Object> rmap = (Map<String,Object>)request.getAttribute("rmap");
 out.print(rmap.get("mem_id")); //NullPointerException 발생함
%>
<hr>
<!-- 익스프레션으로 출력하기 -->
<%= rmap.get("mem_id") %>
<!-- 
  200번 - 성공
  300번 - 재요청으로 인한 상수값
  400번 - 클라이언트측 실수 에러
  500번 - 서버에러임
 -->