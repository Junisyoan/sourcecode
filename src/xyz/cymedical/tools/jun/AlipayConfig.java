package xyz.cymedical.tools.jun;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092500589581";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC2jFEqklYuBeVV87JDrxGgOmZ+GUXJnklWWbLv6BBBP/RuuFZqGdJtDT/ae+wlygZ2FbkED9Kh4Qqg7XolEUCO3c2GEZe1nu81y6kSlkEDy17DN84eSwJJ0HYJhqqTsV2zrFMykhuo4A85w3wmgb4y3A9tcKlUi6puVscgwl/esXgkjk/nmCyCmVyYzyKb4ZIm4P0ghgI1V5mZ7rErITwuTNMuzWVHNJGvboYlPqV0w/NfBwXI/Z8H2+hUDL/Z2mFVTBPHYEyydgUgGEWZWVuysfL30cvPrPh8gGPdPTuaTSQvJR5EYoj1+Io45vfgV+T/bOz0Yjgoz0/0Aw4hSi8/AgMBAAECggEBAKKlcswThmWLK0Lh1rsniPTSE+/WZK+3MHCXiy7l/VWlvgvIgnYWe75eR75LG6Sv1AHyaN6NmoZRFD8+V84fCP5B8ZS6qAlSip/LzeCZr2PKF6yoVCX5fxh1fDYQnnrpVSt5JsewFqTovagh3MQSZXy7RaOk9bo2lquo9dLiXLj0s2JH9FC4K8TQtr7NLsN8aE3g2XuqS3IIl997x8hGfxwZNSbxs29IG35NBzi88NuahKof2rABYPtqJ4cTaas1GidI45XonPADcIxiDJTl78zgiLKnvQ/5drfkDolntqZDT7ebCYer6rn+UjZUHp9hbLOiWHHRfVtFBFmAdSJqWQECgYEA79KL05TK5vHn84h/eiJ4tQLzbp9zwkpwiMrzSfAg9Ab1PEps1AD75/B+/WP+EELRB3YTQ5ST46BQ721esAF04oe63hMDOqVW5I6inAOJkYoKPeqaNmd8NCFgBVsX05iwxqs96/6O4Tw8JGCe0MWoobK1Pa28uJzmRvf3rJJlmY8CgYEAwty1wFzZJFQ0/WQMidoysaysdqJxyxHH+3vOpya8fOR9tWe7U6VuCE94b6b20RAWn/2yHYlFxxAXZJIa9hKNqnM0f5v4HfkyxAutvYvo86NgBy3nTVUm88TlNRkS/hgDmEkJvRS8QDLE7/FvzIeWRdZ9VwNnCUsnkoxrjtw7V1ECgYByMJk9fFqETmi4L6UrHWDGJ4qLgMbYmyMsLx5adUjriKiaNYHODE3lqUB+HG9rhLUMzW7svcERIFOJPVVZjsf92MzkUr813GYcW8IXcSO+tbCcvKkDAJFGLSIQSsh0iv6ZCg5o4QNdQZYNaCgWlhbuLy5XGPOEH8kRv54hgG96BwKBgQCeBRG2zxSf61GVcr7gQ3v8rYSmKBGTlfXQsJPi5PzRYxG2PEqjCHJ0ds257XIWE6/lSnxYi2t0hE4UFo+aoW0UnpwiJ79Lvzw10yqvnXfpq8FB0S3Tfow5/p/JMW4/dAXmRsSI+vm2LfWahvYcrI9mTwwRtgameLW8l/bZQSs2IQKBgGStJl2viFzKjcaJD9yDKth+pmTOtuM1P2FdlO+pm/w0m+2KDCm6OOrqInQ8TwLwkDZbIv9pr/FU1g07OkiWDktUCvkBqQ/Ua2oWQkBNdtwrJVmuS/IZrXUEfEigtJ5ImOwCmGFOSa3hwA0FuyuUV1BBlkkQqC7ZHQ2Dh5r8MQmY";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtqXPnTU4+vXNK3y/dC0bh4/heJXqq6Z4DgTze6jpcCmYkAjm1Aul1LBwvWNsGZU+00zU9D57Tft4AOTEPkKX8g7vz3NPvGgiP7lPqev+UVFlFMCivQ9N9iiSTo93FWpqokb9VL3S3TE8i5Pz6hySeaYh48jjfiae3VcbO8eNFes6bhFZ1TxIpmGVu3sfmkn2C8xoWwLvhkuqvFFDW3qH7d1ZhtQg9RZjZU0Gw15BxJNKvkoVDwkdLyhfRs1VYuYzUHD5oTfEGlfNwRmR8T2EsFsKACVYxrY1quXKFhZjbrY8LlODur1Oln1JoLqtqJ6TH1ExNtJVdxbf5V3GHr6b5wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://www.cyunits.xyz:8080/cymedical/company/notify.handle";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://www.cyunits.xyz:8080/cymedical/return_url.jsp";
	
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

