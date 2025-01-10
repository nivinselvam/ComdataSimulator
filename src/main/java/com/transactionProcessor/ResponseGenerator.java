package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
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

    public void generateResponse() {
        try {
            logger.log(Level.DEBUG, "Processing the below transaction packet");
            logger.log(Level.DEBUG, requestPacket);
            Decoder decoder = new Decoder();
            decoder.decodeRequestPacket(requestPacket);
            logger.log(Level.INFO, "Request Packet");
            for (Map.Entry<String, String> entry : Main.processVariables.requestPacketFields.entrySet()) {
                if (!Main.processVariables.exclusionFieldsList.contains(entry.getValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(entry.getKey(), entry.getValue()));
                }
            }
            processBasedOnTransaction();

            logger.log(Level.INFO, "Response Packet");
            for (TransactionPacketField currentTransactionField : Main.processVariables.responsePacketFields) {
                if (!Main.processVariables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
                }
            }
            Encoder encoder = new Encoder();
            encoder.encodeResponse();

        } catch (Exception e) {
            Main.processVariables.defaultErrorProcessor.generateResponseFields(Constants.TRANSACTION_NAME_DEFAULTERROR, Main.processVariables.defaultError.getResponse());
            logger.log(Level.INFO, "Response Packet");
            for (TransactionPacketField currentTransactionField : Main.processVariables.responsePacketFields) {
                if (!Main.processVariables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
                }
            }
        }

    }

    private void processBasedOnTransaction() {
        String transactionType = Main.processVariables.requestPacketFields.get(Constants.FLD_NAME_REPORTNUMBER);
        switch (transactionType) {
            case Constants.RN_FUELPURCHASESALE:
                Main.processVariables.fuelPurchaseRequestProcessor.generateResponseFields(Constants.TRANSACTION_NAME_FUEL_PURCHASE_REQUEST, Main.processVariables.fuelPurchaseRequestProcessor.selectResponseType());
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
                Main.processVariables.preAuthEditProcessor.generateResponseFields(Constants.TRANSACTION_NAME_PREAUTHEDIT, Main.processVariables.preAuthEditProcessor.selectResponseType());
                break;
            case Constants.RN_FUELPURCHASEREQUESTFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                Main.processVariables.preAuthProcessor.generateResponseFields(Constants.TRANSACTION_NAME_PREAUTH, Main.processVariables.preAuthProcessor.selectResponseType());
                break;
            default:
                Main.processVariables.defaultErrorProcessor.generateResponseFields(Constants.TRANSACTION_NAME_DEFAULTERROR, Main.processVariables.defaultError.getResponse());
        }
    }


}
