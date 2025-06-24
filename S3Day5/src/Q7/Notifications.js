import React from 'react';
import './Notifications.css';

const Notifications = ({ notifications }) => {
  return (
    <div className="notification-container">
      <h2>Notifications</h2>
      {notifications.length === 0 ? (
        <p>No notifications available.</p>
      ) : (
        notifications.map((note, index) => (
          <div className={`notification-card ${note.read ? 'read' : 'unread'}`} key={index}>
            <p><strong>Message:</strong> {note.message}</p>
            <p><strong>Date:</strong> {note.date}</p>
            <p><strong>Status:</strong> {note.read ? 'Read' : 'Unread'}</p>
          </div>
        ))
      )}
    </div>
  );
};

export default Notifications;
