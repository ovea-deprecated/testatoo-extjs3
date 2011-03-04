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
import org.testatoo.cartridge.extjs3.component.DialogBox;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.Button;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;
import static org.testatoo.core.input.Mouse.clickOn;

public class DialogBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/dialogbox/DialogBox.html");
    }

    @Test
    public void can_find_dialogbox() {
        try {
            component(DialogBox.class, "");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), containsString("Cannot find component defined by id="));
        }
        clickOn(component(Button.class, "dialogButton"));
        component(DialogBox.class, "");
    }

    @Test
    public void exception_thrown_if_component_not_a_dialogBox() {
        clickOn(component(Button.class, "alertButton"));
        try {
            component(DialogBox.class, "");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=" + DialogBox.ID + " is not a DialogBox but a AlertBox"));
        }
    }

    @Test
    public void can_test_title() {
        clickOn(component(Button.class, "dialogButton"));
        assertThat(component(DialogBox.class, "").title(), is("Information"));
    }

    @Test
    public void can_test_message() {
        clickOn(component(Button.class, "dialogButton"));
        assertThat(component(DialogBox.class, "").message(), is("Save changes ?"));
    }

    @Test
    public void can_obtain_dialogbox_button() {
        clickOn(component(Button.class, "dialogButton"));
        assertThat(component(DialogBox.class, "").buttons().size(), is(2));
    }

    @Test
    public void test_toString() {
        clickOn(component(Button.class, "dialogButton"));
        assertThat(component(DialogBox.class, "").toString(), is("class org.testatoo.cartridge.extjs3.component.DialogBox with state : enabled:true, visible:true, title:Information, message:Save changes ?"));
    }

}
