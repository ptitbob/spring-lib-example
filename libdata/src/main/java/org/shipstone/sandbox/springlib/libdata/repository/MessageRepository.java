package org.shipstone.sandbox.springlib.libdata.repository;

import org.shipstone.sandbox.springlib.libdata.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Demo de l'utilisation du cache en envirronement Spring
 *
 * @author François Robert
 * LICENCE Apache 2.0
 */
@Repository
@Transactional(readOnly = true)
public interface MessageRepository extends JpaRepository<Message, Long>, JpaSpecificationExecutor<Message> {

  Optional<Message> findByCode(String code);

}
