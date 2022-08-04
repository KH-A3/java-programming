package comment.service;

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

}
