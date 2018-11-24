package model;

import io.vavr.control.Try;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataModelImple implements DataModel {

    @Override
    public Project createProject(ResultSet rows) {
        return Try.of(() -> {
            int id = rows.getInt("project_id");
            String name = rows.getString("title");
            Level level = Level.valueOf(rows.getString("level"));
            String description = rows.getString("description");
            //Date date = rows.getDate("Date").toLocalDate();
            java.util.Date newDate = rows.getDate("Date");
            boolean completed = rows.getBoolean("completed");

            Project project = ImmutableProject
                    .builder()
                    .id(id)
                    .name(name)
                    .completed(completed)
                    .build();

            return project;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    @Override
    public Category createCategory(ResultSet rows) {
        return Try.of(() -> {
            int id = rows.getInt("category_id");
            String name = rows.getString("category_name");

            Category cagetogry = ImmutableCategory
                    .builder()
                    .id(id)
                    .name(name)
                    .build();

            return cagetogry;
        }).getOrElseThrow(throwable -> {
            throw new RuntimeException(throwable.getMessage());
        });
    }

    @Override
    public Task createTask(ResultSet rows) {
        return Try.of(() -> {
            int id = rows.getInt("id");
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
                    .completed(completed)
                    .build();

            return task;
        }).getOrElseThrow(throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }

    @Override
    public void printAllTask(List<Task> list) {
        list.forEach(task -> {
            System.out.println("ID:" + task.id() +
                            " Title:" + task.title() +
                            " Level:" + task.level() +
                            " Date:" + task.date() +
                            " Category:" + task.category() +
                            " Description:" + task.description() +
                            " Completed:" + task.completed()
            );
        });
    }

    @Override
    public void printAllCategory(List<Category> list) {
        list.forEach(category -> {
            System.out.println(" ID:" + category.id() +
                            " Name:" + category.name()
            );
        });
    }

    @Override
    public void printAllProject(List<Project> list) {
        list.forEach(project -> {
            System.out.println("ID:" + project.id() +
                    " Title:" + project.name() +
                    " Level:" + project.dueDate() +
                    " Category: " + project.completed()
            );
        });
    }

}
