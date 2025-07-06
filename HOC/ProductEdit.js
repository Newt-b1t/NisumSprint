import React, { useState } from "react";

function ProductEdit({ product }) {
  const [name, setName] = useState(product.name);

  const handleSave = () => {
    alert(`Product "${name}" updated!`);
    // Here you could dispatch a Redux action or call an API
  };

  return (
    <div>
      <h2>Edit Product</h2>
      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        style={{ marginRight: 8 }}
      />
      <button onClick={handleSave}>Save</button>
    </div>
  );
}

export default ProductEdit;
