package com.base;


import com.socketprocessor.ServerInitializer;
import com.transactionProcessor.*;
import com.transactiondetails.*;

import java.net.ServerSocket;
import java.util.*;

public class TransactionVariables {
    public Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    public Map<String, TransactionFieldProperties> configuredTransactionResponse;
    public TransactionPacketField transactionPacketField;
    public List<TransactionPacketField> responsePacketFields = new ArrayList<>();
    public String responsePacket;
    public String transactionName;
    public String errorMessage = "Error message configured";
}
