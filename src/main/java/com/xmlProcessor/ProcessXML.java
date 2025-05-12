package com.xmlProcessor;

import com.base.Constants;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.io.File;

public class ProcessXML {

    public static void main(String[]args) throws JAXBException{
        processProductTranslation();
    }

    public static void processProductTranslation() throws JAXBException {
        File file = new File("C:\\Users\\nivinp1\\OneDrive - Verifone\\Desktop\\Documents\\Tools\\ComdataSimulator\\transactionProperties\\Comdata_ProductTranslationTable.xml");
//        File file = new File(Constants.PATH_PRODUCT_TRANSLATION_FILE);
        JAXBContext jaxbContext = JAXBContext.newInstance(ProductTranslation.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        ProductTranslation pt = (ProductTranslation) jaxbUnmarshaller.unmarshal(file);
        TranslationRow row = pt.getTranslationRow();

        for (Translation t : row.getTranslations()) {
            System.out.printf("Products: %s | Code: %s | SubCode: %s%n",
                    t.getProductList(), t.getTranslationCode(), t.getSubCategoryCode());
        }
    }

}
