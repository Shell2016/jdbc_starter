package ru.michaelshell;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.SQLException;

public class BlobRunner {
    public static void main(String[] args) throws SQLException, IOException {
//        saveImage();
        getImage();
    }

    private static void getImage() throws SQLException, IOException {
        var sql = """
                SELECT image
                FROM aircraft
                WHERE id = ?
                """;
        try (var connection = ConnnectionManager.open();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, 2);
            var result = preparedStatement.executeQuery();
            if (result.next()) {
                Files.write(Path.of("resources", "boieng_new.jpg"), result.getBytes("image"), StandardOpenOption.CREATE);
            }
        }
    }

    private static void saveImage() throws SQLException, IOException {
        var sql = """
                UPDATE aircraft
                SET image = ?
                WHERE model = 'Боинг 737-300'
                """;

        try (var connection = ConnnectionManager.open();
             var preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setBytes(1, Files.readAllBytes(Path.of("resources", "boeing_737-300.jpg")));
            preparedStatement.executeUpdate();
        }
    }
}
