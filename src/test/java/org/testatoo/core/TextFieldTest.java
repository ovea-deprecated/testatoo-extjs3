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

package org.testatoo.core;

import org.junit.Before;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.component.TextField;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.enter;
import static org.testatoo.core.Language.on;

public class TextFieldTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/textfield/TextField.html");
    }

    @Test
    public void can_find_textField_by_id() {
        component(TextField.class, "username");

        try {
            component(TextField.class, "username_id");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=username_id"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_textField() {
        try {
            component(TextField.class, "textfieldError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=textfieldError is not a TextField but a CheckBox"));
        }
    }

    @Test
    public void can_type_data() {
        TextField username = component(TextField.class, "username");

        assertThat(username.value(), is(""));
        enter("Jean Pierre", on(username));
        assertThat(username.value(), is("Jean Pierre"));
    }

    @Test
    public void can_test_max_length() {
        assertThat(component(TextField.class, "username").maxLength(), is(25));
    }

    @Test
    public void test_label() {
        assertThat(component(TextField.class, "city").label(), is("City"));
    }

    @Test
    public void test_toString() {
        enter("myValue", on(component(TextField.class, "username")));
        assertThat(component(TextField.class, "username").toString(), is("class org.testatoo.core.component.TextField with state : enabled:true, visible:true, value:myValue, label:Username, maxLength:25"));
    }
}
