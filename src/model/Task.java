package model;

import org.immutables.value.Value;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import java.time.Instant;

import io.vavr.control.Option;

@Value.Immutable
@VavrEncodingEnabled
public interface Task {

  /**
   * @return Unique id for the task.
   */
  int id();

  /**
   * @return title of the given task.
   */
  String title();

  /**
   * @return the level of how important the task is.
   */
  Level level();

  /**
   * @return the category the task belongs to.
   */
  Option<Category> category();

  /**
   * @return a due date of the task if given.
   */
  Option<Instant> date();

  /**
   * @return description of the task if given.
   */
  Option<String> description();

  /**
   * @return boolean is the task is completed or not.
   */
  boolean completed();


}
