package com.mariya.action.product.category;

import com.mariya.action.BaseAction;
import com.mariya.dao.ProductCategotyDAO;
import com.mariya.entity.Product;
import com.mariya.entity.ProductCategory;
import com.mariya.form.ProductCategotyForm;
import com.mariya.form.ProductForm;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditCategoryAction extends BaseAction {

    private ProductCategotyDAO productCategotyDAO;

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Long id = Utils.getLongParameter(request, "id");
        ProductCategory category = productCategotyDAO.findByID(id);
        
        ProductCategotyForm categoryForm = (ProductCategotyForm) form;
        categoryForm.setId(category.getId());
        categoryForm.setName(category.getName());
        categoryForm.setActive(category.getActive() == 1);

        return mapping.findForward("edit");
    }
}