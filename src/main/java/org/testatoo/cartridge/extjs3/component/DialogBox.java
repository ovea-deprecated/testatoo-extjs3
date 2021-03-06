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
import org.testatoo.core.ComponentException;
import static org.testatoo.core.ComponentType.DialogBox;

public class DialogBox extends org.testatoo.core.component.DialogBox {

    public static final String ID = "_$DIALOGBOX$_";

    public DialogBox(ExtJSEvaluator evaluator) {
        super(evaluator, ID);

        if (evaluator.componentType(ID) != DialogBox)
            throw new ComponentException("The component with id=" + ID + " is not a " + DialogBox + " but a " + evaluator.componentType(ID));
    }
}
