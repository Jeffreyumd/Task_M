package controller;

import io.vavr.control.Try;
import model.Category;
import model.ImmutableCategory;

import java.sql.ResultSet;

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

