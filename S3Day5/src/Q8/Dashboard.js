import React from 'react';
import UserProfile from '../Q7/UserProfile';
import Notifications from '../Q7/Notifications';

const Dashboard = () => {
  const user = {
    name: 'Avinash Rath',
    email: 'arth123@gmail.com',
    avatarUrl: '',
    bio: 'Student'
  };

  const notifications = [
    {
      message: 'New course material available.',
      date: '2025-06-20 1:00 PM',
      read: false
    },
    {
      message: 'Assignment 5 graded.',
      date: '2025-06-21 12:30 PM',
      read: true
    }
  ];

  return (
    <div>
      <UserProfile {...user} />
      <Notifications notifications={notifications} />
    </div>
  );
};

export default Dashboard;
