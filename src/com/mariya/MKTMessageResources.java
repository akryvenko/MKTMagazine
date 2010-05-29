package com.mariya;

import org.apache.struts.util.MessageResources;
import org.apache.struts.util.MessageResourcesFactory;

import javax.naming.ConfigurationException;
import java.io.*;
import java.net.URL;
import java.util.InvalidPropertiesFormatException;
import java.util.Locale;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 29.05.2010
 * Time: 13:22:15
 * To change this template use File | Settings | File Templates.
 */
public class MKTMessageResources extends MessageResources {

    public MKTMessageResources(MessageResourcesFactory factory, String config, boolean returnNull) {
        super(factory, config, returnNull);
    }

    public String getMessage(Locale locale, String key) {

        Properties resource = getConfiguration("strutsmessage.properties");

        if (resource == null || !resource.containsKey(key)) {
            resource = getConfiguration(this.config + ".properties");
        }

        String s = null;
        try {
            s = new String(resource.getProperty(key).getBytes("ISO8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return resource != null ? s : null;
    }

    private Properties getConfiguration(String name) {
        Properties configuration = new Properties();
        URL url = Thread.currentThread().getContextClassLoader().getResource(name);
        if (url != null) {
            try {
                FileInputStream stream = new FileInputStream(url.getFile());
                configuration.load(stream);
            } catch (InvalidPropertiesFormatException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (FileNotFoundException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }

        return configuration;
    }

}