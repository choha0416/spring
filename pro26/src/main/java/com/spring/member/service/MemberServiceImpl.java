package com.spring.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.member.dao.MemberDAO;
import com.spring.member.vo.MemberVO;

@Service("memberService")
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public List listMembers() throws DataAccessException {
        List membersList = null;
        membersList = memberDAO.selectAllMemberList();
        return membersList;
    }

    @Override
    public int addMember(MemberVO memberVO) throws DataAccessException {
        return memberDAO.insertMember(memberVO);
    }

    @Override
    public int removeMember(String id) throws DataAccessException {
        return memberDAO.deleteMember(id);
    }

    // 회원 정보 수정
  
    public int updateMember(MemberVO memberVO) throws DataAccessException {
        return memberDAO.updateMember(memberVO);
    }

    // 특정 회원 조회
    
    public MemberVO modMember(String id) throws DataAccessException {
        return memberDAO.modMember(id);
    }
}
