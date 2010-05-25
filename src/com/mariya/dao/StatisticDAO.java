package com.mariya.dao;

import com.mariya.view.ViewBean;
import com.mariya.entity.Office;

import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class StatisticDAO extends BaseDAO{

    public List findEmployersNoWorking(){
        List result;
        String query = "from Employer as emp where emp.sales < emp.quota";
        result = executeQuery(query, new String []{}, new Object[]{});
        return result;
    }

    public List findEmployersWork(){
        List result = new ArrayList();
        String query = "select emp.name, avg(ord.amount * prod.price) " +
                " from Employer as emp, Order as ord, Product as prod " +
                " where ord.employee.id = emp.id and ord.product.id = prod.id " +
                " group by emp.name";
        List<Object[]> queryResult = executeQuery(query, new String []{}, new Object[]{});
        for(Object[] element : queryResult){
            result.add(new ViewBean((String)element[0], (Double)element[1]));
        }
        return result;
    }

    public List findMinMaxOffice(){
        List result = new ArrayList();
        String query =  " select emp.office.id, min(emp.quota), max(emp.quota) " +
                        " from Employer as emp " +
                        " group by emp.office.id ";
        List<Object[]> queryResult = executeQuery(query, new String []{}, new Object[]{});
        for(Object[] element : queryResult){

             Office office = (Office) getEntityById(Office.class, (Long)element[0]);

            result.add(new ViewBean(office.getRegion() + ":" + office.getCity(), element[1], element[2]));
        }
        return result;
    }
}
