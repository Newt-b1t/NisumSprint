// todo.js
const idSymbol = Symbol('id');

export default class TodoList {
  constructor() {
    this.todos = new Map();
    this.idGen = this.idGenerator();
  }

  *idGenerator() {
    let id = 1;
    while (true) {
      yield id++;
    }
  }

  addTodo(title = 'Untitled') {
    const id = this.idGen.next().value;
    const todo = { [idSymbol]: id, title, completed: false };
    this.todos.set(id, todo);
  }

  toggleTodo(id) {
    const todo = this.todos.get(id);
    if (todo) todo.completed = !todo.completed;
  }

  removeTodo(id) {
    this.todos.delete(id);
  }

  searchTodos(keyword) {
    const results = [];
    for (const [, todo] of this.todos) {
      if (todo.title.toLowerCase().includes(keyword.toLowerCase())) {
        results.push(todo);
      }
    }
    return results;
  }

  getAllTodos() {
    return Array.from(this.todos.values());
  }
}
