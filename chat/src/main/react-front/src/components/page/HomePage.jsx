import React, { useEffect } from 'react'
import Header from '../include/Header'
import Bottom from '../include/Bottom'
import { useNavigate, useParams } from 'react-router-dom'
//import { useParams } from 'react-router-dom'
//로그아웃 처리를 위해서 props에 authLogic 주소번지를 받아온다
const HomePage = ({authLogic}) => {
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
	//onLogout이라는 변수가 함수객체를 가리키고 있다 - 주소번지
	//함수가 가리키는 주소번지가 다르면 리렌더링이 일어남
	//리렌더링은 언제 발생하지? 
	//1)state가 변경되었을 때 - useState(0)
	//2)props가 변경되었을 때 ({title,onLogout,content}) - spread 연산자 
	//3)부모컴퍼넌트가 변경되었을 때(캡쳐링) - map(n건) -> item별로 row
	//ex)BoardList BoardRow BoardDetail
	//첫글자가 소문자 -> 함수
	//첫글자가 대문자 -> 컴퍼넌트 -> 렌더
	const onLogout = () => {
		console.log('HomePage onLogout 호출')
		authLogic.logout()
	}

	useEffect(() => {
		authLogic.onAuthChange(user => {
			if(!user){
				navigate("/")
			}
		})
	})

  return (
	<React.Fragment>
		<Header userId={userId} onLogout={onLogout} />
		<div>
		HomePage페이지
		</div>
		<Bottom />
	</React.Fragment>
  )
}

export default HomePage
