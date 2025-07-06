import React from "react";
import { connect } from "react-redux";
import { addToCart } from "./actions/cartActions";

const products = [
  { id: 101, name: "T-shirt", price: 15.99 },
  { id: 102, name: "Jeans", price: 39.99 },
  { id: 103, name: "Sneakers", price: 59.99 },
];

function ProductList({ addToCart }) {
  return (
    <div>
      <h2>Products</h2>
      <ul>
        {products.map((prod) => (
          <li key={prod.id}>
            {prod.name} - ${prod.price}
            <button style={{ marginLeft: 8 }} onClick={() => addToCart(prod)}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default connect(null, { addToCart })(ProductList);
