import React from 'react'
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
  authLogic.login("Google")
  //.then(data => console.log(data.user))
  .then(data => moveHome(data.user.uId))
  }
  return (
    <>
     <Button onClick={() => {navigate("/")}}>홈페이지</Button> 
     <Button onClick={handleLogin}>Google</Button>
    </>
  )
}

export default LoginPage
