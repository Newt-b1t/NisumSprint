import { useWishlistContext } from '../context/WishlistContext';
import ProductCard from '../components/ProductCard';

export default function WishlistPage() {
  const { wishlist } = useWishlistContext();

  return (
    <div className="wishlist-page">
      <h2>Your Wishlist</h2>
      
      {wishlist.length === 0 ? (
        <div className="empty-wishlist">
          <p>Your wishlist is empty</p>
          <p>Add items to your wishlist by clicking the ❤️ icon</p>
        </div>
      ) : (
        <div className="wishlist-items">
          {wishlist.map(product => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>
      )}
    </div>
  );
}
