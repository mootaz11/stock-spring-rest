package com.stock.stock.utils;

public class ProductBody {
    private String lineNumber ;
    private String codeArt;
    private String designation;
    private String  quantity ;
    private String priceUnit;
    private String tva ;
    private String remise ;
    private String totalHt ;
    private String priceTtc;

    public ProductBody() {
        super();
    }

    public ProductBody(String lineNumber, String codeArt, String designation, String quantity, String priceUnit, String tva, String remise, String totalHt, String priceTtc) {
        this.lineNumber = lineNumber;
        this.codeArt = codeArt;
        this.designation = designation;
        this.quantity = quantity;
        this.priceUnit = priceUnit;
        this.tva = tva;
        this.remise = remise;
        this.totalHt = totalHt;
        this.priceTtc = priceTtc;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getCodeArt() {
        return codeArt;
    }

    public void setCodeArt(String codeArt) {
        this.codeArt = codeArt;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getRemise() {
        return remise;
    }

    public void setRemise(String remise) {
        this.remise = remise;
    }

    public String getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(String totalHt) {
        this.totalHt = totalHt;
    }

    public String getPriceTtc() {
        return priceTtc;
    }

    public void setPriceTtc(String priceTtc) {
        this.priceTtc = priceTtc;
    }

    @Override
    public String toString() {
        return "ProductBody{" +
                "lineNumber='" + lineNumber + '\'' +
                ", codeArt='" + codeArt + '\'' +
                ", designation='" + designation + '\'' +
                ", quantity='" + quantity + '\'' +
                ", priceUnit='" + priceUnit + '\'' +
                ", tva='" + tva + '\'' +
                ", remise='" + remise + '\'' +
                ", totalHt='" + totalHt + '\'' +
                ", priceTtc='" + priceTtc + '\'' +
                '}';
    }
}
