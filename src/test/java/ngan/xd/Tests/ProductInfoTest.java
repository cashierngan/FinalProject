package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import ngan.xd.helpers.PropertiesHelper;
import org.apache.commons.lang3.ObjectUtils;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class ProductInfoTest extends BaseTest {
    public ExcelHelpers excel;

    @Test(priority = 1)
    public void roductInfo() {
        excel = new ExcelHelpers();
        excel.setExcelFile("DataTest/GetProductInfo.xlsx", "ProductInfo");
        ArrayList productInfo = getProductInfoPage().productInfo(PropertiesHelper.getValue("product_P01"));
        int lastRow = excel.getLastRowNum();
        int newRow = lastRow + 1;
        excel.setCellData(String.valueOf(newRow), newRow, 0);
        for (int i = 0; i < productInfo.size(); i++) {
            if (String.valueOf(newRow) != null) {
                excel.setCellData((String) productInfo.get(i), newRow, i + 1);
            }
        }
    }
}
