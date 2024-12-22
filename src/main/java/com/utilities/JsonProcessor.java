package com.utilities;

import com.base.Constants;
import com.base.Main;
import com.properties.SimulatorProperties;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.transactionDetails.PreAuthEdit;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonProcessor {
    private static final Logger logger = LogManager.getLogger(JsonProcessor.class);
    private File file;
    private ObjectMapper objectMapper;

    public void loadSimulatorProperties() {
        file = new File(Constants.PATH_SIMULATOR_CONFIG);
        objectMapper = new ObjectMapper();
        try {
            Main.simulatorProperties = objectMapper.readValue(file, SimulatorProperties.class);
            logger.log(Level.DEBUG, "Simulator properties successfully loaded from the Simulator config file");
        } catch (IOException e) {
            logger.log(Level.FATAL, "Unable to load the Simulator properties from Simulator config file");
        }
    }

    public void loadPreAuthEditProperties() {
        logger.log(Level.DEBUG, "Trying to open the preAuthEdit.json preAuthEditJsonFile");
        File preAuthEditJsonFile = new File(Constants.PATH_PRE_AUTH_EDIT_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the json into Java object");
            Main.variables.preAuthEdit = objectMapper.readValue(preAuthEditJsonFile, PreAuthEdit.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the pre auth edit properties due to error "+e.toString());
        }
    }

}
