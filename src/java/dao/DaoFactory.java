/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.impl.BookDaoImpl;
import dao.impl.MemberDaoImpl;

/**
 *
 * @author chathura buddhika
 */
public class DaoFactory {

    public static MemberDao getMemberDao() {
        return new MemberDaoImpl();
    }
    public static BookDao getBookDao() {
        return new BookDaoImpl();
    }
}
