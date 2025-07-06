import React from "react";

const withAdminAccess = (WrappedComponent) => {
  return function (props) {
    const { user } = props;
    if (!user || user.role !== "admin") {
      return <div style={{ color: "red" }}>Access Denied: Admins only.</div>;
    }
    return <WrappedComponent {...props} />;
  };
};

export default withAdminAccess;
