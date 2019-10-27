package pl.coderslab.app;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import pl.coderslab.app.configuration.SecurityConfiguration;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityInitializer() {
        super(SecurityConfiguration.class);
    }
}