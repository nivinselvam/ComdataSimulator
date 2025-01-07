package com.transactionProcessor;


import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class FuelPurchaseRequestProcessor {
    private static final Logger logger = LogManager.getLogger(FuelPurchaseRequestProcessor.class);

    public Map<String, TransactionFieldProperties> selectResponseType() {
        logger.log(Level.DEBUG, "Selecting the response based on the configuration");
        if (Main.simulatorProperties.getFuelPurchaseRequestResponse().equals(Constants.RESPONSE_TRUCK_STOP_SERVICE_CENTER)) {
            logger.log(Level.DEBUG, "Processing %s Approval response as configured.".formatted(Constants.RESPONSE_TRUCK_STOP_SERVICE_CENTER));
            Main.variables.configuredTransactionResponse = Main.variables.fuelPurchaseRequest.getTruckStopServiceCenterResponse();
        } else if (Main.simulatorProperties.getFuelPurchaseRequestResponse().equals(Constants.RESPONSE_TRUCK_STOP_SERVICE_CENTER_DUPLICATE_AUTH)) {
            logger.log(Level.DEBUG, "Processing %s Approval response as configured.".formatted(Constants.RESPONSE_TRUCK_STOP_SERVICE_CENTER_DUPLICATE_AUTH));
            Main.variables.configuredTransactionResponse = Main.variables.fuelPurchaseRequest.getTruckStopServiceCenterDuplicateAuthResponse();
        } else if (Main.simulatorProperties.getFuelPurchaseRequestResponse().equals(Constants.RESPONSE_TYPE_ERROR_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing error response as configured.");
            Main.variables.configuredTransactionResponse = Main.variables.fuelPurchaseRequest.getErrorResponse();
        } else {
            Main.variables.configuredTransactionResponse = null;
        }
        return Main.variables.configuredTransactionResponse;
    }

    public void generateResponseFields(String transactionType, Map<String, TransactionFieldProperties> transactionProperties) {
        logger.log(Level.DEBUG, "Starting to generate the response fields for %s".formatted(transactionType));
        String currentField = "";
        String currentFieldValue = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : transactionProperties.entrySet()) {
            currentField = entry.getValue().getName();
            if (entry.getValue().isRequired()) {
                try {
                    if (Main.variables.requestPacketFields.containsKey(currentField)) {
                        logger.log(Level.DEBUG, "Adding value from the request packet for %s".formatted(currentField));
                        currentFieldValue = Main.variables.requestPacketFields.get(currentField);
                    } else {
                        logger.log(Level.DEBUG, "Adding value from the user configuration for %s".formatted(currentField));
                        currentFieldValue = entry.getValue().getDefaultValue();
                    }
                } catch (Exception e) {
                    currentFieldValue = entry.getValue().getDefaultValue();
                }
                Main.variables.transactionPacketField = new TransactionPacketField();
                Main.variables.transactionPacketField.setFieldName(currentField);
                Main.variables.transactionPacketField.setFieldValue(currentFieldValue);
                Main.variables.responsePacketFields.add(Main.variables.transactionPacketField);
                logger.log(Level.DEBUG, "%s with value %s is added to the response packet fields map".formatted(currentField, currentFieldValue));

            } else {
                logger.log(Level.DEBUG, "%s is not required for this transaction as per configuration.".formatted(currentField));
            }

        }
    }

}
