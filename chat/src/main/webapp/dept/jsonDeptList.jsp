<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map" %>
<%
//jsp페이지이지만 page directive에 마임타입을 application/json으로 되어 있어서
//브라우저는 이 페이지를 json 포맷으로 인지함
String temp =
  (String)request.getAttribute("jsonDoc");
out.print(temp);
%>
