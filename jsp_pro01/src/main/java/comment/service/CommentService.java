package comment.service;

import java.util.List;

import comment.model.CommentDAO;
import comment.model.CommentDTO;

public class CommentService {

	public boolean add(CommentDTO data) {
		CommentDAO dao = new CommentDAO();
		
		boolean result = dao.insertData(data);
		
		if(result) {
			dao.commit();
		} else {
			dao.rolback();
		}
		dao.close();
		
		return result;
	}

	public List<CommentDTO> getDatas(int id) {
		CommentDAO dao = new CommentDAO();
		List<CommentDTO> datas = dao.selectDatas(id);
		dao.close();
		return datas;
	}

}
