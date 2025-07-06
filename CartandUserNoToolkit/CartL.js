import React from "react";
import { connect } from "react-redux";
import { removeFromCart } from "./actions/cartActions";

function Cart({ items, removeFromCart }) {
  const totalCount = items.reduce((acc, item) => acc + item.quantity, 0);
  const totalPrice = items.reduce((acc, item) => acc + item.price * item.quantity, 0);

  if (items.length === 0)
    return (
      <div>
        <h2>Shopping Cart</h2>
        <p>Your cart is empty.</p>
      </div>
    );

  return (
    <div>
      <h2>Shopping Cart</h2>
      <p>
        Total Items: <b>{totalCount}</b>
      </p>
      <p>
        Total Price: <b>${totalPrice.toFixed(2)}</b>
      </p>
      <ul>
        {items.map((item) => (
          <li key={item.id}>
            {item.name} - ${item.price} x {item.quantity}
            <button onClick={() => removeFromCart(item.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

const mapStateToProps = (state) => ({
  items: state.cart.items,
});

export default connect(mapStateToProps, { removeFromCart })(Cart);
