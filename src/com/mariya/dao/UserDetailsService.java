package com.mariya.dao;

import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.User;
import com.mariya.enums.UserRoles;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.acegisecurity.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.dao.DataAccessException;

import java.util.List;

public class UserDetailsService extends JdbcDaoImpl {

    private CustomerDAO customerDAO;

    @Override
    public UserDetails loadUserByUsername(String username) {
        try {
            UserDetails user = super.loadUserByUsername(username);
            Object userInfo = null;
            if (user.getAuthorities()[0].getAuthority().equalsIgnoreCase(UserRoles.Customer.getRoleName())) {
                String query = "from Customer as cust where cust.user.username = '"+ username + "'";
                List result = customerDAO.executeQuery(query, new String []{}, new Object[]{});
                userInfo = result.get(0);
            } else if (user.getAuthorities()[0].getAuthority().equalsIgnoreCase(UserRoles.Manager.getRoleName())) {
                String query = "from Employer as emp where emp.user.username = '"+ username + "'";
                List result = customerDAO.executeQuery(query, new String []{}, new Object[]{});
                userInfo = result.get(0);
            }

            if (userInfo != null) {
                return new CustomUser(user.getUsername(), user.getPassword(), user.isEnabled(), user.getAuthorities(), userInfo);
            }

            return new CustomUser(user.getUsername(), user.getPassword(), user.isEnabled(), user.getAuthorities());
        } catch (UsernameNotFoundException ex1) {
            ex1.printStackTrace();
            throw ex1;
        } catch (DataAccessException ex2) {
            ex2.printStackTrace();
            throw ex2;
        }
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
