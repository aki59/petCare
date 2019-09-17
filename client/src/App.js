import React, { Component } from 'react';
import { Route, Link } from 'react-router-dom';
import { HomePageComponent}  from './components/Home/HomePage';
import Login from './components/Login/Login';
import AddPetComponent from './components/Pet/AddAPet';
import './App.scss';

class App extends Component{
  render(){
    return(
      <div>
      <Route path="/petCare" exact component={HomePageComponent}/>
      <Route path="/petCare/login" component={Login}/>
      <Route path="/petCare/addPet" component={AddPetComponent}/>
      </div>
    );
  }
}


export default App;
