import React, { useState } from 'react'
import SamplePage from './components/sample/SamplePage'

const SampleApp = () => {
  const [num,setNum] = useState(5)
  const handleAdd = () => {
    setNum(num+1)
  }
  const handleMinus = () => {
    setNum(num-1)
  }
  return (
    <div>
      <SamplePage num={num} handleAdd={handleAdd} handleMinus={handleMinus}/>     
    </div>
  )
}

export default SampleApp
