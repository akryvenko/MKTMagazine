package com.mariya.action.employee;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.form.EmployerForm;
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

public class NewEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        EmployerForm employerForm = (EmployerForm) form;
        employerForm.setOffice(customer.getOffice().getId());

        List<Employer> employers = getEmployerDAO().findAllByOfficeID(customer.getOffice().getId());
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);

        return mapping.findForward("success");
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