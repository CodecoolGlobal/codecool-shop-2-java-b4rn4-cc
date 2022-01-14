package com.codecool.shop.config;

import com.codecool.shop.logger.ConsoleLogger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class DatabaseConfig {

    private static Properties conProps;

    public static void setupApplication() {
        String configFileName = "connection.properties";

        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String conConfigPath = rootPath + configFileName;

        conProps = new Properties();
        try {
            conProps.load(new FileInputStream(conConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
            ConsoleLogger.log(e);
        }
    }

    public static Properties getConProps() {
        return conProps;
    }
}
