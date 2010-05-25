package com.mariya.dao;

import com.mariya.entity.Order;

import java.util.List;

public class OrderDAO extends BaseDAO {

    private static String ORDER_SEQUENCE = "ord_id_seq";

    public List<Order> findAll() {
        return findAll(Order.class);
    }

    public Order findById(Long orderID) {
        return (Order) getEntityById(Order.class, orderID);
    }

    public void save(Order order) {
        if (order.getId() == null) {
            order.setId(getNextVal(ORDER_SEQUENCE));
        }
        saveOrUpdateEntity(order);
    }

    public void delete(Order order) {
        deleteEntity(order);
    }

    public void deleteById(Long orderId) {
        deleteEntityById(Order.class, orderId);
    }

    public List<Order> findAllByCustomerID(Long id) {

        String query = "from Order as ord where ord.employee.office.customer.id = '" + id + "'";
        List<Order> result = executeQuery(query, new String[]{}, new Object[]{});
        return result;
    }
}
