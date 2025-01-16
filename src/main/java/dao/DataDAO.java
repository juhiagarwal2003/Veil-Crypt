package dao;

import db.MyConnection;
import model.Data;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {

    // Method to retrieve all files for a specific email
    public static List<Data> getAllFiles(String email) throws SQLException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM data WHERE email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        List<Data> files = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String path = rs.getString(3);
            files.add(new Data(id, name, path));
        }
        return files;
    }

    // Method to hide a file (store it in the database)
    public static int hideFile(Data file) throws SQLException, IOException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO data(name, path, email, bin_data) VALUES(?,?,?,?)");

        ps.setString(1, file.getFileName());
        ps.setString(2, file.getPath());
        ps.setString(3, file.getEmail());

        File f = new File(file.getPath());
        FileInputStream fis = new FileInputStream(f); // Using FileInputStream for binary data
        ps.setBinaryStream(4, fis, (int) f.length()); // Using setBinaryStream to handle binary data

        int ans = ps.executeUpdate();
        fis.close();
        f.delete(); // Delete the file after inserting it into the database
        return ans;
    }

    // Method to unhide a file (retrieve and save it back to its original location)
    public static void unhide(int id) throws SQLException, IOException {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT path, bin_data FROM data WHERE id = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String path = rs.getString("path");
        InputStream binDataStream = rs.getBinaryStream("bin_data"); // Use getBinaryStream for binary data

        FileOutputStream fos = new FileOutputStream(path); // Write the binary data to a file
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = binDataStream.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        fos.close();

        // Optionally delete the data from the database after retrieving it
        ps = connection.prepareStatement("DELETE FROM data WHERE id = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("Successfully Unhidden");
    }
}
