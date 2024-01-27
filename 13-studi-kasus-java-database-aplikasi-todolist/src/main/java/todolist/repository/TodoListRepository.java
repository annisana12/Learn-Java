package todolist.repository;

import todolist.entity.TodoList;

public interface TodoListRepository {
    TodoList[] getAll();

    void add(TodoList todo);

    boolean remove(Integer number);
}
