package xyz.cymedical.aop.zsc;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import xyz.cymedical.entity.jiang.Tb_user;

@Aspect    // 切面注解
@Component //通用注解
public class AopMake {
	
	@Pointcut("execution (* xyz.cymedical.biz..*.*(..))")
	public void pointCut() {
	}
	
	@After("pointCut()")
	public void doAfter(JoinPoint joinPoint) {
		try {
			//所有的方法
			Method[] methods = joinPoint.getTarget().getClass().getMethods();
			
			//找到指定方法名
			String methodName = joinPoint.getSignature().getName();
			
			//找到指定方法的所有参数
			Object[] paramObj = joinPoint.getArgs();
			
			// 用反射机制执行连接点的方法
			//((ProceedingJoinPoint) joinPoint).proceed();
			
			//遍历所有方法
			for (Method m : methods) {
				
				//如果方法有Log注解，并且方法名和指定方法名一致，说明找到要找的方法了
				if (m.getAnnotation(Log.class)!=null && m.getName().equals(methodName)) {
					
					//获取方法的参数
					Class[] cls = m.getParameterTypes();
					
					//判断参数长度和指定方法的参数长度是否一致（处理方法的重载时，方法名的重复问题）
					if (paramObj.length == cls.length) {
						
						//通过sesion获取用户信息
						HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				                .getRequestAttributes()).getRequest();    
				        HttpSession session = request.getSession();  
						
				        Tb_user user = (Tb_user) session.getAttribute("user");
				        
//				        m.getAnnotation(Log.class).action()
				        
						break;
					}
					
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
			System.out.println("日志添加时出现异常啦啦啦啦啦啦啦啦啦");
		}
	}
}

