package com.mariya.action.product;

import com.mariya.action.BaseAction;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.Product;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductAction extends BaseAction {

    private ProductDAO productDAO;

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        getProductDAO().save(Utils.getProduct(form));
        List<Product> products = getProductDAO().findAll();
        request.setAttribute(Constants.PRODUCT_LIST, products);
        return mapping.findForward("list");
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}