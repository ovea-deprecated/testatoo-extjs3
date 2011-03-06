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
