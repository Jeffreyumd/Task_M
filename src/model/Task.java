package model;

import org.immutables.value.Value;
import org.immutables.vavr.encodings.VavrEncodingEnabled;

import java.time.Instant;

import io.vavr.control.Option;

@Value.Immutable
@VavrEncodingEnabled
public interface Task {
  String title();
  Level level();
  Instant date();
  Option<String> description();
  boolean completed();
}
