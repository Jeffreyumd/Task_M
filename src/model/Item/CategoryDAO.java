package model.Item;

import io.vavr.control.Try;
import model.Category;
import model.ImmutableCategory;
import model.Item.ItemDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ItemDAO<Category> {


    @Override
    public Category create(ResultSet rows) {
        return Try.of(() -> {
            int id = rows
                    .getInt("id");
            String name = rows
                    .getString("name");

            Category cagetogry = ImmutableCategory
                    .builder()
                    .id(id)
                    .name(name)
                    .build();

            return cagetogry;
        }).getOrElseThrow(throwable -> {
            throw new RuntimeException(throwable.getMessage());
        });
    }

}

