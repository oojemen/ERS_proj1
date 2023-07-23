/*

package com.revature.services;

import com.revature.exceptions.ReimbNotFoundtException;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.daos.UserDAO;
import com.revature.exceptions.ReimbNotFoundtException;
import com.revature.models.Reimbursement;
import com.revature.models.Status;
import org.aspectj.weaver.patterns.IToken;
import org.springframework.stereotype.Service;
import com.revature.security.TokenGenerator;
import java.util.List;

import java.util.Optional;

@Service
public class ReimbursementService {

    private final ReimbursementDAO reimbursementDAO;

    private final UserDAO userDAO;

    private final StatusDAO statusDAO;
    private final TokenGenerator tokenGenerator;


    public ReimbursementService(ReimbursementDAO reimbursementDAO, UserDAO userDAO, StatusDAO statusDAO, TokenGenerator tokenGenerator) {
        this.reimbursementDAO = reimbursementDAO;
        this.userDAO = userDAO;
        this.statusDAO = statusDAO;
        this.tokenGenerator = tokenGenerator;


    }

    public List<Reimbursement> getAllReimbursements(){
        return  reimbursementDAO.findAll();
    }

    public Reimbursement getReimbursementById(int id){
        return reimbursementDAO.findById(id).orElseThrow(() -> new ReimbNotFoundtException("No reimbursement found with id: " + id));
    }

    public Reimbursement addReimbursement(Reimbursement r, String token){
        String username = tokenGenerator.getUsernameFromToken(token);
        r.setUser(userDAO.findByUsername(username).get());
        r.setStatus(statusDAO.findByName("Pending"));
        Reimbursement returnedReimbursement = reimbursementDAO.save(r);
        if (returnedReimbursement.getId() > 0){
            return returnedReimbursement;
        } else {
            return null;
        }
    }

    public Reimbursement updateReimbursement(Reimbursement r){
        return reimbursementDAO.save(r);
    }



}


 */


package com.revature.services;

import com.revature.exceptions.ReimbNotFoundtException;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.StatusDAO;
import com.revature.daos.UserDAO;
import com.revature.models.Reimbursement;
//import com.revature.models.Status;
import org.springframework.stereotype.Service;
import com.revature.security.TokenGenerator;

import java.util.List;

@Service
public class ReimbursementService {

    private final ReimbursementDAO reimbursementDAO;
    private final UserDAO userDAO;
    private final StatusDAO statusDAO;
    private final TokenGenerator tokenGenerator;

    public ReimbursementService(ReimbursementDAO reimbursementDAO, UserDAO userDAO, StatusDAO statusDAO, TokenGenerator tokenGenerator) {
        this.reimbursementDAO = reimbursementDAO;
        this.userDAO = userDAO;
        this.statusDAO = statusDAO;
        this.tokenGenerator = tokenGenerator;
    }

    public List<Reimbursement> getAllReimbursements() {
        return reimbursementDAO.findAll();
    }

    public Reimbursement getReimbursementById(int id) {
        return reimbursementDAO.findById(id).orElseThrow(() -> new ReimbNotFoundtException("No reimbursement found with id: " + id));
    }

    public Reimbursement addReimbursement(Reimbursement r, String token) {
        String username = tokenGenerator.getUsernameFromToken(token);
        r.setUser(userDAO.findByUsername(username).get());
        r.setStatus(statusDAO.findByName("Pending"));
        Reimbursement returnedReimbursement = reimbursementDAO.save(r);
        if (returnedReimbursement.getId() > 0) {
            return returnedReimbursement;
        } else {
            return null;
        }
    }

    public Reimbursement updateReimbursement(Reimbursement r) {
        return reimbursementDAO.save(r);
    }

}
