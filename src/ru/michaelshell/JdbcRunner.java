package ru.michaelshell;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        }
    }
}
