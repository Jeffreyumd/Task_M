package model;

import io.vavr.control.Option;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Project}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableProject.builder()}.
 */
@Generated(from = "Project", generator = "Immutables")
@SuppressWarnings({"all"})
public final class ImmutableProject implements Project {
  private final int id;
  private final String name;
  private final Option<Instant> dueDate;
  private final boolean completed;
  private final List<Task> tasks;

  private ImmutableProject(
      int id,
      String name,
      Option<Instant> dueDate,
      boolean completed,
      List<Task> tasks) {
    this.id = id;
    this.name = name;
    this.dueDate = dueDate;
    this.completed = completed;
    this.tasks = tasks;
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "Project", generator = "Immutables")
  private final class InitShim {
    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      return "Cannot build Project, attribute initializers form cycle " + attributes;
    }
  }

  /**
   * @return Unique id for the project.
   */
  @Override
  public int id() {
    return id;
  }

  /**
   * @return Human readable name of the project.
   */
  @Override
  public String name() {
    return name;
  }

  /**
   * @return A due date for the project, if provided.
   */
  @Override
  public Option<Instant> dueDate() {
    return dueDate;
  }

  /**
   * @return Whether the project is completed.
   */
  @Override
  public boolean completed() {
    return completed;
  }

  /**
   * @return The tasks associated with this project.
   */
  @Override
  public List<Task> tasks() {
    return tasks;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Project#id() id} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProject withId(int value) {
    if (this.id == value) return this;
    return new ImmutableProject(value, this.name, this.dueDate, this.completed, this.tasks);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Project#name() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProject withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableProject(this.id, newValue, this.dueDate, this.completed, this.tasks);
  }

  public ImmutableProject withDueDate(Option<Instant> value) {
    Option<Instant> newValue = Objects.requireNonNull(value);
    if (this.dueDate == newValue) return this;
    return new ImmutableProject(this.id, this.name, newValue, this.completed, this.tasks);
  }

  public ImmutableProject withDueDate(Instant value) {
    Option<Instant> newValue = Option.some(value);
    if (this.dueDate == newValue) return this;
    return new ImmutableProject(this.id, this.name, newValue, this.completed, this.tasks);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Project#completed() completed} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for completed
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableProject withCompleted(boolean value) {
    if (this.completed == value) return this;
    return new ImmutableProject(this.id, this.name, this.dueDate, value, this.tasks);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Project#tasks() tasks}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableProject withTasks(Task... elements) {
    List<Task> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableProject(this.id, this.name, this.dueDate, this.completed, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link Project#tasks() tasks}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of tasks elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableProject withTasks(Iterable<? extends Task> elements) {
    if (this.tasks == elements) return this;
    List<Task> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableProject(this.id, this.name, this.dueDate, this.completed, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableProject} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableProject
        && equalTo((ImmutableProject) another);
  }

  private boolean equalTo(ImmutableProject another) {
    return id == another.id
        && name.equals(another.name)
        && this.dueDate().equals(another.dueDate())
        && completed == another.completed
        && tasks.equals(another.tasks);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code name}, {@code dueDate}, {@code completed}, {@code tasks}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + id;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + (dueDate().hashCode());
    h += (h << 5) + Boolean.hashCode(completed);
    h += (h << 5) + tasks.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Project} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Project{"
        + "id=" + id
        + ", name=" + name
        + ", dueDate=" + (dueDate().toString())
        + ", completed=" + completed
        + ", tasks=" + tasks
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link Project} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Project instance
   */
  public static ImmutableProject copyOf(Project instance) {
    if (instance instanceof ImmutableProject) {
      return (ImmutableProject) instance;
    }
    return ImmutableProject.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableProject ImmutableProject}.
   * @return A new ImmutableProject builder
   */
  public static ImmutableProject.Builder builder() {
    return new ImmutableProject.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableProject ImmutableProject}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Project", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_NAME = 0x2L;
    private static final long INIT_BIT_COMPLETED = 0x4L;
    private long initBits = 0x7L;

    private Option<Instant> dueDate_optional = Option.none();
    private int id;
    private String name;
    private boolean completed;
    private List<Task> tasks = new ArrayList<Task>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Project} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(Project instance) {
      Objects.requireNonNull(instance, "instance");
      id(instance.id());
      name(instance.name());
      dueDate(instance.dueDate());
      completed(instance.completed());
      addAllTasks(instance.tasks());
      return this;
    }

    /**
     * Initializes the value for the {@link Project#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder id(int id) {
      this.id = id;
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link Project#name() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    public Builder dueDate(Option<Instant> opt) {
      this.dueDate_optional = opt;
      return this;
    }

    public Builder dueDate(Instant x) {
      this.dueDate_optional = Option.of(x);
      return this;
    }

    public Builder unsetDueDate() {
      this.dueDate_optional = Option.none();
      return this;
    }

    /**
     * Initializes the value for the {@link Project#completed() completed} attribute.
     * @param completed The value for completed 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder completed(boolean completed) {
      this.completed = completed;
      initBits &= ~INIT_BIT_COMPLETED;
      return this;
    }

    /**
     * Adds one element to {@link Project#tasks() tasks} list.
     * @param element A tasks element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTasks(Task element) {
      this.tasks.add(Objects.requireNonNull(element, "tasks element"));
      return this;
    }

    /**
     * Adds elements to {@link Project#tasks() tasks} list.
     * @param elements An array of tasks elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addTasks(Task... elements) {
      for (Task element : elements) {
        this.tasks.add(Objects.requireNonNull(element, "tasks element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link Project#tasks() tasks} list.
     * @param elements An iterable of tasks elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder tasks(Iterable<? extends Task> elements) {
      this.tasks.clear();
      return addAllTasks(elements);
    }

    /**
     * Adds elements to {@link Project#tasks() tasks} list.
     * @param elements An iterable of tasks elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllTasks(Iterable<? extends Task> elements) {
      for (Task element : elements) {
        this.tasks.add(Objects.requireNonNull(element, "tasks element"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableProject ImmutableProject}.
     * @return An immutable instance of Project
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableProject build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableProject(id, name, dueDate_build(), completed, createUnmodifiableList(true, tasks));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_COMPLETED) != 0) attributes.add("completed");
      return "Cannot build Project, some of required attributes are not set " + attributes;
    }

    private Option<Instant> dueDate_build() {
      return this.dueDate_optional;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
