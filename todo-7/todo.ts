// todo.ts
export enum Priority {
  Low = "Low",
  Medium = "Medium",
  High = "High",
}

export interface Todo {
  id: number;
  title: string;
  completed: boolean;
  priority?: Priority;
}

// Class with Generics
export default class TodoList<T extends Todo> {
  private todos: Map<number, T>;
  private generateId: () => number;

  constructor(generateId: () => number) {
    this.generateId = generateId;
    this.todos = new Map();
  }

  addTodo(item: T) {
    this.todos.set(item.id, item);
  }

  toggleTodo(id: number) {
    const todo = this.todos.get(id);
    if (todo) {
      todo.completed = !todo.completed;
    }
  }

  removeTodo(id: number) {
    this.todos.delete(id);
  }

  searchTodos(criteria: string | number): T[] {
    const result: T[] = [];
    for (const [, todo] of this.todos) {
      if (
        typeof criteria === "string" &&
        todo.title.toLowerCase().includes(criteria.toLowerCase())
      ) {
        result.push(todo);
      } else if (typeof criteria === "number" && todo.id === criteria) {
        result.push(todo);
      }
    }
    return result;
  }

  getAllTodos(): T[] {
    return Array.from(this.todos.values());
  }
}
