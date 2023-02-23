<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,java.util.Map" %>
<%
String temp =
  (String)request.getAttribute("jsonDoc");
out.print(temp);
%>
