/*
 * Created on: 03/March/2023
 * Author: Nivin Selvam
 * This class is used to find the path in which the application is available.
 * Do not use this file for adding any other functionalities.
 */

package com.base;

public class PreReqRunner {

    /*
    This method is used to set the file path of the logger in the log4j properties file.
    Since the path of the application is obtained dynamically, to handle it in the log properties
    this will be required.
     */
    public void configureLoggerFilePath() {
        System.setProperty("log4j.configuration", Constants.PATH_LOG_PROPERTIES_FILE);
    }


}
