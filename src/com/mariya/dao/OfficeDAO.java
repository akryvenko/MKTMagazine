package com.mariya.dao;

import com.mariya.entity.Office;

import java.util.List;

public class OfficeDAO extends BaseDAO {

    public List<Office> findAll() {
        List all = findAll(Office.class);
        getSession().flush();
        return all;
    }

    public Office findById(Long officeID) {
        Office office = (Office) getEntityById(Office.class, officeID);
        getSession().flush();
        return office;
    }

    public Office save(Office office) {
        if (office.getId() == null) {
            office.setId(getNextVal(OFFICE_SEQUENCE));
        }
        saveOrUpdateEntity(office);
        getSession().flush();
        
        return findById(office.getId());
    }

    public void delete(Office office) {
        deleteEntity(office);
        getSession().flush();
    }

    public void deleteById(Long officeId) {
        deleteEntityById(Office.class, officeId);
        getSession().flush();
    }

    public List<Office> findAllByCustomerID(Long id) {

        String query = "from Office as off where off.customer.id = '" + id + "'";
        List<Office> result = executeQuery(query, new String[]{}, new Object[]{});
        getSession().flush();
        return result;
    }
}
