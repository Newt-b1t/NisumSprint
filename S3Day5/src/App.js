
//Q2
// import React from 'react';
// import Counter from './Q2/Counter';

// function App() {
//   return (
//     <div>
//       <Counter />
//     </div>
//   );
// }

// export default App;



//Q3
// import React from 'react';
// import ProductCard from './Q3/ProductCard';

// function App() {
//   return (
//     <div>
//       <ProductCard />
//     </div>
//   );
// }

// export default App;




//Q4
// import React from 'react';
// import ThemeToggle from './Q4/ThemeToggle';

// function App() {
//   return (
//     <div>
//       <ThemeToggle />
//     </div>
//   );
// }

// export default App;




//Q5
// import React from 'react';
// import TodoList from './Q5/TodoList';

// function App() {
//   const myTodos = ['Learn React', 'Complete assignment', 'Go for dinner'];

//   return (
//     <div>
//       <TodoList todos={myTodos} />
//     </div>
//   );
// }

// export default App;



//Q6
// import React from 'react';
// import UserProfile from './Q6/UserProfile';

// function App() {
//   return (
//     <div>
//       <UserProfile
//         name="Madhusmita Sahoo"
//         email="madhusmita@example.com"
//         avatarUrl=""
//         bio="A passionate developer from Odisha!"
//       />
//     </div>
//   );
// }

// export default App;



//Q7
// import React from 'react';
// import Notifications from './Q7/Notifications';

// function App() {
//   const notifications = [
//     {
//       message: 'Assignment submitted successfully.',
//       date: '2025-06-21 10:00 AM',
//       read: true
//     },
//     {
//       message: 'You have a new meeting invite.',
//       date: '2025-06-22 02:30 PM',
//       read: false
//     }
//   ];

//   return (
//     <div>
//       <Notifications notifications={notifications} />
//     </div>
//   );
// }

// export default App;






//Q8
// import React from 'react';
// import Dashboard from './Q8/Dashboard';

// function App() {
//   return (
//     <div>
//       <Dashboard />
//     </div>
//   );
// }

// export default App;




//Q9
// import React from 'react';
// import Navbar from './Q9/Navbar';

// function App() {
//   return (
//     <div>
//       <Navbar />
//     </div>
//   );
// }

// export default App;





//Q10
// import React from 'react';
// import Layout from './Q10/Layout';

// function App() {
//   return (
//     <Layout>
//       <h2>Welcome to the Homepage!</h2>
//       <p>This content is injected via props.children.</p>
//     </Layout>
//   );
// }

// export default App;





//Q11
import React from 'react';
import StatusBadge from './Q11/StatusBadge';

function App() {
  return (
    <div style={{ textAlign: 'center', marginTop: '50px' }}>
      <StatusBadge status="success" />
      <StatusBadge status="error" />
      <StatusBadge status="warning" />
    </div>
  );
}

export default App;





