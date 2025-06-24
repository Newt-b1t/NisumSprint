import { createContext, useContext, useState, useEffect } from 'react';
import localforage from 'localforage';

const WishlistContext = createContext();

export function WishlistProvider({ children }) {
  const [wishlist, setWishlist] = useState([]);

  useEffect(() => {
    localforage.getItem('wishlist').then(data => {
      if (data) setWishlist(data);
    });
  }, []);

  const syncStorage = (newList) => {
    setWishlist(newList);
    localforage.setItem('wishlist', newList);
  };

  const addToWishlist = (product) => {
    if (!wishlist.some(item => item.id === product.id)) {
      syncStorage([...wishlist, product]);
    }
  };

  const removeFromWishlist = (id) => {
    syncStorage(wishlist.filter(item => item.id !== id));
  };

  return (
    <WishlistContext.Provider 
      value={{ wishlist, addToWishlist, removeFromWishlist }}
    >
      {children}
    </WishlistContext.Provider>
  );
}

export const useWishlistContext = () => useContext(WishlistContext);
