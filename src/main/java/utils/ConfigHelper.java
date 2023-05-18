package utils;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
public class ConfigHelper {
    public static Configuration getConfig() {
        Configurations configurations = new Configurations();
        try {
            return configurations.properties(new File("configuration.properties"));
        } catch (ConfigurationException e) {
            throw new RuntimeException("Cannot find configuration.properties file! " + e.getMessage());
        }
    }
}
