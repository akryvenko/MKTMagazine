package com.mariya.action.product;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mariya.dao.ProductDAO;
import com.mariya.entity.Product;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import com.mariya.form.ProductForm;

import java.util.List;

public class ProductAction extends Action {

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)) {
            List<Product> products = getProductDAO().findAll();
            request.setAttribute(Constants.PRODUCT_LIST, products);
            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)) {
            Long productId = Utils.getLongParameter(request, Constants.PRODUCT_ID);
            Product product = getProductDAO().findById(productId);
            request.setAttribute(Constants.PRODUCT, product);
            return mapping.findForward("edit");
        } else if (action.equals(Constants.SAVE_ACTION)) {
            getProductDAO().save(Utils.getProduct(form));
            List<Product> products = getProductDAO().findAll();
            request.setAttribute(Constants.PRODUCT_LIST, products);
            return mapping.findForward("list");
        } else if (action.equals(Constants.CREATE_ACTION)) {
            return mapping.findForward("create");
        } else if (action.equals(Constants.DELETE_ACTION)) {
            Long productId = Utils.getLongParameter(request, Constants.PRODUCT_ID);
            getProductDAO().deleteById(productId);
            List<Product> products = getProductDAO().findAll();
            request.setAttribute(Constants.PRODUCT_LIST, products);
            return mapping.findForward("list");
        }

            List<Product> products = getProductDAO().findAll();
            request.setAttribute(Constants.PRODUCT_LIST, products);
            return mapping.findForward("list");
        }

        private ProductDAO productDAO;
    }
