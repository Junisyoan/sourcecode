package xyz.cymedical.handle.xin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.cymedical.biz.xin.DoctorBiz;


@Controller
@RequestMapping("/doctor")
public class DoctorHandle {

	@Resource
	private DoctorBiz doctor; 			//公司的业务逻辑
}
