package com.mariya.dao;

import com.mariya.entity.Product;

import java.util.List;

public class ProductDAO extends BaseDAO {

    private static String PRODUCT_SEQUENCE = "prod_id_seq";

    public List<Product> findAll(){
        return findAll(Product.class);
    }

    public Product findById(Long productID){
        return (Product) getEntityById(Product.class, productID);
    }

    public void save(Product product){
        if (product.getId() == null)
        {
            product.setId(getNextVal(PRODUCT_SEQUENCE));
        }
       saveOrUpdateEntity(product);
    }

    public void delete(Product product){
        deleteEntity(product);
    }

    public void deleteById(Long productId){
        deleteEntityById(Product.class, productId);
    }
}
