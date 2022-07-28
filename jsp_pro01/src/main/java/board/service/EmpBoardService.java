package board.service;

import board.model.EmpBoardDAO;
import board.model.EmpBoardDTO;

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
}
