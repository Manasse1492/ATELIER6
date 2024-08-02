package org.example.app;

public class Ligne {
    private int id;
    private String nom;
    private String auteur;
    private String type;

    public Ligne(int id, String nom, String auteur, String type) {
        this.id = id;
        this.nom = nom;
        this.auteur = auteur;
        this.type = type;
    }

    // Ajoutez les getters et setters pour les propriétés
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
