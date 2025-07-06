//test for AdminProductEdit
import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import AdminProductEdit from "./AdminProductEdit";

const product = { id: 1, name: "Test Product" };

describe("AdminProductEdit (HOC + ProductEdit)", () => {
  it("allows admin to edit product", () => {
    window.alert = jest.fn();
    render(<AdminProductEdit user={{ id: 1, role: "admin" }} product={product} />);
    expect(screen.getByDisplayValue("Test Product")).toBeInTheDocument();
    fireEvent.change(screen.getByDisplayValue("Test Product"), {
      target: { value: "Changed" },
    });
    fireEvent.click(screen.getByText(/save/i));
    expect(window.alert).toHaveBeenCalledWith('Product "Changed" updated!');
  });

  it("denies access for non-admin", () => {
    render(<AdminProductEdit user={{ id: 2, role: "user" }} product={product} />);
    expect(screen.getByText(/Access Denied/i)).toBeInTheDocument();
  });
});
