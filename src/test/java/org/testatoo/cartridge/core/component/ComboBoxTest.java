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
import org.testatoo.core.component.ComboBox;
import org.testatoo.core.input.Keyboard;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;
import static org.testatoo.core.Language.clickOn;

public class ComboBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/combobox/ComboBox.html");
    }

    @Test
    public void can_find_combobox_by_id() {
        component(ComboBox.class, "combobox");

        try {
            component(ComboBox.class, "otherCombobox");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=otherCombobox"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_combobox() {
        try {
            component(ComboBox.class, "dropdown");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=dropdown is not a ComboBox but a DropDown"));
        }
    }

    @Test
    public void can_select_value() {
        ComboBox comboBox = component(ComboBox.class, "combobox");
        comboBox.select("Oklahoma");
        assertThat(comboBox.selectedValue(), is("Oklahoma"));
    }

    @Test
    public void can_list_values() {
        assertThat(component(ComboBox.class, "combobox").values().size(), is(51));
    }

    @Test
    public void can_type_value() {
        clickOn(component(ComboBox.class, "combobox"));
        Keyboard.type("Canada");
        assertThat(component(ComboBox.class, "combobox").selectedValue(), is("Canada"));
    }

    @Test
    public void test_label() {
        assertThat(component(ComboBox.class, "combobox").label(), is("States label"));
    }

    @Test
    public void test_toString() {
        assertThat(component(ComboBox.class, "combobox").toString(), is("class org.testatoo.core.component.ComboBox with state : enabled:true, visible:true, " +
                "values:[Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, District of Columbia, Florida, Georgia, Hawaii, " +
                "Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, " +
                "Montana, Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina, North Dakota, Ohio, Oklahoma, Oregon, " +
                "Pennsylvania, Rhode Island, South Carolina, South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia, Wisconsin, " +
                "Wyoming], selectedValues:[], label:States label"));
    }
}
