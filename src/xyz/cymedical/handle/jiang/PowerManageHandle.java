package xyz.cymedical.handle.jiang;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.jiang.TbPowerBiz;
import xyz.cymedical.entity.jiang.Tb_power;
import xyz.cymedical.entity.jiang.Tb_user; 


@Controller
@RequestMapping("/powermanage")
public class PowerManageHandle {
	    
		@Resource
		private TbPowerBiz TbPowerBiz; 
		
		private Tb_power tbpower;
		   
//		private List<Map<String,Object>> maplist;
		
		private List<Tb_power> maplist;
		
		// 后台进入 显示

		@RequestMapping(value = "/selectpower.handle")
		public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, Tb_power tbpower) {
			ModelAndView mav = new ModelAndView();
			System.out.println("qweewq");
			
			 maplist = TbPowerBiz.selectPower();
			 
			request.setAttribute("maplist", maplist);
			
			mav.setViewName("WEB-INF/view.jiang/powermanage");
			return mav;


			
			
		}
		
		@RequestMapping(value = "/delect.handle",method = RequestMethod.POST)
		public @ResponseBody String deletePower(HttpServletRequest request, HttpServletResponse response, String delectname) {
//			ModelAndView mav = new ModelAndView();
			
			System.out.println("delectname="+delectname);
			String data = null;
			int power_id=Integer.valueOf(delectname);
			int ret=TbPowerBiz.deletePower(power_id);
			
			if(ret==1) {
//				mav.setViewName("WEB-INF/view.jiang/powermanage");
				data = "00";
			}
			  
			return data;
 	
		}
		 
		
		@RequestMapping(value = "/addPower.handle")
		public ModelAndView addPower(HttpServletRequest request, HttpServletResponse response, Tb_power tb_power) {
			ModelAndView mav = new ModelAndView();  
			 
			int ret=TbPowerBiz.addPower(tb_power);
			
			if(ret==1) {
				
				mav.setViewName("WEB-INF/view.jiang/powermanage");
			}
			  
			return mav;
 
		}
		//修改第一步
		@RequestMapping(value = "/updete1.handle", method = RequestMethod.POST)
		public ModelAndView updete2(HttpServletRequest request, HttpServletResponse response, String updetename) {
			ModelAndView mav = new ModelAndView();

			System.out.println("修改人员信息=" + updetename);
			request.setAttribute("updetename", updetename);
			mav.setViewName("WEB-INF/view.jiang/updetepower");
			return mav;

		}
		//修改第二步
	 
		@RequestMapping(value = "/updetepower2.handle", method = RequestMethod.POST)
		public ModelAndView updeteuser(HttpServletRequest request, HttpServletResponse response, Tb_power tbpower) {
			ModelAndView mav = new ModelAndView();
	 
				System.out.println(tbpower.getPower_id());
			 	System.out.println(tbpower.getMenu_id());
			 	System.out.println(tbpower.getName());
			 	int ret=TbPowerBiz.upPower(tbpower);
			 	if(ret==1) {
			 		
			 		mav.setViewName("WEB-INF/view.jiang/powermanage");
			 	}

			return mav;

		}
		
		
}
