package com.transactionProcessor;

import com.base.Main;
import com.transactionDetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;


public class ResponseGenerator {
    private static final Logger logger = LogManager.getLogger(ResponseGenerator.class);
    private String requestPacket;


    public ResponseGenerator(String requestPacket) {
        this.requestPacket = requestPacket;
    }

    public String generateResponse() {
        logger.log(Level.DEBUG, "Processing the below transaction packet");
        logger.log(Level.DEBUG, requestPacket);
        Decoder decoder = new Decoder();
        decoder.decodeRequestPacket(requestPacket);
        logger.log(Level.INFO, "Request Packet");
        for(Map.Entry<String, String> entry : Main.variables.requestPacketFields.entrySet()){
            logger.log(Level.INFO, "%s  :   %s".formatted(entry.getKey(), entry.getValue()));
        }
        return "";
    }



}
