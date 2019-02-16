package xyz.cymedical.os.zsc;

import java.util.List;
import java.util.Random;

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
	
	String[] imgSite = {"prod-pic1.jpg","prod-pic2.jpg","prod-pic3.jpg",
			"prod-pic4.jpg","prod-pic5.jpg","prod-pic6.jpg","prod-pic7.jpg","prod-pic8.jpg"};
 	
	@RequestMapping(value="/introduce")
	public String introduce(HttpServletRequest req) {
		List<Combo> combos = comboBiz.findCombos();
		
		Random random = new Random();
		for (Combo combo : combos) {
			combo.setImg(imgSite[random.nextInt(8)]);
		}
		
		req.setAttribute("combos", combos);
		
		return "combos";
	}
}
