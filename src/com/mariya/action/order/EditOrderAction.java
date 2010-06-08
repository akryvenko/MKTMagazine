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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class EditOrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Customer customer = null;
        Employer employee = null;

        Object userInfo = ((CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserInfo();
        if (userInfo instanceof Customer) {
            customer = (Customer) userInfo;
        }

        Long orderId = Utils.getLongParameter(request, Constants.ORDER_ID);
        Order order = getOrderDAO().findById(orderId);

        List<Employer> employers = getEmployerDAO().findAllByOfficeID(customer.getOffice().getId());
        request.getSession().setAttribute(Constants.EMPLOYER_LIST, employers);

        Product product = order.getProduct();

        List<Product> products = getProductDAO().findAll();
        request.getSession().setAttribute(Constants.PRODUCT_LIST, products);

        OrderForm orderForm = (OrderForm)form;
        orderForm.setId(order.getId());

        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        orderForm.setDate(format.format(order.getDate()));
        orderForm.setProductCount(order.getProductCount() != null ? order.getProductCount().toString() : "");

        orderForm.setProduct(product.getId());
        orderForm.setProductName(product.getName());
        orderForm.setProductPrice(product.getPrice().floatValue());

        orderForm.setCustomer(customer.getId());
        orderForm.setCustomerName(customer.getOffice().getName());
        
        orderForm.setEmployee(order.getEmployee().getId().toString());
        
        orderForm.setStatus(order.getStatus() == null ? 1 : order.getStatus());

        return mapping.findForward("edit");
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
