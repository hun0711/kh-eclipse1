import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import { BrowserRouter } from "react-router-dom";
import AuthLogic from "./service/authLogic";
import firebaseApp from "./service/firebase";

const authLogic = new AuthLogic(firebaseApp);
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <>
    <BrowserRouter>
      <App authLogic={authLogic} />
    </BrowserRouter>
  </>
);
