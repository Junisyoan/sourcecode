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
import xyz.cymedical.biz.zsc.CompanyBizsc;
import xyz.cymedical.entity.jun.Company;

@Controller
@RequestMapping("/companys")
public class CompanyHandles {

	@Resource
	CompanyBizsc companyBizsc;

	// 重命名验证
	@RequestMapping(value = "/checkName.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String checkName(String account, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("account", account);
		map.put("id", id);
		return companyBizsc.checkName(map);
	}

	// 增
	@RequestMapping(value = "/addCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addDetail(Company company) {
		System.out.println("company="+company);
		return companyBizsc.insertCompany(company);
	}

	// 删
	@RequestMapping(value = "/deleteCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String deleteCompany(HttpServletRequest req, String company_id) {
		return companyBizsc.deleteCompany(company_id);
	}

	// 改
	@RequestMapping(value = "/updateCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateCompany(Company company) {
		return companyBizsc.updateCompany(company);
	}

	// 查
	@RequestMapping(value = "/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectCompany(Company company, String min, String max) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("company", company);
		map.put("min", min);
		map.put("max", max);
		List<Company> companys = companyBizsc.selectCompany(map);
		String str = JSONArray.fromObject(companys).toString();
		return str;
	}

	// 修改状态
	@RequestMapping(value = "/stateChange.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	private @ResponseBody String stateChange(HttpServletRequest req, Company company) {
		return companyBizsc.stateChange(company);
	}

	// 重置密码
	@RequestMapping(value = "/resetPwd.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String resetPwd(HttpServletRequest req, String company_id) {
		return companyBizsc.resetPwd(company_id);
	}

	// 显示
	@RequestMapping(value = "/companysVeiw.handle")
	public ModelAndView companysVeiw(HttpServletRequest req) {
		return findCompanys(req);
	}

	// 列表
	private ModelAndView findCompanys(HttpServletRequest req) {
		List<Company> companys = companyBizsc.findCompanys();
		req.setAttribute("companys", companys);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/companysVeiw");
		return mav;
	}

}