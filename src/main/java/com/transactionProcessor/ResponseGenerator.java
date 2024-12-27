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
        generateResponseFields();
        logger.log(Level.INFO, "Response Packet");
        for(TransactionPacketField currentTransactionField : Main.variables.responsePacketFields){
            if (!Main.variables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
            }
        }
        Encoder encoder = new Encoder();
        return "";
    }

    private static void generateResponseFields() {
        String transactionType = Main.variables.requestPacketFields.get(Constants.fld_name_reportNumber);
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
                Main.variables.preAuthEditProcessor.generateResponseFields();
                break;
            case Constants.rn_fuelPurchaseRequestForceSale:
                break;
            case Constants.rn_preAuthorization:
                break;
        }
    }


}
