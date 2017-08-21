/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import connection.Connection;
import connection.ConnectionFactory;
import dao.MemberDao;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import model.Member;

/**
 *
 * @author chathura buddhika
 */
public class MemberDaoImpl implements MemberDao {

    public int saveMember(Member member) {
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String membersData = p.get("MembersDetail", "");
        membersData += member.toString();
        p.put("MembersDetail", membersData);
        return 1;
    }

    public ArrayList<Member> getAllMembers() {
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String membersData = p.get("MembersDetail", "");
        ArrayList<Member> list = new ArrayList<Member>();
        if (!membersData.equals("")) {
            String[] split = membersData.split("%");
            for (String split1 : split) {
                String[] split2 = split1.split("~");
                Member m = new Member(split2[0], "", split2[2]);
                list.add(m);
            }
        }
        return list;
    }

    public int updateMember(Member member) {
        int isUpdate = 0;
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String membersData = p.get("MembersDetail", "");
        String[] split = membersData.split("%");
        String newList = "";
        for (String split1 : split) {
            String[] split2 = split1.split("~");
            if (member.getUserName().equals(split2[0])) {
            } else {
                newList += split1 + "%";
            }
        }
        newList += member.toString();
        isUpdate = 1;
        p.put("MembersDetail", newList);
        return isUpdate;
    }

    public int deleteMember(String name) {
        int isDelete = 0;
        Connection connection = ConnectionFactory.getConnection();
        Preferences p = (Preferences) connection.getConnection();
        String membersData = p.get("MembersDetail", "");
        String newList = "";
        String[] split = membersData.split("%");
        for (String split1 : split) {
            String[] split2 = split1.split("~");
            if (name.equals(split2[0])) {
                isDelete = 1;
            } else {
                newList += split1 + "%";
            }
        }
        p.put("MembersDetail", newList);
        return isDelete;
    }
}
