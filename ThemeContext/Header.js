
import React from "react";
import { useTheme } from "./ThemeContext";

const Header = () => {
  const { theme, toggleTheme } = useTheme();

  return (
    <header
      style={{
        padding: "1rem",
        background: theme === "light" ? "#f0f0f0" : "#222",
        color: theme === "light" ? "#222" : "#f0f0f0",
        display: "flex",
        justifyContent: "space-between",
        alignItems: "center",
      }}
    >
      <h1>Theme Switcher</h1>
      <button onClick={toggleTheme}>
        Switch to {theme === "light" ? "Dark" : "Light"} Theme
      </button>
    </header>
  );
};

export default Header;
