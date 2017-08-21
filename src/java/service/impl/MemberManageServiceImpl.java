/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import dao.DaoFactory;
import dao.MemberDao;
import dto.MemberDto;
import java.util.ArrayList;
import model.Member;
import service.MemberManageService;

/**
 *
 * @author chathura buddhika
 */
public class MemberManageServiceImpl implements MemberManageService {

    public boolean saveMember(MemberDto memberDto) {
        MemberDao memberDao = DaoFactory.getMemberDao();
        Member member = new Member();
        member.setUserName(memberDto.getUserName());
        member.setPassword(memberDto.getPassword());
        member.setMobile(memberDto.getMobile());
        int saveMember = memberDao.saveMember(member);
        if (saveMember > 0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<MemberDto> getAllMembers() {
        ArrayList<Member> allMembers = DaoFactory.getMemberDao().getAllMembers();
        ArrayList<MemberDto> list = new ArrayList<MemberDto>();
        for (Member member : allMembers) {
            MemberDto dto = new MemberDto(member.getUserName(), "", member.getMobile());
            list.add(dto);
        }
        return list;
    }

    public boolean UpdateMember(MemberDto memberDto) {
        MemberDao memberDao = DaoFactory.getMemberDao();
        Member member = new Member();
        member.setUserName(memberDto.getUserName());
        member.setPassword(memberDto.getPassword());
        member.setMobile(memberDto.getMobile());
        int saveMember = memberDao.updateMember(member);
        return saveMember > 0;
    }

    public boolean deleteMember(String userName) {
        int deleteMember = DaoFactory.getMemberDao().deleteMember(userName);
        return deleteMember > 0;
    }

}
