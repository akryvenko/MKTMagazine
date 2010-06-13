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

public class RegisterCustomerAction extends BaseAction {

    private CustomerDAO customerDAO;
    private OfficeDAO officeDAO;
    private EmployerDAO employerDAO;

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        RegistrationCustomerForm registrationCustomerForm = (RegistrationCustomerForm)form;

        Customer customer = new Customer();

        User user = new User();
        user.setUsername(registrationCustomerForm.getUsername());
        user.setPassword(registrationCustomerForm.getPassword());
        user.setEnabled(1);
        user.setAuthority(new Authority(UserRoles.Customer.getRoleName()));
        customer.setUser(user);

        Office office = new Office();
        office.setName(registrationCustomerForm.getOrganizationName());
        office.setCity(registrationCustomerForm.getCity());
        office.setAddress(registrationCustomerForm.getAddress());
        office.setPhone(registrationCustomerForm.getOrganizationPhone());
        office.setMail(registrationCustomerForm.getOrganizationEmail());
        customer.setOffice(office);

        customer = getCustomerDAO().save(customer);

        office = customer.getOffice();

        Employer employee = new Employer();
        employee.setFirstName(registrationCustomerForm.getFirstName());
        employee.setLastName(registrationCustomerForm.getLastName());
        employee.setMail(registrationCustomerForm.getCustomerEmail());
        employee.setPhone(registrationCustomerForm.getCustomerPhone());
        employee.setActive(1);
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
