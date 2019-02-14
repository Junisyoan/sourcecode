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

public class LoginCheck implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 类型转换
		HttpServletRequest req = (HttpServletRequest) request;
		// 如果是登录操作，直接过
		if (req.getParameter("login") != null) {
			chain.doFilter(request, response);
		}
		// 获取对象
		HttpSession session = req.getSession();
		Tb_user user = (Tb_user) session.getAttribute("user");
		// 判断处理
		if (user == null && req.getAttribute("filterPass") == null) {// 获取路径
			String path = req.getScheme() + "://" + request.getServerName() + ":" + req.getServerPort()
			+ req.getContextPath() + "/backlogin.jsp";
			PrintWriter out = null;
			
			try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			out.println("<script type='text/javascript'>  window.top.location='" + path + "'; </script>");
			out.flush();
			out.close();
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
