package com.mariya.action;

import com.mariya.dao.EmployerDAO;
import com.mariya.dao.OfficeDAO;
import com.mariya.dao.UserDAO;
import com.mariya.entity.Employer;
import com.mariya.entity.Office;
import com.mariya.entity.User;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserAction extends Action {

    private UserDAO userDao;

    public UserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDAO userDao) {
        this.userDao = userDao;
    }

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LIST_ACTION)) {
            List<User> users = getUserDao().findAll();
            request.setAttribute(Constants.USER_LIST, users);
            return mapping.findForward("list");
        } else if (action.equals(Constants.EDIT_ACTION)) {


        } else if (action.equals(Constants.CREATE_ACTION)) {


        } else if (action.equals(Constants.DELETE_ACTION)) {


        }

        List<User> users = getUserDao().findAll();
        request.setAttribute(Constants.USER_LIST, users);
        return mapping.findForward("list");
    }

}
