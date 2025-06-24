import React from 'react';
import './StatusBadge.css';

const StatusBadge = ({ status }) => {
  let statusClass = '';

  if (status === 'success') statusClass = 'badge-success';
  else if (status === 'error') statusClass = 'badge-error';
  else if (status === 'warning') statusClass = 'badge-warning';

  return (
    <span className={`badge ${statusClass}`}>
      {status.toUpperCase()}
    </span>
  );
};

export default StatusBadge;
