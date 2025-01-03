package com.transactionProcessor;


import com.base.Constants;
import com.base.Main;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class FuelPurchaseRequestProcessor {
    private static final Logger logger = LogManager.getLogger(FuelPurchaseRequestProcessor.class);

    public Map<String, TransactionFieldProperties> selectResponseType() {
        logger.log(Level.DEBUG, "Selecting the response based on the configuration");
        if (Main.simulatorProperties.getFuelPurchaseRequestResponse().equals(Constants.RESPONSE_TRUCK_STOP_SERVICE_CENTER)) {
            logger.log(Level.DEBUG, "Processing Approval response as configured.");
            Main.variables.configuredTransactionResponse = Main.variables.fuelPurchaseRequest.getTruckStopServiceCenterResponse();
        } else if (Main.simulatorProperties.getFuelPurchaseRequestResponse().equals(Constants.RESPONSE_TYPE_ERROR_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing error response as configured.");
            Main.variables.configuredTransactionResponse = Main.variables.fuelPurchaseRequest.getErrorResponse();
        } else {
            Main.variables.configuredTransactionResponse = null;
        }
        return Main.variables.configuredTransactionResponse;
    }

}
