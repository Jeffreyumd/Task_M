package model;

import java.sql.ResultSet;
import java.util.List;

public interface DataModel {



    Project createProject(ResultSet rows);

    Category createCategory(ResultSet rows);

    Task createTask(ResultSet rows);

    void printAllTask(List<Task> list);

    void printAllCategory(List<Category> list);

    void printAllProject(List<Project> list);








}
