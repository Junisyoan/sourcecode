package xyz.cymedical.handle.jiang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import xyz.cymedical.biz.jiang.TbDeptBiz;
import xyz.cymedical.biz.jiang.TbRoleBiz;
import xyz.cymedical.biz.jiang.TbRoleDept;
import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.biz.jun.NurseBiz;
import xyz.cymedical.entity.jiang.Tb_role;
import xyz.cymedical.entity.jiang.Tb_role_dept;
import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.jun.Company;
import xyz.cymedical.entity.xin.News;
import xyz.cymedical.tools.zsc.Encryption;

@Controller
@RequestMapping("/usermanage")
public class UserManageHandle {
	@Resource
	private Tb_user user;
	@Resource
	private Tb_user userroledept;

	private List<Tb_user> userall;

	private List<Tb_role_dept> roledept;
	@Resource
	private TbUserBiz tbUserBiz;
	@Resource
	private TbRoleBiz tbRoleBiz;
	@Resource
	private TbRoleDept tbRoleDept;
	@Resource
	private Tb_role tbRole;
	
	private List<Tb_role> tbrole;
	private List<Map<String, Object>> maplisttbrole;
	

	@Resource
	private NurseBiz nurseBiz;
	
	private List<Map<String, Object>> maplist;
	
	private List<Map<String, Object>> maplistdept;
	
	@Resource
	private TbDeptBiz tbDeptBiz;

	// 添加后台人员

