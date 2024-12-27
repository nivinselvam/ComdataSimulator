package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactionDetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Decoder {
    private static final Logger logger = LogManager.getLogger(Decoder.class);
    private int startPosition;
    private int endPosition;
    private List<String> pendingFields;


    public void decodeRequestPacket(String requestPacket) {
        processHeader(requestPacket);
        String pendingString = requestPacket.substring(endPosition, requestPacket.length() - 1);
        pendingFields = List.of(pendingString.split(Constants.fieldSeparator));

        String transactionType;
        transactionType = Main.variables.requestPacketFields.get(Constants.fld_name_reportNumber);
        logger.log(Level.DEBUG, "Request is of transaction type %s".formatted(transactionType));
        switch (transactionType) {
            case Constants.rn_fuelPurchaseSale:
                break;
            case Constants.rn_fuelPurchaseCancel:
                break;
            case Constants.rn_settlement:
                break;
            case Constants.rn_expressCheckEncashment:
                break;
            case Constants.rn_checkAuthorizationUpdateCheck:
                break;
            case Constants.rn_fuelPriceUpdate:
                break;
            case Constants.rn_preAuthEdit:
                processTransactionBody(Constants.transaction_type_preAuthEdit, Main.variables.preAuthEdit.getRequest());
                break;
            case Constants.rn_fuelPurchaseRequestForceSale:
                break;
            case Constants.rn_preAuthorization:
                break;
        }
    }

    private void processHeader(String requestPacket) {
        startPosition = 0;
        endPosition = 0;
        int lengthOfField = 0;
        String currentField = "";
        String currentFieldValue = "";
        logger.log(Level.DEBUG, "Starting to add the header fields into the request packet map");
        for (Map.Entry<String, TransactionFieldProperties> entry : Main.variables.header.getRequest().entrySet()) {
            currentField = entry.getValue().getName();
            logger.log(Level.DEBUG, "Adding the value of %s to the request packet map".formatted(currentField));
            lengthOfField = ((int) entry.getValue().getLength());
            logger.log(Level.DEBUG, "Length of %s is %s".formatted(currentField, lengthOfField));
            endPosition = endPosition + lengthOfField;
            currentFieldValue = requestPacket.substring(startPosition, endPosition);
            logger.log(Level.DEBUG, "Value of %s is %s".formatted(currentField, currentFieldValue));
            Main.variables.requestPacketFields.put(currentField, currentFieldValue);
            logger.log(Level.DEBUG, "%s is added to request packet map".formatted(currentField));
            startPosition = endPosition;
        }
    }

    private void processTransactionBody(String transactionType, Map<String, TransactionFieldProperties> transactionProperties){
        String currentField = "";
        String currentFieldValue = "";
        int lengthOfField = 0;
        logger.log(Level.DEBUG, "Starting to add the %s fields into the request packet map".formatted(transactionType));
        int position = 0;
        for (Map.Entry<String, TransactionFieldProperties> entry : transactionProperties.entrySet()) {
            currentField = entry.getValue().getName();
            logger.log(Level.DEBUG, "Adding the value of %s to the request packet map".formatted(currentField));
            if (currentField.equals(Constants.fld_name_fieldSeparator)) {
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
}
