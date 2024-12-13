package com.base;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Constants");
    }

    /*
    -----------------------------------Folder names-----------------------------------------
     */
    public static final String FOLDER_PROPERTY_FILES = "propertyFiles";
    public static final String FOLDER_LOGS = "logs";
    public static final String FOLDER_CONFIGURATION_FILES = "configurationFiles";

    /*
    ----------------------------------- File names  -----------------------------------------
     */
    public static final String FILE_LOG_PROPERTIES = "log4j2.xml";
    public static final String FILE_APPLICATION_LOG = "messages.log";
    public static final String FILE_SIMULATOR_PROPERTIES = "simulatorConfig.json";

    /*
    -----------------------------------    Path     -----------------------------------------
     */
    public static final String PATH_LOG_PROPERTIES_FILE = "%s/%s".formatted(FOLDER_PROPERTY_FILES, FILE_LOG_PROPERTIES);
    public static final String PATH_SIMULATOR_CONFIG = "%s/%s/%s".formatted(Main.getApplicationPath(), FOLDER_CONFIGURATION_FILES, FILE_SIMULATOR_PROPERTIES);
}
