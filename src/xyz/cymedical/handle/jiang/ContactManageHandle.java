package xyz.cymedical.handle.jiang;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbContactBiz;
import xyz.cymedical.entity.jiang.Tb_contact;

@Controller
@RequestMapping(value="contact")
public class ContactManageHandle {
	
	
	@Resource 
	private TbContactBiz tbContactBiz;
	

	private Tb_contact tb_contact;
	
	@RequestMapping(value="/fornt.so" , method=RequestMethod.GET)
	public ModelAndView fornt(HttpServletRequest req,HttpServletResponse resp) {
		
		System.out.println("公司门户界面信息");
		tb_contact= tbContactBiz.fornt();
		System.out.println("查询到的公司信息="+tb_contact);
		req.setAttribute("tb_contact", tb_contact); 
		ModelAndView ma=new ModelAndView();
		ma.setViewName("contact");
		 
		return ma;
		 
	}
	@RequestMapping(value="/select.handle",method=RequestMethod.GET)
	public ModelAndView select(HttpServletRequest req) {
		System.out.println("后台查询公司信息");
		tb_contact= tbContactBiz.fornt();
		req.setAttribute("tb_contact", tb_contact); 
		ModelAndView ma=new ModelAndView();
		ma.setViewName("WEB-INF/view.jiang/contactManage");
		return ma;
		
	}
	
	@RequestMapping(value="/upcontact.handle",method=RequestMethod.POST)
	public ModelAndView upcontact(HttpServletRequest req,Tb_contact tb_contact) {
		 
		System.out.println("修改公司信息");
		
		int ret=tbContactBiz.upcontact(tb_contact);
		if(ret==1) {
			 
			tb_contact= tbContactBiz.fornt();
			req.setAttribute("tb_contact", tb_contact); 
		} 
		ModelAndView ma=new ModelAndView();
		ma.setViewName("WEB-INF/view.jiang/contactManage");
		return ma;
	 
		
	}
	

}
