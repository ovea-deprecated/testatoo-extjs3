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
import org.testatoo.core.component.Link;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class LinkTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/link/Link.html");
    }

    @Test
    public void can_find_link_by_id() {
        component(Link.class, "link_1");

        try {
            component(Link.class, "link_2");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=link_2"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_link() {
        try {
            component(Link.class, "textfield");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=textfield is not a Link but a TextField"));
        }
    }

    @Test
    public void can_obtain_content() {
        assertThat(component(Link.class, "link_1").text(), is("Link 1"));
    }

    @Test
    public void can_obtain_reference() {
        assertThat(component(Link.class, "link_1").reference(), is("Exit.html"));
    }

    @Test
    public void test_toString() {
        assertThat(component(Link.class, "link_1").toString(), is("class org.testatoo.core.component.Link with state : enabled:true, visible:true, text:Link 1, reference:Exit.html"));
    }

}
