/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.m2i.jpa.hibernate;

import helper.SessionHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RAISA
 */
public class JpaHibernate {

    public static void main(String[] args) {

        EntityManager entityManager = SessionHelper.getEntityManager();

        System.out.println("Nos traitements avec l'entity manager...");

        entityManager.close();
    }
}