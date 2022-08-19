package com.myhome.web.login.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myhome.web.emp.model.EmpDTO;

@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSession session;
	
	public EmpDTO selectLogin(EmpDTO data) {
		EmpDTO result = session.selectOne("loginMapper.selectLogin", data);
		return result;
	}

	public List<PermDTO> selectPerm(int id) {
		List<PermDTO> data = session.selectList("loginMapper.selectPerm", id);
		return data;
	}

}
