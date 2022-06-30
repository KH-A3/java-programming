package dept.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts/mod")
public class DeptModController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DeptService service = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		DeptDTO data = service.getDeptId(id);
		
		request.setAttribute("data", data);
		
		String view = "/WEB-INF/jsp/dept/mod.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String deptId = request.getParameter("deptId");
		String deptName = request.getParameter("deptName");
		String mngId = request.getParameter("mngId");
		String locId = request.getParameter("locId");
		
		DeptDTO data = new DeptDTO();
		data.setDeptId(Integer.parseInt(deptId));
		data.setDeptName(deptName);
		data.setMngId(Integer.parseInt(mngId));
		data.setLocId(Integer.parseInt(locId));
		
		// add 작업을 했던 것과 유사하게 수정 처리가
		// 완료된 데이터에 대해 상태 정보를 받아서
		// 정상/실패 를 구분하고 JSP 에서 에러메시지가
		// 나올 수 있게 처리한다.
		service.modifyDept(data);
	}

}
