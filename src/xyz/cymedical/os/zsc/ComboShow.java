package xyz.cymedical.os.zsc;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.cymedical.biz.zsc.ComboBiz;
import xyz.cymedical.entity.xin.Combo;

@Controller
@RequestMapping("/comboshow")
public class ComboShow {

	@Resource
	ComboBiz comboBiz;
	
	@RequestMapping(value="/introduce")
	public String introduce(HttpServletRequest req) {
		List<Combo> combos = comboBiz.findCombos();
		req.setAttribute("combos", combos);
		
		return "products";
	}
}
