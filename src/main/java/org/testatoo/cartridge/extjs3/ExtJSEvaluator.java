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

}
