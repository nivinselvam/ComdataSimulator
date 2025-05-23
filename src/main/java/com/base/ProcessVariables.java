package com.base;


import com.transactiondetails.*;


import java.util.*;

public class ProcessVariables {
    public String errorMessage = "Error message configured";
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public DefaultError defaultError;
    public PreAuthEdit preAuthEdit;
    public PreAuth preAuth;
    public FuelPurchase fuelPurchase;
    public FuelPurchaseCancel fuelPurchaseCancel;
    public ExpressCheck expressCheck;
    public CheckAuthorizationUpdate checkAuthorizationUpdate;
    public FuelPriceUpdate fuelPriceUpdate;
    public Settlement settlement;
    public Limit limit;
    public Map<String, Limit> limits;
    public List<ProductDetails> productDetailsList = new ArrayList<>();
}
