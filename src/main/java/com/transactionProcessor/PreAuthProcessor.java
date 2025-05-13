package com.transactionProcessor;


import com.base.Constants;
import com.base.Main;
import com.transactiondetails.Limit;
import com.transactiondetails.ProductDetails;
import com.transactiondetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class PreAuthProcessor extends TransactionSpecificProcessor {
    private static final Logger logger = LogManager.getLogger(PreAuthProcessor.class);
    private List<TransactionPacketField> responsePacketFields = new ArrayList<>();

    public Map<String, TransactionFieldProperties> selectResponseType() {
        logger.log(Level.DEBUG, "Selecting the response based on the configuration");
        if (Main.simulatorProperties.getPreAuthResponse().equals(Constants.RESPONSE_TYPE_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing Approval response as configured.");
            return Main.processVariables.preAuth.getResponse();
        } else if (Main.simulatorProperties.getPreAuthResponse().equals(Constants.RESPONSE_TYPE_ERROR_RESPONSE)) {
            logger.log(Level.DEBUG, "Processing error response as configured.");
            return Main.processVariables.preAuth.getErrorResponse();
        } else {
            return Collections.emptyMap();
        }
    }

    public List<TransactionPacketField> generateResponseFields(Map<String, String> requestPacketFields) {
        logger.log(Level.DEBUG, "Starting to generate the response fields for Pre Auth transaction");
        String currentField = "";
        String currentFieldValue = "";
        String productCount = "";
        String subProductName = "";
        for (Map.Entry<String, TransactionFieldProperties> entry : selectResponseType().entrySet()) {
            currentField = entry.getValue().getName();
            if (entry.getValue().isRequired()) {
                try {
                    if (requestPacketFields.containsKey(currentField)) {
                        logger.log(Level.DEBUG, "Adding value from the request packet for %s".formatted(currentField));
                        currentFieldValue = requestPacketFields.get(currentField);
                    } else {
                        logger.log(Level.DEBUG, "Adding value from the user configuration for %s".formatted(currentField));
                        if (currentField.contains("Max Dollar Limit") || currentField.contains("Max Quantity Limit") || currentField.contains("Purchase Category")) {
                            productCount = String.valueOf(currentField.charAt(currentField.length() - 1));
                            subProductName = "Sub Product Code" + productCount;
                            if (!requestPacketFields.get(subProductName).equals("")) {
                                currentFieldValue = entry.getValue().getDefaultValue();
                            } else {
                                currentFieldValue = "";
                            }
                        } else {
                            currentFieldValue = entry.getValue().getDefaultValue();
                        }

                    }
                } catch (Exception e) {
                    currentFieldValue = entry.getValue().getDefaultValue();
                }
                currentFieldValue = addPadding(currentField, currentFieldValue);
                TransactionPacketField transactionPacketField = new TransactionPacketField();
                transactionPacketField.setFieldName(currentField);
                transactionPacketField.setFieldValue(currentFieldValue);
                responsePacketFields.add(transactionPacketField);
                logger.log(Level.DEBUG, "%s with value %s is added to the response packet fields map".formatted(currentField, currentFieldValue));

            } else {
                logger.log(Level.DEBUG, "%s is not required for this transaction as per configuration.".formatted(currentField));
            }

        }
        responsePacketFields = updateResponsePacketFields(responsePacketFields, getConfiguredCategoryLimits(responsePacketFields));
        return responsePacketFields;
    }

    public List<TransactionPacketField> updateResponsePacketFields(List<TransactionPacketField> responsePacketFields, List<TransactionPacketField> configuredCategoryLimits) {
        int index;
        for(TransactionPacketField currentTransactionPacketField : responsePacketFields){
            for(TransactionPacketField expectedTransactionPacketField : configuredCategoryLimits){
                if(currentTransactionPacketField.getFieldName().equals(expectedTransactionPacketField.getFieldName())){
                    index = responsePacketFields.indexOf(currentTransactionPacketField);
                    responsePacketFields.set(index, expectedTransactionPacketField);
                }
            }
        }
        return responsePacketFields;
    }

    public List<TransactionPacketField> getConfiguredCategoryLimits(List<TransactionPacketField> responsePacketFields) {
        String productCount = "", productCode = "", categoryCode = "";
        Limit limit = new Limit();
        List<TransactionPacketField> configuredTransactionFields = new ArrayList<>();
        TransactionPacketField configuredTransactionField1;
        TransactionPacketField configuredTransactionField2;
        TransactionPacketField configuredTransactionField3;
        TransactionPacketField configuredTransactionField4;
        for (TransactionPacketField transactionPacketField : responsePacketFields) {
            if (transactionPacketField.getFieldName().contains("Sub Product Code")) {
                productCode = transactionPacketField.getFieldValue();
                if(!productCode.matches(" *")){
                    productCount = String.valueOf(transactionPacketField.getFieldName().charAt(transactionPacketField.getFieldName().length() - 1));
                    categoryCode = getProductCategory(productCode);
                    limit = getLimits(categoryCode);
                    configuredTransactionField1 = new TransactionPacketField();
                    configuredTransactionField2 = new TransactionPacketField();
                    configuredTransactionField3 = new TransactionPacketField();
                    configuredTransactionField4 = new TransactionPacketField();

                    configuredTransactionField1.setFieldName("Purchase Category" + productCount);
                    configuredTransactionField1.setFieldValue(categoryCode);
                    configuredTransactionFields.add(configuredTransactionField1);
                    configuredTransactionField2.setFieldName("Sub Product Code" + productCount);
                    configuredTransactionField2.setFieldValue(productCode);
                    configuredTransactionFields.add(configuredTransactionField2);
                    configuredTransactionField3.setFieldName("Max Dollar Limit" + productCount);
                    configuredTransactionField3.setFieldValue(limit.getMaxDollar());
                    configuredTransactionFields.add(configuredTransactionField3);
                    configuredTransactionField4.setFieldName("Max Quantity Limit" + productCount);
                    configuredTransactionField4.setFieldValue(limit.getMaxQuantity());
                    configuredTransactionFields.add(configuredTransactionField4);
                }
            }
        }
        return configuredTransactionFields;
    }

    public String getProductCategory(String expectedProductCode) {
        String categoryCode = "";
        for (ProductDetails productDetails : Main.processVariables.productDetailsList) {
            for (String actualProductCode : productDetails.getProductList()) {
                if (actualProductCode.equals(expectedProductCode)) {
                    categoryCode = productDetails.getSubCategoryCode();
                }
            }
        }
        return categoryCode;
    }

    public Limit getLimits(String categoryCode) {
        Limit limit = new Limit();
        limit.setMaxDollar("");
        limit.setMaxQuantity("");
        for (Map.Entry<String, Limit> currentEntry : Main.processVariables.limits.entrySet()) {
            if (currentEntry.getKey().equals(categoryCode)) {
                limit = currentEntry.getValue();
            }
        }
        return limit;
    }
}
