// test for ProductEdit
import React from "react";
import { render, screen, fireEvent } from "@testing-library/react";
import ProductEdit from "./ProductEdit";

describe("ProductEdit", () => {
  it("renders input with product name", () => {
    render(<ProductEdit product={{ id: 1, name: "Test Product" }} />);
    expect(screen.getByDisplayValue("Test Product")).toBeInTheDocument();
  });

  it("updates input value and calls alert on save", () => {
    window.alert = jest.fn(); // Mock alert
    render(<ProductEdit product={{ id: 1, name: "Test Product" }} />);
    const input = screen.getByDisplayValue("Test Product");
    fireEvent.change(input, { target: { value: "New Name" } });
    fireEvent.click(screen.getByText(/save/i));
    expect(window.alert).toHaveBeenCalledWith('Product "New Name" updated!');
  });
});
