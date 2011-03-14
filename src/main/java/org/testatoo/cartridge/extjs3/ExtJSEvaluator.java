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
package org.testatoo.cartridge.extjs3;

import com.thoughtworks.selenium.Selenium;
import org.testatoo.core.Evaluator;

/**
 * @author David Avenante
 */
public interface ExtJSEvaluator extends Evaluator<Selenium> {

    /**
     * To open the page corresponding to the given url
     *
     * @param url the url of the page
     */
    void open(String url);

    /**
     * To get the current page source
     *
     * @return the page source
     */
    String pageSource();

    String pageId();
}
