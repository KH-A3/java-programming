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
			return _getDeptId(deptId);
		}
		return null;
	}
	
	public DeptDTO getDeptId(int id) {
		return _getDeptId(id);
	}
	
	private DeptDTO _getDeptId(int id) {
		dao = new DeptDAO();
		DeptDTO data = dao.searchDeptId(id);
		return data;
	}

	public int addDept(DeptDTO data) {
		dao = new DeptDAO();
		DeptDTO deptData = _getDeptId(data.getDeptId());
		
		/*
		 *  -1 : deptId 중복 오류 -> _getDeptId() DeptDTO
		 *  -2 : mngId 없음 오류 -> existManager() boolean 있으면 true
		 *       관련 맵퍼로는 deptManager.existManager 를 만들어 사용하도록 한다.
		 *  -3 : locId 없음 오류 -> existLocation() boolean 있으면 true
		 *       관련 맵퍼로는 deptManager.existLocation 을 만들어 사용하도록 한다.
		 *  
		 *  위 오류를 구분하여 컨트롤러에 반환하게 만들기.
		 *  
		 *  최종적으로 add.jsp 에 "데이터 저장 처리중 에러 발생" 메시지를
		 *  에러 코드에 따라 다음과 같이 출력되도록 한다.
		 *  -1 : 부서 코드 중복 오류
		 *  -2 : 해당 관리자 ID 존재하지 않음
		 *  -3 : 해당 지역 코드 존재하지 않음
		 */
		
		if(deptData == null) {
			boolean isSave = dao.insertDept(data);
			if(isSave) {
				dao.close();
				return 1;	// 성공
			}
		}
		dao.close();
		return -1;	// 실패
	}
}
