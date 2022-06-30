package dept.service;

import java.util.List;

import dept.model.DeptDAO;
import dept.model.DeptDTO;

public class DeptService {
	
	private DeptDAO dao;
	
	public List<DeptDTO> getAll() {
		dao = new DeptDAO();
		List<DeptDTO> datas = dao.searchAll();
		dao.close();
		return datas;
	}
	
	public DeptDTO getDeptId(String id) {
		boolean isNumber = id.matches("\\d+");
		if(isNumber) {
			int deptId = Integer.parseInt(id);
			dao = new DeptDAO();
			DeptDTO data = _getDeptId(deptId);
			dao.close();
			return data;
		}
		return null;
	}
	
	public DeptDTO getDeptId(int id) {
		dao = new DeptDAO();
		DeptDTO data = _getDeptId(id);
		dao.close();
		return data;
	}
	
	private DeptDTO _getDeptId(int id) {
		// public 메서드에서 dao 객체를 생성하게해야 함.
		DeptDTO data = dao.searchDeptId(id);
		return data;
	}

	public DEPT_SERVICE_STATUS addDept(DeptDTO data) {
		dao = new DeptDAO();
		DEPT_SERVICE_STATUS status = DEPT_SERVICE_STATUS.SUCCESS;
		
		if(_getDeptId(data.getDeptId()) != null) {
			status = DEPT_SERVICE_STATUS.DEPT_ID_DUPLICATED;
		}
		if(!_existManager(data.getMngId())) {
			status = DEPT_SERVICE_STATUS.MNG_ID_NOT_EXISTS;
		}
		if(!_existLocation(data.getLocId())) {
			status = DEPT_SERVICE_STATUS.LOC_ID_NOT_EXISTS;
		}
		
		switch(status) {
			case SUCCESS:
				if(dao.insertDept(data)) {
					dao.commit();
				} else {
					status = DEPT_SERVICE_STATUS.FAILED;
					dao.rollback();
				}
				break;
			default:
				dao.close();
		}
		
		return status;
	}
	
	private boolean _existManager(int id) {
		boolean result = dao.existManager(id);
		return result;
	}
	
	private boolean _existLocation(int id) {
		boolean result = dao.existLocation(id);
		return result;
	}
}
