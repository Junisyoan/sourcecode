package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	// 重名验证
	@RequestMapping(value = "/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String name, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("id", id);
		return detailBiz.checkName(map);
	}

	// 增
	@RequestMapping(value = "/addDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addDetail(Detail detail) {
		return detailBiz.insertDetail(detail);
	}

	// 删
	@RequestMapping(value = "/deleteDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteDetail(String detail_id) {
		return detailBiz.deleteDetail(Integer.valueOf(detail_id));
	}

	// 改
	@RequestMapping(value = "/updateDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateDetail(Detail detail) {
		return detailBiz.updateDetail(detail);
	}

	// 查
	@RequestMapping(value = "/selectDetail.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectDetail(Detail detail) {
		List<Detail> details = detailBiz.selectDetail(detail);
		String str = JSONArray.fromObject(details).toString();
		return str;
	}

	// 显示
	@RequestMapping(value = "/detailsVeiw.handle")
	public ModelAndView detailsVeiw(HttpServletRequest req) {
		return findDetails(req);
	}

	// 列表
	private ModelAndView findDetails(HttpServletRequest req) {
		List<Detail> details = detailBiz.findDetails();
		req.setAttribute("details", details);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/detailsVeiw");
		return mav;
	}

}