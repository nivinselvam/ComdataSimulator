package com.base;


import com.socketprocessor.ServerInitializer;
import com.transactionProcessor.PreAuthProcessor;
import com.transactiondetails.*;
import com.transactionProcessor.PreAuthEditProcessor;
import com.transactionProcessor.TransactionPacketField;


import java.net.ServerSocket;
import java.util.*;

public class Variables {
    public ServerInitializer server;
    public ServerSocket serverSocket;
    public Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    public Map<String, TransactionFieldProperties> configuredTransactionResponse;
    public TransactionPacketField transactionPacketField;
    public List<TransactionPacketField> responsePacketFields = new ArrayList<>();
    public String responsePacket;
    public String transactionName;
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public DefaultError defaultError;
    public PreAuthEdit preAuthEdit;
    public PreAuth preAuth;
    public PreAuthEditProcessor preAuthEditProcessor = new PreAuthEditProcessor();
    public PreAuthProcessor preAuthProcessor = new PreAuthProcessor();
}
