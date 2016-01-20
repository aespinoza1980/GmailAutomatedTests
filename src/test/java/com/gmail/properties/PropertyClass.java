package com.gmail.properties;

/**
 * Created by Alexis Espinoza on 11/13/15.
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyClass {
    String result = "";
    InputStream inputStream;

    public String getPropValues() throws IOException {

        try {
            java.util.Properties prop = new java.util.Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String linkAssertion1 = prop.getProperty("linkAssertion1");
            String linkAssertion2 = prop.getProperty("linkAssertion2");
            String linkAssertion3 = prop.getProperty("linkAssertion3");
            String phoneNumber = prop.getProperty("phoneNumber");
            String account1= prop.getProperty("account1");
            String account2= prop.getProperty("account2");
            String passwordAccounts= prop.getProperty("passwordAccounts");
            String linkAssertion4= prop.getProperty("linkAssertion4");
            String IEDriver= prop.getProperty("IEDriver");
            result = linkAssertion1.trim()+','+linkAssertion2.trim()+','+linkAssertion3.trim()+','+phoneNumber+","+account1.trim()+","+
                    account2.trim()+","+passwordAccounts.trim()+","+linkAssertion4.trim()+","+IEDriver;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
        return result;
    }
}
