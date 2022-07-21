package emps.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dept.service.DeptService;
import emps.model.EmpsDTO;
import emps.model.EmpsDetailDTO;
import emps.service.EmpsService;
import job.service.JobService;

/**
 * Servlet implementation class EmpsModifyController
 */
@WebServlet("/emps/modify")
@MultipartConfig
public class EmpsModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String view = "/WEB-INF/jsp/emps/modify.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		EmpsService empsService = new EmpsService();
		JobService jobService = new JobService();
		DeptService deptService = new DeptService();
		
		EmpsDTO empsData = empsService.getId(id);
		EmpsDetailDTO empsDetailData = empsService.getEmpDetail(empsData.getEmpId());
		
		String imagePath = empsService.getProfileImagePath(request, "/static/img/emp/", empsData);
		
		request.setAttribute("empsData", empsData);
		request.setAttribute("empsDetailData", empsDetailData);
		request.setAttribute("jobDatas", jobService.getAll());
		request.setAttribute("deptDatas", deptService.getAll());
		request.setAttribute("imagePath", imagePath);
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String jobId = request.getParameter("jobId");
		String deptId = request.getParameter("deptId");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String phone = request.getParameter("phone");
		String salary = request.getParameter("salary");
		String commission = request.getParameter("commission");
		
		EmpsService empsService = new EmpsService();
		
		EmpsDTO empsData = empsService.getId(empId);
		
		if(empsData == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/error/error.jsp");
			request.setAttribute("error", "해당 데이터가 존재하지 않습니다.");
			rd.forward(request, response);
			return;
		}
		
		empsData.setEmpName(empName);
		empsData.setJobId(jobId);
		empsData.setDeptId(deptId);
		empsData.setEmail(email);
		
		EmpsDetailDTO empsDetailData = empsService.getEmpDetail(empsData.getEmpId());
		if(empsDetailData == null) {
			empsDetailData = new EmpsDetailDTO();
			empsDetailData.setEmpId(empsData.getEmpId());
		}
		empsDetailData.setHireDate(hireDate);
		empsDetailData.setPhone(phone);
		empsDetailData.setSalary(salary);
		empsDetailData.setCommission(commission);
		
		boolean result = empsService.setEmp(empsData, empsDetailData);
		
		if(result) {
			// 저장 성공
			Part imgFile = request.getPart("uploadImg");
			String originName = imgFile.getSubmittedFileName();
			
			/* 나중에 디테일 화면이 구현되면 완성 할 것.
			 * PNG 이미지가 아닌 다른 이미지 파일이 업로드 되는 경우 해당 페이지에 오류를 출력하기 위함.
			if(!originName.endsWith(".png")) {
				request.setAttribute("imageError", "이미지는 PNG 만 업로드 하세요.");
				doGet(request, response);
				return;
			}
			*/
			
			String location = request.getServletContext().getRealPath("/static/img/emp") + "/" + empsData.getEmpId() + ".png";
			
			if(!originName.isEmpty()) {
				imgFile.write(location);
			}
			
			response.sendRedirect(request.getContextPath() + "/emps/detail?id=" + empsData.getEmpId());
		} else {
			// 저장 실패
			doGet(request, response);
		}
	}

}
