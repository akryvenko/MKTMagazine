package com.mariya.dao;

import com.mariya.entity.Employer;
import com.mariya.entity.Order;

import java.util.List;

public class EmployerDAO extends BaseDAO{

private static String EMPLOYER_SEQUENCE = "emp_id_seq";

    public List<Employer> findAll(){
        List all = findAll(Employer.class);
        getSession().flush();
        return all;
    }

    public Employer findById(Long employerID){
        Employer employer = (Employer) getEntityById(Employer.class, employerID);
        getSession().flush();
        return employer;
    }

    public void save(Employer employer){
        if (employer.getId() == null)
        {
            employer.setId(getNextVal(EMPLOYER_SEQUENCE));
        }

         if (employer.getUser() != null && employer.getUser().getId() == null){
            employer.getUser().setId(getNextVal(USER_SEQUENCE));
        }

        if (employer.getUser() != null && employer.getUser().getAuthority().getId() == null){
            employer.getUser().getAuthority().setId(getNextVal(AUTHORITY_SEQUENCE));
        }

        saveOrUpdateEntity(employer);
        getSession().flush();
    }

    public void delete(Employer employer){
        deleteEntity(employer);
        getSession().flush();
    }

    public void deleteById(Long employerId){
        deleteEntityById(Employer.class, employerId);
        getSession().flush();
    }

    public List<Employer> findAllByCustomerID(Long id) {
        String query = "from Employer as emp where emp.office.customer.id = '" + id + "'";
        List<Employer> result = executeQuery(query, new String[]{}, new Object[]{});
        getSession().flush();
        return result;
    }
}
