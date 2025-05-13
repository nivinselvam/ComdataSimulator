package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Decoder {
    private static final Logger logger = LogManager.getLogger(Decoder.class);
    private int startPosition;
    private int endPosition;
    private List<String> pendingFields;
    private String transactionType;
    private Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();


    public Map<String, String> decodeRequestPacket(String requestPacketString) {
        processHeader(requestPacketString);
        String pendingString = requestPacketString.substring(endPosition, requestPacketString.length() - 1);
        pendingFields = List.of(pendingString.split(Constants.FIELDSEPARATOR, -1));

        transactionType = requestPacketFields.get(Constants.FLD_NAME_REPORTNUMBER);
        logger.log(Level.DEBUG, "Request is of transaction type %s".formatted(transactionType));
        switch (transactionType) {
            case Constants.RN_FUELPURCHASE:
                processTransactionBody(Constants.TRANSACTION_NAME_FUEL_PURCHASE, Main.processVariables.fuelPurchase.getRequest());
                break;
            case Constants.RN_FUELPURCHASECANCEL:
                processTransactionBody(Constants.TRANSACTION_NAME_FUEL_PURCHASE_CANCEL, Main.processVariables.fuelPurchaseCancel.getRequest());
                break;
            case Constants.RN_SETTLEMENT:
                processTransactionBody(Constants.TRANSACTION_NAME_SETTLEMENT, Main.processVariables.settlement.getRequest());
                break;
            case Constants.RN_EXPRESSCHECKENCASHMENT:
                processTransactionBody(Constants.TRANSACTION_NAME_EXPRESS_CHECK, Main.processVariables.expressCheck.getRequest());
                break;
            case Constants.RN_CHECKAUTHORIZATIONUPDATECHECK:
                processTransactionBody(Constants.TRANSACTION_NAME_CHECK_AUTHORIZATION_UPDATE, Main.processVariables.checkAuthorizationUpdate.getRequest());
                break;
            case Constants.RN_FUELPRICEUPDATE:
                processTransactionBody(Constants.TRANSACTION_NAME_FUEL_PRICE_UPDATE, Main.processVariables.fuelPriceUpdate.getRequest());
                break;
            case Constants.RN_PREAUTHEDIT:
                processTransactionBody(Constants.TRANSACTION_NAME_PREAUTHEDIT, Main.processVariables.preAuthEdit.getRequest());
                break;
            case Constants.RN_FUELPURCHASEFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                processTransactionBody(Constants.TRANSACTION_NAME_PREAUTH, Main.processVariables.preAuth.getRequest());
                break;
            default: throw new RuntimeException();
        }
        return requestPacketFields;
    }

    private void processHeader(String requestPacket) {
        startPosition = 0;
        endPosition = 0;
        int lengthOfField = 0;
        String currentField = "";
        String currentFieldValue = "";
        logger.log(Level.DEBUG, "Starting to add the header fields into the request packet map");
        for (Map.Entry<String, TransactionFieldProperties> entry : Main.processVariables.header.getRequest().entrySet()) {
            currentField = entry.getValue().getName();
            logger.log(Level.DEBUG, "Adding the value of %s to the request packet map".formatted(currentField));
            lengthOfField = ((int) entry.getValue().getLength());
            logger.log(Level.DEBUG, "Length of %s is %s".formatted(currentField, lengthOfField));
            endPosition = endPosition + lengthOfField;
            currentFieldValue = requestPacket.substring(startPosition, endPosition);
            logger.log(Level.DEBUG, "Value of %s is %s".formatted(currentField, currentFieldValue));
            requestPacketFields.put(currentField, currentFieldValue);
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
            if (currentField.equals(Constants.FLD_NAME_FIELDSEPARATOR)) {
                currentFieldValue = Constants.FIELDSEPARATOR;
            } else if (currentField.equals(Constants.FLD_NAME_CLOSEBRACKET)) {
                currentFieldValue = Constants.CLOSEBRACKET;
            } else {
                lengthOfField = ((int) entry.getValue().getLength());
                logger.log(Level.DEBUG, "Length of %s is %s".formatted(currentField, lengthOfField));
                currentFieldValue = pendingFields.get(position);
                position = position + 1;
            }
            logger.log(Level.DEBUG, "Value of %s is %s".formatted(currentField, currentFieldValue));
            requestPacketFields.put(currentField, currentFieldValue);
            logger.log(Level.DEBUG, "%s is added to request packet map".formatted(currentField));
        }
    }
}
