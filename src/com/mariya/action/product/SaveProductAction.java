package com.mariya.action.product;

import com.mariya.action.BaseAction;
import com.mariya.dao.ProductCategotyDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.entity.Product;
import com.mariya.form.ProductForm;
import com.mariya.utils.Constants;
import com.mariya.utils.FileUtil;
import com.mariya.utils.Utils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import javax.jnlp.FileContents;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SaveProductAction extends BaseAction {

    private ProductDAO productDAO;
    private ProductCategotyDAO productCategotyDAO;

    public ProductCategotyDAO getProductCategotyDAO() {
        return productCategotyDAO;
    }

    public void setProductCategotyDAO(ProductCategotyDAO productCategotyDAO) {
        this.productCategotyDAO = productCategotyDAO;
    }

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Product product = Utils.getProduct(form);

        ProductForm productForm = (ProductForm) form;

        product.setProductCategory(getProductCategotyDAO().findByID(new Long(productForm.getCategory())));

        FormFile uploadedFile = productForm.getProductImage();

        String uploadedFilePath = request.getRealPath("") + Constants.UPLOAD_DIRECTORY;

        String fileName = "";

        try {
            // Precreate an unique file and then write the InputStream of the uploaded file to it.
            String uploadedFileName = FileUtil.trimFilePath(uploadedFile.getFileName());
            uploadedFileName = uploadedFileName.replace(" ", "_");
            File uniqueFile = FileUtil.uniqueFile(new File(uploadedFilePath), uploadedFileName);
            FileUtil.write(uniqueFile, uploadedFile.getInputStream());
            fileName = uniqueFile.getName();

            product.setImagePath(Constants.UPLOAD_DIRECTORY + "/" + fileName);

            System.out.println(uploadedFilePath + "/" + fileName);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (product.getId() != null) {
            Product savedProduct = getProductDAO().findById(product.getId());
            savedProduct.populate(product);
            getProductDAO().save(savedProduct);
        } else {
            getProductDAO().save(product);
        }

        return mapping.findForward("list");
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
