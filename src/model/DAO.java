package model;

import io.vavr.API;
import io.vavr.control.Try;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

// Data access object
public class DAO {

    private final String url;
    private final String user;
    private final String pass;

    private Connection conn = null;
    private List<Task> list = new ArrayList<>();

    private CategoryDAO categoryDAO = new CategoryDAO();

    public DAO() {
        //get database properties
        Properties properties = setProperties();

        this.url = properties.getProperty("url");
        this.user = properties.getProperty("user");
        this.pass = properties.getProperty("pass");

    }

    private Properties setProperties() {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("resources /Prop.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return prop;
    }


    public Connection getConnection() {
        if (this.conn == null) {
            try {

                this.conn = DriverManager.getConnection(
                        url,
                        user,
                        pass
                );
                System.out.println("Connection made");
                return this.conn;
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return this.conn;
    }


    public void closeConnection() {
        try {
            this.conn.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e.getCause());
        }
    }


    private void getAll_Task() {

        try {

            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM TASK";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                list.add(createTask(rows));
            }

            rows.close();
            con.close();

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void printAll_Task() {
        getAll_Task();
        for (Task task : list) {
            System.out.println("Title:" + task.title() + ", Level:" + task.level() + ", Date:" + task.level() + ", Date:");
        }
    }


    private Task createTask(ResultSet rows) throws SQLException {

        String title = rows.getString("title");
        Level level = Level.valueOf(rows.getString("level"));
        String description = rows.getString("description");
        //Date date = rows.getDate("Date").toLocalDate();
        java.util.Date newDate = rows.getDate("Date");
        boolean completed = rows.getBoolean("completed");

        Task task = ImmutableTask
                .builder()
                .title(title)
                .level(level)
                //.date()
                .description(description)
                .completed(completed).build();

        return task;
    }

    private Category createCategory(ResultSet rows) {

        Category category = categoryDAO.create(rows);

        return category;
    }


    public int getTaksCount() {
        return list.size();
    }

    public Try<Void> insertTask(Task task) {

        return null;
    }

    public Try<Void> updateTask(Task task) {
        return null;
    }

    public Try<Void> deleteTask(Task task) {
        return null;
    }


    /**
     * Project methods
     */


    public void getAll_Project() {

    }

    private Project createProject() {
        return null;
    }


}
