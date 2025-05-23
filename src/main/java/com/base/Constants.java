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
    public static final String FILE_PRE_AUTH_PROPERTIES = "preAuth.json";
    public static final String FILE_FUEL_PURCHASE_PROPERTIES = "fuelPurchase.json";
    public static final String FILE_FUEL_PURCHASE_CANCEL_PROPERTIES = "fuelPurchaseCancel.json";
    public static final String FILE_EXPRESS_CHECK_PROPERTIES = "expressCheck.json";
    public static final String FILE_CHECK_AUTHORIZATION_PROPERTIES = "checkAuthorization.json";
    public static final String FILE_FUEL_PRICE_UPDATE_PROPERTIES = "fuelPriceUpdate.json";
    public static final String FILE_SETTLEMENT_PROPERTIES = "settlement.json";
    public static final String FILE_LIMITS_PROPERTIES = "limits.json";
    public static final String FILE_PRODUCT_TRANSLATION = "Comdata_ProductTranslationTable.xml";

    /*
    -----------------------------------    Path     -----------------------------------------
     */
    public static final String PATH_LOG_PROPERTIES_FILE = "%s\\%s".formatted(FOLDER_PROPERTY_FILES, FILE_LOG_PROPERTIES);
    public static final String PATH_SIMULATOR_CONFIG = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_CONFIGURATION_FILES, FILE_SIMULATOR_PROPERTIES);
    public static final String PATH_DEFAULT_ERROR_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_DEFAULT_ERROR_PROPERTIES);
    public static final String PATH_HEADER_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_HEADER_PROPERTIES);
    public static final String PATH_PRE_AUTH_EDIT_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_PRE_AUTH_EDIT_PROPERTIES);
    public static final String PATH_PRE_AUTH_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_PRE_AUTH_PROPERTIES);
    public static final String PATH_FUEL_PURCHASE_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_FUEL_PURCHASE_PROPERTIES);
    public static final String PATH_FUEL_PURCHASE_CANCEL_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_FUEL_PURCHASE_CANCEL_PROPERTIES);
    public static final String PATH_EXPRESS_CHECK_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_EXPRESS_CHECK_PROPERTIES);
    public static final String PATH_CHECK_AUTHORIZATION_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_CHECK_AUTHORIZATION_PROPERTIES);
    public static final String PATH_FUEL_PRICE_UPDATE_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_FUEL_PRICE_UPDATE_PROPERTIES);
    public static final String PATH_SETTLEMENT_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_SETTLEMENT_PROPERTIES);
    public static final String PATH_LIMITS_PROPERTIES = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_LIMITS_PROPERTIES);
    public static final String PATH_PRODUCT_TRANSLATION_FILE = "%s\\%s\\%s".formatted(Main.getApplicationPath(), FOLDER_TRANSACTION_PROPERTY_FILES, FILE_PRODUCT_TRANSLATION);
    /*
    -----------------------------------Justification----------------------------------------
     */
    public static final String justification_right = "right";
    public static final String justification_left = "left";

    /*
    -----------------------------------Report Numbers----------------------------------------
     */
    public static final String RN_FUELPURCHASE = "00001";
    public static final String RN_FUELPURCHASECANCEL = "00002";
    public static final String RN_SETTLEMENT = "00003";
    public static final String RN_EXPRESSCHECKENCASHMENT = "00004";
    public static final String RN_CHECKAUTHORIZATIONUPDATECHECK = "00005";
    public static final String RN_FUELPRICEUPDATE = "00006";
    public static final String RN_PREAUTHEDIT = "00007";
    public static final String RN_FUELPURCHASEFORCESALE = "00011";
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
    public static final String FLD_NAME_MESSAGE = "Message";
    public static final String FLD_NAME_CLOSEBRACKET = "Close Bracket";
    /*
    -----------------------------------Transaction Type names----------------------------------
   */
    public static final String TRANSACTION_NAME_DEFAULTERROR = "Default Error";
    public static final String TRANSACTION_NAME_PREAUTHEDIT = "Pre Auth Edit";
    public static final String TRANSACTION_NAME_PREAUTH = "Pre Auth";
    public static final String TRANSACTION_NAME_FUEL_PURCHASE = "Fuel Purchase";
    public static final String TRANSACTION_NAME_FUEL_PURCHASE_CANCEL = "Fuel Purchase Cancel";
    public static final String TRANSACTION_NAME_EXPRESS_CHECK = "Express Check encashment";
    public static final String TRANSACTION_NAME_CHECK_AUTHORIZATION_UPDATE = "checkAuthorizationUpdate";
    public static final String TRANSACTION_NAME_FUEL_PRICE_UPDATE = "fuelPriceUpdate";
    public static final String TRANSACTION_NAME_SETTLEMENT = "settlement";
    /*
    -----------------------------------Response Type names----------------------------------
   */
    public static final String RESPONSE_TYPE_RESPONSE = "response";
    public static final String RESPONSE_TYPE_ERROR_RESPONSE = "errorResponse";
    public static final String RESPONSE_TRUCK_STOP_SERVICE_CENTER = "truckStopServiceCenterResponse";
    public static final String RESPONSE_TRUCK_STOP_SERVICE_CENTER_DUPLICATE_AUTH = "truckStopServiceCenterDuplicateAuthResponse";
    public static final String RESPONSE_TYPE_ADDITIONAL_CHECKS = "additionalChecksResponse";

}
