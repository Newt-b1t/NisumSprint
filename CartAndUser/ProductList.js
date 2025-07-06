import React from 'react';
import { useDispatch } from 'react-redux';
import { addItem } from './cartSlice';

const products = [
  { id: 101, name: "T-shirt", price: 15.99 },
  { id: 102, name: "Jeans", price: 39.99 },
  { id: 103, name: "Sneakers", price: 59.99 },
];

const ProductList = () => {
  const dispatch = useDispatch();

  return (
    <div>
      <h2>Products</h2>
      <ul className="product-list">
        {products.map((prod) => (
          <li key={prod.id}>
            <span>
              <b>{prod.name}</b> - ${prod.price}
            </span>
            <button onClick={() => dispatch(addItem(prod))}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
