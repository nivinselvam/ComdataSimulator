package com.transactionProcessor;


import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class PreAuthProcessor {
    private static final Logger logger = LogManager.getLogger(PreAuthProcessor.class);

    public Map<String, TransactionFieldProperties> selectResponseType() {
        logger.log(Level.DEBUG, "Selecting the response based on the configuration");
        if (Main.simulatorProperties.getPreAuthResponse().equals(Constants.RESPONSE_TYPE_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing Approval response as configured.");
            Main.processVariables.configuredTransactionResponse = Main.processVariables.preAuth.getResponse();
        } else if (Main.simulatorProperties.getPreAuthResponse().equals(Constants.RESPONSE_TYPE_ERROR_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing error response as configured.");
            Main.processVariables.configuredTransactionResponse = Main.processVariables.preAuth.getErrorResponse();
        } else {
            Main.processVariables.configuredTransactionResponse = null;
        }
        return Main.processVariables.configuredTransactionResponse;
    }

    public void generateResponseFields(String transactionType, Map<String, TransactionFieldProperties> transactionProperties) {
        logger.log(Level.DEBUG, "Starting to generate the response fields for %s".formatted(transactionType));
        String currentField = "";
        String currentFieldValue = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : transactionProperties.entrySet()) {
            currentField = entry.getValue().getName();
            if (entry.getValue().isRequired()) {
                try {
                    if (Main.processVariables.requestPacketFields.containsKey(currentField)) {
                        logger.log(Level.DEBUG, "Adding value from the request packet for %s".formatted(currentField));
                        currentFieldValue = Main.processVariables.requestPacketFields.get(currentField);
                    } else {
                        logger.log(Level.DEBUG, "Adding value from the user configuration for %s".formatted(currentField));
                        currentFieldValue = entry.getValue().getDefaultValue();
                    }
                } catch (Exception e) {
                    currentFieldValue = entry.getValue().getDefaultValue();
                }
                Main.processVariables.transactionPacketField = new TransactionPacketField();
                Main.processVariables.transactionPacketField.setFieldName(currentField);
                Main.processVariables.transactionPacketField.setFieldValue(currentFieldValue);
                Main.processVariables.responsePacketFields.add(Main.processVariables.transactionPacketField);
                logger.log(Level.DEBUG, "%s with value %s is added to the response packet fields map".formatted(currentField, currentFieldValue));

            } else {
                logger.log(Level.DEBUG, "%s is not required for this transaction as per configuration.".formatted(currentField));
            }

        }
    }

}
