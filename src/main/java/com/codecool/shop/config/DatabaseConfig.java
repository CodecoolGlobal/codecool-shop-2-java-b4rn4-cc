package com.codecool.shop.config;

import com.codecool.shop.service.ErrorLogging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConfig {

    private static Properties conProps;

    public static Properties setupApplication() {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String conConfigPath = rootPath + "connetion.properties";

        conProps = new Properties();
        try {
            conProps.load(new FileInputStream(conConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
            ErrorLogging.log(e);
        }

        return conProps;
    }

    public static Properties getConProps() {
        return conProps;
    }
}
