package org.testatoo.cartridge;

import org.testatoo.config.AbstractTestatooModule;
import org.testatoo.config.Scope;
import org.testatoo.config.cartridge.TestatooCartridge;

/**
 * @author David Avenante
 */
public class LocalModule extends AbstractTestatooModule {
    @Override
    protected void configure() {
        seleniumServers().register(createSeleniumServer()
                .port(4444)
                .useSingleWindow(true)
                .build())
                .scope(Scope.TEST_SUITE);

        seleniumSessions()
                .register(createSeleniumSession()
                        .website("http://127.0.0.1:7899/")
//                        .browser("*iexploreproxy")
                        .browser("*firefox")
//                        .browser("*safari")
//                        .browser("*opera")
//                        .browser("*custom /usr/lib/chromium-browser/chromium-browser")
//                        .browser("*googlechrome")
                        .serverHost("127.0.0.1")
                        .serverPort(4444)
                        .build())
                .scope(Scope.TEST_SUITE)
                .withTimeout(20000)
                .inCartridge(TestatooCartridge.HTML4);
    }
}