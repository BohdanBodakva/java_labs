package ua.lviv.iot.lab8.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import ua.lviv.iot.lab8.controller.GemController;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(Class<?>... classes) {
        register(GemController.class);
    }



}
