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

public class LoginCheck implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if (req.getParameter("login")!=null) {
			chain.doFilter(request, response);
		}
		
		Tb_user user= (Tb_user) session.getAttribute("user");
		
		if (user==null&&req.getAttribute("filterPass")==null) {
			String path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort()
			+ req.getContextPath() +"/backlogin.jsp";
			
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
