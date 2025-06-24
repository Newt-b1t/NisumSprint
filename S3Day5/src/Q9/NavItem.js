import React from 'react';

const NavItem = ({ label, isActive, onClick }) => {
  return (
    <div
      className={`nav-item ${isActive ? 'active' : ''}`}
      onClick={onClick}
    >
      {label}
    </div>
  );
};

export default NavItem;