	@RequestMapping(value = "/adduser.handle")
	public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, Tb_user adduser) {

		ModelAndView mav = new ModelAndView();
//		adduser.setRole_dept_id(1);
//		System.out.println("doctor="+adduser.getDoctor());
		System.out.println(adduser.getRole_dept_id());
		System.out.println("douctor=" + adduser.getDoctor());
//		if (adduser.getDoctor().equals("内科医生")) {
//			adduser.setRole_dept_id(1);
//		} else if (adduser.getDoctor().equals("外科医生")) {
//			adduser.setRole_dept_id(2);
//		} else if (adduser.getDoctor().equals("管理员")) {
//			adduser.setRole_dept_id(3);
//		}
		userroledept= tbUserBiz.findthree(adduser);
		System.out.println("userroledept="+userroledept);
		int role_dept_id=userroledept.getRole_dept_id();
		
//		int role_dept_id=tbUserBiz.findthree(adduser).getRole_dept_id();
		adduser.setRole_dept_id(role_dept_id);

		System.out.println("qqqqqqqqqqqq+Role_dept_id=" + adduser.getRole_dept_id());
		adduser.setPwd(Encryption.getResult(adduser.getPwd()));
		int ret = tbUserBiz.addUser(adduser);

		if (ret == 1) {
			System.out.println("添加成功...");
			maplist = tbUserBiz.findAll2();
		}

//		mav.setViewName("WEB-INF/view.jiang/index");
		mav.setViewName("WEB-INF/view.jiang/usermanage");
		mav.addObject("maplist", maplist);
		return mav;
	}

	// 查
	@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectCompany(Tb_user tb_user, String dept) {
		System.out.println("过");
//		----加密
		Map<String, Object> map = new HashMap<String, Object>();
//		Tb_user tb_userr=tb_user;
//		tb_userr.setPwd(Encryption.getResult(tb_userr.getPwd()));
//		---
		map.put("tb_user", tb_user);

		map.put("dept", dept);
		
		List<Map<String, Object>> companys = tbUserBiz.selectCompany(map);
//			List<Tb_user> companys = companyBizsc.selectCompany(map);
		String str = JSONArray.fromObject(companys).toString();
		System.out.println(companys.get(0).get(dept));
		return str;
	}

	// 显示
	@RequestMapping(value = "/select.handle")
	public ModelAndView findAll(HttpServletRequest request, HttpServletResponse response, Tb_user adduser) {

		ModelAndView mav = new ModelAndView();

		userall = tbUserBiz.findAll();
		maplist = tbUserBiz.findAll2();
		System.out.println("99999=" + maplist.get(0).get("name"));

		System.out.println("aaaa....=" + userall);
		if (null != maplist && maplist.size() > 0) {

			request.setAttribute("maplist", maplist);
		} else {
			System.out.println("沒有數據");
		}
//
		System.out.println("添加人员 进入后台查找部门"); 
		String sta="在用";
		maplistdept=tbDeptBiz.select(sta);
		
		request.setAttribute("maplistdept", maplistdept);
		 
		//
		mav.setViewName("WEB-INF/view.jiang/usermanage");
		return mav;

	}

	// 删除 第一步
	@RequestMapping(value = "/delect.handle", method = RequestMethod.POST)
	public @ResponseBody String delect(HttpServletRequest request, HttpServletResponse response, String delectname) {
		String data = null;
		System.out.println("...=" + delectname);
		int user_id = Integer.valueOf(delectname);
		int ret = tbUserBiz.deleteUser(user_id);
		if (ret == 1) {
			data = "00";
		}

		return data;

	}

	// 部门查询
	@RequestMapping(value = "/adddept.handle", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
//	, produces = "application/text;charset=utf-8"
	public @ResponseBody String adddept(HttpServletRequest request, HttpServletResponse response, String dept) {
		String addrole;
		System.out.println("dept="+dept);
		maplisttbrole=tbRoleBiz.selectrole(dept);
		System.out.println("maplisttbrole="+maplisttbrole);
//		System.out.println("...=" + dept);
//		if (dept.equals("内科")) {
//			addrole = "01";
//		} else {
//			if (dept.equals("外科")) {
//				addrole = "02";
//			} else {
//				addrole = "03";
//
//			}
//		}
//		System.out.println("xxxxxxj" + addrole);
//		addrole=tbRole.toString();
//		System.out.println("addrole="+addrole);
//		mav.addObject("maplist", maplist);
	
		JSONArray jobj=JSONArray.fromObject(maplisttbrole);//把字符串ss转成json对象
		return    jobj.toString();

	}

	// 部門查询第二补
	@RequestMapping(value = "/adddeptto.handle")
	public ModelAndView adddeptto(HttpServletRequest request, HttpServletResponse response, String datato) {
		String addrole;
		System.out.println("...=" + datato);
		ModelAndView mav = new ModelAndView();
		int datadept = Integer.valueOf(datato);
		if (datadept == 01) {
			addrole = "内科";
		} else {
			if (datadept == 02) {
				addrole = "外科";
			} else {
				addrole = "管理员";
			}
		}
		request.setAttribute("addrole", addrole);

		mav.setViewName("WEB-INF/view.jiang/usermanage");
		return mav;

	}

	// 禁用启用
	@RequestMapping(value = "/updetestate.handle", method = RequestMethod.POST)
	public @ResponseBody String updetestate(HttpServletRequest request, HttpServletResponse response, String userid,
			String statet) {
		String successs = null;
		String state = null;
		int user_id = Integer.valueOf(userid);
		if (statet.equals("禁用")) {
			state = "启用";
		} else {
			state = "禁用";
		}
		System.out.println("更改后的状态=" + state);

		int ret = tbUserBiz.upState(user_id, state);
		if (ret == 1) {
			successs = "1";
			System.out.println("修改成功");
		} else {
			successs = "0";
			System.out.println("修改失败");
		}

		return successs;

	}

	// 修改人员信息一步
	@RequestMapping(value = "/updete2.handle", method = RequestMethod.POST)
	public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
		ModelAndView mav = new ModelAndView();

		System.out.println("修改人员信息=" + updetename);
		request.setAttribute("updetename", updetename);
		mav.setViewName("WEB-INF/view.jiang/updeteuser");
		return mav;

	}

	// 修改人员信息二部
	@RequestMapping(value = "/updeteuser.handle", method = RequestMethod.POST)
	public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_user upuser) {
//		ModelAndView mav = new ModelAndView();
//
//		tbUserBiz.upUser(upuser);
//
//		mav.setViewName("WEB-INF/view.jiang/usermanage");
		
		ModelAndView mav = new ModelAndView();
		upuser.setPwd(Encryption.getResult(upuser.getPwd()));
		tbUserBiz.upUser(upuser);
		userall = tbUserBiz.findAll();
		maplist = tbUserBiz.findAll2();
		System.out.println("99999=" + maplist.get(0).get("name"));

		System.out.println("aaaa....=" + userall);
		if (null != maplist && maplist.size() > 0) {

			request.setAttribute("maplist", maplist);
		} else {
			System.out.println("沒有數據");
		}

		mav.setViewName("WEB-INF/view.jiang/usermanage");
		return mav;

	}

	@RequestMapping(value = "/selectlittle.handle", method = RequestMethod.POST)
	public ModelAndView selectlittle(HttpServletRequest request, HttpServletResponse response, String depts,
			String users, String phones) {
		ModelAndView mav = new ModelAndView();
		System.out.println("11-=" + depts);
		System.out.println("11-=" + users);
		System.out.println("11-=" + phones);
//		String account= "'%"+users+"%'";
//		System.out.println(account);
//		String sql="select * from tb_user where account like '%"+users+"%'";
//		System.out.println(sql);
		maplist = tbUserBiz.selUser(depts, users, phones);
		if (null != maplist && maplist.size() > 0) {

			request.setAttribute("maplist", maplist);
		} else {
			System.out.println("沒有數據");
		}

		mav.setViewName("WEB-INF/view.jiang/usermanage");
		return mav;

	}

	@RequestMapping(value = "/checkPwd.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkPwd(HttpServletRequest request, String pwd) {
		Tb_user user = (Tb_user) request.getSession().getAttribute("user");
		String encryption = Encryption.getResult(pwd);
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getUser_id());
		map.put("pwd", encryption);
		return tbUserBiz.checkPwd(map);
	}

	@RequestMapping(value = "/changePwd.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String changePwd(HttpServletRequest request,String pwd) {
		Tb_user user = (Tb_user) request.getSession().getAttribute("user");
		String encryption = Encryption.getResult(pwd);
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getUser_id());
		map.put("pwd",encryption);
		return tbUserBiz.changePwd(map);
	}

	@RequestMapping(value = "/toaddnews.handle")
	public ModelAndView toaddnews() {

		System.out.println("toaddnews");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.jiang/news_add");
		return mav;

	}
	
	@RequestMapping(value = "/toUpdateNews.handle")
	public ModelAndView toUpdateNews(String newsid) {

		System.out.println("news_id="+newsid);
		
		News news=nurseBiz.findMyNews(Integer.valueOf(newsid));
		
		System.out.println("news="+news);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("news", news);
		
		mav.setViewName("WEB-INF/view.jiang/news_update");
		return mav;

	}
	
	//新闻修改
	@RequestMapping(value = "/updatenews.handle",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
	public @ResponseBody String updatenews(News news) {

		System.out.println("news="+news);
		
		boolean flag=nurseBiz.updateNews(news);
		
		if(flag) {
			return "成功";
		}else {
			return "失败";
		}

	}
	
	
	
	@RequestMapping(value = "/addnews.handle",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addnews(String title,String time,String info) {
		
		System.out.println("title="+title);
		System.out.println("time="+time);
		System.out.println("info="+info);
		
		News news = new News(title, info, time);
		
		//添加新闻
		boolean flag=nurseBiz.addNews(news);
		
		if(flag) {
			return "成功";
		}else {
			return "失败";
		}
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("WEB-INF/view.jiang/news_add");
		

	}
	
	//新闻列表
	@RequestMapping(value = "/newslist.handle")
	public ModelAndView newslist() {
		
		ModelAndView mav = new ModelAndView();
		
		ArrayList<News> nlist=nurseBiz.findAllNews(); 
		
		System.out.println("nlist="+nlist);
		
		mav.addObject("nlist", nlist);
		
		mav.setViewName("WEB-INF/view.jiang/news_list");
		
		return mav;
	}
	
	//新闻条件查询
	@RequestMapping(value = "/searchnews.handle")
	public ModelAndView searchnews(String title,String mindate,String maxdate,String info) {
		
		System.out.println("title="+title);
		System.out.println("mindate="+mindate);
		System.out.println("maxdate="+maxdate);
		System.out.println("info="+info);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title",title);
		map.put("mindate",mindate);
		map.put("maxdate",maxdate);
		map.put("info",info);
		
		List<News> nlist = nurseBiz.searchNews(map);
		System.out.println("nlist="+nlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("nlist", nlist);
		
		mav.setViewName("WEB-INF/view.jiang/news_list");
		
		return mav;
	}

	
	// 删除方法
		@RequestMapping(value = "/delNews.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
		public @ResponseBody String delNews(HttpServletRequest req, @RequestParam(value = "arrin") String[] arrin) {
			
			String result = "";
			boolean flag = false;
			
			for (int i = 0; i < arrin.length; i++) {
				flag = nurseBiz.delNews(arrin[i]);
				if (i == arrin.length - 1) {
					if (flag == true) {
						result = "success";
					} else {
						result = "failure";
					}
				}
			}
			return result;
		}
		//ajax 显示部门
		@RequestMapping(value="/selectdept.handle",method = RequestMethod.GET, produces = "application/json;charset=utf-8")
		public @ResponseBody String  selectdept(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("添加人员 进入后台查找部门");
			ModelAndView mav = new ModelAndView(); 
			String sta="在用";
			maplistdept=tbDeptBiz.select(sta);
			
			request.setAttribute("maplistdept", maplistdept);
			
			mav.setViewName("WEB-INF/view.jiang/usermanage");
			return null;
		}
	
}
