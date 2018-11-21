package model;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * This class reads in config and returns whats in it ex: password
 */
public class Config {

  public Properties getConfig() {
    Properties p = new Properties();
    URL a = this.getClass().getResource("config.properties");
    try {
      p.load(this.getClass().getResourceAsStream("config.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return p;
  }
}
