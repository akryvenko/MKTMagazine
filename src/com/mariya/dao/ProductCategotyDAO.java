package com.mariya.dao;

import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.entity.ProductCategory;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 10.06.2010
 * Time: 23:51:01
 * To change this template use File | Settings | File Templates.
 */
public class ProductCategotyDAO extends BaseDAO {

    public List<ProductCategory> findAll() {
        return findAll(ProductCategory.class);
    }

    public void save(ProductCategory productCategory) {
        if (productCategory.getId() == null || productCategory.getId() == 0) {
            productCategory.setId(getNextVal(PRODUCT_CATEGORY_SEQUENCE));
        }

        saveOrUpdateEntity(productCategory);
        getSession().flush();
    }

    public ProductCategory findByID(Long id) {
        ProductCategory productCategory = (ProductCategory) getEntityById(ProductCategory.class, id);
        getSession().flush();
        return productCategory;
    }

    public List<ProductCategory> findAllActive() {
        String query = "from ProductCategory as pc where pc.active = '1'" ;
        List<ProductCategory> result = executeQuery(query, new String[]{}, new Object[]{});
        getSession().flush();
        return result;
    }
}
