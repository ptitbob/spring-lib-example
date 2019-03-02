package org.shipstone.sandbox.springlib.application;

import org.shipstone.sandbox.springlib.library.EnableLibrary;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibrary
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
