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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCdE880H+C/ri7eV06BVhbrct+ozrjKm5xbXrA6ZcGZXHbbyrhwvFbRaKL07ETD4UJviDStzikDvPWTbeOK+stL+JGDX+/gSHsvBF/sAWYpqhV8FWHNSo4IkcdeVDpdS1v0eTE4mlRXRrWCmqYB9/o7QfitBWxfRcAWKA/M/0p/F/6CrTOO9wl9gmm9lcvvnK6lerDtkwB6U30nNhQQ/bTw6E9COVcSuxhWVcIm5RUvEJuwwmLYT3G3nLxDDXJRMV+vlP0klq86Dn0qshXY9hco1vd2Pe5ekQCGTgPZsFf2PdDG/PXeGtdCzoIY908TmOb3DFY3njUBLU/z7mr4fRdZAgMBAAECggEAAkKZtadLxZZNCFf7QjMp60Ng4n3u/MNWcZ4gLQbvzTQeZbU6CC09lo/J4HpR1vuzyAUOtP2Fa49ZfUCUiJhpOnOeLGTB/9krJJcMhknS3YCcBIgOOzT6bDckxj+yA0ulTBQ+WBEoa4UR8YomH1shF58wY9TzJT/MrsTuzUVTHhcFhZLTmuWupu6ItSj9I/epgaNBz9UNMcmOCKkhHHivuE5Eh6oZllNoVuDYtwgSupP2/CZGuuqg3uh3FGJKayq5Swh007dLDEpck2w3fERTBJq34Vf4sA/oHNb3GrT1dn8H8H0FPIrIXMUr+rtIYDKm5udN574yIVeEmxEdI4iegQKBgQDOP/jSZcYe4LK3xgo3lknEwW5K/8bQbMXa7fppRORG5hLGVm8fef1GETkYQ2ZiRsEwJ8WYoeMFE5XrIM/efSicmc4FHcOV1gnpvB6jv/WVwA7JdGa/Uqk/Qab/Pv5o9qy220mUr53IYGOH4NOcVHq67Igg0hSJ0V0eVTyi8q1W8QKBgQDC92lnetOm2Uyrzl0TaR959k0ojTCgNygmpPbGUxOtTENBRTSREUcBs0eqvHXOJkob9lIQvlWtphtzyaO0jWmNq7Lq8vlw6xnJg4knlR4E0nT6I4spm6AJ0hG487isopavFyW+r/n2TTvPFMbTMWag5US8Tm9ewbC3kb1mHcRW6QKBgGjy3GYTK5EivU4OE7zdWIQp+TlolX4RG0yfs8BFMfNxtzP9X2Yg6OPyd58FDOANKNicJEvadG5s3OhcNen8veGR0eeAkbl4xGqPMvgYAZtFs0CHXpEUOtLZUWSoZUR74L7bLsHd6ue/RGYr3QG7awgau9oXjCPkyQFaVhSEb/fBAoGAaiRF5wcwePJuUk57z5h4gW583SnYojDFFBzVGG2cFcmiB8PEdYHBdYSD7MjDHeMsj4KPdPwaKvp2kZfiHuap423pbw2ujTIBDPsmTT1aZWeqNY/qMFHAU/hgm59cF+hAPrxMWT72x4eOmxOFlu6bH9cRj67n5N9v9NBMG27zOBkCgYB+dUdZTk96veCB9eUzSxIC407LJeieGL7cPP7bocK9bdUTJ/24G2xQaRuuRIc4tRy0596/80RrHBvXRgJQMj3WMNR79lgp6HTnorvxtXM5GBg+V4W3drQqtsj8opfUBCAtWte3F7eX+CIj9aMXsLzRbs9ky6hh8Dm1R7PyP5SFmQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtqXPnTU4+vXNK3y/dC0bh4/heJXqq6Z4DgTze6jpcCmYkAjm1Aul1LBwvWNsGZU+00zU9D57Tft4AOTEPkKX8g7vz3NPvGgiP7lPqev+UVFlFMCivQ9N9iiSTo93FWpqokb9VL3S3TE8i5Pz6hySeaYh48jjfiae3VcbO8eNFes6bhFZ1TxIpmGVu3sfmkn2C8xoWwLvhkuqvFFDW3qH7d1ZhtQg9RZjZU0Gw15BxJNKvkoVDwkdLyhfRs1VYuYzUHD5oTfEGlfNwRmR8T2EsFsKACVYxrY1quXKFhZjbrY8LlODur1Oln1JoLqtqJ6TH1ExNtJVdxbf5V3GHr6b5wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/cymedical/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/cymedical/return_url.jsp";
	
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

