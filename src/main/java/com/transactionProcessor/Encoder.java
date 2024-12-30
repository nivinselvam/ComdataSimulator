package com.transactionProcessor;

import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class Encoder {
    private static final Logger logger = LogManager.getLogger(Encoder.class);

    public void encodeResponse() {
        logger.log(Level.DEBUG, "Encoding the response packet");
        Main.variables.responsePacket = "";
        String currentField = "";
        String currentValue = "";
        for (TransactionPacketField transactionField : Main.variables.responsePacketFields) {
            currentField = transactionField.getFieldName();
            currentValue = transactionField.getFieldValue();
            currentValue = addPadding(currentField, currentValue);
            Main.variables.responsePacket = Main.variables.responsePacket + currentValue;
            logger.log(Level.DEBUG, "%s with value %s added to the response packet to be encoded".formatted(currentField, currentValue));
        }
        logger.log(Level.DEBUG, Main.variables.responsePacket);
    }

    private String addPadding(String field, String value) {
        int requiredPadding = 0;
        String padding = "";
        String justfication = "left";
        for (Map.Entry<String, TransactionFieldProperties> entry : Main.variables.preAuthEditProcessor.selectResponseType().entrySet()) {
            if (entry.getValue().getName().equals(field)) {
                requiredPadding = entry.getValue().getLength() - value.length();
                padding = entry.getValue().getPaddingWith();
                justfication = entry.getValue().getJustification();
                break;
            }
        }
        for(int i = 0; i < requiredPadding ; i++){
            if(justfication.equals(Constants.justification_right)){
                value = padding + value;
            }else if(justfication.equals(Constants.justification_left)){
                value = value+padding;
            }
        }
        return value;
    }
}
