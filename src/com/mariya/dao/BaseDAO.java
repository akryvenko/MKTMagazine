package com.mariya.dao;

import org.hibernate.SessionFactory;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.dao.support.DataAccessUtils;

import java.io.Serializable;
import java.util.List;
import java.math.BigInteger;

public class BaseDAO extends HibernateDaoSupport {

    protected static String CUSTOMER_SEQUENCE = "cust_id_seq";
    protected static String USER_SEQUENCE = "user_id_seq";
    protected static String AUTHORITY_SEQUENCE = "auth_id_seq";

    protected Object getEntityById(Class clazz, Serializable id)
	{
        Object o = getHibernateTemplate().get(clazz, id);
        getSession().flush();
        getSession().close();
        return o;
	}

	protected void saveEntity(Object entity)
	{
		getHibernateTemplate().persist(entity);
        getSession().flush();
        getSession().close();
	}

	protected void saveOrUpdateEntity(Object entity)
	{
		getHibernateTemplate().saveOrUpdate(entity);
        getSession().flush();
        getSession().close();
	}

	protected void updateEntity(Object entity)
	{
		getHibernateTemplate().update(entity);
        getSession().flush();
        getSession().close();
	}

	protected void deleteEntity(Object entity)
	{
		getHibernateTemplate().delete(entity);
        getSession().flush();
        getSession().close();
	}

	protected void deleteEntityById(Class clazz, Serializable id)
	{
		Object entity = getEntityById(clazz, id);
		if (entity != null)
		{
			deleteEntity(entity);
		}
        getSession().flush();
        getSession().close();
	}

	protected List findAll(Class clazz)
	{
        List list = getHibernateTemplate().loadAll(clazz);
        getSession().flush();
        getSession().close();
        return list;
	}

	protected List findAll(Class clazz, String orderBy)
	{
        List criteria = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).addOrder(Order.asc(orderBy)));
        getSession().flush();
        getSession().close();
        return criteria;
	}

	protected List findFiltered(Class clazz, String property, Object filter)
	{
        List criteria = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Expression.eq(property, filter)));
        getSession().flush();
        getSession().close();
        return criteria;
	}

	protected List findFiltered(Class clazz, String property, Object filter, String orderBy)
	{
        List criteria = getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Expression.eq(property, filter)).addOrder(Order.asc(orderBy)));
        getSession().flush();
        getSession().close();
        return criteria;
	}

	protected Object findUniqueFiltered(Class clazz, String property, Object filter)
	{
        Object o = DataAccessUtils.requiredUniqueResult(getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Expression.eq(property, filter))));
        getSession().flush();
        getSession().close();
        return o;
	}

	protected Object findUniqueFiltered(Class clazz, String property, Object filter, String orderBy)
	{
        Object o = DataAccessUtils.requiredUniqueResult(getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz).add(Expression.eq(property, filter)).addOrder(Order.asc(orderBy))));
        getSession().flush();
        getSession().close();
        return o;
	}

    public List executeQuery(String queryString, String[] parametersNames, Object[] parametersValues)
	{
        List result = getHibernateTemplate().findByNamedParam(queryString, parametersNames, parametersValues);
        getSession().flush();
        getSession().close();
		return result;
	}

    protected Long getNextVal(String sequenceName){
        BigInteger result;
        SQLQuery query = getSession().createSQLQuery("select nextval('" + sequenceName + "')");
        result = (BigInteger) query.list().get(0);
        return result.longValue();
    }
    
}
