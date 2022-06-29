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
		boolean isNumber = id.matches("\\d+");
		if(isNumber) {
			int deptId = Integer.parseInt(id);
			return _getDeptId(deptId);
		}
		return null;
	}
	
	public DeptDTO getDeptId(int id) {
		return _getDeptId(id);
	}
	
	private DeptDTO _getDeptId(int id) {
		DeptDTO data = dao.searchDeptId(id);
		return data;
	}

	public int addDept(DeptDTO data) {
		DeptDTO deptData = _getDeptId(data.getDeptId());
		
		if(deptData == null) {
			boolean isSave = dao.insertDept(data);
			if(isSave) {
				return 1;	// 성공
			}
		}
		return -1;	// 실패
	}
}
