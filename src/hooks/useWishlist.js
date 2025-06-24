import { useState, useEffect } from 'react';
import localforage from 'localforage';

export default function useWishlist() {
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

  return { wishlist, addToWishlist, removeFromWishlist };
}
