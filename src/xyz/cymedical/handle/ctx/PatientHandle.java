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

	// 人员查询
	@RequestMapping(value = "/findpatient.handle")
	public ModelAndView findpatient(String name, String phone, String time, String code) {

		patientlist = patientMapper.query(name, phone, time, code);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/staffquery");
		mav.addObject("patientlist", patientlist);
		return mav;

	}

	// 人员综合查询
	@RequestMapping(value = "/findpatientall.handle")
	public ModelAndView findpatientall(String name, String phone, String time, String code) {

		patientlist = patientMapper.query(name, phone, time, code);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/integratedquery");
		mav.addObject("patientlist", patientlist);
		return mav;

	}

	// 人员综合查询
	@RequestMapping(value = "/printpatient.handle")
	public ModelAndView printpatient(String name) {

		patientlist = patientMapper.query(name, "", "", "");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/print");
		mav.addObject("patientlist", patientlist);
		return mav;

	}

}
