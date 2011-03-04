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
import org.testatoo.core.component.CheckBox;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;
import static org.testatoo.core.input.Mouse.clickOn;

public class CheckBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/checkbox/CheckBox.html");
    }

    @Test
    public void can_find_checkbox_by_id() {
        component(CheckBox.class, "dog_id");

        try {
            component(CheckBox.class, "bird_id");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=bird_id"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_checkbox() {
        try {
            component(CheckBox.class, "checkboxError");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=checkboxError is not a CheckBox but a Button"));
        }
    }

    @Test
    public void can_check() {
        CheckBox dog = component(CheckBox.class, "dog_id");

        assertThat(dog.isChecked(), is(false));
        clickOn(dog);
        assertThat(dog.isChecked(), is(true));
        clickOn(dog);
        assertThat(dog.isChecked(), is(false));

        CheckBox cat = component(CheckBox.class, "cat_id");
        assertThat(cat.isChecked(), is(true));
        cat.unCheck();
        assertThat(cat.isChecked(), is(false));
        cat.check();
        assertThat(cat.isChecked(), is(true));
    }

    @Test
    public void test_label() {
        assertThat(component(CheckBox.class, "dog_id").label(), is("Dog"));
    }

    @Test
    public void test_toString() {
        assertThat(component(CheckBox.class, "cat_id").toString(), is("class org.testatoo.core.component.CheckBox with state : enabled:true, visible:true, label:Cat, checked:true"));
    }
}