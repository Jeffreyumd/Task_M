package model.Item;


import io.vavr.Function5;
import io.vavr.Function6;
import io.vavr.control.Try;
import model.ImmutableTask;
import model.Level;
import model.Task;

import java.sql.ResultSet;
import java.util.List;


public class TaskDAO implements ItemDAO<model.Task> {


    @Override
    public Task create(ResultSet rows) {
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
                    .completed(completed).build();

            //createTask.apply(id,title,level,description,newDate,completed);

            return task;
        }).getOrElseThrow( throwable -> {
            throw new IllegalArgumentException(throwable.getMessage());
        });
    }




//    @Override
//    public Task create(ResultSet rows) {
//        try {
//            int id = rows.getInt("id");
//            String title = rows.getString("title");
//            Level level = Level.valueOf(rows.getString("level"));
//            String description = rows.getString("description");
//            //Date date = rows.getDate("Date").toLocalDate();
//            java.util.Date newDate = rows.getDate("Date");
//            boolean completed = rows.getBoolean("completed");
//
//            Task task = ImmutableTask
//                    .builder()
//                    .title(title)
//                    .level(level)
//                    //.date()
//                    .description(description)
//                    .completed(completed).build();
//
//            //createTask.apply(id,title,level,description,newDate,completed);
//
//            return task;
//        } catch (SQLException e) {
//            throw new IllegalArgumentException(e.getMessage());
//        }
//    }



//
//    Function6<Integer , String, Level, String, Date, Boolean, Task> createTask
//            = (id, title, level, description,newDate, completed) -> ImmutableTask
//            .builder()
//            .id(id)
//            .title(title)
//            .level(level)
//            .description(description)
//            .completed(completed)
//            .build();



}
