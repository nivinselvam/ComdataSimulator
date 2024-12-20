package com.transactionDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionFields {

    @JsonProperty("openBracket")
    private TransactionField openBracket;

    @JsonProperty("locationCode")
    private TransactionField locationCode;

    // Getters and Setters
    public TransactionField getOpenBracket() {
        return openBracket;
    }

    public void setOpenBracket(TransactionField openBracket) {
        this.openBracket = openBracket;
    }

    public TransactionField getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(TransactionField locationCode) {
        this.locationCode = locationCode;
    }
}