package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class Encoder {
    private static final Logger logger = LogManager.getLogger(Encoder.class);
    private String responsePacket ="";

    public String encodeResponse(List<TransactionPacketField> responsePacketFields) {
        logger.log(Level.DEBUG, "Encoding the response packet");
        String currentField = "";
        String currentValue = "";
        for (TransactionPacketField transactionField : responsePacketFields) {
            currentField = transactionField.getFieldName();
            currentValue = transactionField.getFieldValue();
            responsePacket = responsePacket + currentValue;
            logger.log(Level.DEBUG, "%s with value %s added to the response packet to be encoded".formatted(currentField, currentValue));
        }
        logger.log(Level.DEBUG, responsePacket);
        return responsePacket;
    }

}
