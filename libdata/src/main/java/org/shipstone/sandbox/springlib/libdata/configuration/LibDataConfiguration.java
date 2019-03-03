package org.shipstone.sandbox.springlib.libdata.configuration;

import org.shipstone.sandbox.springlib.libdata.domain.Message;
import org.shipstone.sandbox.springlib.libdata.repository.MessageRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("org.shipstone.sandbox.springlib.libdata")
@EntityScan(basePackageClasses = { Message.class })
@EnableJpaRepositories(basePackageClasses = { MessageRepository.class })
public class LibDataConfiguration {

}
