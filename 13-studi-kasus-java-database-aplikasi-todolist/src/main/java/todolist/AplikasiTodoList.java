package todolist;

import com.zaxxer.hikari.HikariDataSource;
import todolist.repository.TodoListRepository;
import todolist.repository.TodoListRepositoryImpl;
import todolist.service.TodoListService;
import todolist.service.TodoListServiceImpl;
import todolist.util.DatabaseUtil;
import todolist.view.TodoListView;

public class AplikasiTodoList {
    public static void main(String[] args) {
        HikariDataSource dataSource = DatabaseUtil.getHikariDataSource();

        TodoListRepository todoListRepository = new TodoListRepositoryImpl(dataSource);
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.showTodoList();
    }
}
