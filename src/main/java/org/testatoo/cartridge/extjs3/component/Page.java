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

package org.testatoo.cartridge.extjs3.component;

import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.core.component.Component;
import org.testatoo.core.nature.Container;
import org.testatoo.core.nature.TitleSupport;

public class Page extends Component implements Container, TitleSupport {

    public static final String ID = "_PAGE_ID_";
    private ExtJSEvaluator evaluator;

    public Page(ExtJSEvaluator evaluator) {
        super(evaluator, Page.ID);
        this.evaluator = evaluator;
    }

    public Page open(String url) {
        evaluator.open(url);
        return this;
    }

    public String source() {
        return evaluator.pageSource();
    }

    public String title() {
        return evaluator.title(this);
    }

    /* Placeholder for language
    * 1 - if the component doesn't exit a component Exception is thrown before the call of this method
    * 2 - If this method is call than the component exist and by the way in the page.
    */
    public Boolean contains(Component... component) {
        return true;
    }

    @Override
    public Boolean isEnabled() {
        return true;
    }

    @Override
    public Boolean isVisible() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ", title:" + title();
    }
}
