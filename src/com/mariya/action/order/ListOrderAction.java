package com.mariya.action.order;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Order;
import com.mariya.enums.OrderStatus;
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

public class ListOrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;
        Employer employee = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        String status = (String) request.getParameter("statusFilter");
        String managerFilter = (String) request.getParameter("managerFilter");
        String productFilter = (String) request.getParameter("productFilter");


        OrderStatus orderStatus = null;
        Long productId = null;
        Long employeeId = null;

        List<Order> orders = new ArrayList();

        if (status == null || status.equals("active")) {
            orderStatus = OrderStatus.InProgress;
        } else if (status.equals("all")) {
            orderStatus = null;
        } else if (status.equals("closed")) {
            orderStatus = OrderStatus.Finished;
        } else if (status.equals("canceled")) {
            orderStatus = OrderStatus.Canceled;
        }

        if (productFilter != null && !productFilter.equals("")) {
            productId = new Long(productFilter);
        }

        if (managerFilter != null && !managerFilter.equals("")) {
            employeeId = new Long(managerFilter);
        }

        orders.addAll(getOrderDAO().findAllByParams(customer.getOffice().getId(), orderStatus, productId, employeeId));

        request.setAttribute(Constants.ORDER_LIST, orders);
        request.setAttribute(Constants.EMPLOYER_LIST, getEmployerDAO().findAllByOfficeID(customer.getOffice().getId(), true));
        request.setAttribute(Constants.PRODUCT_LIST, getProductDAO().findAllByState(true));

        return mapping.findForward("list");
    }


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

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private OrderDAO orderDAO;
    private EmployerDAO employerDAO;
    private ProductDAO productDAO;
}