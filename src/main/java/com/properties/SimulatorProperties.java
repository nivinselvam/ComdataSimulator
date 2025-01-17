package com.properties;

public class SimulatorProperties {

    private int portNumber;
    private String preAuthEditResponse;
    private String preAuthResponse;
    private String fuelPurchaseRequestResponse;

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

    public String getFuelPurchaseRequestResponse() {
        return fuelPurchaseRequestResponse;
    }

    public void setFuelPurchaseRequestResponse(String fuelPurchaseRequestResponse) {
        this.fuelPurchaseRequestResponse = fuelPurchaseRequestResponse;
    }
}
