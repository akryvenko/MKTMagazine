package com.mariya.action.customer;

import com.mariya.enums.UserRoles;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.EmployerDAO;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.entity.Customer;

import java.util.List;

public class CustomerAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

	String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)){
            List<Customer> customers = getCustomerDAO().findAll();
            request.setAttribute(Constants.CUSTOMER_LIST, customers);
            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)){

            Long productId = Utils.getLongParameter(request, Constants.CUSTOMER_ID);
            Customer customer = getCustomerDAO().findById(productId);
            request.setAttribute(Constants.CUSTOMER, customer);

            List<Employer> employers = getEmployerDAO().findAll();
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("edit");
        } else if (action.equals(Constants.SAVE_ACTION)){

            Customer customer = Utils.getCustomer(form);
            getCustomerDAO().save(customer);

            List<Employer> employers = getEmployerDAO().findAll();
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("list");
        } else if (action.equals(Constants.REGISTER)){

            Customer customer = Utils.getCustomer(form);
            customer.setUser(Utils.getUser(request, UserRoles.Customer.getRoleName()));
            getCustomerDAO().save(customer);

            return mapping.findForward("login");
        } else if (action.equals(Constants.CREATE_ACTION)){

            List<Employer> employers = getEmployerDAO().findAll();
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("create");
        } else if (action.equals(Constants.DELETE_ACTION)) {

            Long customerId = Utils.getLongParameter(request, Constants.CUSTOMER_ID);
            getCustomerDAO().deleteById(customerId);

            List<Customer> customers = getCustomerDAO().findAll();
            request.setAttribute(Constants.CUSTOMER_LIST, customers);

            return mapping.findForward("list");
        } else if (action.equals(Constants.SIGNUP)) {
            return mapping.findForward("register");
        }


        List<Customer> customers = getCustomerDAO().findAll();
        request.setAttribute(Constants.CUSTOMER_LIST, customers);
        return mapping.findForward("list");
	}

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    public CustomerDAO getCustomerDAO() {

        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    private CustomerDAO customerDAO;
    private EmployerDAO employerDAO;
}
