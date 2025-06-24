import { useCart } from '../context/CartContext';

export default function CartItem({ item }) {
  const { updateQuantity, removeFromCart } = useCart();
  
  return (
    <div className="cart-item">
      <img src={item.image} alt={item.name} />
      <div className="item-details">
        <h4>{item.name}</h4>
        <p>${item.price.toFixed(2)}</p>
        
        <div className="quantity-controls">
          <button 
            onClick={() => updateQuantity(item.id, item.quantity - 1)}
            disabled={item.quantity <= 1}
            aria-label="Decrease quantity"
          >
            -
          </button>
          
          <span>{item.quantity}</span>
          
          <button 
            onClick={() => updateQuantity(item.id, item.quantity + 1)}
            aria-label="Increase quantity"
          >
            +
          </button>
        </div>
        
        <button 
          className="remove-btn"
          onClick={() => removeFromCart(item.id)}
          aria-label="Remove item"
        >
          Remove
        </button>
      </div>
    </div>
  );
}
