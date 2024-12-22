package com.utilities;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;

public class Converter {
    private static final Logger logger = LogManager.getLogger(Converter.class);


    /**
     * This method is used for converting a string into bytes array.
     */
    public byte[] convertStringToBytes(String stringToBeConvertedToBytes) {
        byte[] byteArray;
        logger.log(Level.DEBUG, "Trying to convert the string into bytes");
        byteArray = stringToBeConvertedToBytes.getBytes(StandardCharsets.ISO_8859_1);
        logger.log(Level.DEBUG,"Converted byte array is \n " + byteArray);
        return byteArray;
    }
}
