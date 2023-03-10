import React from 'react';
import { Button } from 'react-bootstrap';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from 'react-router-dom';

const Header = (props) => {
  const { userId, onLogout } = props;
  return (
	<React.Fragment>
    <Navbar bg="light" expand="lg">
      <Container fluid>
        <Navbar.Brand href="#home">React-Bootstrap</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Link to="/" class="nav-link" >Home</Link>
            <Link to="/board" class="nav-link">게시판</Link>
            <Link to="/workout" class="nav-link" >홈트</Link>
            <Link to="/hackernews" class="nav-link">해커뉴스</Link>
            <Link to="/youtube" class="nav-link">유튜브</Link>
          </Nav>
          {onLogout && <Button variant='primary' onClick={onLogout}>Logout</Button>}
        </Navbar.Collapse>
      </Container>
    </Navbar>		
	</React.Fragment>
  )
}

export default Header
