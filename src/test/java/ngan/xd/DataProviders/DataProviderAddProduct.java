package ngan.xd.DataProviders;

import ngan.xd.helpers.ExcelHelpers;
import ngan.xd.helpers.Helpers;
import org.testng.annotations.DataProvider;

public class DataProviderAddProduct {
    @DataProvider(name = "data_provider_add_product")
    public Object[][] dataAddProduct() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
//        Object[][] data = excelHelpers.getExcelData(Helpers.getCurrentDir() + "DataTest/AddProduct.xlsx", "AddProduct");
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + "DataTest/AddProduct.xlsx", "AddProduct", 1, 2);
        return data;
    }
}
