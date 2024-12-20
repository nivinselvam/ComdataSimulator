package com.transactionDetails;

import com.requestResponses.Request;
import com.requestResponses.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PreAuthEdit {

    @JsonProperty("Request")
    private Request request;

    @JsonProperty("Response")
    private Response response;

    // Getters and Setters
    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}