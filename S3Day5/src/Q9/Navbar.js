import React, { useState } from 'react';
import './Navbar.css';
import NavItem from './NavItem';

const Navbar = () => {
  const [activeTab, setActiveTab] = useState('Home');
  const tabs = ['Home', 'About', 'Services', 'Contact'];

  return (
    <nav className="navbar">
      {tabs.map(tab => (
        <NavItem
          key={tab}
          label={tab}
          isActive={activeTab === tab}
          onClick={() => setActiveTab(tab)}
        />
      ))}
    </nav>
  );
};

export default Navbar;
