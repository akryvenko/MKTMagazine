package com.mariya.action.employee;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.utils.Constants;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ListEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        String active = (String) request.getParameter("active");

        List<Employer> employers = new ArrayList();

        if (active == null || active.equals("active")) {
            employers.addAll(getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), true));
        } else if (active.equals("all")) {
            employers.addAll(getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), true));
            employers.addAll(getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), false));
        } else if (active.equals("unactive")) {
            employers.addAll(getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), false));
        }
        
        request.setAttribute(Constants.EMPLOYER_LIST, employers);

        return mapping.findForward("list");
    }

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    private EmployerDAO employerDAO;
}