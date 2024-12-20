package com.transactionDetails;

import com.requestResponseTypes.ErrorResponse;
import com.requestResponseTypes.Request;
import com.requestResponseTypes.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PreAuthEdit {

    @JsonProperty("request")
    private Request request;

    @JsonProperty("response")
    private Response response;

    @JsonProperty("errorResponse")
    private ErrorResponse errorResponse;

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

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }
}