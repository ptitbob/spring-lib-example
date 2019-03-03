package org.shipstone.sandbox.springlib.libdata;

import org.shipstone.sandbox.springlib.libdata.configuration.LibDataConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(LibDataConfiguration.class)
public @interface EnableLibData {
}
