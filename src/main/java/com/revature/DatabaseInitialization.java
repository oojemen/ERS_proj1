package com.revature;

/* 

import com.revature.daos.UserDAO;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.RoleDAO;
import com.revature.daos.StatusDAO;
import com.revature.models.User;
import com.revature.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInitialization {


    UserDAO userDAO;
    ReimbursementDAO reimbursementDAO;
    RoleDAO roleDAO;
    StatusDAO statusDAO;

    @Autowired
    public DatabaseInitialization(UserDAO userDAO, ReimbursementDAO reimbursementDAO, RoleDAO roleDAO, StatusDAO statusDAO) {
        this.userDAO = userDAO;
        this.reimbursementDAO = reimbursementDAO;
        this.roleDAO = roleDAO;
        this.statusDAO = statusDAO;
    }

    @PostConstruct
    public void InItDatabase() {
        //Delete the data first...
        roleDAO.deleteAll();
        userDAO.deleteAll();
        reimbursementDAO.deleteAll();


        //Insert some dummy data...

        //ROLES table
        Role role1 = new Role(1, "Employee");
        Role role2 = new Role(2, "Finance Manager");
        roleDAO.save(role1);
        roleDAO.save(role2);

        //people table
        User person1 = new User(1, "Kelvin","Ben", "kben123", "password123", roleDAO.findByRoleTitle("Finance Manager"));
        userDAO.save(person1);

        
    }



}


 */
