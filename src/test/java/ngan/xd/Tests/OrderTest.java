package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void successOrder() {
        getOrderPage().order("delivery as soon as possible");
    }
}
