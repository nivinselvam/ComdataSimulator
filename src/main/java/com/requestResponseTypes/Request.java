package com.requestResponseTypes;

import com.transactionDetails.TransactionFieldProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Request {

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
