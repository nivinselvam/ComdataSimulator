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
    public static final String FOLDER_TRANSACTION_PROPERTY_FILES = "transactionProperties";

    /*
    ----------------------------------- File names  -----------------------------------------
     */
    public static final String FILE_LOG_PROPERTIES = "log4j2.xml";
    public static final String FILE_APPLICATION_LOG = "messages.log";
    public static final String FILE_SIMULATOR_PROPERTIES = "simulatorConfig.json";
    public static final String FILE_DEFAULT_ERROR_PROPERTIES = "defaultError.json";
    public static final String FILE_HEADER_PROPERTIES = "header.json";
    public static final String FILE_PRE_AUTH_EDIT_PROPERTIES = "preAuthEdit.json";

    /*
    -----------------------------------    Path     -----------------------------------------
     */
    public static final String PATH_LOG_PROPERTIES_FILE = "%s\\%s".formatted(FOLDER_PROPERTY_FILES, FILE_LOG_PROPERTIES);
    public static final String PATH_SIMULATOR_CONFIG = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_CONFIGURATION_FILES, FILE_SIMULATOR_PROPERTIES);
    public static final String PATH_DEFAULT_ERROR_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_DEFAULT_ERROR_PROPERTIES);
    public static final String PATH_HEADER_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_HEADER_PROPERTIES);
    public static final String PATH_PRE_AUTH_EDIT_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_PRE_AUTH_EDIT_PROPERTIES);
    /*
    -----------------------------------Report Numbers----------------------------------------
     */
    public static final String RN_FUELPURCHASESALE = "00001";
    public static final String RN_FUELPURCHASECANCEL = "00002";
    public static final String RN_SETTLEMENT = "00003";
    public static final String RN_EXPRESSCHECKENCASHMENT = "00004";
    public static final String RN_CHECKAUTHORIZATIONUPDATECHECK = "00005";
    public static final String RN_FUELPRICEUPDATE = "00006";
    public static final String RN_PREAUTHEDIT = "00007";
    public static final String RN_FUELPURCHASEREQUESTFORCESALE = "00011";
    public static final String RN_PREAUTHORIZATION = "00014";
    /*
    -----------------------------------Operators----------------------------------------
     */
    public static final String OPENBRACKET = "{";
    public static final String FIELDSEPARATOR = "/";
    public static final String CLOSEBRACKET = "}";

    /*
    -----------------------------------Key Fields name----------------------------------------
   */
    public static final String FLD_NAME_REPORTNUMBER = "Report Number";
    public static final String FLD_NAME_FIELDSEPARATOR = "Field Separator";
    public static final String FLD_NAME_CLOSEBRACKET = "Close Bracket";
    /*
    -----------------------------------Transaction Type names----------------------------------
   */
    public static final String TRANSACTION_NAME_DEFAULTERROR = "Default Error";
    public static final String TRANSACTION_NAME_PREAUTHEDIT = "Pre Auth Edit";

}
