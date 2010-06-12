package com.mariya.action.product.category;

import com.mariya.action.BaseAction;
import com.mariya.dao.ProductCategotyDAO;
import com.mariya.form.ProductCategotyForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mariya.entity.ProductCategory;


public class SaveCategoryAction extends BaseAction {

    private ProductCategotyDAO productCategotyDAO;

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        ProductCategotyForm productCategotyForm = (ProductCategotyForm) form;

        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategotyForm.getId());
        productCategory.setName(productCategotyForm.getName());
        productCategory.setActive(productCategotyForm.getActive() ? 1 : 0);

        if (productCategory.getId() == null || productCategory.getId() == 0){
            getProductCategotyDAO().save(productCategory);
        } else {
            ProductCategory savedProductCategory = getProductCategotyDAO().findByID(productCategory.getId());
            savedProductCategory.populate(productCategory);
            getProductCategotyDAO().save(savedProductCategory);
        }

        return mapping.findForward("list");
    }
}