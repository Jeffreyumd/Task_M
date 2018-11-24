package controller;


public class DatabaseAPIimple {

  DAO dao;




  public void setConnection(String url, String user, String pass) {
    dao.getConnection();
  }



  public void closeConnection() {
    dao.closeConnection();
  }
}
