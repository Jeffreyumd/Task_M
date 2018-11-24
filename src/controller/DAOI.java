package controller;

import io.vavr.control.Try;
import model.Category;
import model.Project;
import model.Task;

import java.sql.Connection;
import java.util.List;

public interface DAOI {

    /**
     * @return A connection to a data base
     */
    public Connection getConnection();

    /**
     * Close the connection that has been made.
     */
    public void closeConnection();

    /**
     * @return A list of projects currently stored in the database
     */
    List<Project> getAllProject();

    /**
     * @return A list of task currently stored in the database
     */
    List<Task> getAllTask();

    /**
     * @return A list of category currently stored in the database
     */
    List<Category> getAllCategory();
}
