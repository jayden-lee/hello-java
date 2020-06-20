package ch15_facade;

import java.io.IOException;
import java.util.Properties;

public class Database {

    private Database() {

    }

    public static Properties getProperties(String dbName) {
        String filename = dbName + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(Database.class.getClassLoader().getResourceAsStream(filename));
        } catch (IOException e) {
            System.err.println("Warning: " + filename + " is not found.");
        }

        return prop;
    }
}
