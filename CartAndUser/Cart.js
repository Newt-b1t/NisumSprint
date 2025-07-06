import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { removeItem } from './cartSlice';

const Cart = () => {
  const items = useSelector((state) => state.cart.items);
  const dispatch = useDispatch();

  const totalCount = items.reduce((acc, item) => acc + item.quantity, 0);
  const totalPrice = items.reduce((acc, item) => acc + item.price * item.quantity, 0);

  if (items.length === 0) return <div><h2>Shopping Cart</h2><p>Your cart is empty.</p></div>;

  return (
    <div>
      <h2>Shopping Cart</h2>
      <p>Total Items: <b>{totalCount}</b></p>
      <p>Total Price: <b>${totalPrice.toFixed(2)}</b></p>
      <ul className="cart-list">
        {items.map((item) => (
          <li key={item.id}>
            <span>
              {item.name} - ${item.price} x {item.quantity}
            </span>
            <button onClick={() => dispatch(removeItem(item.id))}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Cart;
