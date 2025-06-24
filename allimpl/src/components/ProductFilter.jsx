import { useState, useEffect } from 'react';
import useDebounce from '../hooks/useDebounce';

export default function ProductFilter({ products, onFilter }) {
  const [filters, setFilters] = useState({
    name: '',
    category: '',
    minPrice: 0,
    maxPrice: Infinity
  });
  
  const debouncedName = useDebounce(filters.name, 300);
  
  useEffect(() => {
    const filtered = products.filter(product => {
      const nameMatch = product.name.toLowerCase().includes(debouncedName.toLowerCase());
      const categoryMatch = filters.category ? product.category === filters.category : true;
      const priceMatch = product.price >= filters.minPrice && product.price <= filters.maxPrice;
      return nameMatch && categoryMatch && priceMatch;
    });
    onFilter(filtered);
  }, [debouncedName, filters, products, onFilter]);

  return (
    <div className="filters">
      <input 
        type="text"
        placeholder="Search..."
        value={filters.name}
        onChange={e => setFilters({...filters, name: e.target.value})}
      />
      
      <select 
        value={filters.category} 
        onChange={e => setFilters({...filters, category: e.target.value})}
      >
        <option value="">All Categories</option>
        {[...new Set(products.map(p => p.category))].map(cat => (
          <option key={cat} value={cat}>{cat}</option>
        ))}
      </select>
      
      <div>
        <label>Price Range:</label>
        <input 
          type="number" 
          placeholder="Min" 
          value={filters.minPrice}
          onChange={e => setFilters({...filters, minPrice: Number(e.target.value)})}
        />
        <input 
          type="number" 
          placeholder="Max" 
          value={filters.maxPrice || ''}
          onChange={e => setFilters({...filters, maxPrice: Number(e.target.value) || Infinity})}
        />
      </div>
    </div>
  );
}
