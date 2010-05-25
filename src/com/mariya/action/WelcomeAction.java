package com.mariya.action;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Employer;
import com.mariya.entity.Product;
import com.mariya.enums.UserRoles;
import com.mariya.utils.Constants;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class WelcomeAction extends Action {

    private ProductDAO productDAO;
    private CustomerDAO customerDAO;

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

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!(principal instanceof String)) {

            String userRole = ((UserDetails) principal).getAuthorities()[0].getAuthority();

            Object userInfo = ((CustomUser) principal).getUserInfo();
            if (userRole.equalsIgnoreCase(UserRoles.Manager.getRoleName())) {

                Employer employer = (Employer) userInfo;
                request.setAttribute(Constants.ORDER_LIST, employer.getOrders());
                Object customer = customerDAO.findByEmployeeId(employer.getId());
                request.setAttribute(Constants.CUSTOMER, customer);
                return mapping.findForward("manager_welcome");

            } else if (userRole.equalsIgnoreCase(UserRoles.Customer.getRoleName())) {
                List<Product> products = getProductDAO().findAll();
                request.setAttribute(Constants.PRODUCT_LIST, products);
                return mapping.findForward("welcome");
            } else if (userRole.equalsIgnoreCase(UserRoles.ProductManager.getRoleName())) {
                List<Product> products = getProductDAO().findAll();
                request.setAttribute(Constants.PRODUCT_LIST, products);
                return mapping.findForward("pm_welcome");
            }

        }

        List<Product> products = getProductDAO().findAll();
        request.setAttribute(Constants.PRODUCT_LIST, products);
        return mapping.findForward("welcome");
    }

}
