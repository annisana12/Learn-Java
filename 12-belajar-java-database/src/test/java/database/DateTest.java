package database;

import database.util.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
    @Test
    void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = """
                INSERT INTO sample_time (sample_time, sample_date, sample_timestamp)
                VALUES (?, ?, ?)
                """;

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, Calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        Date date = calendar.getTime();
        long msInLong = date.getTime();

        preparedStatement.setTime(1, new Time(msInLong));
        preparedStatement.setDate(2, new java.sql.Date(msInLong));
        preparedStatement.setTimestamp(3, new Timestamp(msInLong));

//        preparedStatement.setTime(1, new Time(System.currentTimeMillis()));
//        preparedStatement.setDate(2, new java.sql.Date(System.currentTimeMillis()));
//        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();

        String sql = "SELECT * FROM sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Time time = resultSet.getTime("sample_time");
            System.out.println("Time = " + time);

            java.sql.Date date = resultSet.getDate("sample_date");
            System.out.println("Date = " + date);

            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");
            System.out.println("Timestamp = " + timestamp);
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
