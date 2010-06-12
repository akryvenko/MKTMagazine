package com.mariya.action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: user
 * Date: 12.06.2010
 * Time: 15:21:02
 * To change this template use File | Settings | File Templates.
 */
public class DownloadFileAction extends BaseAction {
    @Override
    protected ActionForward doExecute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {

        File reportPath = (File) request.getSession().getAttribute("reportPath");

        try {
            response.setContentType("application/octet-stream");
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(reportPath));
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            byte[] buf = new byte[4 * 1024];
            int bytesRead;
            while ((bytesRead = in.read(buf)) != -1) {
                out.write(buf, 0, bytesRead);
            }
            in.close();
            out.close();
        } catch (Exception e) {

        }
        return null;
    }
}
