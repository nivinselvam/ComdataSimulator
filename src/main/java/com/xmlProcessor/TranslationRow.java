package com.xmlProcessor;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class TranslationRow {

    @XmlElement(name = "CardType")
    private String cardType;

    @XmlElement(name = "Translations")
    private List<Translation> translations;

    public String getCardType() { return cardType; }
    public void setCardType(String cardType) { this.cardType = cardType; }

    public List<Translation> getTranslations() { return translations; }
    public void setTranslations(List<Translation> translations) { this.translations = translations; }
}