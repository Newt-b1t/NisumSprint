// todo.ts
export var Priority;
(function (Priority) {
    Priority["Low"] = "Low";
    Priority["Medium"] = "Medium";
    Priority["High"] = "High";
})(Priority || (Priority = {}));
// Class with Generics
export default class TodoList {
    constructor(generateId) {
        this.generateId = generateId;
        this.todos = new Map();
    }
    addTodo(item) {
        this.todos.set(item.id, item);
    }
    toggleTodo(id) {
        const todo = this.todos.get(id);
        if (todo) {
            todo.completed = !todo.completed;
        }
    }
    removeTodo(id) {
        this.todos.delete(id);
    }
    searchTodos(criteria) {
        const result = [];
        for (const [, todo] of this.todos) {
            if (typeof criteria === "string" &&
                todo.title.toLowerCase().includes(criteria.toLowerCase())) {
                result.push(todo);
            }
            else if (typeof criteria === "number" && todo.id === criteria) {
                result.push(todo);
            }
        }
        return result;
    }
    getAllTodos() {
        return Array.from(this.todos.values());
    }
}
