package com.requestResponses;

import com.transactionDetails.TransactionFields;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty("reportNumber")
    private String reportNumber;

    @JsonProperty("transactionFields")
    private TransactionFields transactionFields;

    // Getters and Setters
    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public TransactionFields getTransactionFields() {
        return transactionFields;
    }

    public void setTransactionFields(TransactionFields transactionFields) {
        this.transactionFields = transactionFields;
    }
}
