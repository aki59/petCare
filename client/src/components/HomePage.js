import React from 'react';
import './HomePage.scss';

export class HomePageComponent extends React.Component {
  render() {
    return (
      <div className='container'>
        {/* <header /> */}
        <div className='banner'>
          <h1>PET CARE</h1>
        </div>
        <div className='photo_carosel' />
        <div className='petcare_volunteer' />
        <div className='petcare_foster' />
        <footer>about us</footer>
      </div>
    );
  }
}
