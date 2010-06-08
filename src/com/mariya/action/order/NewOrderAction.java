package com.mariya.action.order;

import com.mariya.dao.CustomerDAO;
import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OrderDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.*;
import com.mariya.form.OrderForm;
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

public class NewOrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        List<Employer> employers = getEmployerDAO().findAllByOfficeID(customer.getOffice().getId());
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);

        Long productId = Utils.getLongParameter(request, Constants.PRODUCT_ID);
        Product product = getProductDAO().findById(productId);

        OrderForm orderForm = (OrderForm)form;
        orderForm.setProduct(product.getId());
        orderForm.setProductName(product.getName());
        orderForm.setProductPrice(product.getPrice().floatValue());

        orderForm.setCustomer(customer.getId());
        orderForm.setCustomerName(customer.getOffice().getName());

        return mapping.findForward("create");
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

    private EmployerDAO employerDAO;
    private ProductDAO productDAO;
}