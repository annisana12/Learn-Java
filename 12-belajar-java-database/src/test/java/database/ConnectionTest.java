package database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String url = "jdbc:mysql://localhost:3306/belajar_java_database?serverTimezon=Asia/Jakarta";
        String user = "user1";
        String password = "rahasia";

        try (Connection connection = DriverManager.getConnection(url, user, password);) {
            System.out.println("Berhasil connect ke database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}
