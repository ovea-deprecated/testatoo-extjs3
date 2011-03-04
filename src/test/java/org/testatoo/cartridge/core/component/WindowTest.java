/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.cartridge.core.component;

import org.junit.Before;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.Button;
import org.testatoo.core.component.Window;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;

public class WindowTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/window/Window.html");
    }

    @Test
    public void can_find_window_by_id() {
        component(Window.class, "myWindow");

        try {
            component(Window.class, "myOtherWindow");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=myOtherWindow"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_window() {
        try {
            component(Window.class, "windowError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=windowError is not a Window but a Button"));
        }
    }

    @Test
    public void can_test_title() {
        assertThat(component(Window.class, "myWindow").title(), is("myWindowTitle"));
    }

    @Test
    public void can_close_window() {
        Window window = component(Window.class, "myWindow");

        assertThat(window.isVisible(), is(true));
        window.close();
        assertThat(window.isVisible(), is(false));
    }

    @Test
    public void test_container() {
        assertThat(component(Window.class, "myWindow").contains(component(Button.class, "button1")), is(true));
    }

    @Test
    public void to_String() {
        assertThat(component(Window.class, "myWindow").toString(), is("class org.testatoo.core.component.Window with state : enabled:true, visible:true, title:myWindowTitle"));
    }

}
