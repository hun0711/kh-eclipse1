import React, { useEffect, useState } from 'react'
import { Table } from 'react-bootstrap';
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.17.1/firebase-app.js";
import {
	getDatabase,
	ref,
	set,
	onValue,
  } from "https://www.gstatic.com/firebasejs/9.17.1/firebase-database.js";
import DeptRow from '../dept/DeptRow';
import { useNavigate } from 'react-router-dom';
const firebaseConfig = {
	apiKey: process.env.REACT_APP_FS_APIKEY,
	authDomain: process.env.REACT_APP_FS_AUTHDOMAIN,
	databaseURL: process.env.REACT_APP_FS_DATABASEURL,
	projectId: process.env.REACT_APP_FS_PROJECTID,
	storageBucket: process.env.REACT_APP_FS_STORAGEBUCKET,
	messagingSenderId: process.env.REACT_APP_FS_MESSAGINGSENDERID,
	appId: process.env.REACT_APP_FS_APPID
  };
  
  const app = initializeApp(firebaseConfig);
  console.log(app)
  const database = getDatabase()

const FireDeptPage = ({authLogic}) => {
	const navigate = useNavigate()
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
	const [depts, setDepts] = useState([]);
	useEffect(() => {
		console.log('useEffect 호출')
		console.log(database)
		console.log(depts)
		const starCountRef = ref(database, 'dept');
		onValue(starCountRef, (snapshot) => {
			const data = snapshot.val();
			console.log(data)
			setDepts(data)
		});
	},[]);//옵션에 별도의 값을 지정하지 않으면 최초 한번만 실행됨
	//useEffect에서 초기화 된 상태값 출력해 보기
	console.log(depts)
  return (
	<>
		<Header onLogout={onLogout}/>
		<div>부서관리 페이지</div>
		<div className="dept-list">
			<Table striped bordered hover>
				<thead>
					<tr>
					<th>부서번호</th>
					<th>부서명</th>
					<th>지역</th>
					</tr>
				</thead>
				<tbody>
				{Object.keys(depts).map(key => (
						<DeptRow  dept={depts[key]}/>
					))}
				</tbody>
			</Table>			
		</div>
		<Bottom />
	</>
  )
}

export default FireDeptPage
