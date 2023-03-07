<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.book.scope.Sonata" %>    
<%
Sonata myCar = (Sonata)request.getAttribute("myCar");
String oMyCar = request.getParameter("oMyCar");
Sonata herCar = (Sonata)request.getAttribute("herCar");
String oHerCar = request.getParameter("oHerCar");
Sonata yourCar = (Sonata)session.getAttribute("yourCar");
String oYourCar = request.getParameter("oYourCar");

out.print("객체가 유지되나요?");
out.print("<hr>");
out.print(myCar + "," + oMyCar.concat("1")+"자동차".concat("1"));
out.print("<hr>");
out.print(herCar + "," + oHerCar.indexOf(3));
out.print("<hr>");
out.print(yourCar + "," + oYourCar.charAt(2));
%>