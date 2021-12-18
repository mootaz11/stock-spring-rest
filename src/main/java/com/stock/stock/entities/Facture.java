package com.stock.stock.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "factures")
public class Facture {

    @Id
    private String _id ;
    private String date;
    private String urlFacture;
    private String commandeId;

    public Facture(String _id, String date, String urlFacture, String commandeId) {
        this._id = _id;
        this.date = date;
        this.urlFacture = urlFacture;
        this.commandeId = commandeId;
    }

    public String get_Id() {
        return _id;
    }

    public void setId(String id) {
        this._id = _id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUrlFacture() {
        return urlFacture;
    }

    public void setUrlFacture(String urlFacture) {
        this.urlFacture = urlFacture;
    }

    public String getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(String commandeId) {
        this.commandeId = commandeId;
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id='" + _id + '\'' +
                ", date='" + date + '\'' +
                ", urlFacture='" + urlFacture + '\'' +
                ", commandeId='" + commandeId + '\'' +
                '}';
    }
}
