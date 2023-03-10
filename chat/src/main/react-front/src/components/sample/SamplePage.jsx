import React from 'react'
import SampleApp from '../../SampleApp'
import SampleBottom from './SampleBottom'
import SampleHeader from './SampleHeader'
import SubPage from './SubPage'

const SamplePage = (props) => {
  console.log(":" + props.num)
  const handleAdd = () => {
    console.log('SamplePage handleAdd : '+ props.num)
		props.handleAdd(props.num)
  }
  const handleMinus = () => {
    props.handleMinus(props.num)
  }
  return (
    <>
    <SampleHeader num={props.num} />
     <div style={{border:'5px solid gray', width:'600px', height:'300px'}}>
      <SubPage handleAdd={handleAdd} handleMinus={handleMinus}/>
메인페이지영역
     </div>
    <SampleBottom />
     
    </>
  )
}

export default SamplePage