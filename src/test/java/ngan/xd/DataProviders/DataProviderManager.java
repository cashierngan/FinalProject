package ngan.xd.DataProviders;

import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {
    @DataProvider(name = "data_provider_miniapp")
    public Object[][] dataLogin() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getExcelDataHashTable(ngan.xd.helpers.Helpers.getCurrentDir() + "datatest/RegisterMiniAppPlan.xlsx", "AddMiniApp", 2,3);
        return data;
    }
}
