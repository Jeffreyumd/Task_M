package controller;

import io.vavr.control.Try;
import model.Category;
import model.Project;
import model.Task;

import java.sql.Connection;
import java.util.List;

public interface DAO {

    /**
     * @return A connection to a data base
     */
    Connection getConnection();

    /**
     * Close the connection that has been made.
     */
    void closeConnection();

    /**
     * @return A list of projects currently stored in the database
     */
    Try<List<Project>> getAllProject();

    /**
     * @return A list of task currently stored in the database
     */
    Try<List<Task>> getAllTask();

    /**
     * @return A list of category currently stored in the database
     */
    Try<List<Category>> getAllCategory();
}
