/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.google.gson.Gson;
import dto.BookDto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.BookManageService;
import service.ServiceFactory;

/**
 *
 * @author chathura buddhika
 */
public class BookController extends HttpServlet {

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        if (!bookName.equals("")) {
            boolean deleteBook = ServiceFactory.getBookManageService().deleteBook(bookName);
            PrintWriter out = resp.getWriter();
            if (deleteBook) {
                out.print(true);
            } else {
                out.print(false);
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("bookName");
        String auther = req.getParameter("auther");
        String isbn = req.getParameter("isbn");

        if (!name.equals("") && !auther.equals("") && !isbn.equals("")) {
            BookManageService bookManageService = ServiceFactory.getBookManageService();
            BookDto dto = new BookDto(name, auther, isbn);
            boolean saveBook = bookManageService.UpdateBook(dto);
            PrintWriter out = resp.getWriter();
            if (saveBook) {
                out.print(true);
            } else {
                out.print(false);
            }
        }
    }

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
        ArrayList<BookDto> allBooks = ServiceFactory.getBookManageService().getAllBooks();
        response.setContentType("application/json");
        new Gson().toJson(allBooks, response.getWriter());
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
        String name = request.getParameter("bookName");
        String auther = request.getParameter("auther");
        String isbn = request.getParameter("isbn");

        if (!name.equals("") && !auther.equals("") && !isbn.equals("")) {
            BookManageService bookManageService = ServiceFactory.getBookManageService();
            BookDto dto = new BookDto(name, auther, isbn);
            boolean saveBook = bookManageService.saveBook(dto);
            PrintWriter out = response.getWriter();
            if (saveBook) {
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

}
