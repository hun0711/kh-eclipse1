import React, { useState } from 'react'
//const Workout = (props) => {
//const {workout, onIncrement} = props -> 구조분해할당  

const Workout = ({workout, onIncrement, onDecrement, onDelete}) => { //미리 구조분해할당으로 받아온 것이다
  console.log(workout)
const handleIncrement = () => {
  //이벤트 처리가 되어있지않고 상위 컴포넌트의 함수를 호출함
  //상위 컴포넌트의 함수는 props를 통해서 접근 가능하다
  //상위 함수를 호출할 때 파라미터도 넘어 갑니다.
  onIncrement(workout)
}
const handleDecrement = () => {
   onDecrement(workout)
}
const handleDelete = () => {
  onDelete(workout)
}
  return (
    <>
    <li className="habit">
      <span className="habit-name">{workout.name}</span>
      <span className="habit-count">{workout.count}</span>
    <button className="habit-button habit-increase" onClick={handleIncrement}>
          <i className="fas fa-plus-square"></i>
      </button>
      <button className="habit-button habit-decrease" onClick={handleDecrement}>
          <i className="fas fa-minus-square"></i>
      </button>
      <button className="habit-button habit-delete" onClick={handleDelete}>
          <i className="fas fa-trash"></i>
      </button>
      </li>  
    </>
  )
}

export default Workout
