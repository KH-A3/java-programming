package com.conn.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.emp.vo.DataVO;
import com.emp.vo.EmpVO;
import com.emp.vo.EmpWhereVO;

public class DBConn {

	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		
		String config = "resources/mybatis-config.xml";
		InputStream is;
		
		try {
			is = Resources.getResourceAsStream(config);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, "development");
			sess = sqlSessionFactory.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
	
	public static void main(String[] args) {
		SqlSession session = DBConn.getSqlSession();
		int result1 = session.selectOne("empMapper.empCount");
		System.out.println(result1);
		
		List<String> result2 = session.selectList("empMapper.empNames");
		System.out.println(result2);
		
		List<Object> result3 = session.selectList("empMapper.empDatas");
		System.out.println(result3);
		
		for(int idx = 0; idx < result3.size(); idx++) {
			Map<String, Object> data = (Map<String, Object>)(result3.get(idx));
			System.out.println(data.get("EMPLOYEE_ID") + ", " + data.get("FIRST_NAME"));
		}
		
		List<EmpVO> result4 = session.selectList("empMapper.empObjects");
		for(EmpVO data: result4) {
			System.out.println(data.getEmpId() + ", " + data.getFirstName());
		}
		
		EmpVO result5 = session.selectOne("empMapper.empSelect", 100);
		System.out.println(result5.getEmpId()  + ", " + result5.getFirstName());
		
		Map<String, Integer> param = new HashMap<String, Integer>();
		param.put("first", 100);
		param.put("last", 110);
		List<EmpVO> result6 = session.selectList("empMapper.empRange", param);
		for(EmpVO data: result6) {
			System.out.println(data.getEmpId() + ", " + data.getFirstName());
		}
		
		DataVO insertData = new DataVO();
		// insertData.setId(5);
		insertData.setName("test");
		insertData.setToday(new Date(new java.util.Date().getTime()));
		
		int result7 = session.insert("empMapper.dataInsert1", insertData);
		session.commit();
		System.out.println(result7 + " 개 행이 추가되었습니다.");
		
//		DataVO checkData = session.selectOne("empMapper.insertCheck", insertData.getId());
//		if(checkData == null) {
//			int result7 = session.insert("empMapper.dataInsert1", insertData);
//			session.commit();
//			System.out.println(result7 + " 개 행이 추가되었습니다.");
//		} else {
//			System.out.println("id 컬럼에 " + insertData.getId() + " 에 해당하는 데이터가 이미 존재합니다.");
//			session.rollback();
//		}
		
//		// Map<String, Object> updateData = new HashMap<String, Object>();
//		// updateData.put("id", 1);
//		// updateData.put("name", "update");
//		DataVO updateData = new DataVO();
//		updateData.setId(1);
//		updateData.setName("change");
//		int result8 = session.update("empMapper.dataUpdate1", updateData);
//		session.commit();
//		System.out.println(result8 + " 개 행이 업데이트 되었습니다.");
//		
//		int result9 = session.update("empMapper.dataDelete1", 1);
//		session.commit();
//		System.out.println(result9 + " 개 행이 삭제 되었습니다.");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date stDate = null, edDate = null;
		try {
			stDate = sdf.parse("1990/01/01");
			edDate = sdf.parse("1999/12/31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmpWhereVO dynamicData = new EmpWhereVO();
		// dynamicData.setSalary(10000);
		// dynamicData.setDeptId(80);
		// dynamicData.setStartDate(new Date(stDate.getTime()));
		// dynamicData.setEndDate(new Date(edDate.getTime()));
		
		List<Integer> deptList = new ArrayList<Integer>();
		deptList.add(80); deptList.add(90); deptList.add(100);
		// dynamicData.setDeptIdList(deptList);
		
		List<EmpVO> result10 = session.selectList("empMapper.dynamicQuery", dynamicData);
		System.out.println(result10.size() + " 개 행 데이터가 조회 되었습니다.");
	}

}
