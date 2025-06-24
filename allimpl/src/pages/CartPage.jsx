import { Link } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import CartItem from '../components/CartItem';

export default function CartPage() {
  const { cart, totalPrice, clearCart } = useCart();

  return (
    <div className="cart-page">
      <h2>Your Shopping Cart</h2>
      
      {cart.items.length === 0 ? (
        <div className="empty-cart">
          <p>Your cart is empty</p>
          <Link to="/" className="shop-btn">Continue Shopping</Link>
        </div>
      ) : (
        <>
          <div className="cart-items">
            {cart.items.map(item => (
              <CartItem key={item.id} item={item} />
            ))}
          </div>
          
          <div className="cart-summary">
            <div className="summary-row">
              <span>Subtotal:</span>
              <span>${totalPrice.toFixed(2)}</span>
            </div>
            
            <div className="cart-actions">
              <button 
                className="clear-btn"
                onClick={clearCart}
              >
                Clear Cart
              </button>
              
              <Link to="/" className="continue-btn">
                Continue Shopping
              </Link>
              
              <button className="checkout-btn">
                Proceed to Checkout
              </button>
            </div>
          </div>
        </>
      )}
    </div>
  );
}
