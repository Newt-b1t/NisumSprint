
import React from "react";
import { useTheme } from "./ThemeContext";

const Card = () => {
  const { theme } = useTheme();

  return (
    <div
      style={{
        padding: "2rem",
        margin: "1rem",
        borderRadius: "8px",
        background: theme === "light" ? "#fff" : "#333",
        color: theme === "light" ? "#222" : "#f0f0f0",
        boxShadow: "0 2px 8px rgba(0,0,0,0.1)",
      }}
    >
      <h2>Card Component</h2>
      <p>This card's style change</p>
    </div>
  );
};

export default Card;
