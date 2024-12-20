package com.requestResponseTypes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.transactionDetails.TransactionFieldProperties;

import java.util.Map;

public class ErrorResponse {

    @JsonProperty("reportNumber")
    private String reportNumber;

    @JsonProperty("transactionFields")
    private Map<String, TransactionFieldProperties> transactionFields;

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public Map<String, TransactionFieldProperties> getTransactionFields() {
        return transactionFields;
    }

    public void setTransactionFields(Map<String, TransactionFieldProperties> transactionFields) {
        this.transactionFields = transactionFields;
    }
}
