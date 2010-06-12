package com.mariya.action.product.category;

import com.mariya.action.BaseAction;
import com.mariya.dao.ProductCategotyDAO;
import com.mariya.entity.ProductCategory;
import com.mariya.utils.Constants;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ListCategoryAction extends BaseAction {

    private ProductCategotyDAO productCategotyDAO;

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }


    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        List<ProductCategory> categories = new ArrayList();
        categories.addAll(productCategotyDAO.findAll());
        request.setAttribute(Constants.PRODUCT_CATEGORY_LIST, categories);

        return mapping.findForward("list");
    }


}
