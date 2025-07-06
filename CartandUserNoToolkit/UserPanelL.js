import React from "react";
import { connect } from "react-redux";
import { login, logout } from "./actions/userActions";

const mockUser = { id: 1, name: "Alice", email: "alice@example.com" };

function UserPanel({ user, isLoggedIn, login, logout }) {
  return (
    <div>
      {isLoggedIn ? (
        <>
          <p>Welcome, {user.name}!</p>
          <button onClick={logout}>Logout</button>
        </>
      ) : (
        <button onClick={() => login(mockUser)}>Login</button>
      )}
    </div>
  );
}

const mapStateToProps = (state) => ({
  user: state.user.user,
  isLoggedIn: state.user.isLoggedIn,
});

export default connect(mapStateToProps, { login, logout })(UserPanel);
