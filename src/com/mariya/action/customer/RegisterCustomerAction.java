package com.mariya.action.customer;

import com.mariya.action.BaseAction;
import com.mariya.dao.CustomerDAO;
import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.*;
import com.mariya.enums.UserRoles;
import com.mariya.form.RegistrationCustomerForm;
import com.mariya.utils.Utils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 27.05.2010
 * Time: 1:40:59
 * To change this template use File | Settings | File Templates.
 */
public class RegisterCustomerAction extends BaseAction {

    private CustomerDAO customerDAO;
    private OfficeDAO officeDAO;
    private EmployerDAO employerDAO;

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        RegistrationCustomerForm registrationCustomerForm = (RegistrationCustomerForm)form;

        Customer customer = new Customer();
        customer.setFirstName(registrationCustomerForm.getFirstName());
        customer.setLastName(registrationCustomerForm.getLastName());
        customer.setMail(registrationCustomerForm.getCustomerEmail());
        customer.setPhone(registrationCustomerForm.getCustomerPhone());
        customer.setCredit(new BigDecimal(registrationCustomerForm.getCredit()));

        User user = new User();
        user.setUsername(registrationCustomerForm.getUsername());
        user.setPassword(registrationCustomerForm.getPassword());
        user.setEnabled(1);
        user.setAuthority(new Authority(UserRoles.Customer.getRoleName()));
        customer.setUser(user);

        customer = getCustomerDAO().save(customer);

        Office office = new Office();
        office.setName(registrationCustomerForm.getOrganizationName());
        office.setCity(registrationCustomerForm.getCity());
        office.setAddress(registrationCustomerForm.getAddress());
        office.setPhone(registrationCustomerForm.getOrganizationPhone());
        office.setMail(registrationCustomerForm.getOrganizationEmail());
        office.setCustomer(customer);

        office = officeDAO.save(office);

        Employer employee = new Employer();
        employee.setFirstName(registrationCustomerForm.getFirstName());
        employee.setLastName(registrationCustomerForm.getLastName());
        employee.setMail(registrationCustomerForm.getCustomerEmail());
        employee.setPhone(registrationCustomerForm.getCustomerPhone());
        employee.setOffice(office);

        employerDAO.save(employee);

        return mapping.findForward("success");
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public OfficeDAO getOfficeDAO() {
        return officeDAO;
    }

    public void setOfficeDAO(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }
}
