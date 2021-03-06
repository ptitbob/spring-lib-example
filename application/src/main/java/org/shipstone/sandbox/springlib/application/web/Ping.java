package org.shipstone.sandbox.springlib.application.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {MediaType.TEXT_PLAIN_VALUE })
public class Ping {

  @GetMapping
  public String pong() {
    return "pong";
  }

}
