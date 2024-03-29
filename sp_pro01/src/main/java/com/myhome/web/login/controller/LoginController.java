package com.myhome.web.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.web.dept.model.DeptDTO;
import com.myhome.web.dept.service.DeptService;
import com.myhome.web.login.service.LoginService;
import com.myhome.web.login.vo.LoginVO;

@Controller
public class LoginController {

	@Autowired
	private LoginService service;
	
	@Autowired
	private DeptService deptService;
	
	@GetMapping(value="/login")
	public String login(Model model) {
		List<DeptDTO> deptDatas = deptService.getAll();
		model.addAttribute("deptDatas", deptDatas);
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVo, String url
			, HttpServletRequest request
			, HttpSession session, Model model) {
		
		boolean result = service.getLogin(session, loginVo);
		
		if(result) {
			// 로그인 성공
			if(!url.isEmpty()) {
				if(url.startsWith(request.getContextPath())) {
					url = url.replace(request.getContextPath(), "");
				}
				return "redirect:" + url;
			} else {
				return "redirect:/";
			}
		} else {
			// 로그인 실패
			return login(model);
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		// session.invalidate();
		session.removeAttribute("loginData");
		return "redirect:/";
	}
}
