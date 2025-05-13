package com.utilities;

import com.base.Constants;
import com.base.Main;
import com.properties.SimulatorProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import com.transactiondetails.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Map;

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

    public void loadDefaultErrorProperties() {
        logger.log(Level.DEBUG, "Trying to open the defaultError.json file");
        File defaultErrorJsonFile = new File(Constants.PATH_DEFAULT_ERROR_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the default error json into Java object");
            Main.processVariables.defaultError = objectMapper.readValue(defaultErrorJsonFile, DefaultError.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the default error properties due to error " + e.toString());
        }
    }

    public void loadHeaderProperties() {
        logger.log(Level.DEBUG, "Trying to open the header.json file");
        File headerJsonFile = new File(Constants.PATH_HEADER_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the header json into Java object");
            Main.processVariables.header = objectMapper.readValue(headerJsonFile, Header.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the header properties due to error " + e.toString());
        }
    }

    public void loadPreAuthEditProperties() {
        logger.log(Level.DEBUG, "Trying to open the preAuthEdit.json file");
        File preAuthEditJsonFile = new File(Constants.PATH_PRE_AUTH_EDIT_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the pre auth edit json into Java object");
            Main.processVariables.preAuthEdit = objectMapper.readValue(preAuthEditJsonFile, PreAuthEdit.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the pre auth edit properties due to error " + e.toString());
        }
    }

    public void loadPreAuthProperties() {
        logger.log(Level.DEBUG, "Trying to open the preAuth.json file");
        File preAuthJsonFile = new File(Constants.PATH_PRE_AUTH_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the pre auth json into Java object");
            Main.processVariables.preAuth = objectMapper.readValue(preAuthJsonFile, PreAuth.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the pre auth properties due to error " + e.toString());
        }
    }

    public void loadFuelPurchaseProperties() {
        logger.log(Level.DEBUG, "Trying to open the fuelPurchaseRequest.json file");
        File fuelPurchaseJsonFile = new File(Constants.PATH_FUEL_PURCHASE_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the fuel purchase request json into Java object");
            Main.processVariables.fuelPurchase = objectMapper.readValue(fuelPurchaseJsonFile, FuelPurchase.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the fuel purchase request properties due to error " + e.toString());
        }
    }

    public void loadFuelPurchaseCancelProperties() {
        logger.log(Level.DEBUG, "Trying to open the fuelPurchaseCancel.json file");
        File fuelPurchaseCancelJsonFile = new File(Constants.PATH_FUEL_PURCHASE_CANCEL_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the fuel purchase cancel request json into Java object");
            Main.processVariables.fuelPurchaseCancel = objectMapper.readValue(fuelPurchaseCancelJsonFile, FuelPurchaseCancel.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the fuel purchase cancel request properties due to error " + e.toString());
        }
    }

    public void loadExpressCheckProperties() {
        logger.log(Level.DEBUG, "Trying to open the expressCheck.json file");
        File expressCheckFile = new File(Constants.PATH_EXPRESS_CHECK_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the express check encashment request json into Java object");
            Main.processVariables.expressCheck = objectMapper.readValue(expressCheckFile, ExpressCheck.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the express check encashment request properties due to error " + e.toString());
        }
    }

    public void loadCheckAuthorizationProperties() {
        logger.log(Level.DEBUG, "Trying to open the checkAuthorization.json file");
        File checkAuthorizationFile = new File(Constants.PATH_CHECK_AUTHORIZATION_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the check authorization json into Java object");
            Main.processVariables.checkAuthorizationUpdate = objectMapper.readValue(checkAuthorizationFile, CheckAuthorizationUpdate.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the check authorization properties due to error " + e.toString());
        }
    }

    public void loadFuelPriceUpdateProperties() {
        logger.log(Level.DEBUG, "Trying to open the fuelPriceUpdate.json file");
        File fuelPriceUpdateFile = new File(Constants.PATH_FUEL_PRICE_UPDATE_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the fuel price update json into Java object");
            Main.processVariables.fuelPriceUpdate = objectMapper.readValue(fuelPriceUpdateFile, FuelPriceUpdate.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the fuel price update properties due to error " + e.toString());
        }
    }

    public void loadSettlementProperties() {
        logger.log(Level.DEBUG, "Trying to open the settlement.json file");
        File settlementFile = new File(Constants.PATH_SETTLEMENT_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the settlement json into Java object");
            Main.processVariables.settlement = objectMapper.readValue(settlementFile, Settlement.class);
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the settlement properties due to error " + e.toString());
        }
    }

    public void loadLimits(){
        logger.log(Level.DEBUG, "Trying to open the limits.json file");
        File limitsFile = new File(Constants.PATH_LIMITS_PROPERTIES);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            logger.log(Level.DEBUG, "Converting the limits json into Java object");
            Main.processVariables.limits = objectMapper.readValue(limitsFile, new TypeReference<Map<String, Limit>>() {
            });
        } catch (IOException e) {
            logger.log(Level.ERROR, "Unable to load the limits properties due to error " + e.toString());
        }
    }

}
