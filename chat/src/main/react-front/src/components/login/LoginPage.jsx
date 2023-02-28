import React, { useEffect } from 'react'
import { Button } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom'

const LoginPage = ({ authLogic }) => {
  const navigate = useNavigate()
  //페이지 이동 함수 구현 -
  const moveHome = (userId) => {
    console.log(userId)
    navigate({pathname:'/home/' + userId})
  }
  const handleLogin = () => {
    //service -> authLogic.js에 선언된 클래스 -> login함수가 선언
    //파라미터로 넘기는 문자열에 따라서 구글로그인 또는 깃허브 로그인
    //authLogic 클래스의 getProvider함수에서 분기되어 있음
  authLogic.login("Google")
  //.then(data => console.log(data.user))
  .then(data => moveHome(data.user.uid))
  }

  useEffect(() => {
    authLogic.onAuthChange(user => {
      console.log(user)
      user && moveHome(user.uid)
    })
  })


  return (
    <>
     <Button onClick={() => {navigate("/")}}>홈페이지</Button> 
     <Button onClick={handleLogin}>Google</Button>
    </>
  )
}

export default LoginPage
