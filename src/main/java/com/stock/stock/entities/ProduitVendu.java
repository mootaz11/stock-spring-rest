package com.stock.stock.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produitsvendus")
public class ProduitVendu {


    private int quantity;
    private Double totalHt;
    private Produit produit;

    public  ProduitVendu(){
        super();
    }
    public ProduitVendu( int quantity, Double totalHt, Produit produit) {
        super();
        this.quantity = quantity;
        this.totalHt = totalHt;
        this.produit = produit;
    }





    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotalHt() {
        return totalHt;
    }

    public void setTotalHt(Double totalHt) {
        this.totalHt = totalHt;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "ProduitVendu{" +

                ", quantity=" + quantity +
                ", totalHt=" + totalHt +
                ", produit=" + produit +
                '}';
    }
}
