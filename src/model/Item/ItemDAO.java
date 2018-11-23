package model.Item;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    /**
     * Find all the given object in the data base and store it in a list.
     * @return A list of object based on implemented class
     */
   // List<T> findAll(String sql);


}
