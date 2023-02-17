<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
     <script>
     const autoReload = () => {
    	 console.log('autoReload 호출')
    	 //ajax 함수는 jquery.min.js가 제공하는 api이다.
    	 //ajax 함수는 결국 XMLHttpRequest();
    	 //const ajax = new XMLHttpRequest();
    	 //ajax.open('GET',url,true) false는 동기 true는 비동기 ajax를 쓰는 이유는 비동기임
    	 //ajax.send()
         $.ajax({
             type: "GET",
             url: "newsList.jsp",
             success:function (data) { //성공했을 때
               $("#d_news").html(data);
             },
             error:function(request, status, error){
            	 console.log('error')
            	 console.log('error' + request.status)
            	 console.log('error' + request.responseText)
             }
           });
     }
    </script>
</head>
<body>
 <script type="text/javascript">
autoReload();
 //호출하지 않아도 자동 실행
 // jquery(document)
 // window <- document <- ready(function(){실행문:변수선언,if문,switch문,i+j}) 함수//
  $(document).ready(() => {
	 //실행문
	 start = () => {
		setInterval(autoReload, 2000); 
	 }
	 //function start(){}
   start();
  })//end of ready - DOM을 다 읽었으면  
 </script>
<div id="d_news">뉴스 준비중...</div>

</body>
</html>

<!-- 
 html(단방향, 변수선언이나 제어문 지원 안 됨,이벤트 처리 불가)은 순차적으로 실행
 자바스크립트 코드의 위치에 따라서 document.querySelector(id or class or ele)
 :선언이 먼저 
 자바스크립트 위치
 1)head안에 - 전변선언, 함수선언할 때(호출을 해야 실행됨)
 만일 이것을 지연하고 싶을 때 - defer - 미룬다 - HTML, DOM Tree 그린다
 2)body안에 - 호출하지 않아도 실행됨 - 단 함수로 선언된 부분 제외
 
 자바스크립트로 화면을 그릴 수 있다
 document.write("<font color='red' size=18></font>")

 write는 어디다 쓰는 건가요? - 브라우저
 
 java는 브라우저에 쓸 수 있다 | 없다
 
 System.out.println("<b>굵은글씨</b>")
 
 out.print();
 
 jsp라고 쓰고 html이라고 읽기
 jsp라고 쓰고 json이라고 읽기
 image/png
 image/jpg
 image/gif
 메인타입/서브타입
 text/html
 text/css
 text/javascript
 text/module
 text/babel
  
 
 -->
