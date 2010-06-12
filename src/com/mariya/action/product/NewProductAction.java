package com.mariya.action.product;

import com.mariya.dao.ProductCategotyDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.utils.Constants;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewProductAction extends Action {
    
    private ProductDAO productDAO;
    private ProductCategotyDAO productCategotyDAO;

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.getSession().setAttribute(Constants.PRODUCT_CATEGORY_LIST, productCategotyDAO.findAllActive());

        return mapping.findForward("success");
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }
}
