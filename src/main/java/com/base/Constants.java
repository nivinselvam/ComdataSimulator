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
    public static final String FILE_HEADER_PROPERTIES = "header.json";
    public static final String FILE_PRE_AUTH_EDIT_PROPERTIES = "PreAuthEdit.json";

    /*
    -----------------------------------    Path     -----------------------------------------
     */
    public static final String PATH_LOG_PROPERTIES_FILE = "%s\\%s".formatted(FOLDER_PROPERTY_FILES, FILE_LOG_PROPERTIES);
    public static final String PATH_SIMULATOR_CONFIG = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_CONFIGURATION_FILES, FILE_SIMULATOR_PROPERTIES);
    public static final String PATH_HEADER_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_HEADER_PROPERTIES);
    public static final String PATH_PRE_AUTH_EDIT_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_PRE_AUTH_EDIT_PROPERTIES);
    /*
    -----------------------------------Report Numbers----------------------------------------
     */
    public static final String rn_fuelPurchaseSale = "00001";
    public static final String rn_fuelPurchaseCancel = "00002";
    public static final String rn_settlement = "00003";
    public static final String rn_expressCheckEncashment = "00004";
    public static final String rn_checkAuthorizationUpdateCheck = "00005";
    public static final String rn_fuelPriceUpdate = "00006";
    public static final String rn_preAuthEdit = "00007";
    public static final String rn_fuelPurchaseRequestForceSale = "00011";
    public static final String rn_preAuthorization = "00014";
    /*
    -----------------------------------Operators----------------------------------------
     */
    public static final String openBracket = "{";
    public static final String fieldOperator = "/";
    public static final String closeBracket = "}";

    /*
    -----------------------------------Key Fields name----------------------------------------
   */
    public static final String fld_name_reportNumber = "Report Number";
    public static final String fld_name_fieldSeparator = "Field Separator";
    public static final String fld_name_closeBracket = "Close Bracket";


}
