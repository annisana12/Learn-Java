package todolist.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabaseUtil {
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_todolist?serverTimezon=Asia/Jakarta");
        config.setUsername("user1");
        config.setPassword("rahasia");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000); // 60s
        config.setMaxLifetime(60 * 60 * 1000);

        hikariDataSource = new HikariDataSource(config);
    }

    public static HikariDataSource getHikariDataSource() {
        return hikariDataSource;
    }
}
