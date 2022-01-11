package com.codecool.shop.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConfig {

    public static Properties setupApplication() {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String conConfigPath = rootPath + "connection.properties";

        Properties conProps = new Properties();
        try {
            conProps.load(new FileInputStream(conConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        dao = conProps.getProperty("dao");
//        dbUserName = conProps.getProperty("user");
//        dbPassword = conProps.getProperty("password");
//        dbUrl = conProps.getProperty("url");
//        dbName = conProps.getProperty("database");

        return conProps;
    }
}
