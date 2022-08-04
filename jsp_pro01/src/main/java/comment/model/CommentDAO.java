package comment.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.conn.db.DBConn;

public class CommentDAO {

	private SqlSession session = DBConn.getSqlSession();
	
	public boolean insertData(CommentDTO data) {
		String mapId = String.format("commentMapper.%s", "insertData");
		int res = session.insert(mapId, data);
		return res == 1 ? true : false;
	}
	

	public CommentDTO selectData(int id) {
		String mapId = String.format("commentMapper.%s", "selectData");
		CommentDTO res = session.selectOne(mapId, id);
		return res;
	}

	public List<CommentDTO> selectDatas(int id) {
		String mapId = String.format("commentMapper.%s", "selectDatas");
		List<CommentDTO> res = session.selectList(mapId, id);
		return res;
	}
	
	public boolean deleteData(CommentDTO data) {
		String mapId = String.format("commentMapper.%s", "deleteData");
		int res = session.update(mapId, data);
		return res == 1 ? true : false;
	}

	public void commit() {
		session.commit();
	}

	public void rolback() {
		session.rollback();
	}

	public void close() {
		session.close();
	}

}
