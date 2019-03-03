package org.shipstone.sandbox.springlib.libdata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Demo de l'utilisation du cache en envirronement Spring
 *
 * @author François Robert
 * LICENCE Apache 2.0
 */
@Entity
@Table(name = "adm_message")
@SequenceGenerator(name = "messageSequenceGenerator", sequenceName = "adm_message_sequence", allocationSize = 10)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Message implements Serializable {

  private static final long serialVersionUID = 5284124935064405558L;

  @Id
  @Column(name = "adm_message_id")
  @GeneratedValue(strategy = SEQUENCE, generator = "messageSequenceGenerator")
  private Long id;

  @Column(name = "code")
  private String code;

  @Column(name = "message")
  private String message;

}
