import java.sql.Connection;


import controller.DAO;
import io.vavr.collection.Seq;
import io.vavr.collection.Vector;
import model.*;


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


    DAO dao = new DAO();
    dao.getConnection();
    dao.getAll_Task();
    dao.closeConn();
    //dao.getAll_Task();




  }
}
