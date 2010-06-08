package com.mariya.action.product;

import com.mariya.dao.ProductDAO;
import com.mariya.entity.Product;
import com.mariya.form.ProductForm;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.apache.commons.validator.Form;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditProductAction extends Action {

    private ProductDAO productDAO;

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Long productId = Utils.getLongParameter(request, Constants.PRODUCT_ID);
        Product product = getProductDAO().findById(productId);

        ProductForm productForm = (ProductForm) form;
        productForm.setId(product.getId());
        productForm.setName(product.getName());
        productForm.setCost(product.getPrice().floatValue());
        Integer count = product.getCount();
        productForm.setCount(count == null ? 0 : count);
        productForm.setActive(product.getActive() == 1);
//        productForm.setProductImage(new FormFile());
        
        return mapping.findForward("edit");
    }


}