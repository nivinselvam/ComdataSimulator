package com.base;

import com.properties.SimulatorProperties;
import com.requestResponses.Request;
import com.socketprocessor.ServerInitializer;
import com.transactionDetails.PreAuthEdit;
import com.utilities.Converter;
import com.utilities.JsonProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static Converter converter = new Converter();
    public static SimulatorProperties simulatorProperties;
    public static Variables variables = new Variables();


    public static void main(String[] args) {
        logger.log(Level.INFO, "Comdata Simulator is starting...");
        JsonProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.loadPreAuthEditProperties();


//
//        variables.server = new ServerInitializer();
//        variables.server.start();


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
