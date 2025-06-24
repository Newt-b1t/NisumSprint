import { useState, useEffect } from 'react';
import ProductFilter from '../components/ProductFilter';
import ProductCard from '../components/ProductCard';
import PaginationObserver from '../components/PaginationObserver';
import products from '../data/products';

export default function ProductListPage() {
  const [allProducts, setAllProducts] = useState([]);
  const [filteredProducts, setFilteredProducts] = useState([]);
  const [displayedProducts, setDisplayedProducts] = useState([]);
  const [page, setPage] = useState(1);
  const [isLoading, setIsLoading] = useState(false);
  const [selectedCategory, setSelectedCategory] = useState('All');

  const productsPerPage = 10;

  // Simulate API fetch
  useEffect(() => {
    setIsLoading(true);
    setTimeout(() => {
      setAllProducts(products);
      setFilteredProducts(products);
      setIsLoading(false);
    }, 500);
  }, []);

  // Handle pagination
  useEffect(() => {
    setDisplayedProducts(filteredProducts.slice(0, page * productsPerPage));
  }, [filteredProducts, page]);

  const loadMore = () => {
    if (!isLoading) {
      setPage(prev => prev + 1);
    }
  };

  // Extract categories
  const categories = ['All', ...Array.from(new Set(allProducts.map(p => p.category)))];

  // Handle category tab click
  const handleCategoryClick = (cat) => {
    setSelectedCategory(cat);
    setPage(1); // Reset pagination
    setFilteredProducts(cat === 'All' ? allProducts : allProducts.filter(p => p.category === cat));
    window.scrollTo(0, 0); // Reset scroll to top
  };

  return (
    <div className="product-list-page">
      <h2>All Products</h2>
      <div className="category-tabs">
        {categories.map(cat => (
          <button
            key={cat}
            className={cat === selectedCategory ? 'active' : ''}
            onClick={() => handleCategoryClick(cat)}
          >
            {cat}
          </button>
        ))}
      </div>
      <ProductFilter 
        products={allProducts} 
        onFilter={setFilteredProducts} 
      />
      {isLoading ? (
        <div className="loader">Loading products...</div>
      ) : (
        <>
          <div className="product-grid">
            {displayedProducts.map(product => (
              <ProductCard key={product.id} product={product} />
            ))}
          </div>
          {displayedProducts.length < filteredProducts.length && (
            <PaginationObserver 
              onIntersect={loadMore} 
              isLoading={isLoading} 
            />
          )}
        </>
      )}
    </div>
  );
}
