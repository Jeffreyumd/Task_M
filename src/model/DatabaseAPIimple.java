package model;

import java.util.List;

import io.vavr.collection.Seq;
import io.vavr.control.Try;
import model.DAO;
import model.DatabaseAPI;
import model.Project;
import model.Task;


public class DatabaseAPIimple implements DatabaseAPI {

  DAO dao;

  @Override
  public Try<Seq<Task>> findAlltask() {
    return null;
  }

  @Override
  public Try<List<Task>> findTaskById() {
    return null;
  }

  @Override
  public Try<List<Task>> findTaskByName() {
    return null;
  }

  @Override
  public Try<Void> insertTask(Task task) {
    return null;
  }

  @Override
  public Try<Void> updateTask(Task task) {
    return null;
  }

  @Override
  public Try<Void> deleteTask(Task task) {
    return null;
  }

  @Override
  public Try<List<Project>> findAllSupProject() {
    return null;
  }

  @Override
  public Try<List<Project>> findSupProjectById() {
    return null;
  }

  @Override
  public Try<List<Project>> findSupProjectByName() {
    return null;
  }

  @Override
  public Try<Void> insertSupProject(Project project) {
    return null;
  }

  @Override
  public Try<Void> updateSupProject(Project project) {
    return null;
  }

  @Override
  public Try<Void> deleteSupProject(Project project) {
    return null;
  }

  @Override
  public Try<List<Project>> findAllProject() {
    return null;
  }

  @Override
  public Try<List<Project>> findProjectById() {
    return null;
  }

  @Override
  public Try<List<Project>> findProjectByName() {
    return null;
  }

  @Override
  public Try<Void> insertProject(Project project) {
    return null;
  }

  @Override
  public Try<Void> updateProject(Project project) {
    return null;
  }

  @Override
  public Try<Void> deleteProject(Project project) {
    return null;
  }

  @Override
  public void setConnection(String url, String user, String pass) {
    dao = new DAO("", "", "");
  }

  @Override
  public void closeConnection() {
    dao.closeConnection();
  }
}
