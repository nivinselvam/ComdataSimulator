package com.base;


import com.socketprocessor.ServerInitializer;
import com.transactiondetails.DefaultError;
import com.transactiondetails.Header;
import com.transactiondetails.PreAuthEdit;
import com.transactionProcessor.PreAuthEditProcessor;
import com.transactionProcessor.TransactionPacketField;
import com.transactiondetails.TransactionFieldProperties;


import java.net.ServerSocket;
import java.util.*;

public class Variables {
    public ServerInitializer server;
    public ServerSocket serverSocket;
    public Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    public Map<String, TransactionFieldProperties> configuredTransactionResponse;
    public TransactionPacketField transactionPacketField;
    public List<TransactionPacketField> responsePacketFields = new ArrayList<>();
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public DefaultError defaultError;
    public PreAuthEdit preAuthEdit;
    public PreAuthEditProcessor preAuthEditProcessor = new PreAuthEditProcessor();
    public String responsePacket;


}
