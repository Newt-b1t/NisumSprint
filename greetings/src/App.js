// App.js
import React from 'react';
import greeting from './greeting';

function App() {
  const name = 'Avinash'; 

  return (
    <div>
      <greeting name={name} />
    </div>
  );
}

export default App;
