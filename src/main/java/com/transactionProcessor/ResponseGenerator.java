package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ResponseGenerator {
    private static final Logger logger = LogManager.getLogger(ResponseGenerator.class);
    private String requestPacketString;
    private Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    private List<TransactionPacketField> responsePacketFields;
    private TransactionSpecificProcessor transactionSpecificProcessor;


    public ResponseGenerator(String requestPacketString) {
        this.requestPacketString = requestPacketString;
    }

    public String generateResponse() {
        try {
            logger.log(Level.DEBUG, "Processing the below transaction packet");
            logger.log(Level.DEBUG, requestPacketString);
            Decoder decoder = new Decoder();
            requestPacketFields = decoder.decodeRequestPacket(requestPacketString);
            logger.log(Level.INFO, "Request Packet");
            for (Map.Entry<String, String> entry : requestPacketFields.entrySet()) {
                if (!Main.processVariables.exclusionFieldsList.contains(entry.getValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(entry.getKey(), entry.getValue()));
                }
            }
            responsePacketFields = transactionTypeSpecificProcessing();
            logger.log(Level.INFO, "Response Packet");
            for (TransactionPacketField currentTransactionField : responsePacketFields) {
                if (!Main.processVariables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
                }
            }
            Encoder encoder = new Encoder();
            return encoder.encodeResponse(responsePacketFields);

        } catch (Exception e) {
            transactionSpecificProcessor = new DefaultErrorProcessor();
            responsePacketFields = transactionSpecificProcessor.generateResponseFields(requestPacketFields);
            logger.log(Level.INFO, "Response Packet");
            for (TransactionPacketField currentTransactionField : responsePacketFields) {
                if (!Main.processVariables.exclusionFieldsList.contains(currentTransactionField.getFieldValue())) {
                    logger.log(Level.INFO, "%s  :   %s".formatted(currentTransactionField.getFieldName(), currentTransactionField.getFieldValue()));
                }
            }
            Encoder encoder = new Encoder();
            return encoder.encodeResponse(responsePacketFields);
        }
    }

    private List<TransactionPacketField> transactionTypeSpecificProcessing() {
        String transactionType = requestPacketFields.get(Constants.FLD_NAME_REPORTNUMBER);

        switch (transactionType) {
            case Constants.RN_FUELPURCHASE:
                transactionSpecificProcessor = new FuelPurchaseProcessor();
                break;
            case Constants.RN_FUELPURCHASECANCEL:
                transactionSpecificProcessor = new FuelPurchaseCancelProcessor();
                break;
            case Constants.RN_SETTLEMENT:
                break;
            case Constants.RN_EXPRESSCHECKENCASHMENT:
                transactionSpecificProcessor = new ExpressCheckProcessor();
                break;
            case Constants.RN_CHECKAUTHORIZATIONUPDATECHECK:
                transactionSpecificProcessor = new CheckAuthorizationProcessor();
                break;
            case Constants.RN_FUELPRICEUPDATE:
                transactionSpecificProcessor = new FuelPriceUpdateProcessor();
                break;
            case Constants.RN_PREAUTHEDIT:
                transactionSpecificProcessor = new PreAuthEditProcessor();
                break;
            case Constants.RN_FUELPURCHASEFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                transactionSpecificProcessor = new PreAuthProcessor();
                break;
            default:
                transactionSpecificProcessor = new DefaultErrorProcessor();
        }
        return transactionSpecificProcessor.generateResponseFields(requestPacketFields);
    }

}
