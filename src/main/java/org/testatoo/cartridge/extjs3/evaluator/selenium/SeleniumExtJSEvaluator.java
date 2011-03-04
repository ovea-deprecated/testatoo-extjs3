package org.testatoo.cartridge.extjs3.evaluator.selenium;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleniumException;
import com.thoughtworks.selenium.Wait;
import org.testatoo.cartridge.extjs3.Bootstraper;
import org.testatoo.cartridge.extjs3.ExtJSEvaluator;
import org.testatoo.cartridge.extjs3.component.AlertBox;
import org.testatoo.cartridge.extjs3.component.DialogBox;
import org.testatoo.cartridge.extjs3.component.Page;
import org.testatoo.cartridge.extjs3.component.XType;
import org.testatoo.core.AbstractEvaluator;
import org.testatoo.core.ComponentType;
import org.testatoo.core.ListSelection;
import org.testatoo.core.Selection;
import org.testatoo.core.component.*;
import org.testatoo.core.component.datagrid.*;
import org.testatoo.core.input.Click;
import org.testatoo.core.input.Key;
import org.testatoo.core.nature.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static org.testatoo.core.input.KeyModifier.*;

/**
 * @author David Avenante
 */
public class SeleniumExtJSEvaluator extends AbstractEvaluator<Selenium> implements ExtJSEvaluator {

    private final Selenium selenium;
    private final String name;

    private Component currentFocusedComponent;

    private static final String COLUMN_ALIAS = "testatoo_column";
    private static final String ROW_ALIAS = "testatoo_row";
    private static final String CELL_ALIAS = "testatoo_cell";

    /**
     * Class constructor specifying the used selenium engine
     *
     * @param selenium the selenium engine
     */
    public SeleniumExtJSEvaluator(String name, Selenium selenium) {
        this.name = name;
        this.selenium = selenium;
    }

