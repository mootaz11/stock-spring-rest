package com.stock.stock.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produits")
public class Produit {


    @Id
    private String _id;

    private String name;
    private int quantity;
    private Double price ;
    private Double priceHt;
    private Double priceTtc;
    private Double rem ;

    public Produit() {
        super();
    }

    public Produit(String id, String name, int quantity, Double price, Double priceTtc, Double rem,Double priceHt) {
        super();
        this._id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.priceTtc = priceTtc;
        this.rem = rem;
        this.priceHt=priceHt;
    }

    public Double getPriceHt() {
        return priceHt;
    }

    public void setPriceHt(Double priceHt) {
        this.priceHt = priceHt;
    }

    public Double getPriceTtc() {
        return priceTtc;
    }

    public void setPriceTtc(Double priceTtc) {
        this.priceTtc = priceTtc;
    }

    public Double getRem() {
        return rem;
    }

    public void setRem(Double rem) {
        this.rem = rem;
    }

    public String get_Id() {
        return _id;
    }

    public void set_Id(String id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "_id='" + _id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", priceHt=" + priceHt +
                ", priceTtc=" + priceTtc +
                ", rem=" + rem +
                '}';
    }
}
