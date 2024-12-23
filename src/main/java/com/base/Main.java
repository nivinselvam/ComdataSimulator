package com.base;

import com.properties.SimulatorProperties;
import com.transactionDetails.TransactionFieldProperties;
import com.transactionProcessor.ResponseGenerator;
import com.utilities.Converter;
import com.utilities.JsonProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static Converter converter = new Converter();
    public static SimulatorProperties simulatorProperties;
    public static Variables variables = new Variables();


    public static void main(String[] args) {
        logger.log(Level.INFO, "Comdata Simulator is starting...");
        PreReqRunner preReqRunner = new PreReqRunner();
        preReqRunner.configureLoggerFilePath();
        preReqRunner.loadTransactionProperties();

        String request = "{EX777 TCPISP00007/00036/A5600171620532277=49121201271/22}";
        ResponseGenerator responseGenerator = new ResponseGenerator(request);
        responseGenerator.generateResponse();










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
