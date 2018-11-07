package model;

import io.vavr.control.Option;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Immutable implementation of {@link Task}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableTask.builder()}.
 */
@SuppressWarnings({"all"})
public final class ImmutableTask implements Task {
  private final String title;
  private final Level level;
  private final Option<Instant> date;
  private final Option<String> description;
  private final boolean completed;

  private ImmutableTask(
      String title,
      Level level,
      Option<Instant> date,
      Option<String> description,
      boolean completed) {
    this.title = title;
    this.level = level;
    this.date = date;
    this.description = description;
    this.completed = completed;
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  private final class InitShim {
    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      return "Cannot build Task, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return title of the given task.
   */
  @Override
  public String title() {
    return title;
  }

  /**
   * @return the level of how important the task is.
   */
  @Override
  public Level level() {
    return level;
  }

  /**
   * @return a due date of the task if given.
   */
  @Override
  public Option<Instant> date() {
    return date;
  }

  /**
   * @return description of the task if given.
   */
  @Override
  public Option<String> description() {
    return description;
  }

  /**
   * @return boolean is the task is completed or not.
   */
  @Override
  public boolean completed() {
    return completed;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Task#title() title} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for title
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTask withTitle(String value) {
    if (this.title.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "title");
    return new ImmutableTask(newValue, this.level, this.date, this.description, this.completed);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Task#level() level} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for level
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTask withLevel(Level value) {
    if (this.level == value) return this;
    Level newValue = Objects.requireNonNull(value, "level");
    return new ImmutableTask(this.title, newValue, this.date, this.description, this.completed);
  }

  public ImmutableTask withDate(Option<Instant> value) {
    Option<Instant> newValue = Objects.requireNonNull(value);
    if (this.date == newValue) return this;
    return new ImmutableTask(this.title, this.level, newValue, this.description, this.completed);
  }

  public ImmutableTask withDate(Instant value) {
    Option<Instant> newValue = Option.some(value);
    if (this.date == newValue) return this;
    return new ImmutableTask(this.title, this.level, newValue, this.description, this.completed);
  }

  public ImmutableTask withDescription(Option<String> value) {
    Option<String> newValue = Objects.requireNonNull(value);
    if (this.description == newValue) return this;
    return new ImmutableTask(this.title, this.level, this.date, newValue, this.completed);
  }

  public ImmutableTask withDescription(String value) {
    Option<String> newValue = Option.some(value);
    if (this.description == newValue) return this;
    return new ImmutableTask(this.title, this.level, this.date, newValue, this.completed);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Task#completed() completed} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for completed
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableTask withCompleted(boolean value) {
    if (this.completed == value) return this;
    return new ImmutableTask(this.title, this.level, this.date, this.description, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableTask} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableTask
        && equalTo((ImmutableTask) another);
  }

  private boolean equalTo(ImmutableTask another) {
    return title.equals(another.title)
        && level.equals(another.level)
        && this.date().equals(another.date())
        && this.description().equals(another.description())
        && completed == another.completed;
  }

  /**
   * Computes a hash code from attributes: {@code title}, {@code level}, {@code date}, {@code description}, {@code completed}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + title.hashCode();
    h += (h << 5) + level.hashCode();
    h += (h << 5) + (date().hashCode());
    h += (h << 5) + (description().hashCode());
    h += (h << 5) + Boolean.hashCode(completed);
    return h;
  }

  /**
   * Prints the immutable value {@code Task} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Task{"
        + "title=" + title
        + ", level=" + level
        + ", date=" + (date().toString())
        + ", description=" + (description().toString())
        + ", completed=" + completed
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Task} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Task instance
   */
  public static ImmutableTask copyOf(Task instance) {
    if (instance instanceof ImmutableTask) {
      return (ImmutableTask) instance;
    }
    return ImmutableTask.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableTask ImmutableTask}.
   * @return A new ImmutableTask builder
   */
  public static ImmutableTask.Builder builder() {
    return new ImmutableTask.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableTask ImmutableTask}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  public static final class Builder {
    private static final long INIT_BIT_TITLE = 0x1L;
    private static final long INIT_BIT_LEVEL = 0x2L;
    private static final long INIT_BIT_COMPLETED = 0x4L;
    private long initBits = 0x7L;

    private Option<Instant> date_optional = Option.none();
    private Option<String> description_optional = Option.none();
    private String title;
    private Level level;
    private boolean completed;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Task} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Task instance) {
      Objects.requireNonNull(instance, "instance");
      title(instance.title());
      level(instance.level());
      date(instance.date());
      description(instance.description());
      completed(instance.completed());
      return this;
    }

    /**
     * Initializes the value for the {@link Task#title() title} attribute.
     * @param title The value for title 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder title(String title) {
      this.title = Objects.requireNonNull(title, "title");
      initBits &= ~INIT_BIT_TITLE;
      return this;
    }

    /**
     * Initializes the value for the {@link Task#level() level} attribute.
     * @param level The value for level 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder level(Level level) {
      this.level = Objects.requireNonNull(level, "level");
      initBits &= ~INIT_BIT_LEVEL;
      return this;
    }

    public Builder date(Option<Instant> opt) {
      this.date_optional = opt;
      return this;
    }

    public Builder date(Instant x) {
      this.date_optional = Option.of(x);
      return this;
    }

    public Builder unsetDate() {
      this.date_optional = Option.none();
      return this;
    }

    public Builder description(Option<String> opt) {
      this.description_optional = opt;
      return this;
    }

    public Builder description(String x) {
      this.description_optional = Option.of(x);
      return this;
    }

    public Builder unsetDescription() {
      this.description_optional = Option.none();
      return this;
    }

    /**
     * Initializes the value for the {@link Task#completed() completed} attribute.
     * @param completed The value for completed 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder completed(boolean completed) {
      this.completed = completed;
      initBits &= ~INIT_BIT_COMPLETED;
      return this;
    }

    /**
     * Builds a new {@link ImmutableTask ImmutableTask}.
     * @return An immutable instance of Task
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableTask build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableTask(title, level, date_build(), description_build(), completed);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TITLE) != 0) attributes.add("title");
      if ((initBits & INIT_BIT_LEVEL) != 0) attributes.add("level");
      if ((initBits & INIT_BIT_COMPLETED) != 0) attributes.add("completed");
      return "Cannot build Task, some of required attributes are not set " + attributes;
    }

    private Option<Instant> date_build() {
      return this.date_optional;
    }

    private Option<String> description_build() {
      return this.description_optional;
    }
  }
}
