import TodoList, { Priority } from './todo.js';

let idCounter = 1;
const appInfo: [string, number] = ["TodoApp", 1.0];
const todoList = new TodoList(() => idCounter++);

const input = document.getElementById("todoInput") as HTMLInputElement;
const addBtn = document.getElementById("addBtn") as HTMLButtonElement;
const list = document.getElementById("todoList") as HTMLUListElement;
const searchInput = document.getElementById("searchInput") as HTMLInputElement;
const priorityInput = document.getElementById("priorityInput") as HTMLSelectElement;

function render(todos = todoList.getAllTodos()) {
  list.innerHTML = "";
  for (const todo of todos) {
    const li = document.createElement("li");
    li.textContent = `${todo.title} (${todo.priority ?? "No Priority"})`;
    if (todo.completed) li.classList.add("done");

    li.addEventListener("click", () => {
      todoList.toggleTodo(todo.id);
      render();
    });

    const removeBtn = document.createElement("button");
    removeBtn.textContent = "delete";
    removeBtn.addEventListener("click", (e) => {
      e.stopPropagation();
      todoList.removeTodo(todo.id);
      render();
    });

    li.appendChild(removeBtn);
    list.appendChild(li);
  }
}

addBtn.addEventListener("click", () => {
    const title = input.value.trim();
    const priority = priorityInput.value as Priority; 
    
    if (title) {
        const newTodo = {
            id: idCounter++,
            title,
            completed: false,
            priority
        };
        todoList.addTodo(newTodo);
        input.value = "";
        priorityInput.value = "Medium"; 
        render();
    }
});


function isString(val: unknown): val is string {
  return typeof val === "string";
}

searchInput.addEventListener("input", () => {
  const keyword = searchInput.value;
  const results = todoList.searchTodos(keyword);
  render(results);
});

render();
