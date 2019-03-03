package org.shipstone.sandbox.springlib.libdata.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("lib-data")
public class HelloData {

  @GetMapping
  public String hello() {
    return "Hello from lib-data";
  }

}
