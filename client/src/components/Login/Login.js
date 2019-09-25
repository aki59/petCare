import React, { Component } from 'react';
import { Redirect, NavLink } from 'react-router-dom';
import { Base64 } from 'js-base64';


/*export const AuthService = {
  isAuthenticated: false,
  authenticate(cb) {
    console.log(this.isAuthenticated);
    this.isAuthenticated = true
    setTimeout(cb, 100)
  },
  logout(cb) {
    this.isAuthenticated = false
    setTimeout(cb, 100)
  }
};*/

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = { userName: "", password: '' };
    this.handleNameChange = this.handleChange.bind(this, 'userName');
    this.handlePasswordChange = this.handleChange.bind(this, 'password');
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange = (keyName, event) => {
    this.setState({ [keyName]: event.target.value });
  }

  handleSubmit(event) {
    alert('A name was submitted: ' + this.state.userName);
    event.preventDefault();
  }
 /* state = {
    redirectToPreviousRoute: false
  };

  login = () => {
    AuthService.authenticate(() => {

      this.setState({ redirectToPreviousRoute: true });
    });


  };*/

  oauth2Login =() =>{
    var details={
      username: this.state.userName,
      password: this.state.password,
      grant_type: 'password'
    };

    var formBody = [];
    for(var property in details){
      var encodedKey = encodeURIComponent(property);
      var encodedValue = encodeURIComponent(details[property]);
      formBody.push(encodedKey + "="+ encodedValue);
    }

    formBody=formBody.join("&");
    
    let headers =new Headers();
    //headers.set('Authorization', 'Basic ' + Base64.encode("browser);
    headers.set('Authorization', 'Basic YnJvd3Nlcjo=');
    headers.set('scope','ui');
    headers.set('Content-Type','application/x-www-form-urlencoded');
    fetch('http://localhost:4000/uaa/oauth/token',{
      method:'post',
      headers: headers,
      body: formBody
    })
    .then(response => response.json())
    .then(json => console.log(json));
  };

  render() {
    const { from } = this.props.location.state || { from: { pathname: "/" } };
    const { redirectToPreviousRoute } = this.state;
    if (redirectToPreviousRoute) {
      return <Redirect to={from} />;
    }
    return (
      <div>
        <form onSubmit={this.handleSubmit}>
          <label>
            Name:
          </label>
          <input type="text" value={this.state.userName} onChange={this.handleNameChange} /><br/>
          <label>
           Password:
          <input type="password" value={this.state.password} onChange={this.handlePasswordChange}/><br/>
          </label>
          <button onClick={this.oauth2Login}>Sign in</button>
        </form>
        <p>You must log in to view the page at {from.pathname}</p>
        <NavLink to="/signUp"> Dashboard </NavLink>
       
      </div>
    )
  }
}

export default Login;