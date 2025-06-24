import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';

import { CartProvider } from './context/CartContext';
import { WishlistProvider } from './context/WishlistContext';
import ProductListPage from './pages/ProductListPage';
import ProductDetailPage from './pages/ProductDetailPage';
import CartPage from './pages/CartPage';
import WishlistPage from './pages/WishlistPage';


function App() {
  return (
    
      <CartProvider>
        <WishlistProvider>
          <BrowserRouter>
            <div className="app-container">
              <header>

                <nav className="main-nav">
                  <Link to="/">Home</Link> | 
                  <Link to="/cart">Cart</Link> | 
                  <Link to="/wishlist">Wishlist</Link>
                </nav>
              </header>
              <main>
                <Routes>
                  <Route path="/" element={
                    <>
                     
                      <section className="products-section">
                        <h2>All Products</h2>
                        <ProductListPage />
                      </section>
                    </>
                  } />
                  <Route path="/products/:id" element={<ProductDetailPage />} />
                  <Route path="/cart" element={<CartPage />} />
                  <Route path="/wishlist" element={<WishlistPage />} />
                </Routes>
              </main>
            </div>
          </BrowserRouter>
        </WishlistProvider>
      </CartProvider>
    
  );
}

export default App;
