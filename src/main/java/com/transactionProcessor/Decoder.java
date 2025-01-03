package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
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
        pendingFields = List.of(pendingString.split(Constants.FIELDSEPARATOR, -1));

        Main.variables.transactionName = Main.variables.requestPacketFields.get(Constants.FLD_NAME_REPORTNUMBER);
        logger.log(Level.DEBUG, "Request is of transaction type %s".formatted(Main.variables.transactionName));
        switch (Main.variables.transactionName) {
            case Constants.RN_FUELPURCHASESALE:
                break;
            case Constants.RN_FUELPURCHASECANCEL:
                break;
            case Constants.RN_SETTLEMENT:
                break;
            case Constants.RN_EXPRESSCHECKENCASHMENT:
                break;
            case Constants.RN_CHECKAUTHORIZATIONUPDATECHECK:
                break;
            case Constants.RN_FUELPRICEUPDATE:
                break;
            case Constants.RN_PREAUTHEDIT:
                processTransactionBody(Constants.TRANSACTION_NAME_PREAUTHEDIT, Main.variables.preAuthEdit.getRequest());
                break;
            case Constants.RN_FUELPURCHASEREQUESTFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                processTransactionBody(Constants.TRANSACTION_NAME_PREAUTH, Main.variables.preAuth.getRequest());
                break;
            default: throw new RuntimeException();
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
            Main.variables.requestPacketFields.put(currentField, currentFieldValue);
            logger.log(Level.DEBUG, "%s is added to request packet map".formatted(currentField));

        }
    }
}
