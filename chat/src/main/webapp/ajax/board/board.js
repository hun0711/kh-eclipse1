//비동기통신객체 생성해서 담을 변수 선언
let xhrObject = null; //선언
//비동기 통신객체 생성하는 함수 구현 - 단 리턴예약어가 없어서 반환받을 수 없음
function createRequest() {
  //자바스크립트에서 예외처리가 가능하다

  try {
    xhrObject = new XMLHttpRequest();
  } catch (trymicrosoft) {
    try {
      //MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
} // end of createRequest

function createRequest2() {
  try {
    xhrObject = new XMLHttpRequest(); //constructor
  } catch (trymicrosoft) {
    try {
      //MS의 IE 사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
  return xhrObject;
} // end of createRequest

//span태그가 가지고 있는 텍스트 노드값을 읽어오기
// <td>100</td> -> 100은 문자임. 태그이름 없음 -> 속성 정의할 수 없음 -> 아이디나 클래스를 정의X -> 접근 불가
// 해결방법 - 그래서 텍스트노드에 span으로 감싼다
// document.querySelector("#id")
// document.querySelector(".class")
// document.querySelector("태그이름")
//const costEl = document.querySelector("#cost");
//const priceEl = document.querySelector("#price");
function getText(el) {
  let text = ""; //ES6 -> ECMAScript2015 - 적용안되는 브라우저이면 babel 필요하다 또는 번들러 parcel(웹팩 - 리액트)
  if (el != null) {
    if (el.childNodes) {
      // el null스킵, undefined, "", NaN
      console.log(el + "," + el.childNodes.length);
      for (let i = 0; i < el.childNodes.length; i++) {
        //el.childNodes.length
        //costEL, priceEl
        let childNode = el.childNodes[i]; //el.childNodes[0],el.childNodes[1]
        //너 텍스트 노드니?
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}
//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
	param1 :document.getElementById("boardSold")
	param1 :document.querySelector("#boardSold")
	param2 :xhrObject. 
	************************************************/
function replaceText(el, value) {
  // el-> boardSoldEl(보드판매량), cashEl(마진)
  if (el != null) {
    //span
    clearText(el); //기존에 있던 10을 지워주세요.
    //새로운 텍스트 노드 15를 생성하기
    var newNode = document.createTextNode(value); //15
    //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
    el.appendChild(newNode);//el boardSoldEl -> <span>10</span> <span id=boardSold or cash></span> <span>20</span>
  }
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
  if (el != null) {
    if (el.childNodes) { //자바스크립트에서는 0이 아닌건 모두 참이다.
      for (var i = 0; i < el.childNodes.length; i++) {
        let childNode = el.childNodes[i];
        el.removeChild(childNode); //해당 el삭제하기 - DOM API -> 직관적이지않다 -> 유지보수 어려움 
      }
    }
  }
}
