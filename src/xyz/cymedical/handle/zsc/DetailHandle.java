package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sf.json.JSONArray;
import xyz.cymedical.biz.zsc.DetailBiz;
import xyz.cymedical.entity.zsc.Detail;

@Controller
@RequestMapping("/detail")
public class DetailHandle {

	@Resource
	DetailBiz detailBiz;

	@RequestMapping(value = "/insertPage.handle")
	public ModelAndView insertPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/addDetail");
		return mav;
	}
	
	@RequestMapping(value="/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String name,String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		return detailBiz.checkName(map);
	}
	
	// 添加用户--ajax
	@RequestMapping(value = "/addDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addDetail(Detail detail) {
		System.out.println("detail="+detail);
		return detailBiz.insertDetail(detail);
	}

	// 删除细项--ajax
	@RequestMapping(value = "/deleteDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String  deleteDetail(String detail_id) {
		detailBiz.deleteDetail(Integer.valueOf(detail_id));
		List<Detail> details = detailBiz.findDetails();
		String str = JSONArray.fromObject(details).toString();
		return str;
	}

	// 修改细项--表单
	@RequestMapping(value = "/updateDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateDetail(Detail detail) {
		return detailBiz.updateDetail(detail);
	}

	// 显示细项界面--href
	@RequestMapping(value = "/detailsVeiw.handle")
	public ModelAndView detailsVeiw(HttpServletRequest req) {
		return findDetails(req);
	}

	//查询功能
	@RequestMapping(value="/selectDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectDetail(Detail detail) {		
		List<Detail> details = detailBiz.selectDetail(detail);
		String str = JSONArray.fromObject(details).toString();
		return str;
	}
	
	//修改页面
	@RequestMapping(value = "/updatePage.handle")
	public ModelAndView updatePage(HttpServletRequest req, String detail_id) {
		Detail detail = detailBiz.findDetail(detail_id);
		req.setAttribute("detail", detail);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/updateDetail");
		return mav;
	}

	// 查询细项列表并添加到session中
	private ModelAndView findDetails(HttpServletRequest req) {
		List<Detail> details = detailBiz.findDetails();
		req.setAttribute("details", details);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/detailsVeiw");
		return mav;
	}

}