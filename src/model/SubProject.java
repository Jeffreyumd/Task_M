package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubProject {

  private List<Task> list;
  private String title;
  private boolean complete;
  private Color color;
  private Date date;


  public SubProject(List<Task> list, String title, boolean complete, Color color, Date date) {
    this.list = list;
    this.title = title;
    this.complete = complete;
    this.color = color;
    this.date = date;
  }

  public int getListSize() {
    return list.size();
  }

  public List<Task> getList() {
    return list;
  }

  public String getTitle() {
    return title;
  }

  public boolean isComplete() {
    return complete;
  }

  public Color getColor() {
    return color;
  }

  public Date getDate() {
    return date;
  }
}
