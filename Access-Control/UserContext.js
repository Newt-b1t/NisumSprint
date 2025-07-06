// UserContext.js
import React, { createContext, useState, useContext } from 'react';

const UserContext = createContext({
  user: { id: null, name: '', role: '' },
  isLoggedIn: false,
  login: () => {},
  logout: () => {}
});

export const UserProvider = ({ children }) => {
  const [user, setUser] = useState({ id: null, name: '', role: '' });
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const login = (userData) => {
    setUser(userData);
    setIsLoggedIn(true);
  };

  const logout = () => {
    setUser({ id: null, name: '', role: '' });
    setIsLoggedIn(false);
  };

  return (
    <UserContext.Provider value={{ user, isLoggedIn, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};

export const useUserContext = () => useContext(UserContext);
