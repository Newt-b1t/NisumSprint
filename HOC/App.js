// App.js for Wrap Product Component with HOC for Admin Access
import React from "react";
import AdminProductEdit from "./AdminProductEdit";

// Simulate user roles (could also come from context or Redux)
const adminUser = { id: 1, name: "Alice", role: "admin" };
const regularUser = { id: 2, name: "Bob", role: "user" };

const product = { id: 101, name: "T-shirt" };

function App() {
  return (
    <div style={{ padding: 24 }}>
      <h1>Product Edit (Admin Only)</h1>
      <h3>As Admin:</h3>
      <AdminProductEdit user={adminUser} product={product} />

      <h3 style={{ marginTop: 32 }}>As Regular User:</h3>
      <AdminProductEdit user={regularUser} product={product} />
    </div>
  );
}

export default App;




// App.js for a simple React application that uses Redux for state management
// import React from "react";
// import { Provider } from "react-redux";
// import store from "./storeL";
// import UserPanel from "./UserPanelL";
// import ProductList from "./ProductListL";
// import CartL from "./CartL";

// function App() {
//   return (
//     <Provider store={store}>
//       <UserPanel />
//       <ProductList />
//       <CartL />
//     </Provider>
//   );
// }

// export default App;



// App.js for a simple React application that uses Redux toolkit for state management
// import React from 'react';
// import { Provider } from 'react-redux';
// import store from './store';
// import Cart from './Cart';
// import UserPanel from './UserPanel';
// import ProductList from './ProductList';
// import './App.css';

// function App() {
//   return (
//     <Provider store={store}>
//       <header>My E-Commerce Store</header>
//       <div className="container">
//         <UserPanel />
//         <ProductList />
//         <Cart />
//       </div>
//     </Provider>
//   );
// }

// export default App;





// App.js for a simple React application that uses context to manage theme switching
// import React from "react";
// import { ThemeProvider } from "./ThemeContext";
// import Header from "./Header";
// import Card from "./Card";
// import Footer from "./Footer";

// function App() {
//   return (
//     <ThemeProvider>
//       <Header />
//       <main>
//         <Card />
//         <Card />
//       </main>
//       <Footer />
//     </ThemeProvider>
//   );
// }

// export default App;



//app.js file for a simple React application that uses context to manage user data
// import React from 'react';
// import { UserProvider } from './UserContext';
// import Dashboard from './Dashboard';

// function App() {
//   return (
//     <UserProvider>
//       <Dashboard />
//     </UserProvider>
//   );
// }

// export default App;


//Test prarctice app.js
// import logo from './logo.svg';
// import Test from './Test.jsx';
// import Test1 from './Test1.jsx';
// import Test2 from './Test2.jsx';
// import Button from './Button.jsx';
// import './App.css';

// function App() {
//   const pcontent = "This is my first prop";
//   const listArr = ["apple", "banana", "cherry", "date"];
//   const person = {
//     name: "John Doe",
//     age: 30,
//     position: "student"
//   };

//   let arrList = [
// 	  {'id':1,'name':'avi','Profession':'Software engg'},
// 	  {'id':2,'name':'arya','Profession':'QA engg'},
// 	  {'id':3,'name':'suhana','Profession':'Civil engg'},
// 	  {'id':4,'name':'as','Profession':'Software engg'}
//   ];
//   function handleClick() {
//     alert("Button clicked!");
//   }
//   function handleSelect(e) {
//     console.log(`Selected option: ${e.target.value}`);
//   }
//   function handleSubmit(e) {

//     e.preventDefault();
//     const name = e.target[0].value; // Get the value of the first input field
//     const position = e.target[1].value; // Get the value of the select field
//     const yesChecked = e.target[2].checked; // Check if the first checkbox is checked
//     const noChecked = e.target[3].checked; // Check if the second checkbox is checked

//     console.log(`Name: ${name}, Position: ${position}, Yes: ${yesChecked}, No: ${noChecked}`);
//   }
//   return (
//     <div className="App">
//         <Test content = {person}/>
//         <Test1 arr={listArr} />
//         <Test2 arrL={arrList} />
//         <Button onClick={handleClick}>Submit</Button>
//         <br />
//         <select onChange={handleSelect}>
//           <option value="option1">Option 1</option>
//           <option value="option2">Option 2</option>
//           <option value="option3">Option 3</option>
//         </select>
//         <br />
//         <form onSubmit={handleSubmit}>
//           Name: <input />
//           <br />
//           Position: 
//           <select onChange={handleSelect}>
//             <option value="student">Student</option>
//             <option value="teacher">Teacher</option>
//             <option value="engineer">Engineer</option>
//           </select>
//           <br />
//           Yes:
//           <input type="checkbox" />
//           No:
//           <input type="checkbox" />
//           <br />
//           <button type="submit">Submit</button>
//         </form>
//     </div>
//   );

// }

// export default App;
