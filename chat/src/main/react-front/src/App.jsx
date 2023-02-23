import { Route, Routes } from 'react-router-dom';
import './App.css';
import DeptPage from './components/page/DeptPage';
import EmpPage from './components/page/EmpPage';
import HomePage from './components/page/HomePage';

function App() {
  return (
   <>
   <Routes>
    <Route path='/' exact={true} element={<HomePage/>}/>
    <Route path='/dept/:id' exact={true} element={<DeptPage/>}/>
    <Route path='/emp/' exact={true} element={<EmpPage/>}/>
   </Routes>
   </>
  );
}

export default App;
