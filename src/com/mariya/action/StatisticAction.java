package com.mariya.action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mariya.dao.*;
import com.mariya.utils.Constants;

import java.util.List;

public class StatisticAction extends Action {

    private StatisticDAO statisticDAO;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        String action = (String) request.getParameter(Constants.QUENE);

        if (action.equals(Constants.QUENE_1_ACTION))
        {
            List result = getStatisticDAO().findEmployersNoWorking();
            request.setAttribute(Constants.EMPLOYER_LIST, result);
            return mapping.findForward("quene1");
        } else  if (action.equals(Constants.QUENE_2_ACTION))
        {
            List employers = getStatisticDAO().findEmployersWork();
            request.setAttribute(Constants.VIEW_BEAN_LIST, employers);
            return mapping.findForward("quene2");
        } else  if (action.equals(Constants.QUENE_3_ACTION))
        {
            List result = getStatisticDAO().findMinMaxOffice();
            request.setAttribute(Constants.VIEW_BEAN_LIST, result );
            return mapping.findForward("quene3");
        }

        return null;
    }

    public void setStatisticDAO(StatisticDAO statisticDAO) {
        this.statisticDAO = statisticDAO;
    }

    public StatisticDAO getStatisticDAO() {
        return statisticDAO;
    }
}
