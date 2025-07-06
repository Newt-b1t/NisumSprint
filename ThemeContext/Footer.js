
import React from "react";
import { useTheme } from "./ThemeContext";

const Footer = () => {
  const { theme } = useTheme();

  return (
    <footer
      style={{
        padding: "1rem",
        background: theme === "light" ? "#f0f0f0" : "#222",
        color: theme === "light" ? "#222" : "#f0f0f0",
        textAlign: "center",
      }}
    >
      <p>Avinash Rath &copy; 2025</p>
    </footer>
  );
};

export default Footer;
