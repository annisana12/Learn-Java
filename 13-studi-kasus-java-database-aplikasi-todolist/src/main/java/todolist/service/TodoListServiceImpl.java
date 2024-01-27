package todolist.service; // Business logic

import todolist.entity.TodoList;
import todolist.repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        for (var todo : model) {
            System.out.println(todo.getId() + ". " + todo.getTodo());
        }
    }

    @Override
    public void addTodoList(String todo) {
        TodoList todoList = new TodoList(todo);
        todoListRepository.add(todoList);
        System.out.println("SUKSES MENAMBAH TODO: " + todo);
    }

    @Override
    public void removeTodoList(Integer number) {
        boolean isSuccess = todoListRepository.remove(number);

        if (isSuccess) {
            System.out.println("SUKSES MENGHAPUS TODO NOMOR : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS TODO NOMOR : " + number);
        }
    }
}
