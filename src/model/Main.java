package model;

import java.time.Instant;

import io.vavr.collection.Seq;
import io.vavr.collection.Vector;

public class Main {

  public static void main(String[] args) {

    Seq<Project> projects = Vector.of(
            ImmutableProject.builder()
                    .id("111")
                    .name("Project 1")
                    .completed(false)
                    .addTasks(
                            ImmutableTask.builder()
                                    .completed(false)
                                    .title("Task 1")
                                    .date(Instant.now())
                                    .level(Level.HIGH)
                                    .build()
                    )
                    .build()
    );

    // To make copies.
    // Project p  = null;
    // ImmutableProject.copyOf(p).withDueDate(...);


    System.out.println(projects);
  }


}
