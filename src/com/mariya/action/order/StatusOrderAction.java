package com.mariya.action.order;

import com.mariya.dao.OrderDAO;
import com.mariya.entity.CustomUser;
import com.mariya.entity.Employer;
import com.mariya.entity.Order;
import com.mariya.enums.OrderStatus;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.acegisecurity.context.SecurityContextHolder;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatusOrderAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        Long orderId = Utils.getLongParameter(request, Constants.ORDER_ID);
        Order order = getOrderDAO().findById(orderId);

        Order savedOrder = getOrderDAO().findById(order.getId());
        savedOrder.populate(order);

        String status = (String) request.getParameter(Constants.STATUS);

        if (status.equals("cancel")) {
            savedOrder.setStatus(OrderStatus.Canceled.getStatusValue());
        } else if (status.equals("finish")) {
            savedOrder.setStatus(OrderStatus.Finished.getStatusValue());
        }

        getOrderDAO().save(savedOrder);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Employer employer = (Employer) ((CustomUser) principal).getUserInfo();
        request.setAttribute(Constants.ORDER_LIST, orderDAO.findAllByEmployeeID(employer.getId(), OrderStatus.InProgress));

        return mapping.findForward("employee_list");
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    private OrderDAO orderDAO;
}