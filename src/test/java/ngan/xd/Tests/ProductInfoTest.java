package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductInfoTest extends BaseTest {
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void roductInfo() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/GetProductInfo.xlsx", "ProductInfo");
        ArrayList productInfo = getProductInfoPage().productInfo();
        int row = 1;
        for (int i = 0; i < productInfo.size(); i++) {
            excel.setCellData((String) productInfo.get(i), row, i);
        }


    }

}
