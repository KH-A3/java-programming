package dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService service = new DeptService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		String page = request.getParameter("page");
		int count = 5;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("pgc") != null) {
			count = Integer.parseInt(session.getAttribute("pgc").toString());
		}
		
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));
		}
		
		session.setAttribute("pgc", count);
		
		/*
		Cookie cookies[] = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().equals("pgc")) {
				count = Integer.parseInt(c.getValue());
			}
		}
		
		Cookie cookie = null;
		if(request.getParameter("pgc") != null) {
			count = Integer.parseInt(request.getParameter("pgc"));		
			cookie = new Cookie("pgc", request.getParameter("pgc"));
		} else {
			cookie = new Cookie("pgc", String.valueOf(count));
		}
		cookie.setMaxAge(30);
		cookie.setPath("/depts");
		response.addCookie(cookie);
		*/
		
		request.setAttribute("pgc", count);
		request.setAttribute("menuLocation", "depts");
		List<DeptDTO> datas = null;
		if(search == null) {
			int pageNum = 1;
			if(page != null) {
				if(!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page);
				}
			}
			datas = service.getPage(pageNum, count);
			request.setAttribute("page", pageNum);
			request.setAttribute("pageList", service.getPageNumberList(count));
		} else {
			DeptDTO data = service.getDeptId(search);
			if(data != null) {
				datas = new ArrayList<DeptDTO>();
				datas.add(data);
			}
		}
		
		request.setAttribute("datas", datas);
		
		String view = "/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
