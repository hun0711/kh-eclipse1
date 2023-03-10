import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import Workouts from '../workout/Workouts'

const WorkoutPage = ({authLogic,workouts,onIncrement,onDecrement,onDelete, onAdd}) => { 
/*   const{authLogic, workouts, onIncrement} = props */
  const navigate = useNavigate()
  const onLogout = () => {
   console.log('HomePage onLogout 호출')
   authLogic.logout()
 }
 const handleIncrement = (item) => {
  //자바스크립트는 같은 이름의 함수를 여러 개 정의 못 함
  //item은 어디에서 왔을까?
  console.log("Map에서 온" + item)
  //상위 컴포넌트(App.jsx)의 함수를 호출하는 코드임
  //WorkoutPage의 props에 App에서 선언된 workout로 주소번지를 가지고 있는데
  //왜? 여기서는 처리를 못하고 다시 상위 컴포넌트로 미루는 걸까요?
  //setItems 훅을 사용할 수 없기 때문입니다.
  //setItems는 파라미터로 넘기지 않습니다. 왜냐하면 해당 컴포넌트이 화면 렌더링과
  //관련된 함수 이라서 그렇습니다.
  onIncrement(item);
}
const handleDecrement = (item) => {
  onDecrement(item)
}
const handleDelete = (item) => {
  onDelete(item)
}

const handleAdd = (name) => {
  //부모에 정의된 함수 호출하기 - 파라미터 값은 AddForm에서 inputRef로 설정된 값 가져옴
  onAdd(name)
}

 useEffect(() => {
   authLogic.onAuthChange(user => {
     if(!user){
       navigate("/")
     }
   })
 })
  return (
    <>
    <Header onLogout={onLogout}/>
      <Workouts workouts={workouts} onIncrement={handleIncrement} onDecrement={handleDecrement} onDelete={handleDelete} onAdd={handleAdd}/>
      <Bottom/>
    </>
  )
}

export default WorkoutPage
