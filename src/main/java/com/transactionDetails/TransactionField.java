package com.transactionDetails;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TransactionField {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("length")
    private int length;

    @JsonProperty("required")
    private boolean required;

    @JsonProperty("presetOptions")
    private List<String> presetOptions;

    @JsonProperty("justification")
    private String justification;

    @JsonProperty("paddingWith")
    private String paddingWith;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public List<String> getPresetOptions() {
        return presetOptions;
    }

    public void setPresetOptions(List<String> presetOptions) {
        this.presetOptions = presetOptions;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getPaddingWith() {
        return paddingWith;
    }

    public void setPaddingWith(String paddingWith) {
        this.paddingWith = paddingWith;
    }
}
