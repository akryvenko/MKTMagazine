package com.mariya.action.order;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.*;
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

public class OrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;
        Employer employee = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        } else if (userInfo instanceof Employer) {
            employee = (Employer) userInfo;
        }

        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)) {

            if (customer != null) {
                request.setAttribute(Constants.CUSTOMER, customer);
                List<Order> orders = getOrderDAO().findAllByCustomerID(customer.getId());
                request.setAttribute(Constants.ORDER_LIST, orders);
            } else if (employee != null) {
                request.setAttribute(Constants.CUSTOMER, customerDAO.findByEmployeeId(employee.getId()));
                request.setAttribute(Constants.ORDER_LIST, employee.getOrders());
            }

            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)) {

            Long orderId = Utils.getLongParameter(request, Constants.ORDER_ID);
            Order order = getOrderDAO().findById(orderId);
            request.setAttribute(Constants.ORDER, order);

            List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            List<Product> products = getProductDAO().findAll();
            request.setAttribute(Constants.PRODUCT_LIST, products);

            request.setAttribute(Constants.CUSTOMER, customer);

            return mapping.findForward("edit");
        } else if (action.equals(Constants.SAVE_ACTION)) {

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
                List<Order> orders = getOrderDAO().findAllByCustomerID(customer.getId());
                request.setAttribute(Constants.ORDER_LIST, orders);
            }

            return mapping.findForward("list");
        } else if (action.equals(Constants.CREATE_ACTION)) {

            List<Employer> employers = getEmployerDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.EMPLOYER_LIST, employers);

            if (customer != null) {
                request.setAttribute(Constants.CUSTOMER, customer);
            }

            Long productId = Utils.getLongParameter(request, Constants.PRODUCT_ID);
            Product product = getProductDAO().findById(productId);
            request.setAttribute(Constants.PRODUCT, product);

            return mapping.findForward("create");
        } else if (action.equals(Constants.DELETE_ACTION)) {

            Long orderId = Utils.getLongParameter(request, Constants.ORDER_ID);
            getOrderDAO().deleteById(orderId);

            List<Order> orders = getOrderDAO().findAllByCustomerID(customer.getId());
            request.setAttribute(Constants.ORDER_LIST, orders);

            return mapping.findForward("list");
        }

        List<Order> orders = getOrderDAO().findAllByCustomerID(customer.getId());
        request.setAttribute(Constants.ORDER_LIST, orders);
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
