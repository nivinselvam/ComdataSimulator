package com.base;

import com.properties.SimulatorProperties;
import com.socketprocessor.ServerInitializer;
import com.transactionProcessor.ResponseGenerator;
import com.utilities.Converter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static Converter converter = new Converter();
    public static SimulatorProperties simulatorProperties;
    public static ProcessVariables processVariables = new ProcessVariables();


    public static void main(String[] args) {
        logger.log(Level.INFO, "Comdata Simulator is starting...");
        PreReqRunner preReqRunner = new PreReqRunner();
        preReqRunner.configureLoggerFilePath();
        preReqRunner.loadUserConfigurations();

        String request = "{NY526TTCPISP00003/00031/@12345678901234567890123456789012345678901324567890/1234567890/0/0/0/0/0/0}";
        ResponseGenerator responseGenerator = new ResponseGenerator(request);
        responseGenerator.generateResponse();

//        ServerInitializer server = new ServerInitializer();
//        server.start();

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
