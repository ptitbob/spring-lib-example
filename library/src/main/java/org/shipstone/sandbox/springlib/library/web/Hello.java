package org.shipstone.sandbox.springlib.library.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lib")
public class Hello {

  @GetMapping
  public String hello() {
    return "Hello from Library";
  }

}
