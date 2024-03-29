package com.myhome.web.board.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myhome.web.board.model.BoardDAO;
import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.model.BoardStaticsDTO;
import com.myhome.web.emp.model.EmpDTO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> getAll() {
		List<BoardDTO> datas = dao.selectAll();
		return datas;
	}
	
	public BoardDTO getData(int id) {
		BoardDTO data = dao.selectData(id);
		return data;
	}
	
	public int add(BoardDTO data) {
		int seq = dao.getNextSeq();
		data.setId(seq);
		
		boolean result = dao.insertData(data);
		
		if(result) {
			return data.getId();
		}
		return -1;
	}
	
	public boolean modify(BoardDTO data) {
		boolean result = dao.updateData(data);
		return result;
	}
	
	public boolean remove(BoardDTO data) {
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		
		dao.deleteStaticsData(staticsData);
		boolean result = dao.deleteData(data);
		
		return result;
	}
	
	@Transactional
	public void incViewCnt(HttpSession session, BoardDTO data) {
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(((EmpDTO)session.getAttribute("loginData")).getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		boolean result = false;
		if(staticsData == null) {
			result = dao.updateViewCnt(data);
			if(!result) {
				throw new RuntimeException("조회수 통계 업데이트 처리에 문제가 발생 하였습니다.");
			}
			
			staticsData = new BoardStaticsDTO();
			staticsData.setbId(data.getId());
			staticsData.setEmpId(((EmpDTO)session.getAttribute("loginData")).getEmpId());
			result = dao.insertStatics(staticsData);
			if(!result) {
				throw new RuntimeException("조회수 통계 추가 처리에 문제가 발생 하였습니다.");
			}
		} else {
			long timeDiff = new Date().getTime() - staticsData.getLatestViewDate().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);
				if(!result) {
					throw new RuntimeException("조회수 업데이트 처리에 문제가 발생 하였습니다.");
				}
				result = dao.updateStatics(staticsData);
				if(!result) {
					throw new RuntimeException("조회수 통계 업데이트 처리에 문제가 발생 하였습니다.");
				}
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
		}
	}
	
	public void incLike(HttpSession session, BoardDTO data) {
		EmpDTO empData = (EmpDTO)session.getAttribute("loginData");
		
		BoardStaticsDTO staticsData = new BoardStaticsDTO();
		staticsData.setbId(data.getId());
		staticsData.setEmpId(empData.getEmpId());
		
		staticsData = dao.selectStatics(staticsData);
		
		// 이전에 추천을 했는지 안 했는지 확인
		if(staticsData.isLiked()) {
			// 이전에 추천을 한 기록이 있으면 -> 추천 취소로 전환
			staticsData.setLiked(false);
			data.setLike(data.getLike() - 1);
		} else {
			// 이전에 추천을 한 기록이 없으면 -> 추천으로 전환
			staticsData.setLiked(true);
			data.setLike(data.getLike() + 1);
		}
		
		dao.updateStaticsLike(staticsData);
		boolean result = dao.updateLike(data);
	}

}
