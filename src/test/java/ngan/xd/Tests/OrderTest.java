package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @Test(priority = 0)
    public void order() {
        getOrderPage().order();
    }
}
