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