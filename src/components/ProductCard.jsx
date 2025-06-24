import { Link } from 'react-router-dom';
import { useCart } from '../context/CartContext';
import { useWishlistContext } from '../context/WishlistContext';

export default function ProductCard({ product }) {
  const { addToCart } = useCart();
  const { wishlist, addToWishlist, removeFromWishlist } = useWishlistContext();
  const isInWishlist = wishlist.some(item => item.id === product.id);

  return (
    <div className="product-card">
      <button 
        className="wishlist-btn"
        onClick={() => isInWishlist ? removeFromWishlist(product.id) : addToWishlist(product)}
        aria-label={isInWishlist ? "Remove from wishlist" : "Add to wishlist"}
      >
        {isInWishlist ? '❤️' : '🤍'}
      </button>
      
      <Link to={`/products/${product.id}`}>
        <img src={product.image} alt={product.name} />
        <h3>{product.name}</h3>
        <p>${product.price.toFixed(2)}</p>
        <p className="category">{product.category}</p>
      </Link>
      
      <button 
        className="add-to-cart"
        onClick={() => addToCart(product)}
      >
        Add to Cart
      </button>
    </div>
  );
}
