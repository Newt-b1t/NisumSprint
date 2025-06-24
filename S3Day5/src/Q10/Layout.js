import React from 'react';
import './Layout.css';

const Layout = ({ children }) => {
  return (
    <div className="layout">
      <header className="layout-header">Heaaderrrrr</header>
      <main className="layout-content">{children}</main>
      <footer className="layout-footer">© 2025 Avinash Rath. All rights reserved.</footer>
    </div>
  );
};

export default Layout;
