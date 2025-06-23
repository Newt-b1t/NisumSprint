import React from 'react';
// import TodoApp from './TodoApp';
import { ThemeProvider, useTheme } from './ThemeContext';
import ThemeToggle from './ThemeToggle';
import './App.css';

function App() {
  return (
    // <div className="App">
    //   <TodoApp />
    // </div>
    <ThemeProvider>
      <div className="app">
        <header>
          <h1>Theme Switcher</h1>
          <ThemeToggle />
        </header>
        <main>
          <p>Current theme: {useTheme().isDarkMode ? 'Dark' : 'Light'}</p>
          <section>
            <h2>Content Section</h2>
            <p>This text changes based on the selected theme.</p>
          </section>
        </main>
      </div>
    </ThemeProvider>
  );
}

export default App;
