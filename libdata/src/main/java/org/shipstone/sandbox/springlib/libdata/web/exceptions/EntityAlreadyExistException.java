package org.shipstone.sandbox.springlib.libdata.web.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Projet commons Spring
 *
 * @author François Robert
 * LICENCE Apache 2.0
 */
public class EntityAlreadyExistException extends RegisteredException {

  public EntityAlreadyExistException(String code, String message) {
    super(BAD_REQUEST, code, message, null);
  }

  public EntityAlreadyExistException(String code, String entityName, String key) {
    this(code, String.format("L'objet %s existe déjà avec la clé [%s]", entityName, key));
  }

  public EntityAlreadyExistException(String code, Object entity, String key) {
    this(code, entity.getClass().getName(), key);
  }

}
