package com.transactiondetails;

import java.util.Map;

public class DefaultError {
    private Map<String, TransactionFieldProperties> response;


    public Map<String, TransactionFieldProperties> getResponse() {
        return response;
    }

    public void setResponse(Map<String, TransactionFieldProperties> response) {
        this.response = response;
    }

}

