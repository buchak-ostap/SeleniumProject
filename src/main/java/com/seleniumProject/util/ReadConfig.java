package com.seleniumProject.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig() {
        File src = new File("./Configuration/config.properties");

        try {
            FileInputStream fileInputStream = new FileInputStream(src);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception exception) {
            System.out.println("Exception is" + exception.getMessage());
        }
    }

    public String getGuruUrl() {
        return properties.getProperty("guruBaseURL");
    }

    public String getSSBaseUrl() {
        return properties.getProperty("ssBaseUrl");
    }

    public String getGuruEmail() {
        return properties.getProperty("guruEmail");
    }

    public String getGuruPassword() {
        return properties.getProperty("guruPassword");
    }

    public String getSSEmail() {
        return properties.getProperty("ssEmail");
    }

    public String getSSPassword() {
        return properties.getProperty("ssPassword");
    }

    public String getChromePath() {
        return properties.getProperty("chromepath");
    }

    public String getFirefoxPath() {
        return properties.getProperty("firefoxPath");
    }
}
