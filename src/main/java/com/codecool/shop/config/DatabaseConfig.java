package com.codecool.shop.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConfig {

    private static Properties conProps;

    public static Properties setupApplication() {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String conConfigPath = rootPath + "connection.properties";

        conProps = new Properties();
        try {
            conProps.load(new FileInputStream(conConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conProps;
    }

    public static Properties getConProps() {
        return conProps;
    }
}
