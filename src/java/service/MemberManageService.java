/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.MemberDto;
import java.util.ArrayList;

/**
 *
 * @author chathura buddhika
 */
public interface MemberManageService {

    public boolean saveMember(MemberDto memberDto);

    public ArrayList<MemberDto> getAllMembers();

    public boolean UpdateMember(MemberDto memberDto);

    public boolean deleteMember(String userName);
}
