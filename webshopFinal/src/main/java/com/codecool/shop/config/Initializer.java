package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Amazon", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Lenovo", "Computers");
        supplierDataStore.add(lenovo);
        Supplier apple = new Supplier("Apple","Smartphone");
        supplierDataStore.add(apple);
        Supplier samsung = new Supplier("Samsung","Smartphone");
        supplierDataStore.add(samsung);
        Supplier huawei = new Supplier("Huawei","Smartphone");
        supplierDataStore.add(huawei);



        //setting up a new product category
        ProductCategory tablet = new ProductCategory("Tablet", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(tablet);
        ProductCategory smartphones = new ProductCategory("Smartphone","Hardware","A smartphone is a mobile device that combines cellular and mobile computing functions into one unit.");
        productCategoryDataStore.add(smartphones);
        ProductCategory speakers = new ProductCategory("Speaker","Hardware","Speaker is defined as an electrical device used to make sound or music louder.");
        productCategoryDataStore.add(speakers);

        //setting up products and printing it
        productDataStore.add(new Product("Amazon Fire", 49.9f, "USD", "Fantastic price. Large content ecosystem. Good parental controls. Helpful technical support.", tablet, amazon));
        productDataStore.add(new Product("Lenovo IdeaPad Miix 700", 479.9f, "USD", "Keyboard cover is included. Fanless Core m5 processor. Full-size USB ports. Adjustable kickstand.", tablet, lenovo));
        productDataStore.add(new Product("Amazon Fire HD 8", 89.9f, "USD", "Amazon's latest Fire HD 8 tablet is a great value for media consumption.", tablet, amazon));
        productDataStore.add(new Product("Apple Iphone 11",899.9f,"USD","The iPhone 11 is a smartphone designed, developed, and marketed by Apple Inc. It is the thirteenth generation lower-priced iPhone, succeeding the iPhone XR.",smartphones,apple));
        productDataStore.add(new Product("Samsung Galaxy S20",999.9f,"USD","Samsung Galaxy S20 is released in February 2020. The smartphone is featured with Bixby natural language commands and dictation along with Samsung DeX (desktop experience support).",smartphones,samsung));
        productDataStore.add(new Product("Huawei P30",799.9f,"USD","The Huawei P30, P30 Pro and P30 lite are Android smartphones manufactured by Huawei. Unveiled on 26 March 2019, they succeed the Huawei P20 in the company's P series line.",smartphones,huawei));
        productDataStore.add(new Product("Apple HomePod",349.9f,"USD","HomePod is Apple's answer to the Amazon Echo, but with more of a focus on music and sound quality. HomePod includes impressive sound and also supports Siri commands.",speakers,apple));
    }
}
