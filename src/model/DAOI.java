package model;

import java.sql.Connection;

public interface DAOI {

    /**
     * Create a connection to the data base.
     *
     * @return The connection to the data base
     */
    public Connection getConnection();

    /**
     * Close the connection that has been made.
     */
    public void closeConnection();


    /**
     * Get all the selected Item from the data base, items are selected based on the given sql.
     * @param sql The sql code to be inserted into From:
     */
    public void getAll(String sql);

    //public void inset(String table);
}
