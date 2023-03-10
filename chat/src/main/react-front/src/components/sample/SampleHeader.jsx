import React from 'react'

const SampleHeader = (props) => {
  return (
    <div style={{border:'3px solid yellowgreen', width:'600px', height:'300px'}}>
      SampleHeader페이지 영역
      <h2>{props.num}</h2>
    </div>
  )
}

export default SampleHeader