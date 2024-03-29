package com.myhome.web.login.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.web.emp.model.EmpDTO;
import com.myhome.web.login.model.LoginDAO;
import com.myhome.web.login.vo.LoginVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDAO dao;
	
	public boolean getLogin(HttpSession session, LoginVO loginVo) {
		EmpDTO data = new EmpDTO();
		data.setEmpId(loginVo.getEmpId());
		data.setDeptId(loginVo.getDeptId());
		data.setEmpName(loginVo.getEmpName());
		
		data = dao.selectLogin(data);
		
		if(data == null) {
			return false;
		} else {
			// List<PermDTO> perm = dao.selectPerm(data.getEmpId());
			// session.setAttribute("permData", perm);
			session.setAttribute("loginData", data);
			return true;
		}
		
	}

}
