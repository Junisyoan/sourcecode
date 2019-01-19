package xyz.cymedical.handle.jun;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.cymedical.biz.jun.CompanyBiz;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.tools.jun.ResponseTools;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/
@Controller
@RequestMapping("/company")
public class CompanyHandle {

	@Resource
	private CompanyBiz companyBiz; 
	private String strTarget;
	
	public CompanyHandle() {
		strTarget=null;
	}
	
	/*
	 * 公司注册
	 */
	@RequestMapping(value="/regCompany.handle", method=RequestMethod.POST)
	public @ResponseBody String regCompany(HttpServletResponse response,Company company) {
		System.out.println(company);
		//执行注册
//		String res = companyBiz.regCompany(company);
//		try {
//
//			switch (res) {
//
//			case "已被注册":
//				strTarget = null;
//				response.getWriter().println(ResponseTools.returnMsgAndBack("已被注册"));
//				break;
//			
//			case "注册失败":
//				strTarget = null;
//				response.getWriter().println(ResponseTools.returnMsgAndBack("注册失败"));
//				break;
//				
//			case "注册成功":
//				strTarget = "comanyLogin";
//				response.getWriter().println(ResponseTools.returnMsgAndBack("注册成功"));
//				break;
//				
//			default:
//				strTarget="fail";
//				break;
//			}
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		return strTarget;
	}
}
