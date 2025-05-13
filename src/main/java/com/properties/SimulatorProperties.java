package com.properties;

public class SimulatorProperties {

    private int portNumber;
    private String preAuthEditResponse;
    private String preAuthResponse;
    private String fuelPurchaseResponse;
    private String fuelPurchaseCancelResponse;
    private String expressCheckEncashmentResponse;
    private String checkAuthorizationResponse;

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getPreAuthEditResponse() {
        return preAuthEditResponse;
    }

    public void setPreAuthEditResponse(String preAuthEditResponse) {
        this.preAuthEditResponse = preAuthEditResponse;
    }

    public String getPreAuthResponse() {
        return preAuthResponse;
    }

    public void setPreAuthResponse(String preAuthResponse) {
        this.preAuthResponse = preAuthResponse;
    }

    public String getFuelPurchaseResponse() {
        return fuelPurchaseResponse;
    }

    public void setFuelPurchaseResponse(String fuelPurchaseResponse) {
        this.fuelPurchaseResponse = fuelPurchaseResponse;
    }

    public String getFuelPurchaseCancelResponse() {
        return fuelPurchaseCancelResponse;
    }

    public void setFuelPurchaseCancelResponse(String fuelPurchaseCancelResponse) {
        this.fuelPurchaseCancelResponse = fuelPurchaseCancelResponse;
    }

    public String getExpressCheckEncashmentResponse() {
        return expressCheckEncashmentResponse;
    }

    public void setExpressCheckEncashmentResponse(String expressCheckEncashmentResponse) {
        this.expressCheckEncashmentResponse = expressCheckEncashmentResponse;
    }

    public String getCheckAuthorizationResponse() {
        return checkAuthorizationResponse;
    }

    public void setCheckAuthorizationResponse(String checkAuthorizationResponse) {
        this.checkAuthorizationResponse = checkAuthorizationResponse;
    }
}
