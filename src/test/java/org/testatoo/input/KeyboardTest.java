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

package org.testatoo.input;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.component.Panel;
import org.testatoo.core.component.TextField;
import org.testatoo.core.condition.TimerCondition;
import org.testatoo.core.input.Keyboard;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.into;
import static org.testatoo.core.Language.type;
import static org.testatoo.core.input.KeyModifier.CONTROL;
import static org.testatoo.core.input.KeyModifier.SHIFT;
import static org.testatoo.core.matcher.Matchers.disabled;
import static org.testatoo.core.matcher.Matchers.enabled;

public class KeyboardTest extends WebTest {

    @BeforeClass
    public static void beforeClass() {
        ExtJSEvaluator htmlEvaluator = (ExtJSEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));
    }

    @Test
    public void can_type_data() {
        page().open("input/TextField.html");
        TextField input_language = component(TextField.class, "input_language");
        assertThat(input_language.value(), is("french"));

        type(" AS language", into(input_language));
        assertThat(input_language.value(), containsString("AS language"));
    }

    @Test
    public void can_test_key_modifier() {
        page().open("input/KeyboardTest.html");

        Keyboard.keyDown(CONTROL);
        Keyboard.keyDown(SHIFT);

        assertThat(component(Panel.class, "_Ctrl_Shift_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_Ctrl_Shift_a"), is(disabled()));

        Keyboard.release(CONTROL);

        assertThat(component(Panel.class, "_Shift_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_Shift_a"), is(disabled()));


        Keyboard.release(SHIFT);
        Keyboard.release();

        assertThat(component(Panel.class, "_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_a"), is(disabled()));
    }

}
