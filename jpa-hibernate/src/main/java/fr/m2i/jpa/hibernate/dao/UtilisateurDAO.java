/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.dao;

import fr.m2i.jpa.hibernate.helper.SessionHelper;
import fr.m2i.jpa.hibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author RAISA
 */
public class UtilisateurDAO {
    
    private final EntityManager entityManager;

    public UtilisateurDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    
    //find all users
    public List<Utilisateur> findAll(){
        Query query = entityManager.createQuery("SELECT p FROM Utilisateur p");
         List<Utilisateur> results = query.getResultList();
         return results;
    }
    
    //find a user by id
     public Utilisateur findById(Long id) {
        Utilisateur founded = entityManager.find(Utilisateur.class, id);

        if (founded == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }
     
     public void create(Utilisateur user) {
        // Vérifier le paramètre role
        if (user == null) {
            System.out.println("L'objet user ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(user);
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du user");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
     
     //update a user
     public void update(Long id, Utilisateur userData) {

        Utilisateur userToUpdate = entityManager.find(Utilisateur.class, id);

        if (userToUpdate == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        userToUpdate.copy(userData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification du user");
            if (tx != null) {
                tx.rollback();
            }
        }
    }
}
