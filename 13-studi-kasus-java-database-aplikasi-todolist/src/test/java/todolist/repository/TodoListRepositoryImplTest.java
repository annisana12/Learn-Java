package todolist.repository;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todolist.entity.TodoList;
import todolist.util.DatabaseUtil;

public class TodoListRepositoryImplTest {

    private HikariDataSource dataSource;
    private TodoListRepository todoListRepository;

    @BeforeEach
    void setUp() {
        dataSource = DatabaseUtil.getHikariDataSource();
        todoListRepository = new TodoListRepositoryImpl(dataSource);
    }

    @Test
    void testAdd() {
        TodoList todo = new TodoList("Belajar Java Dasar");
        todoListRepository.add(todo);

        Assertions.assertNotNull(todo.getId());
    }

    @Test
    void testRemove() {
        boolean isSuccess = todoListRepository.remove(2);
        Assertions.assertTrue(isSuccess);
    }

    @Test
    void testGetAll() {
        todoListRepository.add(new TodoList("Belajar PHP"));
        todoListRepository.add(new TodoList("Belajar JavaScript"));

        TodoList[] todoLists = todoListRepository.getAll();

        for (var todo : todoLists) {
            System.out.println(todo);
        }
    }

    @AfterEach
    void tearDown() {
        dataSource.close();
    }
}
