package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.DatabaseConfig;
import com.codecool.shop.config.Initializer;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.database.DatabaseManager;
import com.codecool.shop.dao.implementation.memory.ProductDaoMem;

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
}
