package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

public class AddProductTest extends BaseTest {
    ExcelHelpers excelLogin;
    ExcelHelpers excelAddProduct;

    @Test(priority = 1)
    public void addProductSuccess() {
        excelLogin = new ExcelHelpers();
        excelAddProduct = new ExcelHelpers();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        excelAddProduct.setExcelFile("DataTest/AddProduct.xlsx", "AddProduct");
        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), excelAddProduct.getCellData("product name", 1), excelAddProduct.getCellData("category", 1), excelAddProduct.getCellData("unit", 1), Double.valueOf(excelAddProduct.getCellData("weight", 1)), excelAddProduct.getCellData("tags", 1), Double.valueOf(excelAddProduct.getCellData("unit price", 1)), excelAddProduct.getCellData("discount date", 1),
                Integer.parseInt(excelAddProduct.getCellData("quantity", 1)), excelAddProduct.getCellData("SKU", 1), excelAddProduct.getCellData("description", 1), Integer.parseInt(excelAddProduct.getCellData("discount", 1)));
    }
}
