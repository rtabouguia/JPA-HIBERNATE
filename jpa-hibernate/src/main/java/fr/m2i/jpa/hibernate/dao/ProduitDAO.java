/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.m2i.jpa.hibernate.dao;

import fr.m2i.jpa.hibernate.helper.SessionHelper;
import fr.m2i.jpa.hibernate.model.Produit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.*;

public class ProduitDAO {
    private final EntityManager entityManager;

    public ProduitDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }
    //findAll
public List<Produit> findAll() {
        Query findAllQuery = entityManager.createQuery("select a from Produit a");
        return findAllQuery.getResultList();
    }
//fingById
public Produit findById(Long id) {
        Produit founded = entityManager.find(Produit.class, id);

        if (founded == null) {
            System.out.println("Attention le produit avec l'id: " + id + " n'existe pas !");
        }

        return founded;
    }
//create product
public void create(Produit productToCreate) {

        if (productToCreate == null) {
            System.out.println("L'objet produit ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(productToCreate);

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

//Update product

public void update(Long id, Produit productData) {

        Produit productToUpdate = entityManager.find(Produit.class, id);

        if (productToUpdate == null) {
            System.out.println("Le produit avec l'id:" + id + " n'existe pas");
            return;
        }

        productToUpdate.copy(productData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(productToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }

public void delete(long id, Produit productToDelete){
    productToDelete =    findById(id);
    EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.remove(productToDelete);
            System.out.println("*******Suppression réussie*********");

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la suppression");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
}
//Find
    public List<Produit> findByName(String name) {

        if (name == null) {
            System.out.println("Ce nom de produit n'est pas valide !");
            return null;
        }

        Query findByNameQuery = entityManager.createQuery("select a from Produit a where a.nom = ?1");
        findByNameQuery.setParameter(1, name);

        if(findByNameQuery.getResultList().isEmpty()){
            System.out.println("??Ce nom de produit n'est pas valide !??");
        }
        return findByNameQuery.getResultList();
    }
   //
    public List<Produit> findByDescription(String description){
        if (description == null) {
            System.out.println("Cette description de produit n'est pas valide !");
            return null;
        }

        Query findByDescriptionQuery = entityManager.createQuery("select a from Produit a where a.description = ?1");
        findByDescriptionQuery.setParameter(1, description);

        if(findByDescriptionQuery.getResultList().isEmpty()){
            System.out.println("??Ce nom de produit n'est pas valide !??");
        }
        return findByDescriptionQuery.getResultList();
    }
        ///
   public List<Produit> findByPrix(Float prix){
       if (prix == null) {
            System.out.println("Ce prix de produit n'est pas valide !");
            return null;
        }

        Query findByPrixQuery = entityManager.createQuery("select a from Produit a where a.prix = ?1");
        findByPrixQuery.setParameter(1, prix);

        if(findByPrixQuery.getResultList().isEmpty()){
            System.out.println("??Ce nom de produit n'est pas valide !??");
        }
        return findByPrixQuery.getResultList();
   }
   //
  public List<Produit> findByReference(String reference){
     if (reference == null) {
            System.out.println("Cette reference de produit n'est pas valide !");
            return null;
        }

        Query findByReferenceQuery = entityManager.createQuery("select a from Produit a where a.reference = ?1");
        findByReferenceQuery.setParameter(1, reference);

        if(findByReferenceQuery.getResultList().isEmpty()){
            System.out.println("??Ce nom de produit n'est pas valide !??");
        }
        return findByReferenceQuery.getResultList();
  }
  
 public Produit findByMostQuantity(){
     TypedQuery<Produit> query = entityManager
                .createQuery("select p from Produit p where p.stock = (select max(pp.stock) from Produit pp)", 
                        Produit.class);
      return query.getSingleResult();
  }
    
}
