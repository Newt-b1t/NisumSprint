import React from 'react';
import './UserProfile.css';

const UserProfile = ({
  name = 'Unknown User',
  email = 'Not Provided',
  avatarUrl = '',
  bio = 'No bio available.'
}) => {
  const placeholderImage = 'https://www.pexels.com/photo/classic-parisian-architecture-with-spring-foliage-32549559/';

  return (
    <div className="user-card">
      <img src={avatarUrl || placeholderImage} alt="Avatar" className="avatar" />
      <div className="user-info">
        <h2>{name}</h2>
        <p>Email: {email}</p>
        <p>{bio}</p>
      </div>
    </div>
  );
};

export default UserProfile;
