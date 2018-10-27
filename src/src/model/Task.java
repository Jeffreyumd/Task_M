package model;

import java.util.Date;

public class Task {

  private final String title;
  private final Level level;
  private final Date date;
  private final String desciption;
  private final boolean complete;

  private Task(String title, Level level, Date date, String desciption, boolean complete) {
    this.title = title;
    this.level = level;
    this.date = date;
    this.desciption = desciption;
    this.complete = complete;
  }

  public String getTitle() {
    return title;
  }

  public Level getLevel() {
    return level;
  }

  public Date getDate() {
    return date;
  }

  public String getDesciption() {
    return desciption;
  }

  public boolean isComplete() {
    return complete;
  }

  public static Builder builder() {
    return new Builder();
  }

  public Task withTitle(String title) {
    return new Task(title, this.level, this.date, this.desciption, this.complete);
  }

  public Task withlevel(Level level) {
    return new Task(this.title, level, this.date, this.desciption, this.complete);
  }

  public Task withDate(Date date) {
    return new Task(this.title, this.level, date, this.desciption, this.complete);
  }

  public Task withDesciption(String desciption) {
    return new Task(this.title, this.level, this.date, desciption, this.complete);
  }

  public static class Builder {

    private String title;
    private Level level;
    private Date date;
    private String desciption;
    private boolean complete;

    private Builder() {
      this.title = null;
      this.level = null;
      this.date = null;
      this.desciption = null;
      this.complete = false;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder level(Level level) {
      this.level = level;
      return this;
    }

    public Builder date(Date date) {
      this.date = date;
      return this;
    }

    public Builder desciption(String desciption) {
      this.desciption = desciption;
      return this;
    }

    public Builder complete(boolean complete) {
      this.complete = complete;
      return this;
    }


    public Task builder() {
      return new Task(this.title, this.level, this.date, this.desciption, this.complete);
    }


  }
}
