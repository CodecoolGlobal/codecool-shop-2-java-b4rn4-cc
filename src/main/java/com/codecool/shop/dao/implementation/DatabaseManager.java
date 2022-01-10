package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class DatabaseManager {

    String dbName;
    String dbUserName;
    String dbPassword;

    public DatabaseManager(String dbName, String dbUserName, String dbPassword) {
        this.dbName = dbName;
        this.dbUserName = dbUserName;
        this.dbPassword = dbPassword;
    }

    public void setup() throws SQLException {
        DataSource dataSource = connect();
        // TODO: 2022. 01. 10. add the jdbc classes later
        ProductDao productDao = new ProductDaoJdbc(dataSource);
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
}
