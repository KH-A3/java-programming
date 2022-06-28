package dept.service;

import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;
	
	public DeptService() {
		dao = new DeptDAO();
	}
	
	public List<DeptDTO> getAll() {
		List<DeptDTO> datas = dao.searchAll();
		return datas;
	}
	
	public DeptDTO getDeptId(String id) {
		int deptId = Integer.parseInt(id);
		return _getDeptId(deptId);
	}
	
	public DeptDTO getDeptId(int id) {
		return _getDeptId(id);
	}
	
	private DeptDTO _getDeptId(int id) {
		DeptDTO data = dao.searchDeptId(id);
		return data;
	}
}
