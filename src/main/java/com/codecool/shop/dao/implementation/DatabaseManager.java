package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {

    String dbName;
    String dbUserName;
    String dbPassword;
    ProductDao productDao;
    SupplierDao supplierDao;

    public DatabaseManager(String dbName, String dbUserName, String dbPassword) {
        this.dbName = dbName;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        // TODO: 2022. 01. 10. add the jdbc classes later
        productDao = new ProductDaoJdbc(dataSource);
        supplierDao = new SupplierDaoJdbc(dataSource);
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(dbUserName);
        dataSource.setPassword(dbPassword);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public SupplierDao getSupplierDao() {
        return supplierDao;
    }
}
