package com.spring.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.member.vo.MemberVO;

public interface MemberDAO {
	public List selectAllMemberList() throws DataAccessException;
	public int insertMember(MemberVO memberVO) throws DataAccessException;
	public int deleteMember(String id) throws DataAccessException;
    // 회원 정보 수정 메서드 추가
    int updateMember(MemberVO memberVO) throws DataAccessException;

    // 특정 회원 조회 메서드 추가
    MemberVO modMember(String id) throws DataAccessException;
}
