import React from 'react';
import './HomePage.scss';
import { AboutUsComponent } from '../About-Us/AboutUs';
import { HomePageHeader} from './HomePageHeader';
import { GalleryComponent } from '../Gallery/Gallery';
import { VolunteerComponent } from '../Volunteer/Volunteer';
import { FosterComponent } from '../Foster/Foster';
import { NotificationComponent } from '../common/notification/Notification';

export class HomePageComponent extends React.Component {
  render() {
    return (
      <div className='container'>
        {/* <header /> */}
        <div className='notification-top'>
          <NotificationComponent />
        </div>
        <div className='homePage-header-main'>
          <HomePageHeader />
        </div>
        <div className='banner'>
          <h1>PET CARE</h1>
        </div>
        <div className='photo_carosel'>
          <GalleryComponent />
        </div>
        <div className='petcare_volunteer'>
          <VolunteerComponent />
        </div>
        <div className='petcare_foster'>
          <FosterComponent />
        </div>
        <footer>
          <AboutUsComponent />
        </footer>
      </div>
    );
  }
}
