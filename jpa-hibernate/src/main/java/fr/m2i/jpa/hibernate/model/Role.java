/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role implements Serializable {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( 
            name="id_Role",
            length=20)
    private long idRole;

    @Column(columnDefinition ="TEXT")
    private String description;
    
    @Column(length=50)
    private String identifiant;
    
     public Role() {
        
    }

    public Role(String identifiant, String description) {
        this.identifiant = identifiant;
        this.description = description;
    }


public long getId_role() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

     @Override
    public String toString() {
        return "Role{" + "idRole=" + idRole + ", identifiant=" + identifiant + ", description=" + description + '}';
    }
    
    public void copy(Role roleData) {

        if (roleData.getIdentifiant() != null) {
            this.setIdentifiant(roleData.getIdentifiant());
        }

        if (roleData.getDescription()!= null) {
            this.setDescription(roleData.getDescription());
        }
    }

       
}
