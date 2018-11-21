package model;


public class DatabaseAPIimple {

  DAO dao;



  @Override
  public void setConnection(String url, String user, String pass) {
    dao = new DAO("", "", "");
  }

  @Override
  public void closeConnection() {
    dao.closeConnection();
  }
}
