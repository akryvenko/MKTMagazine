package com.mariya.action.office;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.form.OfficeForm;
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

public class EditOfficeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        Long productId = Utils.getLongParameter(request, Constants.OFFICE_ID);
        Office office = getOfficeDAO().findById(productId);

        OfficeForm officeForm = (OfficeForm) form;
        officeForm.setId(office.getId());
        officeForm.setName(office.getName());
        officeForm.setCity(office.getCity());
        officeForm.setRegion(office.getRegion());
        officeForm.setAddress(office.getAddress());
        officeForm.setPhone(office.getPhone());
        officeForm.setMail(office.getMail());
        officeForm.setTarget(office.getTarget().longValue());
        officeForm.setSales(office.getSales().longValue());

        return mapping.findForward("edit");
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