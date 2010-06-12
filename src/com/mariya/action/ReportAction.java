package com.mariya.action;

import com.mariya.dao.OrderDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.enums.OrderStatus;
import com.mariya.report.EmployeeListReport;
import com.mariya.report.OrderListReport;
import com.mariya.utils.Constants;
import com.mariya.utils.FileUtil;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 08.06.2010
 * Time: 23:34:56
 * To change this template use File | Settings | File Templates.
 */
public class ReportAction extends BaseAction {

    private OrderDAO orderDAO;

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        String report = (String) request.getParameter("report");

        String reportDirectory = request.getRealPath("") + Constants.REPORT_DIRECTORY;
        File uniqueReportName = null;

        if (report.equals("employeeList")) {
            try {
                String reportName = "EmployeeList.pdf";
                uniqueReportName = FileUtil.uniqueFile(new File(reportDirectory), reportName);
                EmployeeListReport employeeListReport = new EmployeeListReport(uniqueReportName);
                employeeListReport.generate(customer.getOffice(), customer.getOffice().getEmployees());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (report.equals("orderList")) {
            try {
                String reportName = "OrderList.pdf";
                uniqueReportName = FileUtil.uniqueFile(new File(reportDirectory), reportName);
                OrderListReport employeeListReport = new OrderListReport(uniqueReportName);
                employeeListReport.generate(customer.getOffice(), getOrderDAO().findAllByOfficeIdAndStatus(customer.getOffice().getId(), OrderStatus.InProgress));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            //set content-type to binary stream
            response.setContentType("application/octet-stream");

            //prepare input stream
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(uniqueReportName));

            //prepare output stream
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());

            //start reading and writing data
            byte[] buf = new byte[4 * 1024];
            int bytesRead;
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
            in.close();
            out.close();

        } catch (Exception e) {

        }

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
