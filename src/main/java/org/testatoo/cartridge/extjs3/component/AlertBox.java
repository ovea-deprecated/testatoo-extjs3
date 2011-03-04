package org.testatoo.cartridge.extjs3.component;

import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.core.ComponentException;

import static org.testatoo.core.ComponentType.AlertBox;

/**
 * @author David Avenante
 */
public class AlertBox extends org.testatoo.core.component.AlertBox {

    public static final String ID = "_$ALERTBOX$_";

    public AlertBox(ExtJSEvaluator evaluator) {
        super(evaluator, ID);

        if (evaluator.componentType(ID) != AlertBox)
            throw new ComponentException("The component with id=" + ID + " is not a " + AlertBox + " but a " + evaluator.componentType(ID));
    }

}