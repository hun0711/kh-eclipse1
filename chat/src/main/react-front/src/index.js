import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import AuthLogic from "./service/authLogic";
import firebaseApp from "./service/firebase";
//공통코드 ->  service > authLogic.js -> import외부 js재사용 가능함
//브라우저에서 import 하려면 반드시 babel이 필요함
const authLogic = new AuthLogic(firebaseApp);
//왜 파라미터가 필요한가? - firebaseApp -> import firebaseApp from "./service/firebase"
//authLogic.파이어베이스에서 제공하는 함수를 호출하겠다.
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <>
    <BrowserRouter>
      { {/* App컴포넌트를 렌더링할 때 속성자리에 주소번지를 넘길 수 있다 */}}
      { {/* 태그와 JS섞어쓰기 가능함 - 좌중괄호 우중괄호 */}}
      <App authLogic={authLogic} />
    </BrowserRouter>
  </>
);
