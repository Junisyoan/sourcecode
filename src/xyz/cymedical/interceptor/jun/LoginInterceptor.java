package xyz.cymedical.interceptor.jun;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.jun.Nurse;

/**
*	@author Junisyoan;
*	日期：2019年2月14日
*	时间：下午9:54:09
*	类说明：
*/
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("拦截器执行");
		//是否附带登录数据
		if (request.getParameter("login")!=null) {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		//没有附带数据，判断是不是已经登录
		}else {
			Tb_user user = (Tb_user)request.getSession().getAttribute("user");
			
			System.out.println("user="+user);
			
			Company company = (Company)request.getSession().getAttribute("userCompany");
			Nurse nurse =(Nurse) request.getSession().getAttribute("nurse");
			if (user==null&&company==null&nurse==null) {
				System.out.println("非法访问");
				String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
				response.getWriter().print("<script type='text/javascript'>window.top.location.href='"+path+"'</script>");
				return false;
			} else {
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}
		}
	}
	
	

}
