package com.mariya.action;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
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

public class OfficeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }


        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)) {
            List<Office> offices = getOfficeDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.OFFICE_LIST, offices);
            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)) {
            Long productId = Utils.getLongParameter(request, Constants.OFFICE_ID);
            Office office = getOfficeDAO().findById(productId);
            request.setAttribute(Constants.OFFICE, office);

            List<Employer> employers = getEmployerDAO().findAll();
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("edit");
        } else if (action.equals(Constants.SAVE_ACTION)) {

            if (customer != null) {
                Office office = Utils.getOffice(form, customer);
                if (office.getId() != null) {
                    Office savedOffice = getOfficeDAO().findById(office.getId());
                    savedOffice.populate(office);
                    getOfficeDAO().save(savedOffice);
                } else {
                    getOfficeDAO().save(office);
                }
            }

            List<Office> officeList = getOfficeDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.OFFICE_LIST, officeList);
            return mapping.findForward("list");
        } else if (action.equals(Constants.CREATE_ACTION)) {

            List<Employer> employers = getEmployerDAO().findAll();
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            return mapping.findForward("create");
        } else if (action.equals(Constants.DELETE_ACTION)) {
            Long officeId = Utils.getLongParameter(request, Constants.OFFICE_ID);
            getOfficeDAO().deleteById(officeId);
            List<Office> offices = getOfficeDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.OFFICE_LIST, offices);
            return mapping.findForward("list");
        }

        List<Office> offices = getOfficeDAO().findAll();
        request.setAttribute(Constants.OFFICE_LIST, offices);
        return mapping.findForward("list");
    }

    public OfficeDAO getOfficeDAO() {
        return officeDAO;
    }

    public void setOfficeDAO(OfficeDAO officeDAO) {
        this.officeDAO = officeDAO;
    }

    private OfficeDAO officeDAO;

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    private EmployerDAO employerDAO;
}
