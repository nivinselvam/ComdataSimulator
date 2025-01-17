package com.transactionProcessor;


import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class DefaultErrorProcessor extends TransactionSpecificProcessor{
    private static final Logger logger = LogManager.getLogger(DefaultErrorProcessor.class);
    private List<TransactionPacketField> responsePacketFields = new ArrayList<>();

    public Map<String, TransactionFieldProperties> selectResponseType() {
        logger.log(Level.DEBUG, "Selecting the response based on the configuration");
        return Main.processVariables.defaultError.getResponse();
    }

    public List<TransactionPacketField> generateResponseFields(Map<String, String> requestPacketFields) {
        logger.log(Level.DEBUG, "Starting to generate the response fields for default error");
        String currentField = "";
        String currentFieldValue = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : selectResponseType().entrySet()) {
            currentField = entry.getValue().getName();
            if (entry.getValue().isRequired()) {
                try {
                    if (requestPacketFields.containsKey(currentField)) {
                        logger.log(Level.DEBUG, "Adding value from the request packet for %s".formatted(currentField));
                        currentFieldValue = requestPacketFields.get(currentField);
                    } else {
                        logger.log(Level.DEBUG, "Adding value from the user configuration for %s".formatted(currentField));
                        currentFieldValue = entry.getValue().getDefaultValue();
                    }
                } catch (Exception e) {
                    currentFieldValue = entry.getValue().getDefaultValue();
                }
                currentFieldValue = addPadding(currentField,currentFieldValue);
                TransactionPacketField transactionPacketField = new TransactionPacketField();
                transactionPacketField.setFieldName(currentField);
                transactionPacketField.setFieldValue(currentFieldValue);
                responsePacketFields.add(transactionPacketField);
                logger.log(Level.DEBUG, "%s with value %s is added to the response packet fields map".formatted(currentField, currentFieldValue));

            } else {
                logger.log(Level.DEBUG, "%s is not required for this transaction as per configuration.".formatted(currentField));
            }

        }
        return responsePacketFields;
    }

}
