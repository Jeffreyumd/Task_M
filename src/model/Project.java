package model;


import org.immutables.value.Value;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import java.time.Instant;
import java.util.List;

import io.vavr.control.Option;

@Value.Immutable
@VavrEncodingEnabled
public interface Project {
  /**
   * @return Unique id for the project.
   */
  int id();

  /**
   * @return Human readable name of the project.
   */
  String name();

  /**
   * @return A due date for the project, if provided.
   */
  Option<Instant> dueDate();

  /**
   * @return Whether the project is completed.
   */
  boolean completed();

  /**
   * @return The tasks associated with this project.
   */
  List<Task> tasks();


}
