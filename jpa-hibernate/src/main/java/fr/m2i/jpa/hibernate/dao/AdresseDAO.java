/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.dao;

import fr.m2i.jpa.hibernate.helper.SessionHelper;
import fr.m2i.jpa.hibernate.model.Adresse;
import fr.m2i.jpa.hibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.*;


public class AdresseDAO {
    private final EntityManager entityManager;

    public AdresseDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public List<Adresse> findAll() {
        Query findAllQuery = entityManager.createQuery("select a from Adresse a");
        return findAllQuery.getResultList();
    }
    
    public Adresse findById(Long id) {
        Adresse founded = entityManager.find(Adresse.class, id);

        if (founded == null) {
            System.out.println("Attention l'adresse avec l'id: " + id + " n'existe pas !");
        }

        return founded;
    }

    public List<Adresse> findByUtilisateur(Utilisateur user) {

        if (user == null || user.getId() < 1L) {
            System.out.println("L'utilisateur n'est pas valide !");
            return null;
        }

        Query findByUserQuery = entityManager.createQuery("select a from Adresse a where a.utilisateur = ?1");
        findByUserQuery.setParameter(1, user);

        return findByUserQuery.getResultList();
    }

    public void create(Adresse adresseToCreate) {

        if (adresseToCreate == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(adresseToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
    }

    public void update(Long id, Adresse adresseData) {

        Adresse adresseToUpdate = entityManager.find(Adresse.class, id);

        if (adresseToUpdate == null) {
            System.out.println("Le adresse avec l'id:" + id + " n'existe pas");
            return;
        }

        adresseToUpdate.copy(adresseData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(adresseToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
}
