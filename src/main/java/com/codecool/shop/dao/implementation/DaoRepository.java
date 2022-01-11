package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.DatabaseConfig;
import com.codecool.shop.config.Initializer;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.database.DatabaseManager;
import com.codecool.shop.dao.implementation.memory.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;
import com.codecool.shop.dao.implementation.memory.SupplierDaoMem;

import java.util.Properties;

public class DaoRepository {

    Properties conProp = DatabaseConfig.getConProps();
    DatabaseManager databaseManager = Initializer.getDatabaseManager();

    public ProductDao getProductDao() {
        if (conProp.getProperty("dao").equals("memory")) {
            return ProductDaoMem.getInstance();
        } else if (conProp.getProperty("dao").equals("jdbc")) {
            return databaseManager.getProductDao();
        } else {
            return null;
        }
    }

    public ProductCategoryDao getProductCategoryDao() {
        if (conProp.getProperty("dao").equals("memory")) {
            return ProductCategoryDaoMem.getInstance();
        } else if (conProp.getProperty("dao").equals("jdbc")) {
            return databaseManager.getProductCategoryDao();
        } else {
            return null;
        }
    }

    public SupplierDao getSupplierDao() {
        if (conProp.getProperty("dao").equals("memory")) {
            return SupplierDaoMem.getInstance();
        } else if (conProp.getProperty("dao").equals("jdbc")) {
            return databaseManager.getSupplierDao();
        } else {
            return null;
        }
    }
}
