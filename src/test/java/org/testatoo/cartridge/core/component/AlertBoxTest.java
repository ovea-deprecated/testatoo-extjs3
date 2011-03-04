package org.testatoo.cartridge.core.component;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.AlertBox;
import org.testatoo.core.component.Button;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.core.ComponentFactory.component;
import static org.testatoo.cartridge.core.ComponentFactory.page;
import static org.testatoo.core.input.Mouse.clickOn;

/**
 * @author David Avenante
 */
public class AlertBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("component/alertbox/AlertBox.html");
    }

    @Test
    public void can_find_alertBox() {
        try {
            component(AlertBox.class, "");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), containsString("Cannot find component defined by id="));
        }
        clickOn(component(Button.class, "alertButton"));
        AlertBox alertbox = component(AlertBox.class, "");
        alertbox.close();
    }

    @Test
    public void exception_thrown_if_component_not_a_alertBox() {
        clickOn(component(Button.class, "dialogButton"));
        try {
            component(AlertBox.class, "");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), containsString("is not a AlertBox but a DialogBox"));
        }
    }

    @Test
    public void can_test_title() {
        clickOn(component(Button.class, "alertButton"));
        assertThat(component(AlertBox.class, "").title(), is("Status"));
    }


    @Test
    public void can_test_message() {
        clickOn(component(Button.class, "alertButton"));
        assertThat(component(AlertBox.class, "").message(), is("Changes saved successfully."));
    }

    @Test
    public void can_close_alertbox() {
        clickOn(component(Button.class, "alertButton"));

        AlertBox alert = component(AlertBox.class, "");
        alert.close();
        try {
            component(AlertBox.class, "");
            fail();
        } catch (ComponentException e) {
            Assert.assertThat(e.getMessage(), is("Cannot find component defined by id=_$ALERTBOX$_"));
        }
    }

    @Test
    public void test_toString() {
        clickOn(component(Button.class, "alertButton"));
        Assert.assertThat(component(AlertBox.class, "").toString(), is("class org.testatoo.cartridge.extjs3.component.AlertBox with state : enabled:true, visible:true, title:Status, message:Changes saved successfully."));
    }
}