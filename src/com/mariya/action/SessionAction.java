package com.mariya.action;

import com.mariya.entity.Customer;
import com.mariya.entity.Employer;
import com.mariya.utils.Constants;
import com.mariya.utils.Utils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SessionAction extends BaseAction {


    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String action = (String) request.getParameter(Constants.ACTION);

        if (action.equals(Constants.LOGIN_ACTION)){
            return mapping.findForward("list");
        } else if (action.equals(Constants.LOGOUT_ACTION)){

            return mapping.findForward("edit");
        }

        return mapping.findForward("list");
    }
}
