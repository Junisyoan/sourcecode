package xyz.cymedical.handle.zsc;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.cymedical.biz.jiang.TbUserBiz;
import xyz.cymedical.tools.zsc.Encryption;
import xyz.cymedical.tools.zsc.SendMail;

@Controller
@RequestMapping("/forgetPassword")
public class ForgetPassword {
	@Resource
	private TbUserBiz tbUserBiz;

	// 邮箱修改密码
	@RequestMapping(value = "/changePwd.handle", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public @ResponseBody String changePwd(String mailAddress) {
		if ("error".equals(tbUserBiz.findMail(mailAddress))) {
			return "邮箱不存在";
		}

		String newPwd = getRandomString(8);
		
		try {
			SendMail.send(mailAddress, newPwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "邮箱不存在";
		}

		Map<String, Object> map = new HashMap<>();
		map.put("mail", mailAddress);
		map.put("pwd", Encryption.getResult(newPwd));

		if ("ok".equals(tbUserBiz.changePwdBymail(map))) {
			return "密码重置成功，已发送至您的邮箱";
		} else {
			return "密码重置失败，请重新尝试！";
		}
	}

	public static String getRandomString(int length) {
		String str = "zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; ++i) {
			int number = random.nextInt(62);
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
}
