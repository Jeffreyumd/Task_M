package controller;

import io.vavr.control.Try;
import model.*;

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

    private DataModel model = new DataModelImple();

    public DAO() {
        //get database properties
        Properties properties = setProperties();

        this.url = properties.getProperty("url");
        this.user = properties.getProperty("user");
        this.pass = properties.getProperty("pass");
    }


    /**
     *
     * @return
     */
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

    @Override
    public List<Project> getAllProject() {
        List<Project> project = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Project";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                project.add(createProject(rows));
            }

            model.printAllProject(project);

            rows.close();
            return project;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> task = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Task";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                task.add(createTask(rows));
            }

            model.printAllTask(task);

            rows.close();
            return task;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> category = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Category";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                category.add(createCategory(rows));
            }

            model.printAllCategory(category);

            rows.close();
            return category;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    private Task createTask(ResultSet rows) {
        Task task = model.createTask(rows);
        return task;
    }


    private Category createCategory(ResultSet rows) {
        Category category = model.createCategory(rows);
        return category;
    }

    private Project createProject(ResultSet rows) {
        Project project = model.createProject(rows);
        return project;
    }


    public int getTaksCount() {
        return list.size();
    }


}
