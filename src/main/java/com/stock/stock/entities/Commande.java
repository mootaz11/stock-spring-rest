package com.stock.stock.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "commandes")
public class Commande {

    @Id
    private String _id;
    private String clientName;
    private String clientAddress;
    private String clientRef;
    private String matriculeFiscale;
    private ArrayList<Produit> produitsVendus ;
    private Double netTotale ;
    private Facture facture ;

    public Commande() {
        super();
    }

    public Commande(String id, String clientName, String clientAddress, String clientRef, String matriculeFiscale, ArrayList<Produit> produitsVendus, Double netTotale, Facture facture ) {
        super();
        this._id = id;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientRef = clientRef;
        this.matriculeFiscale = matriculeFiscale;
        this.produitsVendus = produitsVendus;
        this.netTotale = netTotale ;
        this.facture= facture ;
    }

    public ArrayList<Produit> getProduitsVendus() {
        return produitsVendus;
    }

    public void setProduitsVendus(ArrayList<Produit> produitsVendus) {
        this.produitsVendus = produitsVendus;
    }

    public String get_Id() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getClientRef() {
        return clientRef;
    }

    public void setClientRef(String clientRef) {
        this.clientRef = clientRef;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }

    public Double getNetTotale() {
        return netTotale;
    }

    public void setNetTotale(Double netTotale) {
        this.netTotale = netTotale;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id='" + _id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientRef='" + clientRef + '\'' +
                ", matriculeFiscale='" + matriculeFiscale + '\'' +
                '}';
    }



}
