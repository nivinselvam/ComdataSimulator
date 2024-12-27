package com.base;


import com.socketprocessor.ServerInitializer;
import com.transactionDetails.Header;
import com.transactionDetails.PreAuthEdit;
import com.transactionProcessor.PreAuthEditProcessor;
import com.transactionProcessor.TransactionPacketField;


import java.net.ServerSocket;
import java.util.*;

public class Variables {
    public ServerInitializer server;
    public ServerSocket serverSocket;
    public Map<String, String> requestPacketFields = new LinkedHashMap<String, String>();
    public TransactionPacketField transactionPacketField;
    public List<TransactionPacketField> responsePacketFields = new ArrayList<>();
    public List<String> exclusionFieldsList = new ArrayList<>(Arrays.asList("{", "/", "}"));
    public Header header;
    public PreAuthEdit preAuthEdit;
    public PreAuthEditProcessor preAuthEditProcessor = new PreAuthEditProcessor();


}
