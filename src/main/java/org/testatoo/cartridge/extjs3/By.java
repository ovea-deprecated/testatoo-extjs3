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

import java.util.Arrays;
import java.util.List;

/**
 * @author David Avenante
 */
public abstract class By {

    public static By id(final String id) {
        if (id == null)
            throw new IllegalArgumentException("Cannot find component with a null id.");

        return new By() {
            @Override
            public String id(ExtJSEvaluator evaluator) {
                return id;
            }

            @Override
            public List<String> ids(ExtJSEvaluator evaluator) {
                return Arrays.asList(id);
            }

            @Override
            public String toString() {
                return "by id=" + id;
            }
        };
    }

    public abstract String id(ExtJSEvaluator evaluator);

    public abstract List<String> ids(ExtJSEvaluator evaluator);

    public abstract String toString();
}