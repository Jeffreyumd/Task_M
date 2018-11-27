package model;

import io.vavr.control.Try;

import java.sql.ResultSet;
import java.util.List;

public interface DataModel {

    /**
     * create a project with the given result set, collected from the database.
     *
     * @param rows result set collected from database
     * @return A project constructed with result set collected from database
     */
    Project createProject(ResultSet rows);

    /**
     * create a category with the given result set, collected from the database.
     *
     * @param rows result set collected from database
     * @return A category constructed with result set collected from database
     */
    Category createCategory(ResultSet rows);

    /**
     * create a task with the given result set, collected from the database.
     *
     * @param rows result set collected from database
     * @return A task constructed with result set collected from database
     */
    Task createTask(ResultSet rows);

    /**
     * print all the task given from the collected list.
     *
     * @param list The list of task to be printed
     */
    void printAllTask(List<Task> list);

    /**
     * print all the category given from the collected list.
     *
     * @param list The list of category to be printed
     */
    void printAllCategory(List<Category> list);

    /**
     * print all the project given from the collected list.
     *
     * @param list The list of project to be printed
     */
    void printAllProject(List<Project> list);


}
