package com.transactionDetails;

import java.util.Map;

public class Header {
    private Map<String, TransactionFieldProperties> request;

    // Getters and Setters

    public Map<String, TransactionFieldProperties> getRequest() {
        return request;
    }

    public void setRequest(Map<String, TransactionFieldProperties> request) {
        this.request = request;
    }
}
