package com.xmlProcessor;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "ProductTranslation")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductTranslation {

    @XmlElement(name = "TranslationRow")
    private TranslationRow translationRow;

    public TranslationRow getTranslationRow() {
        return translationRow;
    }

    public void setTranslationRow(TranslationRow translationRow) {
        this.translationRow = translationRow;
    }
}

