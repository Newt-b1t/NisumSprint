import { useParams, useNavigate, Link } from 'react-router-dom';
import products from '../data/products';

export default function ProductDetailPage() {
  const { id } = useParams();
  const navigate = useNavigate();
  const product = products.find(p => p.id === parseInt(id));

  if (!product) return <div>Product not found</div>;

  return (
    <div>
      <nav>
        <Link to="/products">Products</Link> &gt; {product.name}
      </nav>
      
      <button onClick={() => navigate(-1)}>← Go Back</button>
      
      <div className="product-detail">
        <img src={product.image} alt={product.name} />
        <h1>{product.name}</h1>
        <p>${product.price}</p>
        <p>{product.description}</p>
        <p>Stock: {product.stock}</p>
      </div>
    </div>
  );
}
