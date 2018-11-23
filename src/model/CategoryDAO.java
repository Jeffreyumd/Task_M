package model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAO implements ItemDAO<Category> {


    @Override
    public Category create(ResultSet rows) {
        try {
            int id = rows.getInt("id");
            String name = rows.getString("name");

            Category cagetogry = ImmutableCategory
                    .builder()
                    .id(id)
                    .name(name)
                    .build();

            return cagetogry;
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

