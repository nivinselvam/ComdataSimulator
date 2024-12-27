package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactionDetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class ResponseGenerator {
    private static final Logger logger = LogManager.getLogger(ResponseGenerator.class);
    private String requestPacket;


    public ResponseGenerator(String requestPacket) {
        this.requestPacket = requestPacket;
    }

    public String generateResponse() {
        logger.log(Level.DEBUG, "Processing the below transaction packet");
        logger.log(Level.DEBUG, requestPacket);
        Decoder decoder = new Decoder();
        decoder.decodeRequestPacket(requestPacket);
        logger.log(Level.INFO, "Request Packet");
        for (Map.Entry<String, String> entry : Main.variables.requestPacketFields.entrySet()) {
            if (!Main.variables.exclusionFieldsList.contains(entry.getValue())) {
                logger.log(Level.INFO, "%s  :   %s".formatted(entry.getKey(), entry.getValue()));
            }
        }
        processBasedOnTransaction();
        logger.log(Level.INFO, "Response Packet");
        for(TransactionPacketField currentTransactionField : Main.variables.responsePacketFields){
            if (!Main.variables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
            }
        }
        Encoder encoder = new Encoder();
        return "";
    }

    private void processBasedOnTransaction() {
        String transactionType = Main.variables.requestPacketFields.get(Constants.FLD_NAME_REPORTNUMBER);
        switch (transactionType) {
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
                generateResponseFields(Constants.TRANSACTION_NAME_PREAUTHEDIT, Main.variables.preAuthEdit.getResponse());
                break;
            case Constants.RN_FUELPURCHASEREQUESTFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                break;
        }
    }

    private void generateResponseFields(String transactionType, Map<String, TransactionFieldProperties> transactionProperties) {
        logger.log(Level.DEBUG, "Starting to generate the response fields for %s".formatted(transactionType));
        String currentField = "";
        String currentFieldValue = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : transactionProperties.entrySet()) {
            currentField = entry.getValue().getName();
            if (entry.getValue().isRequired()) {
                if (Main.variables.requestPacketFields.containsKey(currentField)) {
                    currentFieldValue = Main.variables.requestPacketFields.get(currentField);
                } else {
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
