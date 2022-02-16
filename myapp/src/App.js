import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "./header";
import Footer from "./footer";

function App() {
  return (
    <div className="maincontainer">
     <Header></Header>
     <h1 className="mr-5 mt-5">Welcome</h1>
      <div className="container mb-5 mt-5">
       <h1 className="mr-5 mt-5">This is main container!!</h1>
     </div>
       <Footer></Footer>
   </div>
  )
};

export default App;
