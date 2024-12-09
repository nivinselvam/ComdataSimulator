package com.utilities;

import com.base.Constants;
import com.base.Main;
import com.base.SimulatorProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonProcessor {
    private static final Logger logger = LogManager.getLogger(JsonProcessor.class);
    private File file;
    private ObjectMapper objectMapper;

    public void loadSimulatorProperties(){
        file = new File(Constants.PATH_SIMULATOR_CONFIG);
        objectMapper = new ObjectMapper();
        try{
            Main.simulatorProperties = objectMapper.readValue(file, SimulatorProperties.class);
            logger.log(Level.DEBUG, "Simulator properties successfully loaded from the Simulator config file");
        } catch (IOException e) {
            logger.log(Level.FATAL, "Unable to load the Simulator properties from Simulator config file");
        }


    }

}
