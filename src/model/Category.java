package model;

import org.immutables.value.Value;

@Value.Immutable
public interface Category {

    /**
     * @return Unique id for the category.
     */
    int id();

    /**
     * @return Name of the category.
     */
    String name();

}
