package model;

import java.util.List;

import io.vavr.collection.Seq;
import io.vavr.control.Try;
import model.Project;
import model.Task;

public interface DatabaseAPI {



  /**
   * Sub-Project
   */
  Try<List<Project>> findAllSupProject();

  Try<List<Project>> findSupProjectById();

  Try<List<Project>> findSupProjectByName();

  Try<Void> insertSupProject(Project project);

  Try<Void> updateSupProject(Project project);

  Try<Void> deleteSupProject(Project project);


  /**
   * Project
   */
  Try<List<Project>> findAllProject();

  Try<List<Project>> findProjectById();

  Try<List<Project>> findProjectByName();

  Try<Void> insertProject(Project project);

  Try<Void> updateProject(Project project);

  Try<Void> deleteProject(Project project);


  public void setConnection(String url, String user, String pass);

  public void closeConnection();
}
