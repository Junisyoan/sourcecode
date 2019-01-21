package xyz.cymedical.handle.ctx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.mapper.ctx.PatientMapper;

@Controller
@RequestMapping("/patient")
public class PatientHandle {

	@Resource
	private PatientMapper patientMapper;

	private List<Patient> patientlist = new ArrayList<Patient>();

	public PatientHandle() {

	}

	// 公司记账
	@RequestMapping(value = "/findpatient.handle")
	public ModelAndView findpatient(String name, String phone, String time, String code) {

		patientlist = patientMapper.query(name, phone, time, code);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/staffquery");
		mav.addObject("patientlist", patientlist);
		return mav;

	}

}
