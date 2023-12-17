package service; // Business logic

import entity.TodoList;
import repository.TodoListRepository;

public class TodoListServiceImpl implements TodoListService {

    private TodoListRepository todoListRepository;

    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public void showTodoList() {
        TodoList[] model = todoListRepository.getAll();

        for (var i = 0; i < model.length; i++) {
            var todoList = model[i];
            var no = i + 1;

            if (todoList != null) {
                System.out.println(no + ". " + todoList.getTodo());
            }
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
