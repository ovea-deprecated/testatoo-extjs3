package org.testatoo.cartridge.extjs3;


import com.thoughtworks.selenium.Selenium;
import org.testatoo.cartridge.extjs3.evaluator.selenium.SeleniumExtJSEvaluator;
import org.testatoo.cartridge.extjs3.evaluator.selenium.condition.AjaxConnectionClosed;
import org.testatoo.cartridge.extjs3.evaluator.selenium.condition.PageLoaded;
import org.testatoo.core.CartridgeBootstraper;
import org.testatoo.core.ConditionChain;
import org.testatoo.core.Evaluator;

import java.util.Map;

/**
 * @author David Avenante
 */

public final class Bootstraper implements CartridgeBootstraper {

    @Override
    public Evaluator buildEvaluator(Map<String, ?> params) {
        String name = (String) params.get("name");
        Selenium session = (Selenium) params.get(Selenium.class.getName());
        if (name != null && session != null) {
            ConditionChain conditionChain = ConditionChain.create();
            SeleniumExtJSEvaluator evaluator = new SeleniumExtJSEvaluator(name, session);
            evaluator.setWaitingCondition(conditionChain);
            return evaluator;
        }
        return null;
    }

}