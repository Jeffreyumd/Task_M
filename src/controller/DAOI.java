package controller;

import io.vavr.control.Try;
import model.Category;
import model.Project;
import model.Task;

import java.sql.Connection;
import java.util.List;

public interface DAOI {

    /**
     * Create a connection to the data base.
     *
     * @return The connection to the data base
     */
    public Connection getConnection();

    /**
     * Close the connection that has been made.
     */
    public void closeConnection();

    /**
     * Get all the Project currently in the database.
     *
     * @return A list of projects
     */
    List<Project> getAllProject();

    List<Task> getAllTask();

    List<Category> getAllCategory();
}
