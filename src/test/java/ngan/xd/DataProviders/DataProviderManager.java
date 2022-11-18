package ngan.xd.DataProviders;

import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name = "data_provider_login")
    public Object[][] dataLogin() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelData(ngan.xd.helpers.Helpers.getCurrentDir() + "DataTest/Login.xlsx", "Login");
        return data;
    }
}
