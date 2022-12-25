package ngan.xd.Tests;

import ngan.xd.Common.BaseTest;
import ngan.xd.DataProviders.DataProviderAddProduct;
import ngan.xd.helpers.ExcelHelpers;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddProductTest extends BaseTest {
    ExcelHelpers excelLogin;
    ExcelHelpers excelAddProduct;

//    @Test(priority = 1, dataProvider = "data_provider_add_product", dataProviderClass = DataProviderAddProduct.class)
//    public void addProductSuccess(String productName, String category, String unit, Double weight, String tags, Double unitPrice, String discountDate, int quantity, String description, int discount, String imgName) {
//        excelLogin = new ExcelHelpers();
//        excelAddProduct = new ExcelHelpers();
//        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
//        excelAddProduct.setExcelFile("DataTest/AddProduct.xlsx", "AddProduct");
////        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), excelAddProduct.getCellData("product name", 1), excelAddProduct.getCellData("category", 1), excelAddProduct.getCellData("unit", 1), Double.valueOf(excelAddProduct.getCellData("weight", 1)), excelAddProduct.getCellData("tags", 1), Double.valueOf(excelAddProduct.getCellData("unit price", 1)), excelAddProduct.getCellData("discount date", 1),
////                Integer.parseInt(excelAddProduct.getCellData("quantity", 1)), excelAddProduct.getCellData("description", 1), Integer.parseInt(excelAddProduct.getCellData("discount", 1)), excelAddProduct.getCellData("image", 1));
////        getAddProductPage().verifyNewProduct(excelAddProduct.getCellData("product name", 1), excelAddProduct.getCellData("category", 1), excelAddProduct.getCellData("unit", 1), Double.valueOf(excelAddProduct.getCellData("unit price", 1)), excelAddProduct.getCellData("description", 1));
//
//        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), productName, category, unit, weight, tags, unitPrice, discountDate,
//                quantity, description, discount, imgName);
//        getAddProductPage().verifyNewProduct(productName, category, unit, unitPrice, description);

//    }

    @Test(priority = 1, dataProvider = "data_provider_add_product", dataProviderClass = DataProviderAddProduct.class)
    public void addProductSuccess(Hashtable<String, String> data) {
        excelLogin = new ExcelHelpers();
        excelAddProduct = new ExcelHelpers();
        excelLogin.setExcelFile("DataTest/Login.xlsx", "Login");
        excelAddProduct.setExcelFile("DataTest/AddProduct.xlsx", "AddProduct");
//        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), excelAddProduct.getCellData("product name", 1), excelAddProduct.getCellData("category", 1), excelAddProduct.getCellData("unit", 1), Double.valueOf(excelAddProduct.getCellData("weight", 1)), excelAddProduct.getCellData("tags", 1), Double.valueOf(excelAddProduct.getCellData("unit price", 1)), excelAddProduct.getCellData("discount date", 1),
//                Integer.parseInt(excelAddProduct.getCellData("quantity", 1)), excelAddProduct.getCellData("description", 1), Integer.parseInt(excelAddProduct.getCellData("discount", 1)), excelAddProduct.getCellData("image", 1));
//        getAddProductPage().verifyNewProduct(excelAddProduct.getCellData("product name", 1), excelAddProduct.getCellData("category", 1), excelAddProduct.getCellData("unit", 1), Double.valueOf(excelAddProduct.getCellData("unit price", 1)), excelAddProduct.getCellData("description", 1));

        getAddProductPage().addProduct(excelLogin.getCellData("email", 5), excelLogin.getCellData("password", 5), data.get("productName"), data.get("category"), data.get("unit"), data.get("weight"), data.get("tags"), data.get("unitPrice"), data.get("discountDate"), data.get("quantity"), data.get("description"), data.get("discount"), data.get("image"));
        getAddProductPage().verifyNewProduct(data.get("productName"), data.get("category"), data.get("unit"), Double.valueOf(data.get("unitPrice")), data.get("description"));

    }

}


