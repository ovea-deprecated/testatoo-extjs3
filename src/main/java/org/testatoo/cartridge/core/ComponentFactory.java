package org.testatoo.cartridge.core;

import org.testatoo.cartridge.extjs3.By;
import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.cartridge.extjs3.component.DialogBox;
import org.testatoo.cartridge.extjs3.component.Page;
import org.testatoo.core.ComponentException;
import org.testatoo.core.Evaluator;
import org.testatoo.core.EvaluatorHolder;
import org.testatoo.core.component.AlertBox;
import org.testatoo.core.component.Component;
import org.testatoo.core.component.DropDown;
import org.testatoo.core.component.ListBox;

import java.lang.reflect.InvocationTargetException;

/**
 * @author David Avenante
 */
public final class ComponentFactory {

    public static Page page() {
        return new Page(evaluator());
    }

    public static <T extends Component> T component(Class<T> componentType, String id) {

        if (componentType.equals(AlertBox.class) || componentType.equals(org.testatoo.cartridge.extjs3.component.AlertBox.class))
            return (T) new org.testatoo.cartridge.extjs3.component.AlertBox(evaluator());
        if (componentType.equals(DialogBox.class) || componentType.equals(org.testatoo.cartridge.extjs3.component.DialogBox.class))
            return (T) new org.testatoo.cartridge.extjs3.component.DialogBox(evaluator());

        try {
            return (T) componentType.getConstructor(ExtJSEvaluator.class, String.class).newInstance(evaluator(), id);
        } catch (Exception e) {
            if (e.getCause() instanceof ComponentException)
                throw (ComponentException) e.getCause();
            try {
                return componentType.getConstructor(Evaluator.class, String.class).newInstance(evaluator(), id);
            } catch (InvocationTargetException ite) {
                throw new ComponentException(ite.getTargetException().getMessage(), ite.getTargetException());
            } catch (Exception e1) {
                throw new ComponentException(e1.getMessage(), e1);
            }
        }

    }

    private static ExtJSEvaluator evaluator() {
        return EvaluatorHolder.get();
    }
}
