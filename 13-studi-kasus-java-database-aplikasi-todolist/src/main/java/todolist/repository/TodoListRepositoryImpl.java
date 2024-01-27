package todolist.repository; // CRUD data

import com.zaxxer.hikari.HikariDataSource;
import todolist.entity.TodoList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TodoListRepositoryImpl implements TodoListRepository {

    private HikariDataSource dataSource;

    public TodoListRepositoryImpl(HikariDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TodoList[] getAll() {
        String sql = "SELECT * FROM todolist WHERE status_id = 1";

        try (
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)
        ) {
            List<TodoList> todoLists = new ArrayList<>();

            while (resultSet.next()) {
                todoLists.add(new TodoList(
                        resultSet.getInt("id"),
                        resultSet.getString("todo"),
                        resultSet.getInt("status_id")
                ));
            }

            return todoLists.toArray(new TodoList[]{});
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void add(TodoList todo) {
        String sql = "INSERT INTO todolist (todo) VALUES (?)";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, todo.getTodo());
            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    todo.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private boolean isExist(Integer id) {
        String sql = "SELECT * FROM todolist WHERE id = ? AND status_id = 1";

        try (
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public boolean remove(Integer id) {
        if (isExist(id)) {
            String sql = """
                        UPDATE todolist
                        SET status_id = 0
                        WHERE id = ?
                    """;

            try (
                    Connection connection = dataSource.getConnection();
                    PreparedStatement statement = connection.prepareStatement(sql)
            ) {
                statement.setInt(1, id);
                statement.executeUpdate();

                return true;
            } catch (SQLException exception) {
                throw new RuntimeException((exception));
            }
        } else {
            return false;
        }
    }
}
