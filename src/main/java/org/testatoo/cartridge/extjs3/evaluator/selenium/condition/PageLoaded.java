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
import org.testatoo.cartridge.extjs3.Bootstraper;
import org.testatoo.core.Condition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author David Avenante
 */
public class PageLoaded implements Condition {

    private String customScript = "";
    private Selenium selenium;

    public PageLoaded(Selenium selenium) {
        this.selenium = selenium;
    }

    public boolean isReach() {
        if (!Boolean.valueOf(selenium.getEval("this.browserbot.newPageLoaded"))) {
            try {
                selenium.getEval("window.tQuery().isTQueryAvailable()");
                return true;
            } catch (Exception e) {
                loadUserExtensions();
                selenium.runScript(customScript);
            }
        }
        return false;
    }

     private void loadUserExtensions() {
        customScript = "";
        addScript("tquery-1.4-min.js");
        addScript("tquery-simulate.js");
        addScript("tquery-util.js");
    }

    private void addScript(String name) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(Bootstraper.class.getResourceAsStream(name)));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            customScript += builder.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Internal error occured when trying to load custom scripts : " + e.getMessage(), e);
        }
    }
}