/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dto.MemberDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.MemberManageService;
import service.ServiceFactory;

/**
 *
 * @author chathura buddhika
 */
public class MemberController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<MemberDto> allMembers = ServiceFactory.getMemberManageService().getAllMembers();
        response.setContentType("application/json");
        new Gson().toJson(allMembers, response.getWriter());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("userName");
        String passwoed = request.getParameter("password");
        String mobile = request.getParameter("mobile");

        if (!name.equals("") && !passwoed.equals("") && !mobile.equals("")) {
            MemberManageService memberManageService = ServiceFactory.getMemberManageService();
            MemberDto dto = new MemberDto(name, passwoed, mobile);
            boolean saveMember = memberManageService.saveMember(dto);
            PrintWriter out = response.getWriter();
            if (saveMember) {
                out.print(true);
            } else {
                out.print(false);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if (!userName.equals("")) {
            boolean deleteMember = ServiceFactory.getMemberManageService().deleteMember(userName);
            PrintWriter out = resp.getWriter();
            if (deleteMember) {
                out.print(true);
            } else {
                out.print(false);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(request, resp);
        String name = request.getParameter("userName");
        String passwoed = request.getParameter("password");
        String mobile = request.getParameter("mobile");

        if (!passwoed.equals("")) {
            MemberManageService memberManageService = ServiceFactory.getMemberManageService();
            MemberDto dto = new MemberDto(name, passwoed, mobile);
            boolean saveMember = memberManageService.UpdateMember(dto);
            PrintWriter out = resp.getWriter();
            if (saveMember) {
                out.print(true);
            } else {
                out.print(false);
            }
        }
    }

}
