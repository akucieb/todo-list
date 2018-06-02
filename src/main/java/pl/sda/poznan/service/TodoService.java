package pl.sda.poznan.service;


import java.util.List;
import pl.sda.poznan.model.TodoItem;
import pl.sda.poznan.repository.TodoRepository;

public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodos() {
        return this.todoRepository.getAll();
    }

    public void save(TodoItem todoItem) {
        this.todoRepository.save(todoItem);
    }
}