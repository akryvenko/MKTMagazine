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

public class EditEmployeeAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        Long employeeId = Utils.getLongParameter(request, Constants.EMPLOYER_ID);
        Employer employee = getEmployerDAO().findById(employeeId);

        EmployerForm employerForm = (EmployerForm) form;
        employerForm.setId(employee.getId());
        employerForm.setFirstName(employee.getFirstName());
        employerForm.setLastName(employee.getLastName());
        employerForm.setMail(employee.getMail());
        employerForm.setPhone(employee.getPhone());
        employerForm.setAge(employee.getAge());
        employerForm.setUsername(employee.getUser().getUsername());
        employerForm.setPassword(employee.getUser().getPassword());
        employerForm.setOffice(employee.getOffice().getId());
        employerForm.setTitle(employee.getTitle());
        employerForm.setManager(employee.getManager() != null ? employee.getManager().getId() : null);
        employerForm.setQuota(employee.getQuota().floatValue());
        employerForm.setSales(employee.getSales().floatValue());

        List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);

        List<Office> offices = getOfficeDAO().findAllByCustomerID(customer.getId());
        request.getSession().setAttribute(Constants.OFFICE_LIST, offices);

        return mapping.findForward("edit");
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