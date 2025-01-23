/*
 * Created on: 03/March/2023
 * Author: Nivin Selvam
 * This class is used to find the path in which the application is available.
 * Do not use this file for adding any other functionalities.
 */

package com.base;

import com.utilities.JsonProcessor;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreReqRunner {

    private static final Logger logger = LogManager.getLogger(PreReqRunner.class);

    /*
    This method is used to set the file path of the logger in the log4j properties file.
    Since the path of the application is obtained dynamically, to handle it in the log properties
    this will be required.
     */
    public void configureLoggerFilePath() {
        System.setProperty("log4j.configuration", Constants.PATH_LOG_PROPERTIES_FILE);
        logger.log(Level.DEBUG, "Logger configured successfully");
    }

    /*
    This method is used for loading all the transaction property JSONS.
     */
    public void loadUserConfigurations(){
        JsonProcessor jsonProcessor = new JsonProcessor();
        jsonProcessor.loadSimulatorProperties();
        jsonProcessor.loadDefaultErrorProperties();
        jsonProcessor.loadHeaderProperties();
        jsonProcessor.loadPreAuthEditProperties();
        jsonProcessor.loadPreAuthProperties();
        jsonProcessor.loadFuelPurchaseProperties();
        jsonProcessor.loadFuelPurchaseCancelProperties();
    }


}
