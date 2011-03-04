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

package org.testatoo.cartridge.input;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.component.Panel;
import org.testatoo.core.condition.TimerCondition;
import org.testatoo.core.input.KeyModifier;
import org.testatoo.core.input.Keyboard;

import static org.hamcrest.Matchers.is;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.input.Key.*;
import static org.testatoo.core.input.KeyModifier.*;
import static org.testatoo.core.matcher.Matchers.disabled;
import static org.testatoo.core.matcher.Matchers.enabled;

public class FullKeyboardTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        ExtJSEvaluator htmlEvaluator = (ExtJSEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));

        page().open("input/AllKeysTest.html");
    }

    @Test
    public void can_test_CONTROL_key_modifier() {
        Keyboard.keyDown(KeyModifier.CONTROL);

        assertThat(component(Panel.class, "_Ctrl_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_Ctrl_a"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_b"), is(enabled()));
        Keyboard.type("b");
        assertThat(component(Panel.class, "_Ctrl_b"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_c"), is(enabled()));
        Keyboard.type("c");
        assertThat(component(Panel.class, "_Ctrl_c"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_d"), is(enabled()));
        Keyboard.type("d");
        assertThat(component(Panel.class, "_Ctrl_d"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_e"), is(enabled()));
        Keyboard.type("e");
        assertThat(component(Panel.class, "_Ctrl_e"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f"), is(enabled()));
        Keyboard.type("f");
        assertThat(component(Panel.class, "_Ctrl_f"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_g"), is(enabled()));
        Keyboard.type("g");
        assertThat(component(Panel.class, "_Ctrl_g"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_h"), is(enabled()));
        Keyboard.type("h");
        assertThat(component(Panel.class, "_Ctrl_h"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_i"), is(enabled()));
        Keyboard.type("i");
        assertThat(component(Panel.class, "_Ctrl_i"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_j"), is(enabled()));
        Keyboard.type("j");
        assertThat(component(Panel.class, "_Ctrl_j"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_k"), is(enabled()));
        Keyboard.type("k");
        assertThat(component(Panel.class, "_Ctrl_k"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_l"), is(enabled()));
        Keyboard.type("l");
        assertThat(component(Panel.class, "_Ctrl_l"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_m"), is(enabled()));
        Keyboard.type("m");
        assertThat(component(Panel.class, "_Ctrl_m"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_n"), is(enabled()));
        Keyboard.type("n");
        assertThat(component(Panel.class, "_Ctrl_n"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_o"), is(enabled()));
        Keyboard.type("o");
        assertThat(component(Panel.class, "_Ctrl_o"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_p"), is(enabled()));
        Keyboard.type("p");
        assertThat(component(Panel.class, "_Ctrl_p"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_q"), is(enabled()));
        Keyboard.type("q");
        assertThat(component(Panel.class, "_Ctrl_q"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_r"), is(enabled()));
        Keyboard.type("r");
        assertThat(component(Panel.class, "_Ctrl_r"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_s"), is(enabled()));
        Keyboard.type("s");
        assertThat(component(Panel.class, "_Ctrl_s"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_t"), is(enabled()));
        Keyboard.type("t");
        assertThat(component(Panel.class, "_Ctrl_t"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_u"), is(enabled()));
        Keyboard.type("u");
        assertThat(component(Panel.class, "_Ctrl_u"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_v"), is(enabled()));
        Keyboard.type("v");
        assertThat(component(Panel.class, "_Ctrl_v"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_w"), is(enabled()));
        Keyboard.type("w");
        assertThat(component(Panel.class, "_Ctrl_w"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_x"), is(enabled()));
        Keyboard.type("x");
        assertThat(component(Panel.class, "_Ctrl_x"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_y"), is(enabled()));
        Keyboard.type("y");
        assertThat(component(Panel.class, "_Ctrl_y"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_z"), is(enabled()));
        Keyboard.type("z");
        assertThat(component(Panel.class, "_Ctrl_z"), is(disabled()));

        Keyboard.release();
    }

    @Test
    public void can_test_SHIFT_key_modifier() {
        Keyboard.keyDown(SHIFT);

        assertThat(component(Panel.class, "_Shift_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_Shift_a"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_b"), is(enabled()));
        Keyboard.type("b");
        assertThat(component(Panel.class, "_Shift_b"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_c"), is(enabled()));
        Keyboard.type("c");
        assertThat(component(Panel.class, "_Shift_c"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_d"), is(enabled()));
        Keyboard.type("d");
        assertThat(component(Panel.class, "_Shift_d"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_e"), is(enabled()));
        Keyboard.type("e");
        assertThat(component(Panel.class, "_Shift_e"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f"), is(enabled()));
        Keyboard.type("f");
        assertThat(component(Panel.class, "_Shift_f"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_g"), is(enabled()));
        Keyboard.type("g");
        assertThat(component(Panel.class, "_Shift_g"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_h"), is(enabled()));
        Keyboard.type("h");
        assertThat(component(Panel.class, "_Shift_h"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_i"), is(enabled()));
        Keyboard.type("i");
        assertThat(component(Panel.class, "_Shift_i"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_j"), is(enabled()));
        Keyboard.type("j");
        assertThat(component(Panel.class, "_Shift_j"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_k"), is(enabled()));
        Keyboard.type("k");
        assertThat(component(Panel.class, "_Shift_k"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_l"), is(enabled()));
        Keyboard.type("l");
        assertThat(component(Panel.class, "_Shift_l"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_m"), is(enabled()));
        Keyboard.type("m");
        assertThat(component(Panel.class, "_Shift_m"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_n"), is(enabled()));
        Keyboard.type("n");
        assertThat(component(Panel.class, "_Shift_n"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_o"), is(enabled()));
        Keyboard.type("o");
        assertThat(component(Panel.class, "_Shift_o"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_p"), is(enabled()));
        Keyboard.type("p");
        assertThat(component(Panel.class, "_Shift_p"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_q"), is(enabled()));
        Keyboard.type("q");
        assertThat(component(Panel.class, "_Shift_q"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_r"), is(enabled()));
        Keyboard.type("r");
        assertThat(component(Panel.class, "_Shift_r"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_s"), is(enabled()));
        Keyboard.type("s");
        assertThat(component(Panel.class, "_Shift_s"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_t"), is(enabled()));
        Keyboard.type("t");
        assertThat(component(Panel.class, "_Shift_t"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_u"), is(enabled()));
        Keyboard.type("u");
        assertThat(component(Panel.class, "_Shift_u"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_v"), is(enabled()));
        Keyboard.type("v");
        assertThat(component(Panel.class, "_Shift_v"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_w"), is(enabled()));
        Keyboard.type("w");
        assertThat(component(Panel.class, "_Shift_w"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_x"), is(enabled()));
        Keyboard.type("x");
        assertThat(component(Panel.class, "_Shift_x"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_y"), is(enabled()));
        Keyboard.type("y");
        assertThat(component(Panel.class, "_Shift_y"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_z"), is(enabled()));
        Keyboard.type("z");
        assertThat(component(Panel.class, "_Shift_z"), is(disabled()));

        Keyboard.release();
    }

    @Test
    public void can_test_ALT_key_modifier() {
        Keyboard.keyDown(ALT);

        assertThat(component(Panel.class, "_Alt_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_Alt_a"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_b"), is(enabled()));
        Keyboard.type("b");
        assertThat(component(Panel.class, "_Alt_b"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_c"), is(enabled()));
        Keyboard.type("c");
        assertThat(component(Panel.class, "_Alt_c"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_d"), is(enabled()));
        Keyboard.type("d");
        assertThat(component(Panel.class, "_Alt_d"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_e"), is(enabled()));
        Keyboard.type("e");
        assertThat(component(Panel.class, "_Alt_e"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f"), is(enabled()));
        Keyboard.type("f");
        assertThat(component(Panel.class, "_Alt_f"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_g"), is(enabled()));
        Keyboard.type("g");
        assertThat(component(Panel.class, "_Alt_g"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_h"), is(enabled()));
        Keyboard.type("h");
        assertThat(component(Panel.class, "_Alt_h"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_i"), is(enabled()));
        Keyboard.type("i");
        assertThat(component(Panel.class, "_Alt_i"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_j"), is(enabled()));
        Keyboard.type("j");
        assertThat(component(Panel.class, "_Alt_j"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_k"), is(enabled()));
        Keyboard.type("k");
        assertThat(component(Panel.class, "_Alt_k"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_l"), is(enabled()));
        Keyboard.type("l");
        assertThat(component(Panel.class, "_Alt_l"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_m"), is(enabled()));
        Keyboard.type("m");
        assertThat(component(Panel.class, "_Alt_m"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_n"), is(enabled()));
        Keyboard.type("n");
        assertThat(component(Panel.class, "_Alt_n"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_o"), is(enabled()));
        Keyboard.type("o");
        assertThat(component(Panel.class, "_Alt_o"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_p"), is(enabled()));
        Keyboard.type("p");
        assertThat(component(Panel.class, "_Alt_p"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_q"), is(enabled()));
        Keyboard.type("q");
        assertThat(component(Panel.class, "_Alt_q"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_r"), is(enabled()));
        Keyboard.type("r");
        assertThat(component(Panel.class, "_Alt_r"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_s"), is(enabled()));
        Keyboard.type("s");
        assertThat(component(Panel.class, "_Alt_s"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_t"), is(enabled()));
        Keyboard.type("t");
        assertThat(component(Panel.class, "_Alt_t"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_u"), is(enabled()));
        Keyboard.type("u");
        assertThat(component(Panel.class, "_Alt_u"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_v"), is(enabled()));
        Keyboard.type("v");
        assertThat(component(Panel.class, "_Alt_v"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_w"), is(enabled()));
        Keyboard.type("w");
        assertThat(component(Panel.class, "_Alt_w"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_x"), is(enabled()));
        Keyboard.type("x");
        assertThat(component(Panel.class, "_Alt_x"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_y"), is(enabled()));
        Keyboard.type("y");
        assertThat(component(Panel.class, "_Alt_y"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_z"), is(enabled()));
        Keyboard.type("z");
        assertThat(component(Panel.class, "_Alt_z"), is(disabled()));

        Keyboard.release();
    }

    @Test
    public void generalKeyTest() {
        assertThat(component(Panel.class, "_a"), is(enabled()));
        Keyboard.type("a");
        assertThat(component(Panel.class, "_a"), is(disabled()));

        assertThat(component(Panel.class, "_b"), is(enabled()));
        Keyboard.type("b");
        assertThat(component(Panel.class, "_b"), is(disabled()));

        assertThat(component(Panel.class, "_c"), is(enabled()));
        Keyboard.type("c");
        assertThat(component(Panel.class, "_c"), is(disabled()));

        assertThat(component(Panel.class, "_d"), is(enabled()));
        Keyboard.type("d");
        assertThat(component(Panel.class, "_d"), is(disabled()));

        assertThat(component(Panel.class, "_e"), is(enabled()));
        Keyboard.type("e");
        assertThat(component(Panel.class, "_e"), is(disabled()));

        assertThat(component(Panel.class, "_f"), is(enabled()));
        Keyboard.type("f");
        assertThat(component(Panel.class, "_f"), is(disabled()));

        assertThat(component(Panel.class, "_g"), is(enabled()));
        Keyboard.type("g");
        assertThat(component(Panel.class, "_g"), is(disabled()));

        assertThat(component(Panel.class, "_h"), is(enabled()));
        Keyboard.type("h");
        assertThat(component(Panel.class, "_h"), is(disabled()));

        assertThat(component(Panel.class, "_i"), is(enabled()));
        Keyboard.type("i");
        assertThat(component(Panel.class, "_i"), is(disabled()));

        assertThat(component(Panel.class, "_j"), is(enabled()));
        Keyboard.type("j");
        assertThat(component(Panel.class, "_j"), is(disabled()));

        assertThat(component(Panel.class, "_k"), is(enabled()));
        Keyboard.type("k");
        assertThat(component(Panel.class, "_k"), is(disabled()));

        assertThat(component(Panel.class, "_l"), is(enabled()));
        Keyboard.type("l");
        assertThat(component(Panel.class, "_l"), is(disabled()));

        assertThat(component(Panel.class, "_m"), is(enabled()));
        Keyboard.type("m");
        assertThat(component(Panel.class, "_m"), is(disabled()));

        assertThat(component(Panel.class, "_n"), is(enabled()));
        Keyboard.type("n");
        assertThat(component(Panel.class, "_n"), is(disabled()));

        assertThat(component(Panel.class, "_o"), is(enabled()));
        Keyboard.type("o");
        assertThat(component(Panel.class, "_o"), is(disabled()));

        assertThat(component(Panel.class, "_p"), is(enabled()));
        Keyboard.type("p");
        assertThat(component(Panel.class, "_p"), is(disabled()));

        assertThat(component(Panel.class, "_q"), is(enabled()));
        Keyboard.type("q");
        assertThat(component(Panel.class, "_q"), is(disabled()));

        assertThat(component(Panel.class, "_r"), is(enabled()));
        Keyboard.type("r");
        assertThat(component(Panel.class, "_r"), is(disabled()));

        assertThat(component(Panel.class, "_s"), is(enabled()));
        Keyboard.type("s");
        assertThat(component(Panel.class, "_s"), is(disabled()));

        assertThat(component(Panel.class, "_t"), is(enabled()));
        Keyboard.type("t");
        assertThat(component(Panel.class, "_t"), is(disabled()));

        assertThat(component(Panel.class, "_u"), is(enabled()));
        Keyboard.type("u");
        assertThat(component(Panel.class, "_u"), is(disabled()));

        assertThat(component(Panel.class, "_v"), is(enabled()));
        Keyboard.type("v");
        assertThat(component(Panel.class, "_v"), is(disabled()));

        assertThat(component(Panel.class, "_w"), is(enabled()));
        Keyboard.type("w");
        assertThat(component(Panel.class, "_w"), is(disabled()));

        assertThat(component(Panel.class, "_x"), is(enabled()));
        Keyboard.type("x");
        assertThat(component(Panel.class, "_x"), is(disabled()));

        assertThat(component(Panel.class, "_y"), is(enabled()));
        Keyboard.type("y");
        assertThat(component(Panel.class, "_y"), is(disabled()));

        assertThat(component(Panel.class, "_z"), is(enabled()));
        Keyboard.type("z");
        assertThat(component(Panel.class, "_z"), is(disabled()));

        assertThat(component(Panel.class, "_f1"), is(enabled()));
        Keyboard.press(F1);
        assertThat(component(Panel.class, "_f1"), is(disabled()));

        assertThat(component(Panel.class, "_f2"), is(enabled()));
        Keyboard.press(F2);
        assertThat(component(Panel.class, "_f2"), is(disabled()));

        assertThat(component(Panel.class, "_f3"), is(enabled()));
        Keyboard.press(F3);
        assertThat(component(Panel.class, "_f3"), is(disabled()));

        assertThat(component(Panel.class, "_f4"), is(enabled()));
        Keyboard.press(F4);
        assertThat(component(Panel.class, "_f4"), is(disabled()));

        assertThat(component(Panel.class, "_f5"), is(enabled()));
        Keyboard.press(F5);
        assertThat(component(Panel.class, "_f5"), is(disabled()));

        assertThat(component(Panel.class, "_f6"), is(enabled()));
        Keyboard.press(F6);
        assertThat(component(Panel.class, "_f6"), is(disabled()));

        assertThat(component(Panel.class, "_f7"), is(enabled()));
        Keyboard.press(F7);
        assertThat(component(Panel.class, "_f7"), is(disabled()));

        assertThat(component(Panel.class, "_f8"), is(enabled()));
        Keyboard.press(F8);
        assertThat(component(Panel.class, "_f8"), is(disabled()));

        assertThat(component(Panel.class, "_f9"), is(enabled()));
        Keyboard.press(F9);
        assertThat(component(Panel.class, "_f9"), is(disabled()));

        assertThat(component(Panel.class, "_f10"), is(enabled()));
        Keyboard.press(F10);
        assertThat(component(Panel.class, "_f10"), is(disabled()));

        assertThat(component(Panel.class, "_f11"), is(enabled()));
        Keyboard.press(F11);
        assertThat(component(Panel.class, "_f11"), is(disabled()));

        assertThat(component(Panel.class, "_f12"), is(enabled()));
        Keyboard.press(F12);
        assertThat(component(Panel.class, "_f12"), is(disabled()));

        assertThat(component(Panel.class, "_0"), is(enabled()));
        Keyboard.press(NUMPAD0);
        assertThat(component(Panel.class, "_0"), is(disabled()));

        assertThat(component(Panel.class, "_1"), is(enabled()));
        Keyboard.press(NUMPAD1);
        assertThat(component(Panel.class, "_1"), is(disabled()));

        assertThat(component(Panel.class, "_2"), is(enabled()));
        Keyboard.press(NUMPAD2);
        assertThat(component(Panel.class, "_2"), is(disabled()));

        assertThat(component(Panel.class, "_3"), is(enabled()));
        Keyboard.press(NUMPAD3);
        assertThat(component(Panel.class, "_3"), is(disabled()));

        assertThat(component(Panel.class, "_4"), is(enabled()));
        Keyboard.press(NUMPAD4);
        assertThat(component(Panel.class, "_4"), is(disabled()));

        assertThat(component(Panel.class, "_5"), is(enabled()));
        Keyboard.press(NUMPAD5);
        assertThat(component(Panel.class, "_5"), is(disabled()));

        assertThat(component(Panel.class, "_6"), is(enabled()));
        Keyboard.press(NUMPAD6);
        assertThat(component(Panel.class, "_6"), is(disabled()));

        assertThat(component(Panel.class, "_7"), is(enabled()));
        Keyboard.press(NUMPAD7);
        assertThat(component(Panel.class, "_7"), is(disabled()));

        assertThat(component(Panel.class, "_8"), is(enabled()));
        Keyboard.press(NUMPAD8);
        assertThat(component(Panel.class, "_8"), is(disabled()));

        assertThat(component(Panel.class, "_9"), is(enabled()));
        Keyboard.press(NUMPAD9);
        assertThat(component(Panel.class, "_9"), is(disabled()));

        assertThat(component(Panel.class, "_backspace"), is(enabled()));
        Keyboard.press(BACKSPACE);
        assertThat(component(Panel.class, "_backspace"), is(disabled()));

        assertThat(component(Panel.class, "_tab"), is(enabled()));
        Keyboard.press(TAB);
        assertThat(component(Panel.class, "_tab"), is(disabled()));

        assertThat(component(Panel.class, "_return"), is(enabled()));
        Keyboard.press(ENTER);
        assertThat(component(Panel.class, "_return"), is(disabled()));

        assertThat(component(Panel.class, "_pause"), is(enabled()));
        Keyboard.press(PAUSE);
        assertThat(component(Panel.class, "_pause"), is(disabled()));

        assertThat(component(Panel.class, "_esc"), is(enabled()));
        Keyboard.press(ESCAPE);
        assertThat(component(Panel.class, "_esc"), is(disabled()));

        assertThat(component(Panel.class, "_space"), is(enabled()));
        Keyboard.press(SPACE);
        assertThat(component(Panel.class, "_space"), is(disabled()));

        assertThat(component(Panel.class, "_pageup"), is(enabled()));
        Keyboard.press(PAGE_UP);
        assertThat(component(Panel.class, "_pageup"), is(disabled()));

        assertThat(component(Panel.class, "_pagedown"), is(enabled()));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Panel.class, "_pagedown"), is(disabled()));

        assertThat(component(Panel.class, "_end"), is(enabled()));
        Keyboard.press(END);
        assertThat(component(Panel.class, "_end"), is(disabled()));

        assertThat(component(Panel.class, "_home"), is(enabled()));
        Keyboard.press(HOME);
        assertThat(component(Panel.class, "_home"), is(disabled()));

        assertThat(component(Panel.class, "_left"), is(enabled()));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Panel.class, "_left"), is(disabled()));

        assertThat(component(Panel.class, "_up"), is(enabled()));
        Keyboard.press(UP_ARROW);
        assertThat(component(Panel.class, "_up"), is(disabled()));

        assertThat(component(Panel.class, "_right"), is(enabled()));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Panel.class, "_right"), is(disabled()));

        assertThat(component(Panel.class, "_down"), is(enabled()));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Panel.class, "_down"), is(disabled()));

        assertThat(component(Panel.class, "_insert"), is(enabled()));
        Keyboard.press(INSERT);
        assertThat(component(Panel.class, "_insert"), is(disabled()));

        assertThat(component(Panel.class, "_del"), is(enabled()));
        Keyboard.press(DELETE);
        assertThat(component(Panel.class, "_del"), is(disabled()));

        assertThat(component(Panel.class, "_scroll"), is(enabled()));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Panel.class, "_scroll"), is(disabled()));

        assertThat(component(Panel.class, "_capslock"), is(enabled()));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Panel.class, "_capslock"), is(disabled()));

        assertThat(component(Panel.class, "_numlock"), is(enabled()));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Panel.class, "_numlock"), is(disabled()));

//    ADD,
//    MULTIPLY,
//    SUBTRACT,
//    DIVIDE,
    }

    @Test
    public void can_test_CONTROL_Key() {
        Keyboard.keyDown(CONTROL);

        assertThat(component(Panel.class, "_Ctrl_esc"), is(enabled()));
        Keyboard.press(ESCAPE);
        assertThat(component(Panel.class, "_Ctrl_esc"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_tab"), is(enabled()));
        Keyboard.press(TAB);
        assertThat(component(Panel.class, "_Ctrl_tab"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_space"), is(enabled()));
        Keyboard.press(SPACE);
        assertThat(component(Panel.class, "_Ctrl_space"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_return"), is(enabled()));
        Keyboard.press(ENTER);
        assertThat(component(Panel.class, "_Ctrl_return"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_backspace"), is(enabled()));
        Keyboard.press(BACKSPACE);
        assertThat(component(Panel.class, "_Ctrl_backspace"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_scroll"), is(enabled()));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Panel.class, "_Ctrl_scroll"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_capslock"), is(enabled()));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Panel.class, "_Ctrl_capslock"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_numlock"), is(enabled()));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Panel.class, "_Ctrl_numlock"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_pause"), is(enabled()));
        Keyboard.press(PAUSE);
        assertThat(component(Panel.class, "_Ctrl_pause"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_insert"), is(enabled()));
        Keyboard.press(INSERT);
        assertThat(component(Panel.class, "_Ctrl_insert"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_home"), is(enabled()));
        Keyboard.press(HOME);
        assertThat(component(Panel.class, "_Ctrl_home"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_del"), is(enabled()));
        Keyboard.press(DELETE);
        assertThat(component(Panel.class, "_Ctrl_del"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_end"), is(enabled()));
        Keyboard.press(END);
        assertThat(component(Panel.class, "_Ctrl_end"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_pageup"), is(enabled()));
        Keyboard.press(PAGE_UP);
        assertThat(component(Panel.class, "_Ctrl_pageup"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_pagedown"), is(enabled()));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Panel.class, "_Ctrl_pagedown"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_left"), is(enabled()));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Panel.class, "_Ctrl_left"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_up"), is(enabled()));
        Keyboard.press(UP_ARROW);
        assertThat(component(Panel.class, "_Ctrl_up"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_right"), is(enabled()));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Panel.class, "_Ctrl_right"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_down"), is(enabled()));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Panel.class, "_Ctrl_down"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f1"), is(enabled()));
        Keyboard.press(F1);
        assertThat(component(Panel.class, "_Ctrl_f1"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f2"), is(enabled()));
        Keyboard.press(F2);
        assertThat(component(Panel.class, "_Ctrl_f2"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f3"), is(enabled()));
        Keyboard.press(F3);
        assertThat(component(Panel.class, "_Ctrl_f3"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f4"), is(enabled()));
        Keyboard.press(F4);
        assertThat(component(Panel.class, "_Ctrl_f4"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f5"), is(enabled()));
        Keyboard.press(F5);
        assertThat(component(Panel.class, "_Ctrl_f5"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f6"), is(enabled()));
        Keyboard.press(F6);
        assertThat(component(Panel.class, "_Ctrl_f6"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f7"), is(enabled()));
        Keyboard.press(F7);
        assertThat(component(Panel.class, "_Ctrl_f7"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f8"), is(enabled()));
        Keyboard.press(F8);
        assertThat(component(Panel.class, "_Ctrl_f8"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f9"), is(enabled()));
        Keyboard.press(F9);
        assertThat(component(Panel.class, "_Ctrl_f9"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f10"), is(enabled()));
        Keyboard.press(F10);
        assertThat(component(Panel.class, "_Ctrl_f10"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f11"), is(enabled()));
        Keyboard.press(F11);
        assertThat(component(Panel.class, "_Ctrl_f11"), is(disabled()));

        assertThat(component(Panel.class, "_Ctrl_f12"), is(enabled()));
        Keyboard.press(F12);
        assertThat(component(Panel.class, "_Ctrl_f12"), is(disabled()));

        Keyboard.release();
    }

    @Test
    public void can_test_SHIFT_Key() {
        Keyboard.keyDown(SHIFT);

        assertThat(component(Panel.class, "_Shift_esc"), is(enabled()));
        Keyboard.press(ESCAPE);
        assertThat(component(Panel.class, "_Shift_esc"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_tab"), is(enabled()));
        Keyboard.press(TAB);
        assertThat(component(Panel.class, "_Shift_tab"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_space"), is(enabled()));
        Keyboard.press(SPACE);
        assertThat(component(Panel.class, "_Shift_space"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_return"), is(enabled()));
        Keyboard.press(ENTER);
        assertThat(component(Panel.class, "_Shift_return"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_backspace"), is(enabled()));
        Keyboard.press(BACKSPACE);
        assertThat(component(Panel.class, "_Shift_backspace"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_scroll"), is(enabled()));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Panel.class, "_Shift_scroll"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_capslock"), is(enabled()));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Panel.class, "_Shift_capslock"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_numlock"), is(enabled()));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Panel.class, "_Shift_numlock"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_pause"), is(enabled()));
        Keyboard.press(PAUSE);
        assertThat(component(Panel.class, "_Shift_pause"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_insert"), is(enabled()));
        Keyboard.press(INSERT);
        assertThat(component(Panel.class, "_Shift_insert"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_home"), is(enabled()));
        Keyboard.press(HOME);
        assertThat(component(Panel.class, "_Shift_home"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_del"), is(enabled()));
        Keyboard.press(DELETE);
        assertThat(component(Panel.class, "_Shift_del"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_end"), is(enabled()));
        Keyboard.press(END);
        assertThat(component(Panel.class, "_Shift_end"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_pageup"), is(enabled()));
        Keyboard.press(PAGE_UP);
        assertThat(component(Panel.class, "_Shift_pageup"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_pagedown"), is(enabled()));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Panel.class, "_Shift_pagedown"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_left"), is(enabled()));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Panel.class, "_Shift_left"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_up"), is(enabled()));
        Keyboard.press(UP_ARROW);
        assertThat(component(Panel.class, "_Shift_up"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_right"), is(enabled()));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Panel.class, "_Shift_right"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_down"), is(enabled()));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Panel.class, "_Shift_down"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f1"), is(enabled()));
        Keyboard.press(F1);
        assertThat(component(Panel.class, "_Shift_f1"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f2"), is(enabled()));
        Keyboard.press(F2);
        assertThat(component(Panel.class, "_Shift_f2"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f3"), is(enabled()));
        Keyboard.press(F3);
        assertThat(component(Panel.class, "_Shift_f3"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f4"), is(enabled()));
        Keyboard.press(F4);
        assertThat(component(Panel.class, "_Shift_f4"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f5"), is(enabled()));
        Keyboard.press(F5);
        assertThat(component(Panel.class, "_Shift_f5"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f6"), is(enabled()));
        Keyboard.press(F6);
        assertThat(component(Panel.class, "_Shift_f6"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f7"), is(enabled()));
        Keyboard.press(F7);
        assertThat(component(Panel.class, "_Shift_f7"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f8"), is(enabled()));
        Keyboard.press(F8);
        assertThat(component(Panel.class, "_Shift_f8"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f9"), is(enabled()));
        Keyboard.press(F9);
        assertThat(component(Panel.class, "_Shift_f9"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f10"), is(enabled()));
        Keyboard.press(F10);
        assertThat(component(Panel.class, "_Shift_f10"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f11"), is(enabled()));
        Keyboard.press(F11);
        assertThat(component(Panel.class, "_Shift_f11"), is(disabled()));

        assertThat(component(Panel.class, "_Shift_f12"), is(enabled()));
        Keyboard.press(F12);
        assertThat(component(Panel.class, "_Shift_f12"), is(disabled()));


        Keyboard.release();
    }

    @Test
    public void can_test_ALT_Key() {
        Keyboard.keyDown(ALT);

        assertThat(component(Panel.class, "_Alt_esc"), is(enabled()));
        Keyboard.press(ESCAPE);
        assertThat(component(Panel.class, "_Alt_esc"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_tab"), is(enabled()));
        Keyboard.press(TAB);
        assertThat(component(Panel.class, "_Alt_tab"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_space"), is(enabled()));
        Keyboard.press(SPACE);
        assertThat(component(Panel.class, "_Alt_space"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_return"), is(enabled()));
        Keyboard.press(ENTER);
        assertThat(component(Panel.class, "_Alt_return"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_backspace"), is(enabled()));
        Keyboard.press(BACKSPACE);
        assertThat(component(Panel.class, "_Alt_backspace"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_scroll"), is(enabled()));
        Keyboard.press(SCROLL_LOCK);
        assertThat(component(Panel.class, "_Alt_scroll"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_capslock"), is(enabled()));
        Keyboard.press(CAPS_LOCK);
        assertThat(component(Panel.class, "_Alt_capslock"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_numlock"), is(enabled()));
        Keyboard.press(NUM_LOCK);
        assertThat(component(Panel.class, "_Alt_numlock"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_pause"), is(enabled()));
        Keyboard.press(PAUSE);
        assertThat(component(Panel.class, "_Alt_pause"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_insert"), is(enabled()));
        Keyboard.press(INSERT);
        assertThat(component(Panel.class, "_Alt_insert"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_home"), is(enabled()));
        Keyboard.press(HOME);
        assertThat(component(Panel.class, "_Alt_home"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_del"), is(enabled()));
        Keyboard.press(DELETE);
        assertThat(component(Panel.class, "_Alt_del"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_end"), is(enabled()));
        Keyboard.press(END);
        assertThat(component(Panel.class, "_Alt_end"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_pageup"), is(enabled()));
        Keyboard.press(PAGE_UP);
        assertThat(component(Panel.class, "_Alt_pageup"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_pagedown"), is(enabled()));
        Keyboard.press(PAGE_DOWN);
        assertThat(component(Panel.class, "_Alt_pagedown"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_left"), is(enabled()));
        Keyboard.press(LEFT_ARROW);
        assertThat(component(Panel.class, "_Alt_left"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_up"), is(enabled()));
        Keyboard.press(UP_ARROW);
        assertThat(component(Panel.class, "_Alt_up"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_right"), is(enabled()));
        Keyboard.press(RIGHT_ARROW);
        assertThat(component(Panel.class, "_Alt_right"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_down"), is(enabled()));
        Keyboard.press(DOWN_ARROW);
        assertThat(component(Panel.class, "_Alt_down"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f1"), is(enabled()));
        Keyboard.press(F1);
        assertThat(component(Panel.class, "_Alt_f1"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f2"), is(enabled()));
        Keyboard.press(F2);
        assertThat(component(Panel.class, "_Alt_f2"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f3"), is(enabled()));
        Keyboard.press(F3);
        assertThat(component(Panel.class, "_Alt_f3"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f4"), is(enabled()));
        Keyboard.press(F4);
        assertThat(component(Panel.class, "_Alt_f4"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f5"), is(enabled()));
        Keyboard.press(F5);
        assertThat(component(Panel.class, "_Alt_f5"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f6"), is(enabled()));
        Keyboard.press(F6);
        assertThat(component(Panel.class, "_Alt_f6"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f7"), is(enabled()));
        Keyboard.press(F7);
        assertThat(component(Panel.class, "_Alt_f7"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f8"), is(enabled()));
        Keyboard.press(F8);
        assertThat(component(Panel.class, "_Alt_f8"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f9"), is(enabled()));
        Keyboard.press(F9);
        assertThat(component(Panel.class, "_Alt_f9"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f10"), is(enabled()));
        Keyboard.press(F10);
        assertThat(component(Panel.class, "_Alt_f10"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f11"), is(enabled()));
        Keyboard.press(F11);
        assertThat(component(Panel.class, "_Alt_f11"), is(disabled()));

        assertThat(component(Panel.class, "_Alt_f12"), is(enabled()));
        Keyboard.press(F12);
        assertThat(component(Panel.class, "_Alt_f12"), is(disabled()));

        Keyboard.release();
    }

}


