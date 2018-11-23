package controller;


public class DatabaseAPIimple {

  DAO dao;




  public void setConnection(String url, String user, String pass) {
    try {
      dao = new DAO();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void closeConnection() {
    dao.closeConnection();
  }
}
