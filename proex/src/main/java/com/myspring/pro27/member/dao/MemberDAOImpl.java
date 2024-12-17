package com.myspring.pro27.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.myspring.pro27.member.vo.MemberVO;



@Repository("memberDAO") //id가 memberDAO인 빈을 자동 주입
public class MemberDAOImpl implements MemberDAO {

    @Autowired
    private SqlSession sqlSession; //xml설정 파일에서 생성한id가 sqlSession인 빈을 자동 주입

    @Override
    public List selectAllMemberList() throws DataAccessException {
        List<MemberVO> membersList = null;
        membersList = sqlSession.selectList("mapper.member.selectAllMemberList");
        return membersList;
    }

    @Override
    public int insertMember(MemberVO memberVO) throws DataAccessException {
        int result = sqlSession.insert("mapper.member.insertMember", memberVO);
        return result;
    }

    @Override
    public int deleteMember(String id) throws DataAccessException {
        int result = sqlSession.delete("mapper.member.deleteMember", id);
        return result;
    }


    public int updateMember(MemberVO memberVO) throws DataAccessException {
        int result = sqlSession.update("mapper.member.updateMember", memberVO);
        return result;
    }

  
    public MemberVO modMember(String id) throws DataAccessException {
        // selectOne 반환값을 MemberVO로 캐스팅
        return (MemberVO) sqlSession.selectOne("mapper.member.modMember", id);
    }

	@Override
	public MemberVO loginById(MemberVO memberVO) throws DataAccessException {
		MemberVO vo = sqlSession.selectOne("mapper.member.loginById",memberVO);
		return vo;
	}
    
    
}
