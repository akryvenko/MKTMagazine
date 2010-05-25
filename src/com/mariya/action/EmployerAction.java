package com.mariya.action;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.enums.UserRoles;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class EmployerAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)) {
            List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)) {

            Long employeeId = Utils.getLongParameter(request, Constants.EMPLOYER_ID);
            Employer Employer = getEmployerDAO().findById(employeeId);
            request.setAttribute(Constants.EMPLOYER, Employer);

            List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            List<Office> offices = getOfficeDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.OFFICE_LIST, offices);

            return mapping.findForward("edit");
        } else if (action.equals(Constants.SAVE_ACTION)) {
            Employer employer = Utils.getEmployer(form, employerDAO, officeDAO);
            employer.setUser(Utils.getUser(request, UserRoles.Manager.getRoleName()));

            if (employer.getId() != null) {
                Employer savedEmployee = getEmployerDAO().findById(employer.getId());
                savedEmployee.populate(employer);
                getEmployerDAO().save(savedEmployee);
            } else {
                getEmployerDAO().save(employer);
            }

            List<Employer> products = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, products);
            return mapping.findForward("list");
        } else if (action.equals(Constants.CREATE_ACTION)) {

            List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            List<Office> offices = getOfficeDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.OFFICE_LIST, offices);

            return mapping.findForward("create");
        } else if (action.equals(Constants.DELETE_ACTION)) {

            Long employerId = Utils.getLongParameter(request, Constants.EMPLOYER_ID);
            getEmployerDAO().deleteById(employerId);

            List<Employer> Employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, Employers);

            return mapping.findForward("list");
        }

        List<Employer> Employers = getEmployerDAO().findAll();
        request.setAttribute(Constants.EMPLOYER_LIST, Employers);
        return mapping.findForward("list");
    }

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    private EmployerDAO employerDAO;

    public OfficeDAO getOfficeDAO() {
        return officeDAO;
    }

    public void setOfficeDAO(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    private OfficeDAO officeDAO;

}
