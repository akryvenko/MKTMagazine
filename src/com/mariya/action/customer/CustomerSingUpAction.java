package com.mariya.action.customer;

import com.mariya.action.BaseAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 27.05.2010
 * Time: 2:00:37
 * To change this template use File | Settings | File Templates.
 */
public class CustomerSingUpAction extends BaseAction {

    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
        return mapping.findForward("success");
    }
}
