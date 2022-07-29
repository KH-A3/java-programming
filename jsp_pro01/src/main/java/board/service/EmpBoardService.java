package board.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;
import board.model.EmpBoardStaticsDTO;
import emps.model.EmpsDTO;

public class EmpBoardService {
	
	public int add(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
			dao.close();
			return data.getId();
		}
		
		dao.rollback();
		dao.close();
		return -1;
	}

	public EmpBoardDTO getData(int id) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardDTO data = dao.selectData(id);
		dao.close();
		
		return data;
	}

	public void incViewCnt(HttpSession session, EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		EmpBoardStaticsDTO staticsData = new EmpBoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		boolean result = false;
		if(staticsData == null) {
			result = dao.updateViewCnt(data);
			
			staticsData = new EmpBoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(((EmpsDTO)session.getAttribute("loginData")).getEmpId());
			dao.insertStatics(staticsData);
		} else {
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);
				dao.updateStatics(staticsData);
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}

	public void incLike(EmpBoardDTO data) {
		EmpBoardDAO dao = new EmpBoardDAO();
		
		boolean result = dao.updateLike(data);
		if(result) {
			data.setLike(data.getLike() + 1);
			dao.commit();
			dao.close();
		}
		dao.rollback();
		dao.close();
	}
}
