package org.testatoo.cartridge.extjs3.evaluator.selenium.condition;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import org.testatoo.core.Condition;

/**
 * @author David Avenante
 */
public class AjaxConnectionClosed implements Condition {

    private Selenium selenium;

    public AjaxConnectionClosed(Selenium selenium) {
        this.selenium = selenium;
    }

    public boolean isReach() {
        String numberOfActiveConnection;

        try {
            if (selenium.getEval("window.Ext.numberOfActiveConnection").equals("null")) {
                try {
                    numberOfActiveConnection = selenium.getEval("window.Ext.numberOfActiveConnection = 0;window.Ext.Ajax.on('beforerequest', function(response) {window.Ext.numberOfActiveConnection++;}, window.Ext.Ajax);" +
                        "window.Ext.Ajax.on('requestcomplete', function(response) {window.Ext.numberOfActiveConnection--;}, window.Ext.Ajax);" +
                        "window.Ext.Ajax.on('requestexception', function(response) {window.Ext.numberOfActiveConnection--;}, window.Ext.Ajax); window.Ext.numberOfActiveConnection");
                    return Integer.valueOf(numberOfActiveConnection) == 0;
                } catch (SeleniumException se) {
                    // Page without ExtJS !!!
                }
            }

            numberOfActiveConnection = selenium.getEval("window.Ext.numberOfActiveConnection");
            if (!numberOfActiveConnection.equals("null") && Integer.valueOf(numberOfActiveConnection) < 0)
                numberOfActiveConnection = selenium.getEval("window.Ext.numberOfActiveConnection = 0");
            return !numberOfActiveConnection.equals("null") && Integer.valueOf(numberOfActiveConnection) == 0;
        } catch (Exception e) {
            // ExtJs is not here so continue
            return true;
        }
    }
}
