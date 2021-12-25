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
    private ArrayList<ProduitVendu> produitsVendus ;
    private Double netTotale ;
    private Double htTotale;
    private Double remise;
    private Facture facture ;

    public Commande() {
        super();
    }

    public Commande(String id, String clientName,Double remise,Double htTotale, String clientAddress, String clientRef, String matriculeFiscale, ArrayList<ProduitVendu> produitsVendus, Double netTotale, Facture facture ) {
        super();
        this._id = id;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientRef = clientRef;
        this.matriculeFiscale = matriculeFiscale;
        this.produitsVendus = produitsVendus;
        this.netTotale = netTotale ;
        this.remise=remise;
        this.htTotale=htTotale;
        this.facture= facture ;
    }

    public Double getHtTotale() {
        return htTotale;
    }

    public void setHtTotale(Double htTotale) {
        this.htTotale = htTotale;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public ArrayList<ProduitVendu> getProduitsVendus() {
        return produitsVendus;
    }

    public void setProduitsVendus(ArrayList<ProduitVendu> produitsVendus) {
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
                "_id='" + _id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientRef='" + clientRef + '\'' +
                ", matriculeFiscale='" + matriculeFiscale + '\'' +
                ", produitsVendus=" + produitsVendus +
                ", netTotale=" + netTotale +
                ", htTotale=" + htTotale +
                ", remise=" + remise +
                ", facture=" + facture +
                '}';
    }
}
