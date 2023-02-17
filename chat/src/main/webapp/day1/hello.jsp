<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="f_test" method="post" action="/day1/hello.kh">
<!-- 전송 버튼에 대한 이벤트 처리가 없는 요청이 서버에 전달되는 이유는 뭘까요 ?? 버튼은 submit이므로 페이지가 이동됨!!
버튼이 아닌 경우는 이벤트리스너를 걸거나 submit을 붙이지 않는 이상 이동하지 않는다!! -->
<!--  <button>전송</button> 페이지 이동된다-->
<input type="button" id="btnSend" value="전송">
<script type="text/javascript">
 const btnSend = document.querySelector("#btnSend");
 btnSend.addEventListener('click',() => {
	 alert("전송 버튼 클릭")
	 document.querySelector("#f_test").submit();
 })
</script>
</form>
</body>
</html>