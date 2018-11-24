import controller.DAOImple;
import io.vavr.collection.Seq;
import io.vavr.collection.Vector;
import model.*;


public class Main {

  public static void main(String[] args) {


    Seq<Project> projects = Vector.of(
            ImmutableProject.builder()
                    .id(111)
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


    DAOImple dao = new DAOImple();
    dao.getConnection();
    dao.getAllCategory();
    dao.closeConnection();





  }
}
