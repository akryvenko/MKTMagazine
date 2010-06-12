package com.mariya.dao;

import com.mariya.entity.Order;
import com.mariya.enums.OrderStatus;
import org.hibernate.Query;

import java.util.Date;
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

    public List<Order> findAllByOfficeIdAndStatus(Long id, OrderStatus inProgress) {

        String query = "from Order as ord where ord.employee.office.id = '" + id + "'and ord.status = '" + inProgress.getStatusValue() + "'";
        List<Order> result = executeQuery(query, new String[]{}, new Object[]{});
        return result;
    }

    public List<Order> findAllByParams(Long officeID, OrderStatus inProgress, Long productId, Long managerId) {

        String query = "from Order as ord where ord.employee.office.id = '" + officeID + "' ";

        if (inProgress != null) {
            query += "and ord.status = '" + inProgress.getStatusValue() + "' ";
        }

        if (productId != null) {
            query += "and ord.product.id = '" + productId + "' ";
        }

        if (managerId != null) {
            query += "and ord.employee.id = '" + managerId + "' ";
        }


        List<Order> result = executeQuery(query, new String[]{}, new Object[]{});
        return result;
    }

    public List<Order> findAllByEmployeeID(Long id, OrderStatus inProgress) {
        String query = "from Order as ord where ord.employee.id = '" + id + "' and ord.status = '" + inProgress.getStatusValue() + "'";
        List<Order> result = executeQuery(query, new String[]{}, new Object[]{});
        return result;
    }

    public List<Order> findAllEmployeeIdAndPeriod(Long id, Date startDate, Date endDate) {
        Query query = getSession().createQuery("from Order as ord where ord.employee.id = ? and ord.date between ? and ?");
        query.setLong(0, id);
        query.setTimestamp(1, startDate);
        query.setTimestamp(2, endDate);
        return query.list();
    }
}
