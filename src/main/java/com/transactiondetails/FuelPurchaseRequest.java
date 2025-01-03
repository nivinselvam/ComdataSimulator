package com.transactiondetails;

import java.util.Map;

public class FuelPurchaseRequest {
    private Map<String, TransactionFieldProperties> request;
    private Map<String, TransactionFieldProperties> truckStopServiceCenterResponse;
    private Map<String, TransactionFieldProperties> errorResponse;

    // Getters and Setters

    public Map<String, TransactionFieldProperties> getRequest() {
        return request;
    }

    public void setRequest(Map<String, TransactionFieldProperties> request) {
        this.request = request;
    }

    public Map<String, TransactionFieldProperties> getTruckStopServiceCenterResponse() {
        return truckStopServiceCenterResponse;
    }

    public void setTruckStopServiceCenterResponse(Map<String, TransactionFieldProperties> truckStopServiceCenterResponse) {
        this.truckStopServiceCenterResponse = truckStopServiceCenterResponse;
    }

    public Map<String, TransactionFieldProperties> getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(Map<String, TransactionFieldProperties> errorResponse) {
        this.errorResponse = errorResponse;
    }
}