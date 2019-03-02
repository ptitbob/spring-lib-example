package org.shipstone.sandbox.springlib.library;


import org.shipstone.sandbox.springlib.library.configuration.DefaultLibraryConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({DefaultLibraryConfiguration.class})
@Configuration
public @interface EnableLibrary {
}
