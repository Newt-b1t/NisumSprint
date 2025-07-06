// test for withAdminAccess
import React from "react";
import { render, screen } from "@testing-library/react";
import withAdminAccess from "./withAdminAccess";

// Dummy component for testing
const DummyComponent = ({ text }) => <div>{text}</div>;
const WrappedComponent = withAdminAccess(DummyComponent);

describe("withAdminAccess HOC", () => {
  it("renders wrapped component for admin user", () => {
    render(<WrappedComponent user={{ id: 1, role: "admin" }} text="Secret" />);
    expect(screen.getByText("Secret")).toBeInTheDocument();
  });

  it("shows Access Denied for non-admin user", () => {
    render(<WrappedComponent user={{ id: 2, role: "user" }} text="Secret" />);
    expect(screen.getByText(/Access Denied/i)).toBeInTheDocument();
  });

  it("shows Access Denied if user is missing", () => {
    render(<WrappedComponent text="Secret" />);
    expect(screen.getByText(/Access Denied/i)).toBeInTheDocument();
  });
});
