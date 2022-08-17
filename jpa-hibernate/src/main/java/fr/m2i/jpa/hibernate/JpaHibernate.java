/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package fr.m2i.jpa.hibernate;

import fr.m2i.jpa.hibernate.dao.RoleDAO;
import javax.persistence.EntityManager;
import fr.m2i.jpa.hibernate.helper.SessionHelper;
import fr.m2i.jpa.hibernate.model.Role;
import java.util.List;

/**
 *
 * @author RAISA
 */
public class JpaHibernate {

    public static void main(String[] args) {
        EntityManager entityManager = SessionHelper.getEntityManager();
        RoleDAO roleDao = new RoleDAO();

        // create
       // Role roleAdmin = new Role("ADMIN", "Le rôle Administrateur"); 
       // roleDao.create(roleAdmin);
       Role roleTech = new Role("TECHNICIEN", "Le rôle de Technicien"); 
       roleDao.create(roleTech);

        // find
        //Role founded = roleDao.findById(1L);
        //System.out.println("Role CREATED : " + founded);

        // update
        //Role roleData = new Role();
        //roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");

        //roleDao.update(1L, roleData);

        // find
        //Role updated = roleDao.findById(1L);
        //System.out.println("Role UPDATED : " + updated);
        
        //find all
        for (Role role: roleDao.findAll()){
            System.out.println("Role UPDATED : "+role.toString());
        }

        entityManager.close();
    }
}
