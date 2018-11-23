package model;

import io.vavr.control.Try;
import model.Item.CategoryDAO;
import model.Item.TaskDAO;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

// Data access object
public class DAO implements DAOI {

    private final String url;
    private final String user;
    private final String pass;

    private Connection conn = null;
    private List<Task> list = new ArrayList<>();

    private CategoryDAO categoryDAO = new CategoryDAO();
    private TaskDAO taskDAO = new TaskDAO();

    public DAO() {
        //get database properties
        Properties properties = setProperties();

        this.url = properties.getProperty("url");
        this.user = properties.getProperty("user");
        this.pass = properties.getProperty("pass");
    }


    private Properties setProperties() {
        return Try.of(() -> {
            Properties prop = new Properties();
            prop.load(new FileInputStream("resources /Prop.properties"));
            return prop;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }


    @Override
    public Connection getConnection() {
        if (this.conn == null) {
            Try.of(() -> {
                this.conn = DriverManager
                        .getConnection(
                                url,
                                user,
                                pass
                        );
                System.out.println("Connection made");
                return this.conn;
            }).getOrElseThrow(throwable -> {
                throw new IllegalArgumentException(throwable.getMessage());
            });
        }
        return this.conn;
    }


    @Override
    public void closeConnection() {
        try {
            this.conn.close();
            System.out.println("connection closed");
        } catch (SQLException e) {
            throw new RuntimeException(e.getCause());
        }
    }


    public Optional<Void> closeConn() {
         Try.of(() -> {
            this.conn.close();
            System.out.println("Connection closed");
            return Optional.empty();
        }).getOrElseThrow(throwable -> {
            throw new RuntimeException(throwable.getMessage());
        });
        return Optional.empty();
    }


    public Optional getAll_Task() {
         return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM TASK";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                list.add(createTask(rows));
            }

            list.forEach(i -> {
                System.out.println("Title:"
                        + i.title() + ", Level:"
                        + i.level() + ", Date:"
                        + i.level() + ", Date:");
            });

            rows.close();
            con.close();
            return Optional.empty();
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }


    private Task createTask(ResultSet rows) {
        Task task = taskDAO.create(rows);
        return task;
    }


    private Category createCategory(ResultSet rows) {
        Category category = categoryDAO.create(rows);
        return category;
    }


    public int getTaksCount() {
        return list.size();
    }


}
