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
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.core.Condition;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.condition.TimerCondition;

import static org.testatoo.core.ComponentFactory.page;

public class AutoCompleterTest extends WebTest {

    @BeforeClass
    public static void beforeClass() {
        ExtJSEvaluator htmlEvaluator = (ExtJSEvaluator) EvaluatorHolder.get();
        ConditionChain conditionChain = (ConditionChain) htmlEvaluator.getWaitingCondition();
        conditionChain.addCondition(new TimerCondition(200));
    }

    @Test
    public void can_test_ajax_autocompleter() {
        page().open("input/AutoCompleter.html");

//        try {
//            findDiv(By.title("March"));
//            fail();
//        } catch (Exception e) {
//
//        }

//        clickOn(inputText("months"));
//        Keyboard.type("M");
//
//        waitingFor(OneSecond());
//        findDiv(By.title("March"));
//        findDiv(By.title("May"));
    }

    @Ignore
    private Condition OneSecond() {
        return new Condition() {
            @Override
            public boolean isReach() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    // Nop
                }
                return true;
            }
        };
    }
}
