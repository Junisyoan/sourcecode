package xyz.cymedical.filter.zsc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.Nurse;

public class LoginCheck implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		System.out.println(request.getParameter("a"));
		
		Tb_user user= (Tb_user) session.getAttribute("user");
		Company company = (Company) session.getAttribute("userCompany");
		Nurse nurse = (Nurse) session.getAttribute("nurse");
		String path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
		+ req.getContextPath();
		if (user==null&&req.getAttribute("filterPass")==null
				&& company==null
				&& nurse==null) {
			
			PrintWriter out = response.getWriter();
			
			out.println("<script type='text/javascript'> window.top.location.href='" + path + "'; </script>");
			out.flush();
			out.close();
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
