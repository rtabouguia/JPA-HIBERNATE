/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author RAISA
 */

@Entity
@Table(name="adresses")
public class Adresse implements Serializable {
    
    @Id
    @Column(name="id_adresse", length=20)
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAdresse;
    
    @Column(name="code_postal", length=100)
    private String codePostal;
    
    @Column(name="pays", length=100)
    private String pays;
    
     @Column(name = "actif", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean principale;
    
     @Column(length=100)
     private String rue;
     
     @Column(length=100)
     private String ville;
     
     @JoinColumn(name="id_utilisateur")
     @ManyToOne(fetch = FetchType.LAZY)
     private Utilisateur utilisateur;

     //Constructors
    public Adresse() {
    }

    public Adresse(Utilisateur utilisateur, String rue,  String codePostal, String ville, String pays, boolean principale) {
         this.codePostal = codePostal;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
        this.utilisateur = utilisateur;
    }
     
   //Assesseurs et modificateurs

    public long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public boolean isPrincipale() {
        return principale;
    }

    public void setPrincipale(boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur Utilisateur) {
        this.utilisateur = Utilisateur;
    }
    
    public void copy(Adresse adressData) {

        if (adressData.getCodePostal()!=null) {
            this.setCodePostal(adressData.getCodePostal());
        }
        if (adressData.getPays()!= null) {
            this.setPays(adressData.getPays());
        }
          if (adressData.isPrincipale()!= false) {
            this.setPrincipale(adressData.isPrincipale());
        }
        if (adressData.getRue()!= null) {
            this.setRue(adressData.getRue());
        }
          if (adressData.getVille()!= null) {
            this.setVille(adressData.getVille());
        }
       
    }    
          
     public String getFullAdresse() {
        return String.format("%s, %s, %s, %s", rue, codePostal, ville, pays);
    }
     
    @Override
    public String toString() {
        return "AdresseDAO{" + "id_Adresse=" + idAdresse
                + ", codePostal=" + codePostal
                + ", pays=" + pays
                + ", principale=" + principale
                + ", rue=" + rue 
                + ", ville=" + ville
                + ", Utilisateur=" + utilisateur         + '}';
    }
    
}
