package com.spring.ex04;

import java.io.Reader;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MemberDAO {
	private static SqlSessionFactory sqlMapper=null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;
	}
	
	public List<MemberVO> selectAllMemberList(){
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		List<MemberVO> memlist=null;
		memlist=session.selectList("mapper.member.selectAllMemberList");
		return memlist;
	}
	
	public com.spring.ex04.MemberVO selectMemberById(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		MemberVO memberVO = (MemberVO) session.selectOne("mapper.member.selectMemberById",id);		
		return memberVO;
	}
	
	public List<MemberVO> selectMemberByPwd(int pwd) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		List<MemberVO> memberslist=null;
		memberslist=session.selectList("mapper.member.selectMemberByPwd",pwd);
		return memberslist;
	}
	
	public int insertMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result=0;
		result=session.insert("mapper.member.insertMember",memberVO);
		session.commit();
		System.out.println("result="+result);
		return result;
	}
	
	public int insertMember2(Map<String, String> memberMap) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result= session.insert("mapper.member.insertMember",memberMap);
		session.commit();
		return result;
	}	
	
	public int updateMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result= session.update("mapper.member.updateMember",memberVO);
		session.commit();
		return result;
	}	
	
	public int deleteMember(String id) {
		sqlMapper=getInstance();
		SqlSession session=sqlMapper.openSession();
		int result= session.update("mapper.member.deleteMember",id);
		session.commit();
		return result;
	}	
}
