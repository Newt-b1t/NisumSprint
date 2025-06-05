// app.js
import TodoList from './todo.js';

const todoApp = new TodoList();
const input = document.getElementById('todoInput');
const addBtn = document.getElementById('addBtn');
const list = document.getElementById('todoList');
const searchInput = document.getElementById('searchInput');

const render = (todos = todoApp.getAllTodos()) => {
  list.innerHTML = '';
  for (const todo of todos) {
    const { title, completed } = todo;
    const li = document.createElement('li');
    li.textContent = title;
    li.classList.toggle('done', completed);

    li.addEventListener('click', () => {
      todoApp.toggleTodo(todo[Object.getOwnPropertySymbols(todo)[0]]);
      render();
    });

    const removeBtn = document.createElement('button');
    removeBtn.textContent = 'Delete';
    removeBtn.addEventListener('click', (e) => {
      e.stopPropagation();
      todoApp.removeTodo(todo[Object.getOwnPropertySymbols(todo)[0]]);
      render();
    });

    li.appendChild(removeBtn);
    list.appendChild(li);
  }
};

addBtn.addEventListener('click', () => {
  const title = input.value.trim();
  if (title) {
    todoApp.addTodo(title);
    input.value = '';
    render();
  }
});

searchInput.addEventListener('input', () => {
  const keyword = searchInput.value;
  const filtered = todoApp.searchTodos(keyword);
  render(filtered);
});


Promise.resolve().then(() => console.log('✅ Promises in action!'));
const a = { a: 1 }, b = { b: 2 };
const c = Object.assign({}, a, b);
console.log('Object.assign:', c);
console.log('Object.is:', Object.is(NaN, NaN)); // true
console.log('Array.from:', Array.from('hello'));
console.log('Array.of:', Array.of(1, 2, 3));

render();
