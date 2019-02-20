package xyz.cymedical.handle.jiang;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbContactBiz;
import xyz.cymedical.biz.jiang.TbMsgBiz;
import xyz.cymedical.entity.jiang.Tb_contact;
import xyz.cymedical.entity.jiang.Tb_msg;
import xyz.cymedical.tools.jun.ResponseTools;

@Controller
@RequestMapping(value="contact")
public class ContactManageHandle {
	
	
	@Resource 
	private TbContactBiz tbContactBiz;
	
	@Resource 
	private TbMsgBiz tbMsgBiz;
	
	private List<Tb_msg> msglist;
	@Resource
	private Tb_msg tb_msg;

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
	
	@RequestMapping(value="/upcontact.so",method=RequestMethod.POST)
	public ModelAndView upcontact(HttpServletRequest req,Tb_contact tb_contact) {
		 
		System.out.println("修改公司信息"+tb_contact);
		
		int ret=tbContactBiz.upcontact(tb_contact);
		System.out.println(ret);
		if(ret==1) {
			 System.out.println("修改公司信息ret="+ret); 
		} 
		ModelAndView ma=new ModelAndView();
		ma.setViewName("WEB-INF/view.jiang/contactManage");
		return ma;
	  
	}
	
	@RequestMapping(value="/msg.so")
	public ModelAndView msg(HttpServletResponse response, Tb_msg tb_msg) {
		
		String state="未读";
		tb_msg.setState(state);
		System.out.println("tbmsg="+tb_msg.getName());
		System.out.println("tbmsg="+tb_msg.getState());
		int ret=tbMsgBiz.addmsg(tb_msg);
		ModelAndView ma=new ModelAndView();
		if(ret==1) {
			 
			try {
				response.getWriter().println(ResponseTools.returnMsgAndBack("留言成功...请耐心等待我们的回复"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
				response.getWriter().println(ResponseTools.returnMsgAndBack("由于不可抗因素  留言失败..."));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		return null;
	}
	
	 @RequestMapping(value="/selectmsg.handle")
	 public ModelAndView selectmsg(HttpServletRequest rq) {
		 ModelAndView ma=new ModelAndView();	
		 msglist=tbMsgBiz.selectmsg();
		 System.out.println("留言信息="+msglist);
		 rq.setAttribute("msglist", msglist);
		 
		 
		 ma.setViewName("WEB-INF/view.jiang/msgmanage");
		 return ma;
	 }
	 @RequestMapping(value="/deletemsg.handle")
	 public ModelAndView deletemsg(HttpServletRequest rq,int begin,int end) {
		 ModelAndView ma=new ModelAndView();	
		 System.out.println("begin="+begin);
		 System.out.println("end="+end);
		 for(int i=begin;i<=end;) {
			 int id=i;
			  tbMsgBiz.deleteall(id) ;
			  i++;
		 }
		  
		 ma.setViewName("WEB-INF/view.jiang/msgmanage");
		 return ma;
	 }
	 @RequestMapping(value="/adelete.handle")
	 public ModelAndView adelete(HttpServletRequest rq,String id) {
		 ModelAndView ma=new ModelAndView();	
		 System.out.println("未读信息变已读");
		 System.out.println("未读信息变已读="+id);
		 int msg_id=Integer.valueOf(id);
		 String state="已读";
		 System.out.println("id="+msg_id+"and="+state);
		 tb_msg.setMsg_id(msg_id);
		 tb_msg.setState(state);
		 tbMsgBiz.upstate(tb_msg); 
		 ma.setViewName("WEB-INF/view.jiang/msgmanage");
		 return ma;
	 }
	

}
