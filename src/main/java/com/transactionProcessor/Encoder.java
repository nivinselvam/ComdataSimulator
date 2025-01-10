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
        Main.processVariables.responsePacket = "";
        String currentField = "";
        String currentValue = "";
        for (TransactionPacketField transactionField : Main.processVariables.responsePacketFields) {
            currentField = transactionField.getFieldName();
            currentValue = transactionField.getFieldValue();
            currentValue = addPadding(currentField, currentValue);
            Main.processVariables.responsePacket = Main.processVariables.responsePacket + currentValue;
            logger.log(Level.DEBUG, "%s with value %s added to the response packet to be encoded".formatted(currentField, currentValue));
        }
        logger.log(Level.DEBUG, Main.processVariables.responsePacket);
    }

    private String addPadding(String field, String value) {
        int requiredPadding = 0;
        String padding = "";
        String justfication = "left";
        for (Map.Entry<String, TransactionFieldProperties> entry : selectTransactionResponse().entrySet()) {
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

    private Map<String, TransactionFieldProperties> selectTransactionResponse(){
        switch (Main.processVariables.transactionName) {
            case Constants.RN_FUELPURCHASESALE:
                return Main.processVariables.fuelPurchaseRequestProcessor.selectResponseType();
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
                return Main.processVariables.preAuthEditProcessor.selectResponseType();
            case Constants.RN_FUELPURCHASEREQUESTFORCESALE:
                break;
            case Constants.RN_PREAUTHORIZATION:
                return Main.processVariables.preAuthProcessor.selectResponseType();
            default: throw new RuntimeException();
        }
        return Main.processVariables.defaultError.getResponse();
    }
}
