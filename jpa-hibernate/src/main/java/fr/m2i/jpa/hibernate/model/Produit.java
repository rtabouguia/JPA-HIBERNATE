/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity @Table(name="produits")
public class Produit implements Serializable {
    
    @Id
    @Column(name="id_produit", length=20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    
    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean active;
    
     @Column(name="description", columnDefinition="TEXT")
    private String description;
     
    @Column(length=100)
    private String nom;
    
    private float prix;
    @Column(length=100)
    
    private String reference;
    
    @Column(length=20)
    private int stock;

    //CONSTRUCTORS
    public Produit() {
    }

    public Produit(Long idProduit, boolean active, String description, String nom, float prix, String reference, int stock) {
        this.idProduit = idProduit;
        this.active = active;
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long IdProduit) {
        this.idProduit = IdProduit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void copy(Produit productData) {

        if (productData.isActive()!= false) {
            this.setActive(productData.isActive());
        }
        if (productData.getDescription()!= null) {
            this.setDescription(productData.getDescription());
        }
          if (productData.getNom()!= null) {
            this.setNom(productData.getNom());
        }
        if (productData.getNom()!= null) {
            this.setNom(productData.getNom());
        }
          if (productData.getPrix()!= 0) {
            this.setPrix(productData.getPrix());
        }
          if (productData.getReference()!= null) {
            this.setReference(productData.getReference());
        }
        if (productData.getStock()!= 0) {
            this.setStock(productData.getStock());
        }
           
    }
    
    @Override
    public String toString() {
        return "ProduitDAO{" + "idProduit=" + idProduit
                + ", active=" + active
                + ", description=" + description
                + ", nom=" + nom
                + ", prix=" + prix 
                + ", reference=" + reference
                + ", stock=" + stock         + '}';
    }
    
}
