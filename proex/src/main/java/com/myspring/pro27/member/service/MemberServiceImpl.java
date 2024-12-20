package com.myspring.pro27.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro27.member.dao.MemberDAO;
import com.myspring.pro27.member.vo.MemberVO;



@Service("memberService") //memberServiceImpl을 이용해 id가 memberService인 빈을 자동 생성
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
    @Autowired //id가 memberDAO인 빈을 자동 주입
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

	@Override
	public MemberVO login(MemberVO memberVO) throws DataAccessException {
		// TODO Auto-generated method stub
		return memberDAO.loginById(memberVO);
	}
    
}
