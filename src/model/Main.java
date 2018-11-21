package model;

import java.sql.Connection;


import io.vavr.collection.Seq;
import io.vavr.collection.Vector;


public class Main {
  private static Connection myConn;

  public static void main(String[] args) {

    Seq<Project> projects = Vector.of(
            ImmutableProject.builder()
                    .id("111")
                    .name("Project 1")
                    .completed(false)
                    .addTasks( ImmutableTask.builder()
                            .id(2)
                            .title("1")
                            .level(Level.MEDIUM)
                            .completed(false)
                            .build())
                    .build()
    );


    Task task = ImmutableTask.builder()
            .id(2)
            .title("1")
            .level(Level.MEDIUM)
            .completed(false)
            .build();


    String user = "root";
    String password = "Qsetthuk7";
    String url = "jdbc:mysql://localhost:3306/Task_manager?useUnicode=" +
            "true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode" +
            "=false&serverTimezone=UTC";


    DAO dao = new DAO(url, user, password);
    dao.getConnection();
    //dao.getAll_Task();
    dao.printAll_Task();
    dao.closeConnection();


  }
}
