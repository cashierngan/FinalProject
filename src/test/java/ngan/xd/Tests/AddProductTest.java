package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.DataProviders.DataProviderAddProduct;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddProductTest extends BaseTest {
    ExcelHelpers excelLogin;
    ExcelHelpers excelAddProduct;

    @Test(priority = 1, dataProvider = "data_provider_add_product", dataProviderClass = DataProviderAddProduct.class)
    public void addProductSuccess(Hashtable<String, String> data) {
        excelLogin = new ExcelHelpers();
        excelAddProduct = new ExcelHelpers();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        excelAddProduct.setExcelFile("DataTest/AddProduct.xlsx", "AddProduct");
        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), data.get("productName"), data.get("category"), data.get("unit"), data.get("weight"), data.get("tags"), data.get("unitPrice"), data.get("discountDate"), data.get("quantity"), data.get("description"), data.get("discount"), data.get("image"));
        getAddProductPage().verifyNewProduct(data.get("category"), data.get("unit"), Double.valueOf(data.get("unitPrice")), data.get("description"));

    }
}


