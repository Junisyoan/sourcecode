package xyz.cymedical.handle.xin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import xyz.cymedical.biz.xin.BriefBiz;
import xyz.cymedical.biz.xin.DoctorBiz;
import xyz.cymedical.entity.jiang.Tb_user;

@Controller
@RequestMapping("/brief")
public class BriefHandle {

	@Resource
	private BriefBiz briefbiz; 			//小结的业务逻辑
	
	@Resource
	private DoctorBiz doctorbiz; 		//医生的业务逻辑
	
	List<Map<String,Object>> plist;			//项目列表
	
	List<Map<String,Object>> dlist;			//细项列表
	

	//普通小结
	@RequestMapping(value = "/normal.handle")
	public ModelAndView normal(String result,String tips,String id) {
		
		boolean f=briefbiz.Normal(result,tips,id);
		
		dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", DoctorHandle.projectname);
		mav.addObject("projectid", DoctorHandle.projectid);
		mav.addObject("keshi", DoctorHandle.keshi);
		mav.addObject("dlist", dlist);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
		
	}
	
	
//	//彩超小结
//		@RequestMapping(value = "/photo.handle")
//		public ModelAndView photo(String result,String path,String id) {
//			
//			System.out.println("result="+result);
//			System.out.println("path="+path);
//			System.out.println("id="+id);
//			
//			briefbiz.Photo(result, path, id);
//			
//			dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
//			
//			System.out.println("dlist="+dlist);
//			
//			ModelAndView mav = new ModelAndView();
//			mav.addObject("projectname", DoctorHandle.projectname);
//			mav.addObject("keshi", DoctorHandle.keshi);
//			mav.addObject("dlist", dlist);
//
//			mav.setViewName("WEB-INF/doctor.xin/brief");
//			return mav;
//			
//		}
	

	//检验小结
	@RequestMapping(value = "/check.handle")
	public ModelAndView check(String result,String tips,String id) {
		
		System.out.println("result="+result);
		System.out.println("tips="+tips);
		System.out.println("id="+id);
		
		
		boolean f=briefbiz.Check(result,tips,id);
		
		
		dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
		
		System.out.println("dlist="+dlist);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectname", DoctorHandle.projectname);
		mav.addObject("projectid", DoctorHandle.projectid);
		mav.addObject("keshi", DoctorHandle.keshi);
		mav.addObject("dlist", dlist);

		mav.setViewName("WEB-INF/doctor.xin/brief");
		return mav;
		
	}
	
	// 查询一维码对应病人的导检单
		@RequestMapping(value = "/turnback.handle")
		public ModelAndView turnback(HttpServletRequest req) {

			System.out.println("onecode=" + DoctorHandle.onecode);

			System.out.println(doctorbiz.findMyProject(DoctorHandle.onecode));
			
			Tb_user user=(Tb_user) req.getSession().getAttribute("user");
			plist=doctorbiz.findMyProject(DoctorHandle.onecode);

			List<Map<String,Object>> pplist = new ArrayList<Map<String,Object>>();//

			if(plist!=null && plist.size()>0) {
				for (int i = 0; i < plist.size(); i++) {
					Map m=plist.get(i);
					if(user.getParam_id()==Integer.parseInt(m.get("param_id").toString())) {
						pplist.add(m);
					}
				}
			}
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("prolist", pplist);
			mav.setViewName("WEB-INF/doctor.xin/pro_receive");
			return mav;

		}
		
		
		
		// 跳转至总结
		@RequestMapping(value = "/tosummarize.handle")
		public ModelAndView Tosummarize() {

			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("WEB-INF/doctor.xin/summarize");
			return mav;
		}
	
		
		
		//彩超小结
		/**
	     * 图片文件上传
	     */
	    @ResponseBody
	    @RequestMapping(value = "/photoUpload",method = RequestMethod.POST)
	    public ModelAndView photoUpload(MultipartFile file,HttpServletRequest request,HttpServletResponse response,HttpSession session,
	    		String result,String id) throws IllegalStateException, IOException{
//	        ResultData<Object> resultData=new ResultData<>();
	        // 判断用户是否登录
	        /*User user=(User) session.getAttribute("user");
	        if (user==null) {
	            resultData.setCode(40029);
	            resultData.setMsg("用户未登录");
	            return resultData;
	        }*/
	    	
	    	System.out.println("result="+result);
	    	System.out.println("id="+id);
	    	
	    	
	        if (file!=null) {// 判断上传的文件是否为空
	            String path=null;// 文件路径
	            String type=null;// 文件类型
	            String fileName=file.getOriginalFilename();// 文件原名称
	            System.out.println("上传的文件原名称:"+fileName);
	            // 判断文件类型
	            type=fileName.indexOf(".")!=-1?fileName.substring(fileName.lastIndexOf(".")+1, fileName.length()):null;
	            if (type!=null) {// 判断文件类型是否为空
	                if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())||"JPEG".equals(type.toUpperCase())) {
	                    // 项目在容器中实际发布运行的根路径
	                    String realPath=request.getSession().getServletContext().getRealPath("/");
	                    // 自定义的文件名称
	                    String trueFileName=String.valueOf(System.currentTimeMillis())+fileName;
	                    
	                    String uploadpath=realPath+"\\upload";
	                    if(!new File(uploadpath).exists()) {
	                    	new File(uploadpath).mkdirs();
	                    }
	                    
	                    
	                    // 设置存放图片文件的路径
	                    path=realPath+"\\upload\\"+trueFileName;
	                    System.out.println("存放图片文件的路径:"+path);
	                    
	                    
	                    
	                    // 转存文件到指定的路径
	                    file.transferTo(new File(path));
	                    System.out.println("文件成功上传到指定目录下");
	                    
	                    
	                    briefbiz.Photo(result, trueFileName, id);
	                    
	                    
	                }else {
	                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
	                    return null;
	                }
	            }else {
	                System.out.println("文件类型为空");
	                return null;
	            }
	        }else {
	            System.out.println("没有找到相对应的文件");
	            return null;
	        }
	        
	        
	       
			
			dlist=doctorbiz.findMyDetail(Integer.valueOf(DoctorHandle.projectid),Integer.valueOf(DoctorHandle.patientid));
			
			System.out.println("dlist="+dlist);
	        
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("projectname", DoctorHandle.projectname);
			mav.addObject("projectid", DoctorHandle.projectid);
			mav.addObject("keshi", DoctorHandle.keshi);
			mav.addObject("dlist", dlist);

			mav.setViewName("WEB-INF/doctor.xin/brief");
			return mav;
	    }
	
}
