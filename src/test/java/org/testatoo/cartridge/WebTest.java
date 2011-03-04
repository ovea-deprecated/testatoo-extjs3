package org.testatoo.cartridge;

import org.junit.runner.RunWith;
import org.testatoo.config.annotation.TestatooModules;
import org.testatoo.config.junit.TestatooJunitRunner;

/**
 * @author David Avenante
 */
@RunWith(TestatooJunitRunner.class)
@TestatooModules(MainModule.class)
public abstract class WebTest {

}