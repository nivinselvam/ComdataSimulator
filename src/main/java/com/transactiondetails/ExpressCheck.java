package com.transactiondetails;

import java.util.Map;

public class ExpressCheck {
    private Map<String, TransactionFieldProperties> request;
    private Map<String, TransactionFieldProperties> response;
    private Map<String, TransactionFieldProperties> additionalChecksResponse;
    private Map<String, TransactionFieldProperties> errorResponse;

    // Getters and Setters

    public Map<String, TransactionFieldProperties> getRequest() {
        return request;
    }

    public void setRequest(Map<String, TransactionFieldProperties> request) {
        this.request = request;
    }

    public Map<String, TransactionFieldProperties> getResponse() {
        return response;
    }

    public void setResponse(Map<String, TransactionFieldProperties> response) {
        this.response = response;
    }

    public Map<String, TransactionFieldProperties> getAdditionalChecksResponse() {
        return additionalChecksResponse;
    }

    public void setAdditionalChecksResponse(Map<String, TransactionFieldProperties> additionalChecksResponse) {
        this.additionalChecksResponse = additionalChecksResponse;
    }

    public Map<String, TransactionFieldProperties> getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(Map<String, TransactionFieldProperties> errorResponse) {
        this.errorResponse = errorResponse;
    }
}