package com.mariya.dao;

import com.mariya.entity.Customer;
import com.mariya.entity.Employer;

import java.util.List;

public class CustomerDAO extends BaseDAO {



    public List<Customer> findAll(){
        return findAll(Customer.class);
    }

    public Customer findById(Long customerID){
        return (Customer) getEntityById(Customer.class, customerID);
    }

    public Customer save(Customer customer){
        if (customer.getId() == null){
            customer.setId(getNextVal(CUSTOMER_SEQUENCE));
        }

        if (customer.getUser().getId() == null){
            customer.getUser().setId(getNextVal(USER_SEQUENCE));
        }

        if (customer.getUser().getAuthority().getId() == null){
            customer.getUser().getAuthority().setId(getNextVal(AUTHORITY_SEQUENCE));
        }

       saveOrUpdateEntity(customer);

       return findById(customer.getId()); 
    }

    public void delete(Customer customer){
        deleteEntity(customer);
    }

    public void deleteById(Long customerId){
        deleteEntityById(Customer.class, customerId);
    }

    public Customer findByEmployeeId(Long id) {
        String query = "SELECT DISTINCT c FROM Employer e LEFT JOIN e.office o LEFT JOIN o.customer c  WHERE e.id = '" + id + "'";
        List<Customer> result = executeQuery(query, new String[]{}, new Object[]{});
        return result.get(0);
    }
}
