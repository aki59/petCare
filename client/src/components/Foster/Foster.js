import React, { Component } from 'react';
import './Foster.scss';

export class FosterComponent extends Component {
  render() {
    return (
      <div className='foster_wrapper'>
        <h1>FOSTER</h1>
        <a href="/petCare/addAPet">Please click if you want to foster a canine.</a>
      </div>
    );
  }
}
