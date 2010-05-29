package com.mariya.action;

import com.mariya.dao.CustomerDAO;
import com.mariya.entity.Customer;
import com.mariya.enums.UserRoles;
import com.mariya.utils.Utils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 27.05.2010
 * Time: 1:40:59
 * To change this template use File | Settings | File Templates.
 */
public class RegisterCustomerAction extends BaseAction {

    private CustomerDAO customerDAO;

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = Utils.getCustomer(form);
        customer.setUser(Utils.getUser(request, UserRoles.Customer.getRoleName()));
        getCustomerDAO().save(customer);

        return mapping.findForward("success");
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
