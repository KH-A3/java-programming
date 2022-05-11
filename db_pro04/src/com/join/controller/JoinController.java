package com.join.controller;

import com.join.dao.JoinDAO;
import com.join.vo.JoinVO;

public class JoinController {

	private JoinDAO dao = new JoinDAO();
	
	public boolean join(JoinVO data) {
		// 회원 가입 처리 전 필요한 로직(데이터 검사, 계산 등.)
		// 회원 가입 처리 후 결과를 반환한다.
		
		// 가입을 진행하기 전에 아이디 중복 확인!
		JoinVO account = dao.get(data.getUserid());
		if(account == null) {
			boolean result = dao.add(data);
			if(result) {
				return true;
			}
		}
		return false;
	}
	
	public JoinVO login(String userid, String userpw) {
		JoinVO account = dao.get(userid);
		
		// userid 에 해당하는 계정이 있는지 확인.
		if(account != null) {
			if(account.getUserpw().equals(userpw)) {
				return account;
			}
		}
		return null;
	}

}
