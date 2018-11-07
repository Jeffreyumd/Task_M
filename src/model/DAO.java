package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Data access object
public class DAO {

  final private String url;
  final private String user;
  final private String pass;
  private Connection conn = null;
  private List<Task> list = new ArrayList<>();

  public DAO(String url, String user, String pass) {
    this.url = url;
    this.user = user;
    this.pass = pass;
  }

  /**
   *
   * @return
   */
  public Connection getConnection() {
    if (this.conn == null) {
      try {
        this.conn = DriverManager.getConnection(url, user, pass);
        System.out.println("Connection made");
        return this.conn;
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    return this.conn;
  }


  /**
   * close database connection.
   */
  public void closeConnection() {
    try {
      this.conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }


  /**
   * Store all the task into a list and print the result query.
   */
  private void getAll_Task()  {

    try {

      Connection con = getConnection();
      Statement stmt = con.createStatement();

      String sqlGet = "SELECT * FROM TASK";
      ResultSet rows = stmt.executeQuery(sqlGet);

      while (rows.next()) {
//        System.out.println("Title:" + rows.getString("title")
//                + ", Level:" + rows.getString("level")
//                + ", Date:" + rows.getString("date")
//                + ", Description:" + rows.getString("description")
//                + ", Completed:" + rows.getString("completed"));
        list.add(createTask(rows));
      }

      rows.close();
      con.close();

    } catch (SQLException e) {
      throw new IllegalArgumentException(e);
    }
  }

  public void printAll_Task() {
    getAll_Task();
    for (Task task: list) {
      System.out.println("Title:" + task.title() + ", Level:" + task.level() + ", Date:" + task.level() + ", Date:");
    }
  }


  private Task createTask(ResultSet rows) throws SQLException {

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

    return task;
  }


  public int getTaksCount() {
    return list.size();
  }





}