    public SeleniumExtJSEvaluator(Selenium selenium) {
        this(DEFAULT_NAME, selenium);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selenium implementation() {
        return selenium;
    }

    @Override
    public String name() {
        return name;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void open(String url) {
        currentFocusedComponent = null;
        release();
        selenium.open(url);
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String pageSource() {
        return selenium.getHtmlSource();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean existComponent(String id) {
        if (id.equals(Page.ID)) {
            return true;
        }

        if (id.equals(AlertBox.ID) || id.equals(DialogBox.ID)) {
            try {
                String exist = selenium.getEval("window.Ext.WindowMgr.getActive()");
                return !exist.equals("null");
            } catch (SeleniumException se) {
                return false;
            }
        }

        if (id.startsWith(COLUMN_ALIAS) || id.startsWith(ROW_ALIAS) || id.startsWith(CELL_ALIAS)) {
            return true;
        }

        Boolean exist = Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + id + "') != null;"));
        if (exist == FALSE) {
            return selenium.isElementPresent("id=" + id);
        }
        return exist;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public ComponentType componentType(String id) {
        XType xType;

        if (id.startsWith(COLUMN_ALIAS)) {
            return ComponentType.Column;
        }

        if (id.startsWith(ROW_ALIAS)) {
            return ComponentType.Row;
        }

        if (id.startsWith(CELL_ALIAS)) {
            return ComponentType.Cell;
        }

        if (id.equals(AlertBox.ID)) {
            if (windowButtons().size() > 1) {
                return ComponentType.DialogBox;
            }
            return ComponentType.AlertBox;
        }
        if (id.equals(DialogBox.ID)) {
            if (windowButtons().size() == 1) {
                return ComponentType.AlertBox;
            }
            return ComponentType.DialogBox;
        }
        try {
            xType = XType.valueOf(selenium.getEval("window.Ext.getCmp('" + id + "').getXType();"));
            if (xType == XType.button) {
                return ComponentType.Button;
            }
            if (xType == XType.checkbox) {
                return ComponentType.CheckBox;
            }
            if (xType == XType.combo) {
                if (Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + id + "').forceSelection;")))
                    return ComponentType.DropDown;
                return ComponentType.ComboBox;
            }
            if (xType == XType.panel || xType == XType.form) {
                return ComponentType.Panel;
            }
            if (xType == XType.radio) {
                return ComponentType.Radio;
            }
            if (xType == XType.textfield) {
                if (selenium.getEval("window.Ext.getCmp('" + id + "').inputType;").equals("password"))
                    return ComponentType.PasswordField;
                return ComponentType.TextField;
            }
            if (xType == XType.window) {
                return ComponentType.Window;
            }
        } catch (Exception e) {
            // Maybe it a HTML element like Link or img
            if (selenium.isElementPresent("id=" + id)) {
                return ComponentType.valueOf(evaluate(jQueryExpression("result = $('#" + id + "').componentType()")));
            }
        }

        return ComponentType.Undefined;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String text(TextSupport textSupport) {
        if ((Component) textSupport instanceof Link)
            return selenium.getText(((Component) textSupport).id());

        return selenium.getEval("window.Ext.getCmp('" + ((Component) textSupport).id() + "').getText();");
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String message(org.testatoo.core.component.AlertBox alertBox) {
        return selenium.getEval("window.Ext.DomQuery.selectValue(\"[@class='ext-mb-text']\", window.Ext.WindowMgr.getActive().body.dom);");
    }

    @Override
    public String message(org.testatoo.core.component.DialogBox dialogBox) {
        return selenium.getEval("window.Ext.DomQuery.selectValue(\"[@class='ext-mb-text']\", window.Ext.WindowMgr.getActive().body.dom);");
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String icon(IconSupport iconSupport) {
        String icon = selenium.getEval("window.Ext.getCmp('" + ((Component) iconSupport).id() + "').icon;");
        if (icon.equals("null"))
            return "";
        return icon;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean isEnabled(Component component) {
        if (component instanceof Image || component instanceof Link)
            return !Boolean.valueOf(evaluate(jQueryExpression("result = $('#" + component.id() + "').is(':disabled')")))
                    && !Boolean.valueOf(evaluate(jQueryExpression("result = $('#" + component.id() + "').attr('readonly') == true")));

        if (component.id().equals(AlertBox.ID) || component.id().equals(DialogBox.ID))
            return !Boolean.valueOf(selenium.getEval("window.Ext.WindowMgr.getActive().disabled;"));
        return !Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + component.id() + "').disabled;"));
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean isVisible(Component component) {
        if (component instanceof org.testatoo.core.component.AlertBox || component instanceof org.testatoo.core.component.DialogBox)
            return !Boolean.valueOf(selenium.getEval("window.Ext.WindowMgr.getActive().hidden;"));

        if (component instanceof Window) {
            try {
                return !Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + component.id() + "').hidden;"));
            } catch (Exception e) {
                return false;
            }
        }

        try {
            return !Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + component.id() + "').hidden;"));
        } catch (Exception e) {
            return selenium.isVisible(component.id());
        }
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void click(Component component, Click which) {
        try {
            setFocus(component);
            if (which == Click.right) {
                evaluate(jQueryExpression("$('#" + component.id() + "').simulate('rightclick')"));
            } else {
                // If component is link we need to open the expected target
                // Not sure but some Browser seems have a security check to not open page on js event
                if (component instanceof Link && !((Link) component).reference().equals("#")) {
                    selenium.click(component.id());
                } else {
                    evaluate(jQueryExpression("$('#" + component.id() + "').simulate('click')"));
                }
            }
            waitForCondition();
        } catch (Exception e) {
            // Continue... if the click change page
            waitForCondition();
        }
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void doubleClick(Component component) {
        selenium.getEval("window.tQuery('#" + component.id() + "').simulate('dblclick')");
        setFocus(component);
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void mouseOver(Component component) {
        selenium.getEval("window.tQuery('#" + component.id() + "').simulate('mouseover')");
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void mouseOut(Component component) {
        selenium.getEval("window.tQuery('#" + component.id() + "').simulate('mouseout')");
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void dragAndDrop(Component from, Component to) {
        selenium.getEval("window.tQuery('#" + from.id() + "').simulate('dragTo', {'target': window.tQuery('#" + to.id() + "')})");
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void type(String text) {
        String keyModifier = keyModifier();
        if (currentFocusedComponent != null) {
            for (byte charCode : text.getBytes()) {
                if (Boolean.valueOf(evaluate(jQueryExpression("$.browser.msie")))) {
                    evaluate(jQueryExpression("$('#" + currentFocusedComponent.id() + "')" +
                            ".val($('#" + currentFocusedComponent.id() + "').val() + String.fromCharCode(" + charCode + "));"));
                }
                evaluate(jQueryExpression("$('#" + currentFocusedComponent.id() + "').simulate('type', {charCode: " + charCode + keyModifier + "});"));
            }
        } else {
            for (char charCode : text.toCharArray()) {
                evaluate(jQueryExpression("if ($.browser.mozilla) {$(window.document).simulate('type', {keyCode: " + keyboardLayout.convert(charCode) + keyModifier + "})}" +
                        "else {$(window.document).simulate('type', {charCode: " + keyboardLayout.convert(charCode) + keyModifier + "})};"));
            }
        }
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void press(Key key) {
        typeKey(key.code());
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void focusOn(Component component) {
        click(component, Click.left);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String title(TitleSupport titleSupport) {
        Component component = (Component) titleSupport;

        if (component instanceof Page) {
            return selenium.getTitle();
        }

        if (component instanceof AlertBox || component instanceof DialogBox) {
            return selenium.getEval("window.Ext.WindowMgr.getActive().title");
        }

        if (component.id().startsWith(COLUMN_ALIAS)) {
            String[] composedId = component.id().split("-");
            return selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getColumnModel().getColumnHeader(" + composedId[2] + ");");
        }

        return selenium.getEval("window.Ext.getCmp('" + component.id() + "').title;");
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void close(AbstractWindow window) {
        if (window.id().equals(AlertBox.ID) || window.id().equals(DialogBox.ID))
            selenium.getEval("window.Ext.WindowMgr.getActive().close();");
        else
            selenium.getEval("window.Ext.getCmp('" + window.id() + "').close();");
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void check(Checkable checkable) {
        if (!checkable.isChecked()) {
            click((Component) checkable, Click.left);
        }
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void unCheck(CheckBox checkbox) {
        if (checkbox.isChecked()) {
            click(checkbox, Click.left);
        }
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean isChecked(Checkable checkable) {
        return Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + ((Component) checkable).id() + "').checked == true;"));
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String label(LabelSupport labelSupport) {
        Component component = (Component) labelSupport;
        String label;
        if (component instanceof CheckBox || component instanceof Radio)
            label = selenium.getEval("window.Ext.getCmp('" + ((Component) labelSupport).id() + "').boxLabel;");
        else
            label = selenium.getEval("window.Ext.getCmp('" + ((Component) labelSupport).id() + "').fieldLabel;");
        if (label.equals("null"))
            return "";
        return label;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public void select(String value, ListModel listModel) {
        selenium.getEval("window.Ext.getCmp('" + listModel.id() + "').setValue('" + value + "');");
        selenium.getEval("window.Ext.getCmp('" + listModel.id() + "').fireEvent('change');");
        waitForCondition();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<String> values(ListModel listModel) {
        String field = selenium.getEval("window.Ext.getCmp('" + listModel.id() + "').displayField;");
        String[] data = selenium.getEval("window.Ext.getCmp('" + listModel.id() + "').store.collect('" + field + "');").split(",");
        List<String> values = new ArrayList<String>();
        values.addAll(Arrays.asList(data));

        return ListSelection.from(values);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<String> selectedValues(ListModel listModel) {
        List<String> selectedValues = new ArrayList<String>();
        selectedValues.add(selenium.getEval("window.Ext.getCmp('" + listModel.id() + "').getValue();"));
        return ListSelection.from(selectedValues);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<Row> rows(DataGrid dataGrid) {
        String cmpId = dataGrid.id();
        List<Row> rows = new ArrayList<Row>();

        int numberOfRows = Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + cmpId + "').getStore().getCount();"));
        for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
            String rowId = ROW_ALIAS + "-" + cmpId + "-" + rowIndex;
            rows.add(new Row(this, rowId));
            evaluate(jQueryExpression("$($('#" + cmpId + " table[class=x-grid3-row-table]')[" + rowIndex + "]).attr('id', '" + rowId + "');"));
        }
        return ListSelection.from(rows);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<Column> columns(DataGrid dataGrid) {
        String cmpId = dataGrid.id();

        int numberOfColumns = Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + cmpId + "').getColumnModel().getColumnCount();"));
        List<Column> columns = new ArrayList<Column>();

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            String columnId = COLUMN_ALIAS + "-" + cmpId + "-" + columnIndex;
            columns.add(new Column(this, columnId));
            evaluate(jQueryExpression("$($('#" + cmpId + " tr[class=x-grid3-hd-row] td')[" + columnIndex + "]).attr('id', '" + columnId + "');"));
        }

        return ListSelection.from(columns);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<Cell> cells(CellContainer cellContainer) {
        Component component = (Component) cellContainer;
        String[] composedId = component.id().split("-");

        List<Cell> cells = new ArrayList<Cell>();

        if (component instanceof Row) {
            int numberOfColumns = Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getColumnModel().getColumnCount();"));
            int cellPosition = numberOfColumns * Integer.valueOf(composedId[2]);
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                String cellId = CELL_ALIAS + "-" + composedId[1] + "-C:" + columnIndex + "_" + "R:" + composedId[2];
                cells.add(new Cell(this, cellId));
                evaluate(jQueryExpression("$($('#" + composedId[1] + " table[class=x-grid3-row-table] td')[" + cellPosition + "]).attr('id', '" + cellId + "');"));
                cellPosition++;
            }
        }

        if (component instanceof Column) {
            int numberOfRows = Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getStore().getCount();"));
            int numberOfColumns = Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getColumnModel().getColumnCount();"));
            int cellPosition = Integer.valueOf(composedId[2]);
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                String cellId = CELL_ALIAS + "-" + composedId[1] + "-C:" + composedId[2] + "_" + "R:" + rowIndex;
                evaluate(jQueryExpression("$($('#" + composedId[1] + " table[class=x-grid3-row-table] td')[" + cellPosition + "]).attr('id', '" + cellId + "');"));
                cells.add(new Cell(this, cellId));
                cellPosition = cellPosition + numberOfColumns;
            }
        }
        return ListSelection.from(cells);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String value(ValueSupport valueSupport) {
        Component component = (Component) valueSupport;

        if (component instanceof Radio || component instanceof CheckBox)
            return inputValue(component.id());

        if (component instanceof Cell) {
            String[] composedId = component.id().split("-");
            String[] coord = composedId[2].split("_");

            String dataIndex = selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getColumnModel().getDataIndex(" + coord[0].split(":")[1] + ");");

            return selenium.getEval("window.Ext.getCmp('" + composedId[1] + "').getColumnModel()" +
                    ".getRenderer(" + coord[0].split(":")[1] + ")(window.Ext.getCmp('" + composedId[1] + "').getStore()" +
                    ".data.items[" + coord[1].split(":")[1] + "].data." + dataIndex + ");").replaceAll("\\<.*?>", "");
        }

        return selenium.getEval("window.Ext.getCmp('" + component.id() + "').getRawValue();");
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Selection<Button> buttons(org.testatoo.core.component.DialogBox dialogBox) {
        return windowButtons();
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String source(Image image) {
        String attributeValue = attribute(image.id(), "src");
        if (attributeValue.equals("null")) {
            return "";
        }
        return attributeValue;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String reference(Link link) {
        return attribute(link.id(), "href");
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Integer maxLength(AbstractTextField textField) {
        if (Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + textField.id() + "').maxLength == Number.MAX_VALUE;")))
            return Integer.MAX_VALUE;
        return Integer.valueOf(selenium.getEval("window.Ext.getCmp('" + textField.id() + "').maxLength;"));
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean contains(Container container, Component... component) {
        boolean containsAllElements = true;
        for (Component cmp : component) {
            if (!Boolean.valueOf(selenium.getEval("window.Ext.getCmp('" + cmp.id() + "').findParentBy(function(parent, child) {return parent.id == '" + ((Component) container).id() + "'}) != null;"))) {
                containsAllElements = false;
            }
        }
        return containsAllElements;
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public Boolean hasFocus(Component component) {
        return currentFocusedComponent != null && currentFocusedComponent.equals(component);
    }

    /**
     * @see org.testatoo.core.Evaluator
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("SeleniumExtJSEvaluator");
        sb.append("{location='").append(selenium.getLocation()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    // -------------- Private ----------------------

    private Selection<Button> windowButtons() {
        List<Button> buttons = new ArrayList<Button>();
        for (String id : activeButtons()) {
            buttons.add(new org.testatoo.cartridge.extjs3.component.Button(this, id));
        }
        return ListSelection.from(buttons);
    }

    private String[] activeButtons() {
        String listButtonsId = selenium.getEval("var buttons = window.Ext.WindowMgr.getActive().buttons;" +
                "var visibleButtonsId = new Array();" +
                "for(var i = 0, len = buttons.length; i < len; i++) {if (buttons[i].hidden == false) visibleButtonsId.push(buttons[i].id);}" +
                "visibleButtonsId;");
        return listButtonsId.split(",");
    }

    private void typeKey(int keyCode) {
        String keyModifier = keyModifier();
        evaluate(jQueryExpression("if($.browser.webkit) {$(window.document).simulate('type', {charCode: " + keyCode + keyModifier + "});}" +
                "else {$('body').simulate('type', {keyCode: " + keyCode + keyModifier + "});}"));
    }

    private String keyModifier() {
        if (!pressedKeyModifier.isEmpty()) {
            List<String> options = new ArrayList<String>();
            if (pressedKeyModifier.contains(CONTROL)) {
                options.add("ctrlKey : true");
            }
            if (pressedKeyModifier.contains(SHIFT)) {
                options.add("shiftKey : true");
            }
            if (pressedKeyModifier.contains(ALT)) {
                options.add("altKey : true");
            }

            String result = "";
            for (String option : options) {
                result = result + ", " + option;
            }
            return result;
        } else {
            return "";
        }
    }

    private String inputValue(String id) {
        String value = selenium.getEval("window.Ext.getCmp('" + id + "').inputValue;");
        if (value.equals("null"))
            return "";
        return value;
    }

    private String attribute(String id, String attribute) {
        String attributeValue = evaluate(jQueryExpression("result = $('#" + id + "').attributeValue('" + attribute + "');"));
        if (attributeValue.equals("null")) {
            return "";
        }
        return attributeValue;
    }

    private void waitForCondition() {
        new Wait() {
            public boolean until() {
                return getWaitingCondition().isReach();
            }
        }.wait("One of the waiting conditions has fail", 60000);
    }

    private String evaluate(String expression) {

        try {
            selenium.getEval("window.tQuery().isTQueryAvailable()");
        } catch (Exception e) {
            selenium.runScript(loadUserExtensions());
        }

        return selenium.getEval(expression);
    }

    private String loadUserExtensions() {
        String script = "";
        script += addScript("tquery-1.5.js");
        script += addScript("tquery-simulate.js");
        script += addScript("tquery-util.js");
        return script;
    }

    private String addScript(String name) {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(Bootstraper.class.getResourceAsStream(name)));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Internal error occured when trying to load custom scripts : " + e.getMessage(), e);
        }
    }

    private void setFocus(Component component) {
        evaluate(jQueryExpression("$('#" + component.id() + "').focus()"));
        currentFocusedComponent = component;

    }

    private String jQueryExpression(String expression) {
        return "(function($){var result; " + expression + " ;return result;})(window.tQuery);";
    }
//
//    private String content(String id) {
//        return selenium.getText("id=" + id);
//    }
}