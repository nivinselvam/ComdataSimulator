package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactionDetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class PreAuthEditProcessor {
    private static final Logger logger = LogManager.getLogger(PreAuthEditProcessor.class);

    public void decodePreAuthEdit(List<String> pendingFields) {
        String currentField = "";
        String currentFieldValue = "";
        int lengthOfField = 0;
        logger.log(Level.DEBUG, "Starting to add the pre auth edit fields into the request packet map");
        int position = 0;
        for (Map.Entry<String, TransactionFieldProperties> entry : Main.variables.preAuthEdit.getRequest().entrySet()) {
            currentField = entry.getValue().getName();
            logger.log(Level.DEBUG, "Adding the value of %s to the request packet map".formatted(currentField));
            if(currentField.equals(Constants.fld_name_fieldSeparator)){
                currentFieldValue = Constants.fieldSeparator;
            } else if (currentField.equals(Constants.fld_name_closeBracket)) {
                currentFieldValue = Constants.closeBracket;
            } else {
                lengthOfField = ((int) entry.getValue().getLength());
                logger.log(Level.DEBUG, "Length of %s is %s".formatted(currentField, lengthOfField));
                currentFieldValue = pendingFields.get(position);
                position = position + 1;
            }
            logger.log(Level.DEBUG, "Value of %s is %s".formatted(currentField, currentFieldValue));
            Main.variables.requestPacketFields.put(currentField, currentFieldValue);
            logger.log(Level.DEBUG, "%s is added to request packet map".formatted(currentField));

        }
    }

    public void generateResponseFields() {
        logger.log(Level.DEBUG, "Starting to generate the response fields");
        String currentField = "";
        String currentFieldValue = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : Main.variables.preAuthEdit.getResponse().entrySet()) {
            currentField = entry.getValue().getName();
            if (Main.variables.requestPacketFields.containsKey(currentField)) {
                currentFieldValue = Main.variables.requestPacketFields.get(currentField);
            } else {
                currentFieldValue = Main.variables.preAuthEdit.getResponse().get(currentField).getPresetOptions().getFirst();
            }
            Main.variables.responsePacketFields.put(currentField, currentFieldValue);

            logger.log(Level.DEBUG, "%s with value %s is added to the response packet fields map".formatted(currentField, currentFieldValue));
        }
    }
}
