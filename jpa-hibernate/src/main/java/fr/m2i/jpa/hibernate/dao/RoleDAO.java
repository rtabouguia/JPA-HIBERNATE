/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.dao;

/**
 *
 * @author RAISA
 */
import fr.m2i.jpa.hibernate.helper.SessionHelper;

import fr.m2i.jpa.hibernate.model.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RoleDAO {

    private final EntityManager entityManager;

    public RoleDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Role findById(Long id) {
        Role founded = entityManager.find(Role.class, id);

        if (founded == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }
    
    public List<Role> findAll(){
        Query query = entityManager.createQuery("SELECT p FROM Role p");
         List<Role> results = query.getResultList();
         return results;
        
    }

    public void create(Role role) {
        // Vérifier le paramètre role
        if (role == null) {
            System.out.println("L'objet role ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(role);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du role");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    // Différente manière : Lister les paramètres modifiables
    // public void update(Long id, String identifiant, String description)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.setIdentifiant(identifiant);
    // ...

    // Différente manière : Avoir l'id + les données à modifier encapsulé dans l'entity
    // public void update(Long id, Role roleData)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    // Différente manière : Tout encapsuler dans l'entity
    // public void update(Role roleData)
    // On utilise roleData.getId() pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    public void update(Long id, Role roleData) {

        Role roleToUpdate = entityManager.find(Role.class, id);

        if (roleToUpdate == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        roleToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(roleToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification du role");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}