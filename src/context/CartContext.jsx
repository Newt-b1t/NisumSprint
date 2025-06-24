import { createContext, useContext, useReducer } from 'react';

const CartContext = createContext();

const cartReducer = (state, action) => {
  switch (action.type) {
    case 'ADD':
      return {
        ...state,
        items: state.items.some(item => item.id === action.item.id)
          ? state.items.map(item => 
              item.id === action.item.id 
                ? { ...item, quantity: item.quantity + 1 } 
                : item
            )
          : [...state.items, { ...action.item, quantity: 1 }]
      };
    case 'REMOVE':
      return {
        ...state,
        items: state.items.filter(item => item.id !== action.id)
      };
    case 'CLEAR':
      return { items: [] };
    case 'UPDATE_QUANTITY':
      return {
        ...state,
        items: state.items.map(item =>
          item.id === action.id
            ? { ...item, quantity: Math.max(1, action.quantity) }
            : item
        )
      };
    default:
      return state;
  }
};

export function CartProvider({ children }) {
  const [cart, dispatch] = useReducer(cartReducer, { items: [] });

  const addToCart = (product) => 
    dispatch({ type: 'ADD', item: product });
  
  const removeFromCart = (id) => 
    dispatch({ type: 'REMOVE', id });
  
  const clearCart = () => 
    dispatch({ type: 'CLEAR' });
  
  const updateQuantity = (id, quantity) => 
    dispatch({ type: 'UPDATE_QUANTITY', id, quantity });

  const totalItems = cart.items.reduce((sum, item) => sum + item.quantity, 0);
  const totalPrice = cart.items.reduce(
    (sum, item) => sum + item.price * item.quantity, 0
  );

  return (
    <CartContext.Provider value={{
      cart,
      addToCart,
      removeFromCart,
      clearCart,
      updateQuantity,
      totalItems,
      totalPrice
    }}>
      {children}
    </CartContext.Provider>
  );
}

export const useCart = () => useContext(CartContext);
