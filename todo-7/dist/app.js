import TodoList from './todo.js';
let idCounter = 1;
const appInfo = ["TodoApp", 1.0];
const todoList = new TodoList(() => idCounter++);
const input = document.getElementById("todoInput");
const addBtn = document.getElementById("addBtn");
const list = document.getElementById("todoList");
const searchInput = document.getElementById("searchInput");
const priorityInput = document.getElementById("priorityInput");
function render(todos = todoList.getAllTodos()) {
    var _a;
    list.innerHTML = "";
    for (const todo of todos) {
        const li = document.createElement("li");
        li.textContent = `${todo.title} (${(_a = todo.priority) !== null && _a !== void 0 ? _a : "No Priority"})`;
        if (todo.completed)
            li.classList.add("done");
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
    const priority = priorityInput.value;
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
function isString(val) {
    return typeof val === "string";
}
searchInput.addEventListener("input", () => {
    const keyword = searchInput.value;
    const results = todoList.searchTodos(keyword);
    render(results);
});
render();
