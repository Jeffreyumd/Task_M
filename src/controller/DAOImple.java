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
import java.util.Properties;

// Data access object
public class DAOImple implements DAO {

    private final String url;
    private final String user;
    private final String pass;

    private Connection conn = null;
    private List<Task> list = new ArrayList<>();

    private DataModel model = new DataModelImple();

    public DAOImple() {
        //get database properties
        Properties properties = setProperties();

        this.url = properties.getProperty("url");
        this.user = properties.getProperty("user");
        this.pass = properties.getProperty("pass");
    }


    /**
     * Read url, user and pass from the Proper file for connecting to the database.
     * @return Properties with store information needed for database connection.
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
                throw new RuntimeException(throwable.getMessage());
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
    public Try<List<Project>> getAllProject() {
        List<Project> project = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Project";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                project.add(createProject(rows));
            }



            rows.close();
            return project;
        });
    }

    @Override
    public Try<List<Task>> getAllTask() {
        List<Task> task = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Task";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                task.add(createTask(rows));
            }

            task.forEach(i -> {
                System.out.println("ID:" + i.id() +
                        " Title:" + i.title() +
                        " Level:" + i.level() +
                        " Date:" + i.date() +
                        " Category:" + i.category() +
                        " Description:" + i.description() +
                        " Completed:" + i.completed()
                );

            });

            rows.close();
            return task;
        });
    }

    @Override
    public Try<List<Category>> getAllCategory() {
        List<Category> category = new ArrayList();

        return Try.of(() -> {
            Connection con = getConnection();
            Statement stmt = con.createStatement();

            String sqlGet = "SELECT * FROM Category";
            ResultSet rows = stmt.executeQuery(sqlGet);

            while (rows.next()) {
                category.add(createCategory(rows));
            }

            rows.close();
            return category;
        });
    }

    /**
     * Create a task with the result set collected from the database.
     * @param rows The result set collected from the database
     * @return A new task with values collected from the database
     */
    private Task createTask(ResultSet rows) {
        Task task = model.createTask(rows);
        return task;
    }


    /**
     * Create a category with the result set collected from the database.
     * @param rows The result set collected from the database
     * @return A new category with values collected from the database
     */
    private Category createCategory(ResultSet rows) {
        Category category = model.createCategory(rows);
        return category;
    }

    /**
     * Create a project with the result set collected from the database.
     * @param rows The result set collected from the database
     * @return A new project with values collected from the database
     */
    private Project createProject(ResultSet rows) {
        Project project = model.createProject(rows);
        return project;
    }


    public int getTaksCount() {
        return list.size();
    }


}
