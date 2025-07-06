// Dashboard.js
import React from 'react';
import { useUserContext } from './UserContext';

const Dashboard = () => {
  const { user, isLoggedIn, login, logout } = useUserContext();

  const handleAdminLogin = () => {
    login({ id: 1, name: 'Admin User', role: 'Admin' });
  };

  const handleUserLogin = () => {
    login({ id: 2, name: 'Regular User', role: 'User' });
  };

  return (
    <div>
      <h1>User Dashboard</h1>
      
      {!isLoggedIn ? (
        <div>
          <p>Please log in:</p>
          <button onClick={handleAdminLogin}>Login as Admin</button>
          <button onClick={handleUserLogin}>Login as Regular User</button>
        </div>
      ) : (
        <div>
          <p>Welcome, {user.name} ({user.role})</p>
          <button onClick={logout}>Logout</button>
          
          {/* Role-based content */}
          <div>
            <h2>Dashboard Content</h2>
            <p>All users can see this content</p>
            
            {user.role === 'Admin' && (
              <div>
                <h3>Admin Section</h3>
                <button>Add Product</button>
                <button>Manage Users</button>
              </div>
            )}
          </div>
        </div>
      )}
    </div>
  );
};

export default Dashboard;
