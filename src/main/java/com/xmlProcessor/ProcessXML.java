package com.xmlProcessor;

import com.base.Constants;
import com.base.Main;
import com.base.PreReqRunner;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProcessXML {

    private static final Logger logger = LogManager.getLogger(PreReqRunner.class);

    public void processProductTranslation() throws JAXBException {
        logger.log(Level.DEBUG, "Reading the product translation configuration from "+Constants.PATH_PRODUCT_TRANSLATION_FILE);
        File file = new File(Constants.PATH_PRODUCT_TRANSLATION_FILE);
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductTranslation.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        ProductTranslation pt = (ProductTranslation) jaxbUnmarshaller.unmarshal(file);
        TranslationRow row = pt.getTranslationRow();
        for (Translation t : row.getTranslations()) {
            Main.processVariables.productDetails.setProductList(generateProductsList(t.getProductList()));
            Main.processVariables.productDetails.setTranslationCode(t.getTranslationCode());
            Main.processVariables.productDetails.setSubCategoryCode(t.getSubCategoryCode());
        }
    }

    public static List<String> generateProductsList(String productsList) {
        List<String> productList = new ArrayList<>();
        String value;
        String[] tempValue;
        char start, end;
        for (String product : productsList.split("\\|")) {
            if (product.contains("[")) {
                tempValue = product.split("\\[");
                value = tempValue[0];
                start = tempValue[1].charAt(0);
                end = tempValue[1].charAt(2);
                for (int i = Character.getNumericValue(start); i <= Character.getNumericValue(end); i++) {
                    productList.add(value + String.valueOf(i));
                }
            } else {
                productList.add(product);
            }
        }
        return productList;
    }

}
