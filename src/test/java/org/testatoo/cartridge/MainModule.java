package org.testatoo.cartridge;

import org.testatoo.config.AbstractTestatooModule;
import org.testatoo.config.lifecycle.TestListenerAdapter;

import java.lang.reflect.Method;

/**
 * @author David Avenante
 */
public class MainModule extends AbstractTestatooModule {

    @Override
    protected void configure() {
        install(new CommonModule());
        if (System.getProperty("CI") != null)
            install(new CIModule());
        else
            install(new LocalModule());


        // TODO; NEW FEATURES TO DOCUMENT
        // 1. Ability to add listeners on test execution
        lifecycle().onTest(new TestListenerAdapter() {
            @Override
            public void onTest(Object instance, Method method) {
                System.out.println("===> Executing: " + method);
            }
        });

        // 2. Ability to add annotation support:
        // Exemple of currently supported annotation:
        // TODO: See SeleniumTest for usage
        useAnnotations();

    }
}