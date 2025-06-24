import React from 'react';
import './ProductCard.css';

const ProductCard = ({
  title = 'iphone 12 pro max',
  price = 1099,
  description = 'Too old'
}) => {
  return (
    <div className="product-card">
      <h2>{title}</h2>
      <p>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
};

export default ProductCard;
