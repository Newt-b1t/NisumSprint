import React from 'react';

const TodoList = ({ todos }) => {
  return (
    <div style={{ textAlign: 'center', marginTop: '40px' }}>
      <h2>My Todo List</h2>
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {todos && todos.length > 0 ? (
          todos.map((todo, index) => (
            <li key={index} style={{ margin: '10px 0' }}>
               {todo}
            </li>
          ))
        ) : (
          <p>No todos available.</p>
        )}
      </ul>
    </div>
  );
};

export default TodoList;
