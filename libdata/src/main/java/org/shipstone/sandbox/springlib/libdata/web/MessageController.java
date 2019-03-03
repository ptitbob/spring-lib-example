package org.shipstone.sandbox.springlib.libdata.web;


import org.shipstone.sandbox.springlib.libdata.domain.Message;
import org.shipstone.sandbox.springlib.libdata.service.MessageService;
import org.shipstone.sandbox.springlib.libdata.web.exceptions.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Demo de l'utilisation du cache en envirronement Spring
 *
 * @author François Robert
 * LICENCE Apache 2.0
 */
@RestController
@RequestMapping("lib-data/messages")
public class MessageController {

  @Autowired
  private MessageService messageService;

  private final Logger logger = LoggerFactory.getLogger(MessageController.class);

  @GetMapping
  public ResponseEntity<List<Message>> getAll() {
    return new ResponseEntity<>(messageService.getAll(), HttpStatus.OK);
  }

  @GetMapping("{code:[A-Z]{3,}}")
  public Message getMessageByCode(
      @PathVariable("code") String code
  ) throws EntityNotFoundException {
    logger.info("HTTP GET /messages/{}", code);
    return messageService.getMessageByCode(code);
  }

}
