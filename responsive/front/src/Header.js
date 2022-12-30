import React from 'react';
import styled from 'styled-components';

const Box = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-top: 0px;
  position: fixed;
  width: 100%;
  height: 10vh;
  background-color: white;
  z-index: 10;
  @media (max-width: 768px) {
    justify-content: center;
    height: 4rem;
  }
`

const Menu = styled.div`
  display: flex;
`
// border이 테두리, outline은 border 바깥 외곽선
const LOGO = styled.button`
  font-size: 3rem;
  background: none;
  border: none;
  //outline: none;
  padding: 1rem;
  font-family: 'Scheherazade New', serif;
  font-weight: 600;
`

const Button = styled.button`
  height: 3em;
  font-size: 1.5rem;
  justify-content: center;
  padding: 0.5rem 1rem;
  // outline: none;
  background: none;
  border: none;
  border-radius: 4px;
  display: block;
  box-sizing: inherit;
  font-family: 'Times New Roman', Times, serif;
  &:hover {
    font-weight: 600;
  }
  @media (max-width: 768px) {
    display: none;
  }
`

const Header = () => {
  return(
    <Box>
      <LOGO>EFUB</LOGO>
      <Menu>
        <Button>About</Button>
        <Button>Contents</Button>
        <Button>Contact</Button>
      </Menu>
    </Box>
  );
}

export default Header;