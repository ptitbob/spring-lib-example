package org.shipstone.sandbox.springlib.libdata.service;

import org.shipstone.sandbox.springlib.libdata.domain.Message;
import org.shipstone.sandbox.springlib.libdata.repository.MessageRepository;
import org.shipstone.sandbox.springlib.libdata.web.exceptions.EntityAlreadyExistException;
import org.shipstone.sandbox.springlib.libdata.web.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Demo de l'utilisation du cache en envirronement Spring
 *
 * @author François Robert
 * LICENCE Apache 2.0
 */
@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  public List<Message> getAll() {
    return messageRepository.findAll();
  }

  public Message getMessageByCode(String code) throws EntityNotFoundException {
    try {
      return messageRepository.findByCode(code).orElseThrow(() -> new EntityNotFoundException("Message", code, "404-ME01"));
    } catch (EntityNotFoundException e) {
      throw e;
    }
  }

}
