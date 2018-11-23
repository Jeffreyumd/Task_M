package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ItemDAO<T> {

    /**
     * Create an object using the values collected from the database.
     * The object created will depend on the implemented generic.
     *
     * @param rows The row where the data is being collected from, for storage
     * @return A new object based on what class implements the generic
     * @throws SQLException The exception will be according to the error
     */
    T create(ResultSet rows);


}
