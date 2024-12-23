package com.transactionProcessor;

import com.base.Main;
import com.transactionDetails.TransactionFieldProperties;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



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


        return "";
    }



}
