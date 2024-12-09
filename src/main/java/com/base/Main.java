package com.base;

import com.utilities.JsonProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static SimulatorProperties simulatorProperties;


    public static void main(String[] args) {
        logger.log(Level.INFO, "Comdata Simulator is starting...");
        JsonProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.loadSimulatorProperties();

    }

    /*
     * This method is used for identifying the path in which the app is installed
     * parameters: none return: String
     */
    public static String getApplicationPath() {
        try {
            return new File(".").getCanonicalPath();
        } catch (IOException e) {
            return null;
        }
    }

}
