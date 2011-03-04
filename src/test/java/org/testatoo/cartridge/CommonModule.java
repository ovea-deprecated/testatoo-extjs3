package org.testatoo.cartridge;

import org.testatoo.config.AbstractTestatooModule;
import org.testatoo.config.Scope;

import static org.testatoo.container.TestatooContainer.JETTY;

/**
 * @author David Avenante
 */
public class CommonModule extends AbstractTestatooModule {
    @Override
    protected void configure() {
        containers().register(createContainer()
                .implementedBy(JETTY)
                .webappRoot("src/test/webapp")
                .port(7899)
                .build())
                .scope(Scope.TEST_SUITE);
    }
}