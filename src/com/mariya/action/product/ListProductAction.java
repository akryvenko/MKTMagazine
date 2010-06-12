package com.mariya.action.product;

import com.mariya.dao.ProductDAO;
import com.mariya.entity.Product;
import com.mariya.utils.Constants;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ListProductAction extends Action {

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {


        String active = (String) request.getParameter("activeFilter");

        List<Product> products = new ArrayList();

        if (active == null || active.equals("active")) {
            products.addAll(getProductDAO().findAllByState(true));
        } else if (active.equals("all")) {
            products.addAll(getProductDAO().findAll());
        } else if (active.equals("unactive")) {
            products.addAll(getProductDAO().findAllByState(false));
        }

        request.setAttribute(Constants.PRODUCT_LIST, products);
        return mapping.findForward("list");

    }

    private ProductDAO productDAO;
}