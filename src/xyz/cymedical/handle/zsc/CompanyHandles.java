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

	@RequestMapping("/insertPage.handle")
	private ModelAndView insertPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/addCompany");
		return mav;
	}
	
	// 添加用户--ajax
	@RequestMapping(value = "/addCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String addDetail(Company company) {
		int rt = companyBizsc.insertCompany(company);
		if (rt > 0) {
			return "添加成功";
		} else {
			return "添加失败";
		}
	}

	// 删除细项--ajax
	@RequestMapping(value = "/deleteCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String  deleteCompany(String company_id) {
		companyBizsc.deleteCompany(company_id);
		List<Company> companies = companyBizsc.findCompanys();
		String str = JSONArray.fromObject(companies).toString();
		return str;
	}

	// 修改细项--表单
	@RequestMapping(value = "/updateCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String updateCompany(Company company) {
		int rt = companyBizsc.updateCompany(company);
		if (rt > 0) {
			return "修改成功";
		} else {
			return "修改失败";
		}
	}

	// 显示细项界面--href
	@RequestMapping(value = "/companysVeiw.handle")
	public ModelAndView companysVeiw(HttpServletRequest req) {
		return findCompanys(req);
	}

	//查询功能
	@RequestMapping(value="/selectCompany.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String selectCompany(Company company,String min,String max) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("company", company);
		map.put("min", min);
		map.put("max", max);
		List<Company> companys = companyBizsc.selectCompany(map);
		String str = JSONArray.fromObject(companys).toString();
		return str;
	}
	
	//修改页面
	@RequestMapping(value = "/updatePage.handle")
	public ModelAndView updatePage(HttpServletRequest req, String company_id) {
		Company company = companyBizsc.findCompany(company_id);
		req.setAttribute("company", company);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/updateCompany");
		return mav;
	}

	// 查询细项列表并添加到session中
	private ModelAndView findCompanys(HttpServletRequest req) {
		List<Company> companys = companyBizsc.findCompanys();
		req.setAttribute("companys", companys);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/view.zsc/companysVeiw");
		return mav;
	}

}