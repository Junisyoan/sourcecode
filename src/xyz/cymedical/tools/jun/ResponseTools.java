package xyz.cymedical.tools.jun;

/**
* 2019年1月19日
* @author Junisyoan
* @version 1.0
*/
public class ResponseTools {

	/*
	 * 返回数据并且 跳回 跳转之前的页面
	 */
	public static String returnMsgAndBack(String msg) {
		String strMsg="<script type='text/javascript'>alert('###');window.history.go(-1);</script>";
		return strMsg.replace("###", msg);
	}
	
	/*
	 * 返回数据并且跳转指定的网页
	 */
	public static String returnMsgAndRedirect(String msg,String webpath) {
		String strMsg="<script type='text/javascript'>alert('###');location.href='@@';</script>";
		return strMsg.replace("###", msg).replace("@@", webpath);
	}
}
