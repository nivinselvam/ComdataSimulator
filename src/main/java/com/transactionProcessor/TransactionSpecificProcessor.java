package com.transactionProcessor;

import com.base.Constants;
import com.transactiondetails.TransactionFieldProperties;

import java.util.List;
import java.util.Map;

abstract class TransactionSpecificProcessor {

    TransactionSpecificProcessor(){
    }

    public abstract Map<String, TransactionFieldProperties> selectResponseType();
    public abstract List<TransactionPacketField> generateResponseFields(Map<String, String> requestPacketFields);

    protected String addPadding(String field, String value) {
        if(!field.equals(Constants.FLD_NAME_MESSAGE)){
            int requiredPadding = 0;
            String padding = "";
            String justfication = "left";
            for (Map.Entry<String, TransactionFieldProperties> entry : selectResponseType().entrySet()) {
                if (entry.getValue().getName().equals(field)) {
                    requiredPadding = entry.getValue().getLength() - value.length();
                    padding = entry.getValue().getPaddingWith();
                    justfication = entry.getValue().getJustification();
                    break;
                }
            }
            for(int i = 0; i < requiredPadding ; i++){
                if(justfication.equals(Constants.justification_right)){
                    value = padding + value;
                }else if(justfication.equals(Constants.justification_left)){
                    value = value+padding;
                }
            }
        }
        return value;
    }

}
