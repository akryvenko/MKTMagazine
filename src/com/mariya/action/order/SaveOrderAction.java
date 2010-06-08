package com.mariya.action.order;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.Order;
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

public class SaveOrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        Order order = Utils.getOrder(form, employerDAO, productDAO);

        if (order.getId() != null) {
            Order savedOrder = getOrderDAO().findById(order.getId());
            savedOrder.populate(order);
            getOrderDAO().save(savedOrder);
        } else {
            getOrderDAO().save(order);
        }

        if (customer != null) {
            request.setAttribute(Constants.CUSTOMER, customer);
            List<Order> orders = getOrderDAO().findAllByOfficeID(customer.getOffice().getId());
            request.setAttribute(Constants.ORDER_LIST, orders);
        }

        return mapping.findForward("list");
    }

    public EmployerDAO getEmployerDAO() {
        return employerDAO;
    }

    public void setEmployerDAO(EmployerDAO employerDAO) {
        this.employerDAO = employerDAO;
    }

    public CustomerDAO getCustomerDAO() {

        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }


    private CustomerDAO customerDAO;
    private EmployerDAO employerDAO;
    private ProductDAO productDAO;
    private OrderDAO orderDAO;
}