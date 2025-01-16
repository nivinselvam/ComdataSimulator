package com.base;


import com.transactionProcessor.*;
import com.transactiondetails.*;


import java.util.*;

public class ProcessVariables {
    public Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    public Map<String, TransactionFieldProperties> configuredTransactionResponse;
    public TransactionPacketField transactionPacketField;
    public List<TransactionPacketField> responsePacketFields = new ArrayList<>();
    public String responsePacket;
    public String transactionType;
    public String errorMessage = "Error message configured";
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public DefaultError defaultError;
    public PreAuthEdit preAuthEdit;
    public PreAuth preAuth;
    public DefaultErrorProcessor defaultErrorProcessor = new DefaultErrorProcessor();
    public FuelPurchaseRequest fuelPurchaseRequest;
    public PreAuthEditProcessor preAuthEditProcessor = new PreAuthEditProcessor();
    public PreAuthProcessor preAuthProcessor = new PreAuthProcessor();
    public FuelPurchaseRequestProcessor fuelPurchaseRequestProcessor = new FuelPurchaseRequestProcessor();
}
