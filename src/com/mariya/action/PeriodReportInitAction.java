package com.mariya.action;

import com.mariya.dao.EmployerDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.form.PeriodReportForm;
import com.mariya.utils.Constants;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 12.06.2010
 * Time: 13:09:58
 * To change this template use File | Settings | File Templates.
 */
public class PeriodReportInitAction extends BaseAction {

    private EmployerDAO employerDAO;

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        PeriodReportForm periodReportForm = (PeriodReportForm) form;

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        List<Employer> employers = employerDAO.findAllByOfficeID(customer.getOffice().getId());
        
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);
        return mapping.findForward("report");
    }
}
