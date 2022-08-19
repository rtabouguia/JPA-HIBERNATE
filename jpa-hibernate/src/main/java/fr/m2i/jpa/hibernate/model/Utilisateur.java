/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.model;

import java.io.Serializable;
//import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name="utilisateurs")
public class Utilisateur implements Serializable {
    
    @Id
    @Column(name="id_utilisateur", length=20)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
     @Column(name = "actif", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean actif;
    private String civilite;
    
    @Column(name="date_creation", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateCreation;
    
    @Column(name="date_modification", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateModification;
    
     @Column(name="date_naissance", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
     @Temporal(value=TemporalType.TIMESTAMP)
    private  Date dateNaissance;
    
    
     
      @Column(name="marquer_effacer", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean marquerEffacer;
    
    @Column(name="mot_passe", length=100)
    private String motDePasse;
    
    @Column(length=100)
    private String nom;
    
    @Column(length=100)
    private String prenom;
    
    @Column(name = "identifiant", length = 100)
    private String identifiant;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_role")
    private Role role;
    
    @OneToMany(mappedBy = "utilisateur",
            cascade = {CascadeType.PERSIST, 
                CascadeType.MERGE, CascadeType.REMOVE}, 
            fetch = FetchType.LAZY, orphanRemoval = true)
    List <Adresse> listAdresses;
      

    public Utilisateur() {
    }

    
    public Utilisateur(Role role,  String civilite, String nom, String prenom, String identifiant, String motDePasse, boolean actif, boolean marquerEffacer, Date dateCreation, Date dateModification, Date dateNaissance) {
       this.identifiant =identifiant;
        this.actif = actif;
        this.civilite = civilite;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.dateNaissance = dateNaissance;
        this.marquerEffacer = marquerEffacer;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }
    
    
    //Accesseurs et modificateurs
     public List<Adresse> getListAdresses() {
        return listAdresses;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
     
     

    public void setListAdresses(List<Adresse> listAdresses) {
        this.listAdresses = listAdresses;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
   
     public boolean getMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
     public void copy(Utilisateur userData) {

        if (userData.getActif()!= false) {
            this.setActif(userData.getActif());
        }
        if (userData.getMotDePasse()!= null) {
            this.setMotDePasse(userData.getMotDePasse());
        }
          if (userData.getCivilite()!= null) {
            this.setCivilite(userData.getCivilite());
        }
        if (userData.getNom()!= null) {
            this.setNom(userData.getNom());
        }
          if (userData.getRole()!= null) {
            this.setRole(userData.getRole());
        }
        if (userData.getPrenom()!= null) {
            this.setPrenom(userData.getPrenom());
        }
          if (userData.getMarquerEffacer()!= false) {
            this.setMarquerEffacer(userData.getMarquerEffacer());
        }
        if (userData.getDateCreation()!= null) {
            this.setDateCreation(userData.getDateCreation());
        }
           if (userData.getDateModification()!= null) {
            this.setDateModification(userData.getDateModification());
        }
        if (userData.getDateNaissance()!= null) {
            this.setDateNaissance(userData.getDateNaissance());
        }
        if (userData.getIdentifiant()!= null) {
            this.setIdentifiant(userData.getIdentifiant());
        }
    }
     
 @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + id
                + ", role=" + role
                + ", civilite=" + civilite
                + ", nom=" + nom
                + ", prenom=" + prenom 
                + ", identifiant=" + identifiant
                + ", motPasse=" + motDePasse
                + ", actif=" + actif
                + ", marquerEffacer=" + marquerEffacer
                + ", dateCreation=" + dateCreation
                + ", dateModification=" + dateModification
                + ", dateNaissance=" + dateNaissance + '}';
    }

}
