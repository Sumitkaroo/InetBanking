package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties pro=new Properties();

    public ReadConfig() {

        try {
            FileInputStream fis = new FileInputStream("./Configuration/config.properties");
            pro.load(fis);
        } catch (IOException e) {
            System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL() {
        String url = pro.getProperty("BaseURL");
        return url;
    }

    public String getUsername() {
        String username = pro.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = pro.getProperty("password");
        return password;
    }

    public String getChromePath() {
        String chromepath = pro.getProperty("chromepath");
        return chromepath;
    }

    public String getMicrosoftEdgePath() {
        String edge = pro.getProperty("edgepath");
        return edge;
    }
}