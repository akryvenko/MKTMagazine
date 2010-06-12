package com.mariya.action.employee;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
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

        if (employee.getUser() != null) {
            employerForm.setUsername(employee.getUser().getUsername());
            employerForm.setPassword(employee.getUser().getPassword());
        }

        employerForm.setOffice(employee.getOffice().getId());
        employerForm.setManager(employee.getManager() != null ? employee.getManager().getId() : null);
        employerForm.setQuota(employee.getQuota() == null ? 0 : employee.getQuota().floatValue());
        employerForm.setSales(employee.getSales() == null ? 0 : employee.getSales().floatValue());
        employerForm.setActive(employee.getActive() == 1);

        List<Employer> employers = getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), true);
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);


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