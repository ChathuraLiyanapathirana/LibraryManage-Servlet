/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.Member;

/**
 *
 * @author chathura buddhika
 */
public interface MemberDao {

    public int saveMember(Member member);

    public ArrayList<Member> getAllMembers();

    public int updateMember(Member member);

    public int deleteMember(String name);
}
