package com.mariya.utils;

import com.mariya.entity.*;
import com.mariya.enums.UserRoles;
import com.mariya.form.*;
import com.mariya.dao.EmployerDAO;
import com.mariya.dao.ProductDAO;
import com.mariya.dao.CustomerDAO;
import com.mariya.dao.OfficeDAO;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Utils {

    public static Long getLongParameter(HttpServletRequest request, String parameterName) {
        String parameterValue = request.getParameter(parameterName);
        if (parameterValue == null || parameterValue.trim().equals("")) {
            return null;
        }
        return new Long(parameterValue);
    }


    public static Date convertStringToDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat(Constants.SIMPLE_DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Product getProduct(ActionForm form) {
        ProductForm productForm = (ProductForm) form;
        Product product = new Product();
        if (productForm.getId() > 0) {
            product.setId(productForm.getId());
        } else {
            product.setId(null);
        }
        product.setDescription(productForm.getDescription());
        product.setPrice(new BigDecimal(productForm.getCost()));
        product.setName(productForm.getName());
        product.setCount(productForm.getCount());
        return product;
    }

    public static Office getOffice(ActionForm form, Customer customer) {
        OfficeForm officeForm = (OfficeForm) form;
        Office office = new Office();
        if (officeForm.getId() > 0) {
            office.setId(officeForm.getId());
        } else {
            office.setId(null);
        }
        office.setCity(officeForm.getCity());
        office.setRegion(officeForm.getRegion());
        office.setCustomer(customer);
        office.setTarget(officeForm.getTarget());
        office.setSales(officeForm.getSales());
        return office;
    }

    public static Employer getEmployer(ActionForm form, EmployerDAO employerDAO, OfficeDAO officeDAO) {
        EmployerForm employerForm = (EmployerForm) form;
        Employer employer = new Employer();
        if (employerForm.getId() > 0) {
            employer.setId(employerForm.getId());
        } else {
            employer.setId(null);
        }

        employer.setFirstName(employerForm.getFirstName());
        employer.setLastName(employerForm.getLastName());
        employer.setMail(employerForm.getMail());
        employer.setPhone(employerForm.getPhone());
        employer.setAge(employerForm.getAge());
        employer.setManager(employerForm.getManager() > 0 ? employerDAO.findById(employerForm.getManager()) : null);
        employer.setTitle(employerForm.getTitle());
        employer.setOffice(employerForm.getOffice() > 0 ? officeDAO.findById(employerForm.getOffice()) : null);
        employer.setQuota(employerForm.getQuota());
        employer.setSales(employerForm.getSales());
        return employer;
    }

    public static Customer getCustomer(ActionForm form) {
        CustomerForm customerForm = (CustomerForm) form;
        Customer customer = new Customer();
        if (customerForm.getId() != null && customerForm.getId() > 0) {
            customer.setId(customerForm.getId());
        } else {
            customer.setId(null);
        }

        customer.setFirstName(customerForm.getFirstName());
        customer.setLastName(customerForm.getLastName());
        customer.setCredit(customerForm.getCredit());
        return customer;
    }

    public static User getUser(HttpServletRequest request, String userRole) {
        String userName = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");
        
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEnabled(1);
        user.setAuthority(new Authority(userRole));
        return user;
    }


    public static Order getOrder(ActionForm form, EmployerDAO employerDAO, ProductDAO productDAO) {
        OrderForm orderForm = (OrderForm) form;
        Order order = new Order();
        if (orderForm.getId() > 0) {
            order.setId(orderForm.getId());
        } else {
            order.setId(null);
        }

        order.setDate(convertStringToDate(orderForm.getDate()));
        order.setEmployee(orderForm.getEmployee() > 0 ? employerDAO.findById(orderForm.getEmployee()) : null);
        order.setProductCount(orderForm.getProductCount());
        order.setProduct(orderForm.getProduct() > 0 ? productDAO.findById(orderForm.getProduct()) : null);
        order.setAmount(orderForm.getAmount());
        return order;
    }

}
