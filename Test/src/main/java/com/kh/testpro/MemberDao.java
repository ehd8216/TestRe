package com.kh.testpro;

import org.mybatis.spring.SqlSessionTemplate;

public class MemberDao {
	
	private SqlSessionTemplate sqlSession;

	public boolean isEmailExist(String email){
//		if(sqlSession.selectOne("memberMapper.selectMember", email) == null) {
//			return false;
//		}else {
//			return true;
//		}
		return false;
	}

}


