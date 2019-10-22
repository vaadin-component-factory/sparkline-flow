package com.vaadin.flow.component.sparkline;

import com.vaadin.testbench.TestBenchElement;
import org.junit.Assert;
import org.junit.Test;

public class DemoViewIT extends AbstractViewTest {

    @Test
    public void testIt() {
        final TestBenchElement sparkline = $("object").first();
        Assert.assertTrue(sparkline.hasAttribute("data"));
    }
}
