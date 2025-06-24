import React, { useState } from 'react';

const ThemeToggle = () => {
  const [isDarkMode, setIsDarkMode] = useState(false);

  const toggleTheme = () => {
    setIsDarkMode(prev => !prev);
  };

  const styles = {
    backgroundColor: isDarkMode ? '#222' : '#f0f0f0',
    color: isDarkMode ? '#fff' : '#000',
    height: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'column'
  };

  return (
    <div style={styles}>
      <h2>{isDarkMode ? 'Dark Mode' : 'Light Mode'}</h2>
      <button onClick={toggleTheme}>
        Switch to {isDarkMode ? 'Light' : 'Dark'} Theme
      </button>
    </div>
  );
};

export default ThemeToggle;
