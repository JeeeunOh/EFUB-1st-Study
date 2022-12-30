import React from 'react';
import styled, { css } from 'styled-components';

const sizes = {
  desktop: 1024,
  tablet: 768
}

// 위에 있는 size 객체에 따라 자동으로 media 쿼리 함수를 만들어 줍니다.

const media = Object.keys(sizes).reduce((acc, label) => {
  acc[label] = (...args) => css`
  @media (max-width: ${sizes[label] /16}em) {
    ${css(...args)};
  }
  `
  return acc;
}, {})

const About= styled.div`
  text-align: center;
  position: relative;
`

const Content = styled.div`
  justify-content: center;
  text-align: center;
  position: relative;
`

const Banner = styled.img`
  height: 60vh;
  width: 80%;
  margin-top: 10vh;
  ${media.tablet`
    width: 100%;
    height: 350px;`}
`

const Title = styled.h1`
  position: absolute;
  bottom: 1rem;
  left: 10%;
  font-weight: 500;
  margin-left: 50px;
  color: whitesmoke;
  ${media.tablet`
    top: 65%;
    left: 50%;
    margin: 0;
    transform: translate(-50%, -50%);
    text-align: center;`}
`

const Box = styled.div`
  display: flex;
  margin: 0 auto;
  margin-top: 2em;
  width: 60vw;
  height: 50vh;
  ${media.tablet`
    width: 80vw;
    margin-top: 2em;
    background-color: #C3E2DD;
    height: 30vh;`}
`

const Text = styled.div`
  text-align: justify;
  width: 30vw;
  margin-left: 3rem;
  ${media.tablet`
    width: 100%;
    margin: 0;
    text-align: center;`}
`

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 25vw;
  height: 50vh;
  border-radius: 4px;
  background-color: #C3E2DD;
  ${media.tablet`
    display: none;`}
`


const Contents = () => {
  return(
    <div>
      <About>
        <Banner src="https://cdn.pixabay.com/photo/2016/02/19/11/19/computer-1209641_1280.jpg"
        />
        <Title>반응형 웹 사이트 만들기 실습</Title>
      </About>
      <Content>
        <h1 style={{marginTop: "32px"}}>Contents</h1>
        <Box>
          <Container>EFUB 은</Container>
          <Text>
            <h3>Responsive web design basics</h3>
            <p>
            The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.

            </p>
          </Text>
        </Box>
        <Box>
          <Container>최고의</Container>
          <Text>
            <h3>Responsive web design basics</h3>
            <p>
            The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.
            </p>
          </Text>
        </Box>
        <Box>
          <Container>동아리</Container>
          <Text>
            <h3>Responsive web design basics</h3>
            <p>
            The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.The use of mobile devices to surf the web continues to grow at an astronomical pace, and these devices are often constrained by display size and require a different approach to how content is laid out on the screen.
            </p>
          </Text>
        </Box>
      </Content>
    </div>
    
  );
}

export default Contents;