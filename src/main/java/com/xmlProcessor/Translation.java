package com.xmlProcessor;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class Translation {

    @XmlAttribute(name = "ProductList")
    private String productList;

    @XmlAttribute(name = "TranslationCode")
    private String translationCode;

    @XmlAttribute(name = "SubCategoryCode")
    private String subCategoryCode;

    // Getters and setters
    public String getProductList() {
        return productList;
    }

    public void setProductList(String productList) {
        this.productList = productList;
    }

    public String getTranslationCode() {
        return translationCode;
    }

    public void setTranslationCode(String translationCode) {
        this.translationCode = translationCode;
    }

    public String getSubCategoryCode() {
        return subCategoryCode;
    }

    public void setSubCategoryCode(String subCategoryCode) {
        this.subCategoryCode = subCategoryCode;
    }
}