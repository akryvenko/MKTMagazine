package com.mariya.action;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.dao.ProductCategotyDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Employer;
import com.mariya.entity.Order;
import com.mariya.entity.Product;
import com.mariya.enums.OrderStatus;
import com.mariya.enums.UserRoles;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class WelcomeAction extends Action {

    private ProductDAO productDAO;
    private CustomerDAO customerDAO;
    private OrderDAO orderDAO;
    private ProductCategotyDAO productCategotyDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Long categoryId = Utils.getLongParameter(request, "categoryId");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof String)) {

            String userRole = ((UserDetails) principal).getAuthorities()[0].getAuthority();

            Object userInfo = ((CustomUser) principal).getUserInfo();
            if (userRole.equalsIgnoreCase(UserRoles.Manager.getRoleName())) {

                String status = (String) request.getParameter("statusFilter");

                Employer employer = (Employer) userInfo;
                List<Order> orders = new ArrayList();

                if (status == null || status.equals("opened")) {
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.InProgress));
                } else if (status.equals("all")) {
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.InProgress));
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.Finished));
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.Canceled));
                } else if (status.equals("closed")) {
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.Finished));
                } else if (status.equals("canceled")) {
                    orders.addAll(getOrderDAO().findAllByEmployeeID(employer.getId(), OrderStatus.Canceled));
                }

                request.setAttribute(Constants.ORDER_LIST, orders);
                return mapping.findForward("manager_welcome");

            } else if (userRole.equalsIgnoreCase(UserRoles.Customer.getRoleName()) || userRole.equalsIgnoreCase(UserRoles.ProductManager.getRoleName())) {

                List<Product> products = new ArrayList();

                if (categoryId == null) {
                    products.addAll(getProductDAO().findAllByState(true));
                } else {
                    products.addAll(getProductDAO().findAllActiveAndCategoryId(categoryId));
                }

                request.setAttribute(Constants.PRODUCT_CATEGORY_LIST, productCategotyDAO.findAllActive());
                request.setAttribute(Constants.PRODUCT_LIST, products);
                return mapping.findForward("welcome");
            }
        }

        List<Product> products = new ArrayList();
        if (categoryId == null) {
            products.addAll(getProductDAO().findAllByState(true));
        } else {
            products.addAll(getProductDAO().findAllActiveAndCategoryId(categoryId));
        }

        request.setAttribute(Constants.PRODUCT_CATEGORY_LIST, productCategotyDAO.findAllActive());
        request.setAttribute(Constants.PRODUCT_LIST, products);
        return mapping.findForward("welcome");
    }

}
