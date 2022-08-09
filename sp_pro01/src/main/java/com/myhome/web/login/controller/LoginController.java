package com.myhome.web.login.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService service;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVo, HttpSession session) {
		logger.info("login({}, {}, {})", loginVo.getEmpId(), loginVo.getDeptId(), loginVo.getEmpName());
		
		boolean result = service.getLogin(session, loginVo);
		
		if(result) {
			// 로그인 성공
			return "redirect:/";
		} else {
			// 로그인 실패
			return "";
		}
	}
}
