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
	private List<Patient> patientlist2 = new ArrayList<Patient>();
	private List<Patient> patientlist3 = new ArrayList<Patient>();
	private List<Patient> patientlist4 = new ArrayList<Patient>();

	public PatientHandle() {

	}

	// 人员查询
	@RequestMapping(value = "/findpatient.handle")
	public ModelAndView findpatient(String name, String phone, String time, String code) {

		System.out.println(name + "," + phone + "," + time + "," + code);

		patientlist = patientMapper.query(name, phone, time, code);

		System.out.println(patientlist.size() + "aa");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/staffquery");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;

	}

	// 人员综合查询
	@RequestMapping(value = "/findpatientall.handle")
	public ModelAndView findpatientall(String name, String phone, String time, String code) {

		patientlist = patientMapper.query(name, phone, time, code);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/integratedquery");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;

	}

	// 打印界面显示
	@RequestMapping(value = "/showpatient.handle")
	public ModelAndView showpatient() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/print");
		return mav;

	}

	// 体检报告人查询
	@RequestMapping(value = "/printpatient.handle")
	public ModelAndView printpatient(String name, String time) {

		patientlist = patientMapper.query(name, "", time, "");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/print");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;

	}

	// 体检报告人查询
	@RequestMapping(value = "/print.handle")
	public ModelAndView print(String name, String time) {

		patientlist = patientMapper.query(name, "", time, "");
		patientlist2 = patientMapper.queryproject(name, time);
		patientlist3 = patientMapper.querybrief(name, time);
		patientlist4 = patientMapper.queryadvise(name, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/printpatient");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
			mav.addObject("patientlist2", patientlist2);
			mav.addObject("patientlist3", patientlist3);
			mav.addObject("patientlist4", patientlist4);
		}
		return mav;
	}

	@RequestMapping(value = "/showmessage.handle")
	public ModelAndView showmessage(String name, String time) {

		patientlist = patientMapper.query(name, "", time, "");

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/message");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;
	}

	@RequestMapping(value = "/showproject.handle")
	public ModelAndView showproject(String name, String time) {

		patientlist = patientMapper.queryproject(name, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/project");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;
	}

	@RequestMapping(value = "/showbrief.handle")
	public ModelAndView showbrief(String name, String time) {

		patientlist = patientMapper.querybrief(name, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/brief");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;
	}

	@RequestMapping(value = "/showsummarize.handle")
	public ModelAndView showsummarize(String name, String time) {

		patientlist = patientMapper.querybrief(name, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/summarize");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
		}
		return mav;
	}

	@RequestMapping(value = "/showall.handle")
	public ModelAndView showall(String name, String time) {

		patientlist = patientMapper.query(name, "", time, "");
		patientlist2 = patientMapper.queryproject(name, time);
		patientlist3 = patientMapper.querybrief(name, time);
		patientlist4 = patientMapper.queryadvise(name, time);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("WEB-INF/medical_workstation/showall");
		if (patientlist.size() > 0) {
			mav.addObject("patientlist", patientlist);
			mav.addObject("patientlist2", patientlist2);
			mav.addObject("patientlist3", patientlist3);
			mav.addObject("patientlist4", patientlist4);
		}
		return mav;
	}

}
