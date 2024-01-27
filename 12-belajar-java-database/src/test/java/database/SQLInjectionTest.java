package database;

import database.util.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class SQLInjectionTest {
    @Test
    void testSQLInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = '" + username
                + "' AND password = '" + password + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            // sukses login
            System.out.println("Sukses login untuk username " + resultSet.getString("username"));
        } else {
            // gagal login
            System.out.println("Gagal login");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    void testPrepareStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String username = "admin'; #";
        String password = "salah";
        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // login berhasil
            System.out.println("Login berhasil untuk username " + resultSet.getString("username"));
        } else {
            // gagal login
            System.out.println("Gagal Login");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
