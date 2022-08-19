/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.m2i.jpa.hibernate;

import fr.m2i.jpa.hibernate.dao.*;
import javax.persistence.EntityManager;
import fr.m2i.jpa.hibernate.helper.SessionHelper;
import fr.m2i.jpa.hibernate.model.*;
import fr.m2i.jpa.hibernate.model.Utilisateur;
import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author RAISA
 */
public class JpaHibernate {

    public static void main(String[] args) {
        /******ROLE *******/
       EntityManager entityManager = SessionHelper.getEntityManager();
//        RoleDAO roleDao = new RoleDAO();
//
//        // create
//       Role roleAdmin = new Role("ADMIN", "Le rôle Administrateur"); 
//       roleDao.create(roleAdmin);
//       Role roleTech = new Role("USER", "Le rôle d'utilisateur"); 
//       roleDao.create(roleTech);
//
//         //find
//        Role founded = roleDao.findById(1L);
//        System.out.println("Role CREATED : " + founded);
//
//         //update
//        Role roleData = new Role();
//        roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");
//
//        roleDao.update(1L, roleData);
//
//        // find
//        Role updated = roleDao.findById(1L);
//        System.out.println("Role UPDATED : " + updated);
//        
//        //find all
//    for (Role role: roleDao.findAll()){
//            System.out.println("Role UPDATED : "+role.toString());
//        }
//
//        entityManager.close();
        

/*********** USER **********/
        
//       SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
       UtilisateurDAO userDao = new UtilisateurDAO();
//
//        // create
//        Role role = new Role();
//        role.setIdRole(1L);
//
//        Utilisateur user = new Utilisateur(role, "Madame", "Mme x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
//        Utilisateur user2 = new Utilisateur(role, "Monsieur", "Mr x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
//
//        userDao.create(user);
//        userDao.create(user2);
//        
//        // find all
//        List<Utilisateur> users = userDao.findAll();
//
//        for (Utilisateur u : users) {
//            System.out.println("Find all : " + u);
//        }
//
//        // update
//        Utilisateur userData = new Utilisateur();
//        userData.setActif(false);
//        userData.setMarquerEffacer(true);
//
//        try {
//            userData.setDateModification(formatter.parse("11/01/2022"));
//        } catch (ParseException e) {
//            System.out.println("Problème de parsing : " + e.getMessage());
//        }
//
//       userDao.update(2L, userData);
//
//        // find
       Utilisateur secondUser = userDao.findById(2L);
//       System.out.println("User updated : " + secondUser);

         /*********** ADDRESS **********/
        
//        AdresseDAO adresseDao = new AdresseDAO();
//        
//        // create
//        Utilisateur user = new Utilisateur();
//        user.setId(1L);
//
//        Adresse address1 = new Adresse(user, "1 rue de la paix", "75001", "Paris", "France", true);
//        Adresse address2 = new Adresse(secondUser, "2 rue de la guerre", "75019", "Paris", "France", false);
//        
//        adresseDao.create(address1);
//        adresseDao.create(address2);
//
//        // find all
//        List<Adresse> addresses = adresseDao.findAll();
//        
//        for (Adresse a : addresses) {
//            System.out.println("All addresses : " + a.getFullAdresse());
//        }
//
//        // update
//        Adresse addressData = new Adresse();
//        addressData.setRue("2 rue de la paix");
//        addressData.setPrincipale(true);
//        
//        adresseDao.update(2L, addressData);
//        
//        // find by user
//        List<Adresse> addressesOfSecondUser = adresseDao.findByUtilisateur(secondUser);
//        
//        for (Adresse a : addressesOfSecondUser) {
//            System.out.println("All addresses of 2nd user : " + a.getFullAdresse());
//        }
//
//        // find
//        System.out.println("First address : " + adresseDao.findById(2L).getFullAdresse());
//
//        entityManager.close();
        
        /*********PRODUIT*********/
         System.out.println("/**********Delete product***************/");
        ProduitDAO produitDAO = new ProduitDAO();
        //Produit productToDelete = new Produit();
        
        //delete produit
        //produitDAO.delete(1L, productToDelete);
        
        System.out.println("/**********Find product by name***************/");
        for(Produit produit:produitDAO.findByName("Iphone 4")){
            
            System.out.println(produit.toString());
                
        }
        
        //********findByMostQuantity()**********//
       System.out.println("findByMostQuantity():***Name: "+produitDAO.findByMostQuantity().getNom()
        +"****Stock: "+produitDAO.findByMostQuantity().getStock());
         entityManager.close();
    }
        
    }

