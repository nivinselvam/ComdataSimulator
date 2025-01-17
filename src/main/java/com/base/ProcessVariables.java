package com.base;


import com.transactionProcessor.*;
import com.transactiondetails.*;


import java.util.*;

public class ProcessVariables {
    public String errorMessage = "Error message configured";
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public DefaultError defaultError;
    public PreAuthEdit preAuthEdit;
    public PreAuth preAuth;
    public FuelPurchaseRequest fuelPurchaseRequest;

}
