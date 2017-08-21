/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import service.impl.BookManageServiceImpl;
import service.impl.MemberManageServiceImpl;

/**
 *
 * @author chathura buddhika
 */
public class ServiceFactory {

    public static MemberManageService getMemberManageService() {
        return new MemberManageServiceImpl();
    }
    public static BookManageService getBookManageService() {
        return new BookManageServiceImpl();
    }
}
