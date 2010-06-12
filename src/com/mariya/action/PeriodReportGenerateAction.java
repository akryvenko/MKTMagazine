package com.mariya.action;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.form.PeriodReportForm;
import com.mariya.report.PeriodReportListReport;
import com.mariya.utils.Constants;
import com.mariya.utils.FileUtil;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PeriodReportGenerateAction extends BaseAction {

    private EmployerDAO employerDAO;
    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        PeriodReportForm periodReportForm = (PeriodReportForm) form;

        String reportDirectory = request.getRealPath("") + Constants.REPORT_DIRECTORY;
        File uniqueReportName = null;

        Long employeeId = new Long(periodReportForm.getEmployee());

        try {
            String reportName = "PeriodOrderList.pdf";
            uniqueReportName = FileUtil.uniqueFile(new File(reportDirectory), reportName);
            PeriodReportListReport employeeListReport = new PeriodReportListReport(uniqueReportName);

            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

            Date startDate = format.parse(periodReportForm.getStartDate());
            Date endDate = format.parse(periodReportForm.getEndDate());
            employeeListReport.generate(customer.getOffice(), employerDAO.findById(employeeId), startDate, endDate, getOrderDAO().findAllEmployeeIdAndPeriod(employeeId, startDate, endDate));
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("reportPath", uniqueReportName);

        return mapping.findForward("download");
    }
}
