import React, { useReducer, useState } from 'react';
import './TodoApp.css';


function todoReducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      return [
        ...state,
        {
          id: Date.now(),
          text: action.payload,
          completed: false
        }
      ];
      
    case 'DELETE_TODO':
      return state.filter(todo => todo.id !== action.payload);
      
    case 'TOGGLE_TODO':
      return state.map(todo =>
        todo.id === action.payload 
          ? { ...todo, completed: !todo.completed } 
          : todo
      );
      
    default:
      return state;
  }
}

function TodoApp() {
  const [todos, dispatch] = useReducer(todoReducer, []);
  const [todoText, setTodoText] = useState('');
  

  const completedCount = todos.filter(todo => todo.completed).length;
  const pendingCount = todos.length - completedCount;
  

  const addTodo = () => {
    if (todoText.trim()) {
      dispatch({ type: 'ADD_TODO', payload: todoText });
      setTodoText('');
    }
  };
  
  const deleteTodo = id => dispatch({ type: 'DELETE_TODO', payload: id });
  const toggleTodo = id => dispatch({ type: 'TOGGLE_TODO', payload: id });

  return (
    <div className="todo-app">
      <h1>Todo List</h1>
      

      <div className="add-todo">
        <input
          type="text"
          value={todoText}
          onChange={e => setTodoText(e.target.value)}
          placeholder="Add a new task"
          onKeyDown={e => e.key === 'Enter' && addTodo()}
        />
        <button onClick={addTodo}>Add Todo</button>
      </div>
      

      <div className="stats">
        <p>Total: {todos.length}</p>
        <p>Completed: {completedCount}</p>
        <p>Pending: {pendingCount}</p>
      </div>
      

      <ul className="todo-list">
        {todos.map(todo => (
          <li 
            key={todo.id}
            className={todo.completed ? 'completed' : ''}
          >
            <span onClick={() => toggleTodo(todo.id)}>
              {todo.text}
            </span>
            <button onClick={() => deleteTodo(todo.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoApp;
